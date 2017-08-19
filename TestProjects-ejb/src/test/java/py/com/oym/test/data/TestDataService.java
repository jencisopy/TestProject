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

import org.javabeanstack.data.IDataRow;
import org.javabeanstack.services.IDataServiceRemote;
import org.javabeanstack.services.IDataService;
import org.javabeanstack.error.IErrorReg;
import net.makerapp.model.tables.Pais;
import py.com.oym.model.tables.Usuario;
import py.com.oym.model.tables.UsuarioMiembro;
import net.makerapp.model.tables.Moneda;
import org.javabeanstack.data.IDBLinkInfo;
import org.junit.Test;

/**
 *
 * @author Jorge Enciso
 */
public class TestDataService extends TestClass{
    public TestDataService() {
    }

    //@Test
    public void testInstance() throws Exception {
        IDataServiceRemote instance  = 
                (IDataServiceRemote) context.lookup(jndiProject+"DataService!org.javabeanstack.services.IDataServiceRemote");
        assertNotNull(instance);
    }

    /** Prueba control de los unique keys
     * @throws java.lang.Exception */
    //@Test
    public void testCheckUnique1() throws Exception {
        IDataService dataService  = 
                (IDataService) context.lookup(jndiProject+"UsuarioSrv!net.makerapp.services.IUsuarioSrvRemote");
        Usuario row = dataService.find(Usuario.class,null ,14L);
        //dataService.checkDataRow(row,"");
        // Va a pasar la prueba porque es el mismo objeto
        assertTrue(dataService.checkUniqueKey(row, ""));
    }

    /** Prueba control de los unique keys
     * @throws java.lang.Exception */
    //@Test    
    public void testCheckUnique2() throws Exception {
        IDataServiceRemote dataService  = 
                (IDataServiceRemote) context.lookup(jndiProject+"DataService!org.javabeanstack.services.IDataServiceRemote");
        
        IDBLinkInfo dbInfo = dataService.getUserSession(sessionId).getDbLinkInfo();
        Moneda row = dataService.find(Moneda.class,dbInfo ,234L);
        //dataService.checkDataRow(row,"");
        // Necesita del parametro sessionId para acceder a la unidad de persistencia adecuado
        assertTrue(dataService.checkUniqueKey(row, sessionId));
    }

    /** Prueba unique key
     * @throws java.lang.Exception */
    //@Test    
    public void testCheckUniqueKey3() throws Exception {
        IDataService usuarioSrv  = 
                (IDataService) context.lookup(jndiProject+"UsuarioSrv!net.makerapp.services.IUsuarioSrvRemote");
        
        List<Usuario> rows = usuarioSrv.findAll(Usuario.class,null);
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
        
        usuario.setCodigo("xxxxxxx");
        usuario.setOperation(IDataRow.AGREGAR);        
        errors = usuarioSrv.checkDataRow(usuario, "");
        assertTrue(errors.isEmpty());
        
     }        
    
    /** Prueba de ejecución del metodo de chequeo de acuerdo al tipo de operación
     * @throws java.lang.Exception
     */
    //@Test    
    public void testCheckData3() throws Exception {
        IDataService usuarioSrv  = 
                (IDataService) context.lookup(jndiProject+"UsuarioSrv!net.makerapp.services.IUsuarioSrvRemote");
        
        List<Usuario> rows = usuarioSrv.findAll(Usuario.class,null);
        rows.get(0).setOperation(IDataRow.MODIFICAR);
        usuarioSrv.checkDataRow(rows.get(0), "");
        
        rows.get(0).setOperation(IDataRow.BORRAR);
        usuarioSrv.checkDataRow(rows.get(0), "");
    }        
    
    /** Prueba chequeo de datos
     * @throws java.lang.Exception */
    //@Test    
    public void testCheckData4() throws Exception {
        IDataService usuarioSrv  = 
                (IDataService) context.lookup(jndiProject+"UsuarioSrv!net.makerapp.services.IUsuarioSrvRemote");
        
        List<Usuario> rows = usuarioSrv.findAll(Usuario.class,null);
        usuarioSrv.edit(rows.get(0), "");
        //dataService.checkDataRow(rows.get(0), "");
       
    }        

    /** Prueba de chequeo de los foreignkeys
     * @throws java.lang.Exception */
    @Test    
    public void testCheckForeignkey() throws Exception {
        IDataServiceRemote dataService  = 
                (IDataServiceRemote) context.lookup(jndiProject+"UsuarioMiembroSrv!org.javabeanstack.services.IDataServiceRemote");
        
        List<UsuarioMiembro> rows = dataService.findAll(UsuarioMiembro.class,null);
        assertTrue(dataService.checkForeignKey(rows.get(0),"usuariogrupo",""));
        rows.get(0).setUsuarioGrupo(null);        
        assertFalse(dataService.checkForeignKey(rows.get(0),"usuariogrupo",""));        
    }    

    /** Chequeo de los foreignkeys
     * @throws java.lang.Exception */
    //@Test    
    public void testCheckForeignKey2() throws Exception {
        IDataServiceRemote dataService  = 
                (IDataServiceRemote) context.lookup(jndiProject+"DataService!org.javabeanstack.services.IDataServiceRemote");
        
        Map<String, IErrorReg> errors;        
        IDBLinkInfo dbInfo = dataService.getUserSession(sessionId).getDbLinkInfo();        
        List<Pais> rows = dataService.findAll(Pais.class,dbInfo);
        rows.get(0).setOperation(IDataRow.MODIFICAR);
        // Necesita del parametro sessionId para acceder a la unidad de persistencia adecuado        
        errors = dataService.checkDataRow(rows.get(0), sessionId);
        assertTrue(errors.isEmpty());
    }    

    //@Test        
    /** Chequeo de los foreignkeys
     * @throws java.lang.Exception */
    public void testCheckForeignKey3() throws Exception {
        IDataServiceRemote dataService  = 
                (IDataServiceRemote) context.lookup(jndiProject+"UsuarioMiembroSrv!org.javabeanstack.services.IDataServiceRemote");
        
        List<UsuarioMiembro> rows = dataService.findAll(UsuarioMiembro.class,null);
        UsuarioMiembro usuarioMiembro = rows.get(0);
        usuarioMiembro.setOperation(IDataRow.MODIFICAR);
        
        Map<String, IErrorReg> errors = dataService.checkDataRow(rows.get(0), sessionId);
        assertTrue(errors.isEmpty());
    }
    
    /** Chequeo de los foreignkeys
     * @throws java.lang.Exception */
    //@Test    
    public void testCheckForeignKey4() throws Exception {
        IDataServiceRemote dataService  = 
                (IDataServiceRemote) context.lookup(jndiProject+"PaisSrv!org.javabeanstack.services.IDataServiceRemote");
        
        IDBLinkInfo dbInfo = dataService.getUserSession(sessionId).getDbLinkInfo();        
        List<Pais> rows = dataService.findAll(Pais.class,dbInfo);
        Pais pais = rows.get(0);
        //pais.setRegion(null);
        pais.setOperation(IDataRow.MODIFICAR);
        // Necesita del parametro sessionId para acceder a la unidad de persistencia adecuado                
        Map<String, IErrorReg> errors = dataService.checkDataRow(pais, sessionId);
        assertTrue(errors.isEmpty());
    }    
 }
