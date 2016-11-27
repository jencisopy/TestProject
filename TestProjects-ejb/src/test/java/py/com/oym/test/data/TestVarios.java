/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import py.com.oym.frame.data.DataLink;
import py.com.oym.frame.data.IGenericDAORemote;
import static py.com.oym.test.data.TestDao.context;

/**
 *
 * @author jenci_000
 */
public class TestVarios {
    
    public TestVarios() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testGetCount() throws Exception{
        IGenericDAORemote dao  = (IGenericDAORemote) context.lookup("/TestProjects-ear/TestProjects-ejb/GenericDAO!py.com.oym.frame.data.IGenericDAORemote");        
        Long rec = dao.getCount("PU1", "select o FROM Empresa o", null);
        System.out.println(rec);
    }

    
    //@Test
    public void testMapPut() {
        Map<String, Object> params = new HashMap<>();
        params.put("valor", "1");
        System.out.println(params.get("valor"));
        params.put("valor", "2");
        System.out.println(params.get("valor"));
    }    
    
    //@Test
    public void testParam() throws Exception{
        IGenericDAORemote dao  = (IGenericDAORemote) context.lookup("/TestProjects-ear/TestProjects-ejb/GenericDAO!py.com.oym.frame.data.IGenericDAORemote");        
        DataLink dataLink = new DataLink(dao);
        Long rec = dataLink.getCount2("select * FROM {schema}.usuario where disable = :true", null);
        System.out.println(rec);
    }
    
    
    
}
