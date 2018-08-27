/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.data;


import org.javabeanstack.model.tables.Pais;
import org.junit.Test;
import org.javabeanstack.data.DataRow;
import static org.junit.Assert.*;

/**
 *
 * @author jenci_000
 */
public class TestInstance {
    
    @Test
    public void test1(){
        DataRow dataRow = new DataRow();
        Pais pais = new Pais();
        assertFalse(pais.getClass().isInstance(dataRow));
        assertFalse(pais.getClass().isAssignableFrom(dataRow.getClass()));
        System.out.println(pais.getClass().getName());
        System.out.println(dataRow.getClass().getName());
    }
    
    @Test
    public void test2(){
        DataRow dataRow = new DataRow();
        Pais pais = new Pais();
        assertTrue(dataRow.getClass().isAssignableFrom(pais.getClass()));
    }    
    
    @Test
    public void test3(){
        DataRow dataRow = new DataRow();
        Pais pais = new Pais();
        pais.setIdpais(2L);
        //System.out.println(dataRow.getId().hashCode());
        //System.out.println(Objects.hashCode(dataRow.getId()));
        System.out.println(dataRow.hashCode());
        System.out.println(pais.hashCode());        
    }    
}
