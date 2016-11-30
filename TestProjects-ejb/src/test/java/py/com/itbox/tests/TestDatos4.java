/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.itbox.tests;

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
import py.com.oym.frame.data.DataLink;
import py.com.oym.frame.data.DataObject;
import py.com.oym.frame.data.IDataObject;
import py.com.oym.frame.exceptions.SessionError;
import py.com.oym.frame.security.ISecManager;
import py.com.oym.frame.security.IUserSession;
import py.com.oym.frame.data.IGenericDAO;

/**
 *
 * @author Jorge Enciso
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestDatos4 {
    static Context context;
    static DataLink dataLink;
    static IGenericDAO dao;
            
    public TestDatos4() {
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
        
        IUserSession userSession = secMngr.createSession("J", "", 10L, null);
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
        
        //Campo        
        IDataObject campo = new DataObject(BxCampo.class, null, dataLink, null);
        campo.open();
        campo.find("codigo", "FECHA");
        campo.deleteRow();
        result = campo.update(false);
        if (!result){
            System.out.println(campo.getErrorMsg(true));
        }
        campo.revert();
        campo.insertRow();
        campo.insertRow();        
        campo.revert(true);
        assertFalse(result);
    }

    @Test
    public void test1BorrarData() throws NamingException, SessionError, Exception{
        System.out.println("2"); 
        boolean result;
        
        //Campo        
        IDataObject campo = new DataObject(BxCampo.class, null, dataLink, null);
        campo.open();
        campo.find("codigo", "002");
        campo.deleteRow();
        result = campo.update(true);
        if (!result){
            System.out.println(campo.getErrorMsg(true));
        }
        campo.revert(true);
        assertFalse(result);
    }
    
}