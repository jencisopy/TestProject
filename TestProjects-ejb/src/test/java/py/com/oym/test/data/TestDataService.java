/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.data;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import py.com.oym.frame.data.IDataRow;
import py.com.oym.frame.services.IDataServiceRemote;
import py.com.oym.frame.services.IDataService;
import py.com.oym.frame.data.IGenericDAO;
import py.com.oym.frame.error.IErrorReg;
import py.com.oym.frame.security.ISecManager;
import py.com.oym.frame.security.IUserSession;
import py.com.oym.model.tables.Pais;
import py.com.oym.model.tables.Usuario;
import py.com.oym.model.tables.UsuarioMiembro;

/**
 *
 * @author jenci_000
 */
public class TestDataService {
    static Context context;
    static String sessionId;

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
        
        ISecManager secMngr = (ISecManager)context.lookup("/TestProjects-ear/TestProjects-ejb/SecManager!py.com.oym.frame.security.ISecManagerRemote");
        
        IUserSession userSession = secMngr.createSession("J", "", 98L);        
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

    @Test
    public void testInstance() throws Exception {
        IDataServiceRemote instance  = (IDataServiceRemote) context.lookup("/TestProjects-ear/TestProjects-ejb/DataService!py.com.oym.frame.logic.IDataServiceRemote");
        assertNotNull(instance);
    }
    
