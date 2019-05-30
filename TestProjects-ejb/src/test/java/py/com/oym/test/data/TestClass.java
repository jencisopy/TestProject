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
import org.javabeanstack.security.model.IUserSession;

import static py.com.oym.test.data.TestDataService.sessionId;

/**
 *
 * @author Jorge Enciso
 */
public class TestClass {

    static protected Context context;
    static protected IDataLink dataLink;
    static protected IDataLink dataLinkCat;
    static protected String sessionId;
    static protected String error;
    static String jndiProject = "/TestProjects-ear/TestProjects-ejb/";

    public TestClass() {
    }

    @BeforeClass
    public static void setUpClass() throws NamingException, Exception {
        Properties p = new Properties();
        p.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        p.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        //TODO cambiar credenciales
        p.put(Context.SECURITY_PRINCIPAL, "test");
        p.put(Context.SECURITY_CREDENTIALS, "test");
        p.put("jboss.naming.client.ejb.context", true);
        context = new InitialContext(p);

        ISecManager secMngr = (ISecManager) context.lookup(jndiProject + "SecManager!org.javabeanstack.security.ISecManagerRemote");
        //TODO cambiar a empresas tests
        IUserSession userSession = secMngr.createSession("J", "", 2L, null);        
        sessionId = userSession.getSessionId();

        IGenericDAO dao = (IGenericDAO) context.lookup(jndiProject + "GenericDAO!org.javabeanstack.data.IGenericDAORemote");
        dataLinkCat = new DataLink(dao);

        dataLink = new DataLink(dao);
        dataLink.setUserSession(userSession);
        //dataLink.getUserSession().getDBFilter().setModelPackagePath("net.makerapp.model.tables;net.makerapp.model.views");
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
