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
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import py.com.oym.frame.logic.IDataServiceRemote;
import py.com.oym.frame.data.IGenericDAO;
import py.com.oym.model.tables.Usuario;
import py.com.oym.model.tables.UsuarioMiembro;

/**
 *
 * @author jenci_000
 */
public class TestDataService {
    static Context context;

    public TestDataService() {
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
    public void testInstance() throws Exception {
        IDataServiceRemote instance  = (IDataServiceRemote) context.lookup("/TestProject/TestProject-ejb/DataService!py.com.oym.frame.data.IDataServiceRemote");
        assertNotNull(instance);
    }
    
    //@Test
    public void testCheckData() throws Exception {
        IDataServiceRemote dataService  = (IDataServiceRemote) context.lookup("//TestProject/TestProject-ejb/UsuarioSrv!py.com.oym.frame.data.IDataServiceRemote");
        IGenericDAO dao  = (IGenericDAO) context.lookup("/TestProject/TestProject-ejb/GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
        Usuario row = dao.find(Usuario.class,"PU1" ,14L);
        dataService.checkDataRow(row,"");
        assertTrue(dataService.checkUniqueKey(row, ""));
    }
    
    @Test
    public void testCheckData2() throws Exception {
        IDataServiceRemote dataService  = (IDataServiceRemote) context.lookup("//TestProject/TestProject-ejb/UsuarioMiembroSrv!py.com.oym.frame.data.IDataServiceRemote");
        IGenericDAO dao  = (IGenericDAO) context.lookup("/TestProject/TestProject-ejb/GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
        List<UsuarioMiembro> rows = dao.findAll(UsuarioMiembro.class,"PU1");
        //rows.get(0).setUsuarioGrupo(null);
        assertTrue(dataService.checkForeignKey(rows.get(0),"usuariogrupo",""));
    }    
}