    //@Test
    // Prueba control de los unique keys
    public void testCheckData() throws Exception {
        IDataServiceRemote dataService  = (IDataServiceRemote) context.lookup("/TestProjects-ear/TestProjects-ejb/UsuarioSrv!py.com.oym.frame.logic.IDataServiceRemote");
        IGenericDAO dao  = (IGenericDAO) context.lookup("/TestProjects-ear/TestProjects-ejb/GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
        Usuario row = dao.find(Usuario.class,"PU1" ,14L);
        dataService.checkDataRow(row,"");
        assertTrue(dataService.checkUniqueKey(row, ""));
    }
    
    //@Test
    // Prueba de chequeo de los foreignkeys
    public void testCheckData2() throws Exception {
        IDataServiceRemote dataService  = (IDataServiceRemote) context.lookup("/TestProjects-ear/TestProjects-ejb/UsuarioMiembroSrv!py.com.oym.frame.logic.IDataServiceRemote");
        IGenericDAO dao  = (IGenericDAO) context.lookup("/TestProjects-ear/TestProjects-ejb/GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
        List<UsuarioMiembro> rows = dao.findAll(UsuarioMiembro.class,"PU1");
        //rows.get(0).setUsuarioGrupo(null);
        assertTrue(dataService.checkForeignKey(rows.get(0),"usuariogrupo",""));
    }    

    //@Test
    // Prueba de ejecución del metodo de chequeo de acuerdo al tipo de operación.
    public void testCheckData3() throws Exception {
        IDataService usuarioSrv  = (IDataService) context.lookup("/TestProjects-ear/TestProjects-ejb/UsuarioSrv!py.com.oym.frame.logic.IDataServiceRemote");
        IGenericDAO dao  = (IGenericDAO) context.lookup("/TestProjects-ear/TestProjects-ejb/GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
        
        List<Usuario> rows = dao.findAll(Usuario.class,"PU1");
        rows.get(0).setOperation(IDataRow.MODIFICAR);
        usuarioSrv.checkDataRow(rows.get(0), "");
        
        rows.get(0).setOperation(IDataRow.BORRAR);
        usuarioSrv.checkDataRow(rows.get(0), "");
       
    }        
    
    //@Test
    // Prueba chequeo de datos
    public void testCheckData4() throws Exception {
        IDataService usuarioSrv  = (IDataService) context.lookup("/TestProjects-ear/TestProjects-ejb/UsuarioSrv!py.com.oym.frame.logic.IDataServiceRemote");
        IGenericDAO dao  = (IGenericDAO) context.lookup("/TestProjects-ear/TestProjects-ejb/GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
        List<Usuario> rows = dao.findAll(Usuario.class,"PU1");
        usuarioSrv.merge(rows.get(0), sessionId);
        //dataService.checkDataRow(rows.get(0), "");
       
    }        

    //@Test
    // Prueba unique key
    public void testCheckData5() throws Exception {
        IDataService usuarioSrv  = (IDataService) context.lookup("/TestProjects-ear/TestProjects-ejb/UsuarioSrv!py.com.oym.frame.logic.IDataServiceRemote");
        IGenericDAO dao  = (IGenericDAO) context.lookup("/TestProjects-ear/TestProjects-ejb/GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
        List<Usuario> rows = dao.findAll(Usuario.class,"PU1");
        Usuario usuario = rows.get(0);
        usuario.setIdusuario(0L);
        Map<String, IErrorReg> errors;

        usuario.setOperation(IDataRow.MODIFICAR);
        errors = usuarioSrv.checkDataRow(usuario, sessionId);
        assertFalse(errors.isEmpty());
        
        usuario.setOperation(IDataRow.AGREGAR);        
        errors = usuarioSrv.checkDataRow(usuario, sessionId);
        assertFalse(errors.isEmpty());

        usuario.setOperation(IDataRow.BORRAR);        
        errors = usuarioSrv.checkDataRow(usuario, sessionId);
        assertTrue(errors.isEmpty());
        
     }        

    //@Test
    // Chequeo de los foreignkeys
    public void testCheckData6() throws Exception {
        IDataServiceRemote dataService  = (IDataServiceRemote) context.lookup("/TestProjects-ear/TestProjects-ejb/DataService!py.com.oym.frame.logic.IDataServiceRemote");
        IGenericDAO dao  = (IGenericDAO) context.lookup("/TestProjects-ear/TestProjects-ejb/GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
        List<Pais> rows = dao.findAll(Pais.class,"PU2");
        rows.get(0).setOperation(IDataRow.MODIFICAR);
        dataService.checkDataRow(rows.get(0), sessionId);
        //assertFalse(dataService.checkForeignKey(rows.get(0),"usuariogrupo",""));
    }    

    //@Test
    // Chequeo de los foreignkeys
    public void testCheckData7() throws Exception {
        IDataServiceRemote dataService  = (IDataServiceRemote) context.lookup("/TestProjects-ear/TestProjects-ejb/UsuarioMiembroSrv!py.com.oym.frame.logic.IDataServiceRemote");
        IGenericDAO dao  = (IGenericDAO) context.lookup("/TestProjects-ear/TestProjects-ejb/GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
        List<UsuarioMiembro> rows = dao.findAll(UsuarioMiembro.class,"PU1");
        UsuarioMiembro usuarioMiembro = rows.get(0);
        //usuarioMiembro.setUsuarioGrupo(null);
        usuarioMiembro.setOperation(IDataRow.MODIFICAR);
        
        Map<String, IErrorReg> errors = dataService.checkDataRow(rows.get(0), sessionId);
        assertTrue(errors.isEmpty());
        //assertFalse(dataService.checkForeignKey(rows.get(0),"usuariogrupo",""));
    }
    
    @Test
    // Chequeo de los foreignkeys y 
    public void testCheckData8() throws Exception {
        IDataServiceRemote dataService  = (IDataServiceRemote) context.lookup("/TestProjects-ear/TestProjects-ejb/PaisSrv!py.com.oym.frame.logic.IDataServiceRemote");
        IGenericDAO dao  = (IGenericDAO) context.lookup("/TestProjects-ear/TestProjects-ejb/GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
        List<Pais> rows = dao.findAll(Pais.class,"PU2");
        Pais pais = rows.get(0);
        pais.setRegion(null);
        rows.get(0).setOperation(IDataRow.MODIFICAR);
        dataService.checkDataRow(pais, sessionId);
    }    
 }
