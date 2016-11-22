/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.core;

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
import py.com.oym.frame.data.IGenericDAORemote;
import py.com.oym.frame.error.ErrorManager;

/**
 *
 * @author jenci_000
 */
public class TestError {
    static Context context;    
    
    public TestError() {
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
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() {
    }

    
    @Test
    public void test1() throws NamingException{
        IGenericDAORemote dao  = (IGenericDAORemote) context.lookup("/TestProjects-ear/TestProjects-ejb/GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
        ErrorManager errorMngr = new ErrorManager();
        assertNotNull(errorMngr.getErrorMessage(50001,dao));
    }

    @Test
    public void test2() throws NamingException{
        IGenericDAORemote dao  = (IGenericDAORemote) context.lookup("/TestProjects-ear/TestProjects-ejb/GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
        ErrorManager errorMngr = new ErrorManager();
        assertNotNull(errorMngr.getErrorReg(50001,"", dao));
    } 
}
