/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import py.com.oym.frame.data.IGenericDAORemote;


/**
 *
 * @author jenci_000
 */
public class TestDao {
    private static Context context;

    public TestDao() {
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

    //@Test
    public void testInstance() throws Exception {

        IGenericDAORemote instance  = (IGenericDAORemote) context.lookup("/TestProjects-ear/TestProjects-ejb/GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
        //String expResult = "Hola";
        //String result = instance.saludar();
        //assertEquals(expResult, result); 
        assertNotNull(instance);
        //assertNotNull(dao2);

    }
    
    //@Test
    public void testDao() throws Exception{
        IGenericDAORemote dao  = (IGenericDAORemote) context.lookup("/TestProjects-ear/TestProjects-ejb/GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
        System.out.println(dao.getDataEngine("PU1"));
        System.out.println(dao.getSchema("PU1"));
    }    
    
    @Test
    public void testDao2() throws Exception{
        IGenericDAORemote dao  = (IGenericDAORemote) context.lookup("/TestProjects-ear/TestProjects-ejb/GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
        Map<String, Object> params = new HashMap<>();
        params.put("idempresa", 98L);
        List<Object> list = dao.findByNativeQuery("PU2","select codigo, nombre from datos.item where idempresa = :idempresa", params, 10, 10);
        assertNotNull(list);
    }        
}
