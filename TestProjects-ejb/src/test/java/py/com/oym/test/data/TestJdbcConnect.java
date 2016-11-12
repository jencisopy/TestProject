/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.data;

import java.sql.Connection;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import py.com.oym.frame.data.IGenericDAO;
import py.com.oym.frame.data.DataLink;
import py.com.oym.frame.data.IDBConnectFactory;
import static py.com.oym.test.data.TestDataNativeQuery.context;

/**
 *
 * @author jenci_000
 */
public class TestJdbcConnect {
    public TestJdbcConnect(){
        
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

//    @Test
//    public void test() throws Exception {
//        IGenericDAO dao   = (IGenericDAO) context.lookup("/TestProject/TestProject-ejb/GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
//        DataLink dataLink = new DataLink(dao);
//        assertNotNull(dao);
//        IDBConnectFactory dbConect = new DbConnectFactory();
//        Connection conn = dataLink.getConnection(dbConect);
//        assertNotNull(conn);
//    }
}
