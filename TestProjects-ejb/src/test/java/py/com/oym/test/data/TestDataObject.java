/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.data;

import javax.naming.NamingException;
import net.makerapp.model.tables.Pais;
import net.makerapp.model.tables.Region;
import org.javabeanstack.data.DataSet;
import org.javabeanstack.data.IDataObject;
import org.javabeanstack.data.IDataSet;
import org.javabeanstack.data.IGenericDAO;
import org.javabeanstack.exceptions.SessionError;
import static org.junit.Assert.assertTrue;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import py.com.oym.frame.data.DataObject;

/**
 *
 * @author Jorge Enciso
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestDataObject extends TestClass {
    //@Test
    public void test1AddData() throws NamingException, SessionError, Exception{
        System.out.println("1"); 
        //Region
        IDataObject<Region, IGenericDAO> region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        region.insertRow();
        region.setField("codigo","ZZZ");
        region.setField("nombre", "ZZZ BORRAR");


        IDataSet dataSet = new DataSet();
        dataSet.addDataObject("region", region);
        
        boolean result = dataLink.update(dataSet).isSuccessFul();
        assertTrue(result);        
    }
    
    //@Test
    public void test2BorrarData() throws NamingException, SessionError, Exception{
        System.out.println("2"); 
        boolean result;
        
        //Campo        
        IDataObject<Region,IGenericDAO> campo = new DataObject(Region.class, null, dataLink, null);
        campo.open();
        campo.find("codigo", "ZZZ");
        campo.deleteRow();
        result = campo.update(false);
        if (!result){
            System.out.println(campo.getErrorMsg(true));
        }
        assertTrue(result);
    }
    
    
    
    @Test
    public void test3AddData() throws NamingException, SessionError, Exception{
        System.out.println("3"); 
        //Region
        IDataObject<Region, IGenericDAO> region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        region.insertRow();
        region.setField("codigo","ZZZ");
        region.setField("nombre", "ZZZ BORRAR");

        //pais
        IDataObject pais = new DataObject(Pais.class, null, dataLink, null);
        pais.open();
        pais.insertRow();
        pais.setField("codigo","ZZZ");
        pais.setField("nombre","ZZZ PAIS BORRAR");
        pais.setField("region", region.getRow());

        IDataSet dataSet = new DataSet();
        dataSet.addDataObject("region", region);
        dataSet.addDataObject("pais", pais);        
        
        boolean result = dataLink.update(dataSet).isSuccessFul();
        assertTrue(result);        
    }
    
    @Test
    public void test4BorrarData() throws NamingException, SessionError, Exception{
        System.out.println("4"); 
        boolean result;
        
        //Pais
        IDataObject<Pais, IGenericDAO> pais = new DataObject(Pais.class, null, dataLink, null);
        pais.open();
        if (pais.find("codigo", "ZZZ")){
            pais.deleteRow();
            result = pais.update(false);
            assertTrue(result);
        }        
        
        //Region        
        IDataObject<Region,IGenericDAO> campo = new DataObject(Region.class, null, dataLink, null);
        campo.open();
        campo.find("codigo", "ZZZ");
        campo.deleteRow();
        result = campo.update(false);
        if (!result){
            System.out.println(campo.getErrorMsg(true));
        }
        assertTrue(result);
    }
    
}
