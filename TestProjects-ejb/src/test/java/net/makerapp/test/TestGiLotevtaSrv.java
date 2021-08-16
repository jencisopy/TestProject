/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.makerapp.test;

import py.com.oym.test.data.*;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.javabeanstack.data.IDataRow;
import org.javabeanstack.data.services.IDataServiceRemote;
import org.javabeanstack.data.services.IDataService;
import org.javabeanstack.error.IErrorReg;
import org.javabeanstack.model.tables.Pais;
import org.javabeanstack.model.appcatalog.AppUser;
import org.javabeanstack.model.appcatalog.AppUserMember;
import org.javabeanstack.model.tables.Moneda;
import org.javabeanstack.data.IDBLinkInfo;
import org.junit.Test;

/**
 *
 * @author Jorge Enciso
 */
public class TestGiLotevtaSrv extends TestClass{
    public TestGiLotevtaSrv() {
    }

    //@Test
    public void testInstance() throws Exception {
        IDataServiceRemote instance  = 
                (IDataServiceRemote) context.lookup(jndiProject+"DataService!org.javabeanstack.data.services.IDataServiceRemote");
        assertNotNull(instance);
    }

    /** Prueba control de los unique keys
     * @throws java.lang.Exception */
    //@Test    
    public void testCheckUnique2() throws Exception {
        IDataServiceRemote dataService  = 
                (IDataServiceRemote) context.lookup(jndiProject+"DataService!org.javabeanstack.data.services.IDataServiceRemote");
        
        Moneda row = dataService.findById(Moneda.class,sessionId ,234L);
        //dataService.checkDataRow(row,"");
        // Necesita del parametro sessionId para acceder a la unidad de persistencia adecuado
        assertTrue(dataService.checkUniqueKey(sessionId, row));
    }

    /** Prueba unique key
     * @throws java.lang.Exception */
    @Test    
    public void testCheckUniqueKey3() throws Exception {
        IDataService usuarioSrv  = 
                (IDataService) context.lookup(jndiProject+"UsuarioSrv!net.makerapp.services.IUsuarioSrvRemote");
        
        List<AppUser> rows = usuarioSrv.find(AppUser.class,null);
        AppUser usuario = rows.get(0);
        usuario.setIduser(0L);
        Map<String, IErrorReg> errors;

        usuario.setAction(IDataRow.MODIFICAR);
        errors = usuarioSrv.checkDataRow("", usuario);
        assertTrue(errors.isEmpty());
        
        usuario.setAction(IDataRow.AGREGAR);        
        errors = usuarioSrv.checkDataRow("", usuario);
        assertFalse(errors.isEmpty());

        usuario.setAction(IDataRow.BORRAR);        
        errors = usuarioSrv.checkDataRow("", usuario);
        assertTrue(errors.isEmpty());
        
        usuario.setLogin("xxxxxxx");
        usuario.setAction(IDataRow.AGREGAR);        
        errors = usuarioSrv.checkDataRow("", usuario);
        assertTrue(errors.isEmpty());
        
     }        
    
    /** Prueba de ejecución del metodo de chequeo de acuerdo al tipo de operación
     * @throws java.lang.Exception
     */
    //@Test    
    public void testCheckData3() throws Exception {
        IDataService usuarioSrv  = 
                (IDataService) context.lookup(jndiProject+"UsuarioSrv!net.makerapp.services.IUsuarioSrvRemote");
        
        List<AppUser> rows = usuarioSrv.findAll(AppUser.class,null);
        rows.get(0).setAction(IDataRow.MODIFICAR);
        usuarioSrv.checkDataRow("", rows.get(0));
        
        rows.get(0).setAction(IDataRow.BORRAR);
        usuarioSrv.checkDataRow("", rows.get(0));
    }        
    
    /** Prueba chequeo de datos
     * @throws java.lang.Exception */
    //@Test    
    public void testCheckData4() throws Exception {
        IDataService usuarioSrv  = 
                (IDataService) context.lookup(jndiProject+"UsuarioSrv!net.makerapp.services.IUsuarioSrvRemote");
        
        List<AppUser> rows = usuarioSrv.findAll(AppUser.class,null);
        usuarioSrv.merge("", rows.get(0));
        //dataService.checkDataRow(rows.get(0), "");
       
    }        

    /** Prueba de chequeo de los foreignkeys
     * @throws java.lang.Exception */
    //@Test    
    public void testCheckForeignkey() throws Exception {
        IDataServiceRemote dataService  = 
                (IDataServiceRemote) context.lookup(jndiProject+"UsuarioMiembroSrv!org.javabeanstack.data.services.IDataServiceRemote");
        
        List<AppUserMember> rows = dataService.findAll(AppUserMember.class,null);
        assertTrue(dataService.checkForeignKey("",rows.get(0),"usuariogrupo"));
        rows.get(0).setUserGroup(null);        
        assertFalse(dataService.checkForeignKey("", rows.get(0),"usuariogrupo"));        
    }    

    /** Chequeo de los foreignkeys
     * @throws java.lang.Exception */
    //@Test    
    public void testCheckForeignKey2() throws Exception {
        IDataServiceRemote dataService  = 
                (IDataServiceRemote) context.lookup(jndiProject+"DataService!org.javabeanstack.data.services.IDataServiceRemote");
        
        Map<String, IErrorReg> errors;        
        List<Pais> rows = dataService.find(Pais.class,sessionId);
        rows.get(0).setAction(IDataRow.MODIFICAR);
        // Necesita del parametro sessionId para acceder a la unidad de persistencia adecuado        
        errors = dataService.checkDataRow(sessionId, rows.get(0));
        assertTrue(errors.isEmpty());
    }    

    //@Test        
    /** Chequeo de los foreignkeys
     * @throws java.lang.Exception */
    public void testCheckForeignKey3() throws Exception {
        IDataServiceRemote dataService  = 
                (IDataServiceRemote) context.lookup(jndiProject+"UsuarioMiembroSrv!org.javabeanstack.data.services.IDataServiceRemote");
        
        List<AppUserMember> rows = dataService.findAll(AppUserMember.class,null);
        AppUserMember usuarioMiembro = rows.get(0);
        usuarioMiembro.setAction(IDataRow.MODIFICAR);
        
        Map<String, IErrorReg> errors = dataService.checkDataRow(sessionId, rows.get(0));
        assertTrue(errors.isEmpty());
    }
    
    /** Chequeo de los foreignkeys
     * @throws java.lang.Exception */
    //@Test    
    public void testCheckForeignKey4() throws Exception {
        IDataServiceRemote dataService  = 
                (IDataServiceRemote) context.lookup(jndiProject+"PaisSrv!org.javabeanstack.data.services.IDataServiceRemote");
        
        List<Pais> rows = dataService.find(Pais.class, sessionId);
        Pais pais = rows.get(0);
        //pais.setRegion(null);
        pais.setAction(IDataRow.MODIFICAR);
        // Necesita del parametro sessionId para acceder a la unidad de persistencia adecuado                
        Map<String, IErrorReg> errors = dataService.checkDataRow(sessionId, pais);
        assertTrue(errors.isEmpty());
    }    
 }
