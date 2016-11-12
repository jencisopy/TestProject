/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.data;

import java.util.List;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.Test;
import py.com.oym.frame.data.DataLink;
import py.com.oym.frame.data.IGenericDAO;
import static py.com.oym.test.data.TestDataNativeQuery.context;
import py.com.oym.frame.sec.ISecManagerRemote;
import py.com.oym.frame.sec.ISessionsRemote;
import py.com.oym.frame.sec.IUserSession;
import py.com.oym.frame.sec.UserSession;


/**
 *
 * @author Jorge Enciso
 */
public class TestSesiones {
    
    public TestSesiones() {
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

    //@Test
    public void test() throws Exception {
        ISessionsRemote sesiones  = (ISessionsRemote) context.lookup("/TestProject/TestProject-ejb/Sessions!py.com.oym.frame.sec.ISessionsRemote");
        IUserSession userSession = sesiones.login("J", "");
        assertNotNull(userSession);
    }
    
  
    //@Test
    public void testLogin() throws Exception {
        ISecManagerRemote sesiones  = (ISecManagerRemote) context.lookup("/TestProject/TestProject-ejb/SecManager!py.com.oym.frame.sec.ISecManagerRemote");
        assertNotNull(sesiones);                
        IUserSession userSession = sesiones.login2("webuser", "123456");
        assertNotNull(userSession);        
        //boolean login = sesiones.login("webuser", "123456");
        //boolean login = sesiones.isSesionIdValid("xx");
        //assertEquals(true, login); 
    }
    
    //@Test
    public void testCreateSession() throws Exception {
        ISecManagerRemote sesiones  = (ISecManagerRemote) context.lookup("/TestProject/TestProject-ejb/SecManager!py.com.oym.frame.sec.ISecManagerRemote");
        IUserSession userSesion = sesiones.createSession("webuser", "123456",98L);
        if (userSesion.getError() != null){
            System.out.println(userSesion.getError().getMessage());
        }
        assertNotNull(userSesion.getSessionId());
        assertTrue(sesiones.isSesionIdValid(userSesion.getSessionId()));
        System.out.println(sesiones.getUserRol("J"));
    }    
    
    //@Test
    public void testDataLink() throws Exception {
        IGenericDAO dao  = (IGenericDAO) context.lookup("/TestProject/TestProject-ejb/GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
        DataLink dataLink = new DataLink(dao);
        IUserSession userSession = new UserSession();
        dataLink.setUserSession(userSession);
        
        List<Object> result = dataLink.findByNativeQuery("select * from {schema}.empresa", null);
        assertNotNull(result);
    }        
    
    @Test
    public void testDataLink2() throws Exception {
        ISecManagerRemote sesiones  = (ISecManagerRemote) context.lookup("/TestProject/TestProject-ejb/SecManager!py.com.oym.frame.sec.ISecManagerRemote");        
        IGenericDAO dao  = (IGenericDAO) context.lookup("/TestProject/TestProject-ejb/GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
        DataLink dataLink = new DataLink(dao); 
        
        IUserSession userSession = sesiones.createSession("webuser", "123456",98L);
        if (userSession.getError() != null){
            System.out.println(userSession.getError().getMessage());
        }
        assertNotNull(userSession.getSessionId());
        assertTrue(sesiones.isSesionIdValid(userSession.getSessionId()));

        dataLink.setUserSession(userSession);
        
        List<Object> result = dataLink.findByNativeQuery("select * from {schema}.moneda", null);
        assertNotNull(result);
    }            
}
