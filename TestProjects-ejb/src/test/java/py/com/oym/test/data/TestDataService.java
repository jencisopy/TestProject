/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.data;

import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import py.com.oym.frame.data.IDataRow;
import py.com.oym.frame.services.IDataServiceRemote;
import py.com.oym.frame.services.IDataService;
import py.com.oym.frame.error.IErrorReg;
import net.makerapp.model.tables.Pais;
import py.com.oym.model.tables.Usuario;
import py.com.oym.model.tables.UsuarioMiembro;
import net.makerapp.model.tables.Moneda;

/**
 *
 * @author Jorge Enciso
 */
public class TestDataService extends TestClass{
    public TestDataService() {
    }

    //@Test
    public void testInstance() throws Exception {
        IDataServiceRemote instance  = (IDataServiceRemote) context.lookup("/TestProjects-ear/TestProjects-ejb/DataService!py.com.oym.frame.services.IDataServiceRemote");
        assertNotNull(instance);
    }

    /** Prueba control de los unique keys */
    //@Test
    public void testCheckUnique1() throws Exception {
        IDataServiceRemote dataService  = (IDataServiceRemote) context.lookup("/TestProjects-ear/TestProjects-ejb/UsuarioSrv!py.com.oym.frame.services.IDataServiceRemote");
        Usuario row = dataService.find(Usuario.class,"PU1" ,14L);
        //dataService.checkDataRow(row,"");
        // Va a pasar la prueba porque es el mismo objeto
        assertTrue(dataService.checkUniqueKey(row, ""));
    }

    /** Prueba control de los unique keys */
    //@Test    
    public void testCheckUnique2() throws Exception {
        IDataServiceRemote dataService  = (IDataServiceRemote) context.lookup("/TestProjects-ear/TestProjects-ejb/DataService!py.com.oym.frame.services.IDataServiceRemote");
        Moneda row = dataService.find(Moneda.class,"PU2" ,234L);
        //dataService.checkDataRow(row,"");
        // Necesita del parametro sessionId para acceder a la unidad de persistencia adecuado
        assertTrue(dataService.checkUniqueKey(row, sessionId));
    }
    
    /** Prueba de chequeo de los foreignkeys */
    //@Test    
    public void testCheckForeignkey() throws Exception {
        IDataServiceRemote dataService  = (IDataServiceRemote) context.lookup("/TestProjects-ear/TestProjects-ejb/UsuarioMiembroSrv!py.com.oym.frame.services.IDataServiceRemote");
        List<UsuarioMiembro> rows = dataService.findAll(UsuarioMiembro.class,"PU1");
        //rows.get(0).setUsuarioGrupo(null);
        assertTrue(dataService.checkForeignKey(rows.get(0),"usuariogrupo",""));
    }    

    /** Prueba de ejecución del metodo de chequeo de acuerdo al tipo de operación.*/
    //@Test    
    public void testCheckData3() throws Exception {
        IDataService usuarioSrv  = (IDataService) context.lookup("/TestProjects-ear/TestProjects-ejb/UsuarioSrv!py.com.oym.frame.services.IDataServiceRemote");
        
        List<Usuario> rows = usuarioSrv.findAll(Usuario.class,"PU1");
        rows.get(0).setOperation(IDataRow.MODIFICAR);
        usuarioSrv.checkDataRow(rows.get(0), "");
        
        rows.get(0).setOperation(IDataRow.BORRAR);
        usuarioSrv.checkDataRow(rows.get(0), "");
    }        
    
    /** Prueba chequeo de datos */
    //@Test    
    public void testCheckData4() throws Exception {
        IDataService usuarioSrv  = (IDataService) context.lookup("/TestProjects-ear/TestProjects-ejb/UsuarioSrv!py.com.oym.frame.services.IDataServiceRemote");
        List<Usuario> rows = usuarioSrv.findAll(Usuario.class,"PU1");
        usuarioSrv.edit(rows.get(0), "");
        //dataService.checkDataRow(rows.get(0), "");
       
    }        

    /** Prueba unique key */
    //@Test    
    public void testCheckUniqueKey3() throws Exception {
        IDataService usuarioSrv  = (IDataService) context.lookup("/TestProjects-ear/TestProjects-ejb/UsuarioSrv!py.com.oym.frame.services.IDataServiceRemote");
        List<Usuario> rows = usuarioSrv.findAll(Usuario.class,"PU1");
        Usuario usuario = rows.get(0);
        usuario.setIdusuario(0L);
        Map<String, IErrorReg> errors;

        usuario.setOperation(IDataRow.MODIFICAR);
        errors = usuarioSrv.checkDataRow(usuario, "");
        assertFalse(errors.isEmpty());
        
        usuario.setOperation(IDataRow.AGREGAR);        
        errors = usuarioSrv.checkDataRow(usuario, "");
        assertFalse(errors.isEmpty());

        usuario.setOperation(IDataRow.BORRAR);        
        errors = usuarioSrv.checkDataRow(usuario, "");
        assertTrue(errors.isEmpty());
     }        

    /** Chequeo de los foreignkeys */
    //@Test    
    public void testCheckForeignKey2() throws Exception {
        IDataServiceRemote dataService  = (IDataServiceRemote) context.lookup("/TestProjects-ear/TestProjects-ejb/DataService!py.com.oym.frame.services.IDataServiceRemote");
        Map<String, IErrorReg> errors;        
        List<Pais> rows = dataService.findAll(Pais.class,"PU2");
        rows.get(0).setOperation(IDataRow.MODIFICAR);
        // Necesita del parametro sessionId para acceder a la unidad de persistencia adecuado        
        errors = dataService.checkDataRow(rows.get(0), sessionId);
        assertTrue(errors.isEmpty());
    }    

    //@Test        
    /** Chequeo de los foreignkeys  */
    public void testCheckForeignKey3() throws Exception {
        IDataServiceRemote dataService  = (IDataServiceRemote) context.lookup("/TestProjects-ear/TestProjects-ejb/UsuarioMiembroSrv!py.com.oym.frame.services.IDataServiceRemote");
        List<UsuarioMiembro> rows = dataService.findAll(UsuarioMiembro.class,"PU1");
        UsuarioMiembro usuarioMiembro = rows.get(0);
        usuarioMiembro.setOperation(IDataRow.MODIFICAR);
        
        Map<String, IErrorReg> errors = dataService.checkDataRow(rows.get(0), sessionId);
        assertTrue(errors.isEmpty());
    }
    
    //@Test
    /** Chequeo de los foreignkeys  */
    public void testCheckForeignKey4() throws Exception {
        IDataServiceRemote dataService  = (IDataServiceRemote) context.lookup("/TestProjects-ear/TestProjects-ejb/PaisSrv!py.com.oym.frame.services.IDataServiceRemote");
        List<Pais> rows = dataService.findAll(Pais.class,"PU2");
        Pais pais = rows.get(0);
        //pais.setRegion(null);
        pais.setOperation(IDataRow.MODIFICAR);
        // Necesita del parametro sessionId para acceder a la unidad de persistencia adecuado                
        Map<String, IErrorReg> errors = dataService.checkDataRow(pais, sessionId);
        assertTrue(errors.isEmpty());
    }    
 }
