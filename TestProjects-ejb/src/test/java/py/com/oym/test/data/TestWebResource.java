/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.data;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import py.com.oym.frame.security.ISecManager;
import py.com.oym.frame.security.IUserSession;
import py.com.oym.frame.ws.resources.IWebResource;
import py.com.oym.frame.ws.resources.remote.WebResource;

/**
 *
 * @author jenci_000
 */
public class TestWebResource {
    static private Context context; 
    static private String sessionId;

    public TestWebResource() {
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
        
        ISecManager secMngr = (ISecManager)context.lookup("/TestProjects-ear/TestProjects-ejb/SecManager!py.com.oym.frame.security.ISecManagerRemote");
        
        IUserSession userSession = secMngr.createSession("J", "", 98L, null);        
        sessionId = userSession.getSessionId();
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() {
    }

    
    //@Test
    public void testWebResource1() throws Exception {
        IWebResource webResource = new WebResource();
        assertNotNull(webResource.getSecManager("/TestProjects-ear/TestProjects-ejb/SecManager!py.com.oym.frame.security.ISecManagerRemote"));
    }
    
    @Test
    // Prueba de crear y cerrar sesión
    public void testWebResource2() throws Exception {
        IWebResource webResource = new WebResource();        
        ISecManager secManager = 
              (ISecManager)webResource.getSecManager("ejb:TestProjects-ear/TestProjects-ejb//SecManager!py.com.oym.frame.security.ISecManagerRemote");
        IUserSession userSession = secManager.createSession("J", "", 98L, null);
        assertNotNull(userSession);
        secManager.logout(userSession);
    }
    
    @Test
    // Prueba de Buscar registros
    public void testWebResource3() throws Exception {
    }

    @Test
    // Prueba de count
    public void testWebResource4() throws Exception {
    }

    @Test
    // Prueba grabación
    public void testWebResource5() throws Exception {
    }
}
