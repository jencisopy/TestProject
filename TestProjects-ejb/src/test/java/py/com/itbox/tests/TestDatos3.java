/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.itbox.tests;

import java.util.List;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import py.com.itbox.model.tables.BxCampo;
import py.com.itbox.model.tables.BxPlantilla;
import py.com.itbox.model.tables.BxPlantilladetalle;
import py.com.itbox.model.tables.BxRepositorio;
import py.com.oym.frame.data.DataLink;
import py.com.oym.frame.data.DataObject;
import py.com.oym.frame.data.DataSet;
import py.com.oym.frame.data.IDataObject;
import py.com.oym.frame.data.IDataSet;
import py.com.oym.frame.exceptions.SessionError;
import py.com.oym.frame.security.ISecManager;
import py.com.oym.frame.security.IUserSession;
import py.com.oym.frame.data.IGenericDAO;

/**
 *
 * @author Jorge Enciso
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestDatos3 {
    static Context context;
    static DataLink dataLink;
    static IGenericDAO dao;
            
    public TestDatos3() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        Properties p = new Properties();
        p.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        p.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        p.put(Context.SECURITY_PRINCIPAL, "jenciso");
        p.put(Context.SECURITY_CREDENTIALS, "Oym1282873");
        p.put("jboss.naming.client.ejb.context", true);
        context = new InitialContext(p);           
        
        ISecManager secMngr = (ISecManager)context.lookup("/ItBox-1.0//SecManager!py.com.oym.frame.security.ISecManagerRemote");
        
        dao  = (IGenericDAO) context.lookup("/ItBox-1.0//GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
//        dao.sqlExec("PU2", "remove from {schema}.bx_index where codigo = '002';", null);                
//        dao.sqlExec("PU2", "remove from {schema}.bx_documentotipo where codigo = '002';", null);                
//        dao.sqlExec("PU2", "remove from {schema}.bx_plantilla where codigo = '002';", null);        
//        dao.sqlExec("PU2", "remove from {schema}.bx_repositorio where codigo = '002';", null);                        
//        dao.sqlExec("PU2", "remove from {schema}.bx_campo where codigo = '002';", null);        
        
        IUserSession userSession = secMngr.createSession("J", "", 10L,null);
        dataLink = new DataLink(dao);
        dataLink.setUserSession(userSession);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void test0BorrarData() throws NamingException, SessionError, Exception{
        System.out.println("1"); 
        boolean result;
        
        //Plantilla
        IDataObject<BxPlantilla, IGenericDAO> plantilla = new DataObject(BxPlantilla.class, null, dataLink, null);
        plantilla.open();
        if (plantilla.find("codigo", "002")){
            plantilla.deleteRow();
            result = plantilla.update(false);
            assertTrue(result);
        }                
        
        //Repositorio
        IDataObject<BxRepositorio, IGenericDAO> repositorio = new DataObject(BxRepositorio.class, null, dataLink, null);
        repositorio.open();
        if (repositorio.find("codigo", "002")){
            repositorio.deleteRow();
            result = repositorio.update(false);
            assertTrue(result);
        }        
        
        //Campo        
        IDataObject<BxCampo,IGenericDAO> campo = new DataObject(BxCampo.class, null, dataLink, null);
        campo.open();
        campo.find("codigo", "002");
        campo.deleteRow();
        result = campo.update(false);
        if (!result){
            System.out.println(campo.getErrorMsg(true));
        }
        assertTrue(result);
    }
    
    @Test
    public void test1AddData() throws NamingException, SessionError, Exception{
        System.out.println("2"); 
        //Campo        
        IDataObject<BxCampo, IGenericDAO> campo = new DataObject(BxCampo.class, null, dataLink, null);
        campo.open();
        campo.insertRow();
        campo.setField("codigo","002");
        campo.setField("nombre", "Nro.Str2");
        campo.setField("tipo", "C");

        //Repositorio
        IDataObject repositorio = new DataObject(BxRepositorio.class, null, dataLink, null);
        repositorio.open();
        repositorio.insertRow();
        repositorio.setField("codigo","002");
        repositorio.setField("nombre","CENTRAL2");
        repositorio.setField("inactivo",false);
        repositorio.setField("path1","/servidor/path1");
        repositorio.setField("path2","/servidor/path2");

        IDataSet dataSet = new DataSet();
        dataSet.addDataObject("bxcampo", campo);
        dataSet.addDataObject("bxrepositorio", repositorio);        
        
        boolean result = dataLink.update(dataSet).isSuccessFul();
        assertTrue(result);        
    }

    @Test
    public void test2AddBxPlantilla() throws Exception{
        System.out.println("3");         
        //Plantilla
        IDataObject<BxPlantilla, IGenericDAO> plantilla = new DataObject(BxPlantilla.class, null, dataLink, null);
        plantilla.open();
        plantilla.insertRow();
        plantilla.setField("codigo","002");
        plantilla.setField("nombre","PLANTILLA2");
        plantilla.setField("inactivo",false);        

        //Plantilladetalle
        IDataObject<BxPlantilladetalle, IGenericDAO> plantillaDet = new DataObject(BxPlantilladetalle.class, null, dataLink, null);
        plantillaDet.open();
        plantillaDet.insertRow();
        
        String queryString = "select o from BxCampo o where idempresa = 10 and codigo = '002'";
        BxCampo bxCampo = dataLink.findByQuery(BxCampo.class, queryString, null);
        ((BxPlantilladetalle)plantillaDet.getRow()).setBxPlantilla((BxPlantilla)plantilla.getRow());
        
        plantillaDet.setField("bxcampo",bxCampo);
        plantillaDet.setField("orden", 1);
        plantillaDet.setField("valordefecto","xx");
        
        plantillaDet.insertRow();
        plantillaDet.setField("bxplantilla", plantilla.getRow());        
        plantillaDet.setField("bxcampo",bxCampo);
        plantillaDet.setField("orden", 2);
        plantillaDet.setField("valordefecto","xx");
        
        List<BxPlantilladetalle> list = plantillaDet.getDataRows();
//        
        plantilla.setField("bxplantilladetalle",list);
        
        IDataSet dataSet = new DataSet();
        dataSet.addDataObject("bxplantilla", plantilla);
        dataSet.addDataObject("bxplantilladetalle", plantillaDet);        
        
        boolean result = dataLink.update(dataSet).isSuccessFul();
        assertTrue(result);        
    }
}