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
import py.com.oym.model.tables.Usuario;
import py.com.oym.frame.data.IGenericDAO;

/**
 *
 * @author jenci_000
 */
public class TestRefreshRow {

    static Context context;

    public TestRefreshRow() {
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
    public void testRefreshRow() throws Exception{
        IGenericDAO dao  = (IGenericDAO) context.lookup("/TestProjects-ear/TestProjects-ejb/GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
        Usuario row = dao.find(Usuario.class,"PU1" ,14L);
        assertNotNull(row.getListaUsuarioMiembro().get(0));
        row = dao.refreshRow("PU1", row);
        System.out.println(row.getNombre());        
        System.out.println(row.getListaUsuarioMiembro().get(0));
        assertNotNull(row.getListaUsuarioMiembro().get(0));
    }        
}
