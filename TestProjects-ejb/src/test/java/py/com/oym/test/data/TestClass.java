/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.data;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.javabeanstack.data.DataLink;
import org.javabeanstack.data.IDataLink;
import org.javabeanstack.data.IGenericDAO;
import org.javabeanstack.security.ISecManager;
import org.javabeanstack.security.IUserSession;

import static py.com.oym.test.data.TestDataService.sessionId;

/**
 *
 * @author Jorge Enciso
 */
public class TestClass {
    static protected Context context; 
    static protected IDataLink dataLink;
    static String sessionId;    
    
    public TestClass() {
    }
    
    @BeforeClass
    public static void setUpClass() throws NamingException, Exception {
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
        
        IGenericDAO dao  = (IGenericDAO) context.lookup("/TestProjects-ear/TestProjects-ejb/GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
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

}
