/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.digitalbox.tests;

import java.util.ArrayList;
import java.util.List;
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
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import py.com.digitalbox.model.tables.BxCampo;

import org.javabeanstack.data.DataLink;
import org.javabeanstack.data.IDataResult;
import org.javabeanstack.exceptions.SessionError;
import org.javabeanstack.security.ISecManager;
import org.javabeanstack.security.IUserSession;
import org.javabeanstack.data.IGenericDAO;

/**
 *
 * @author Jorge Enciso
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestDatos5 {

    static Context context;
    static DataLink dataLink;
    static IGenericDAO dao;

    public TestDatos5() {
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

        ISecManager secMngr = (ISecManager) context.lookup("/ItBox-1.0//SecManager!py.com.oym.frame.security.ISecManagerRemote");

        dao = (IGenericDAO) context.lookup("/ItBox-1.0//GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
//        dao.sqlExec("PU2", "remove from {schema}.bx_index where codigo = '002';", null);                
//        dao.sqlExec("PU2", "remove from {schema}.bx_documentotipo where codigo = '002';", null);                
//        dao.sqlExec("PU2", "remove from {schema}.bx_plantilla where codigo = '002';", null);        
//        dao.sqlExec("PU2", "remove from {schema}.bx_repositorio where codigo = '002';", null);                        
//        dao.sqlExec("PU2", "remove from {schema}.bx_campo where codigo = '002';", null);        

        IUserSession userSession = secMngr.createSession("J", "", 10L, null);
        dataLink = new DataLink(dao);
        dataLink.setUserSession(userSession);
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
    public void test0findByUk() throws NamingException, SessionError, Exception {
        System.out.println("1");
        boolean result = true;

        BxCampo campo = new BxCampo();
        campo.setCodigo("codigo");
        campo.setIdempresa(10L);

        BxCampo camporesult = dataLink.findByUk(BxCampo.class, campo);
        if (camporesult != null) {
            result = false;
        }
        assertTrue(result);
    }

//    @Test
    public void test1persist() throws NamingException, SessionError, Exception {
        System.out.println("2");
        BxCampo campo = new BxCampo();
        campo.setCodigo("12345");
        campo.setNombre("Codigo");
        campo.setTipo("C");
        campo.setIdempresa(10L);
        IDataResult resultado;
        resultado = dataLink.persist(campo);
        assertTrue(resultado.isSuccessFul());
    }

//    @Test
    public void test2merge() throws NamingException, SessionError, Exception {
        System.out.println("3");
        BxCampo campo = new BxCampo();
        campo.setCodigo("12345");
        campo.setIdempresa(10L);
        BxCampo camporesult = dataLink.findByUk(BxCampo.class, campo);
        IDataResult resultado;
        if (camporesult != null) {
            camporesult.setNombre("CodigoUpdated");
            resultado = dataLink.merge(camporesult);
            assertTrue(resultado.isSuccessFul());
        } else {
            fail("Codigo no encontrado");
        }
            
    }
    
//    @Test
    public void test3find() throws NamingException, SessionError, Exception {
        System.out.println("4");
        BxCampo campo = new BxCampo();
        campo.setCodigo("codigo");
        campo.setIdempresa(10L);
        BxCampo camporesult = dataLink.findByQuery(BxCampo.class,"select o from BxCampo o where o.codigo='12345' and o.idempresa=10",null);
        if (camporesult != null) {
            assertTrue(true);
        } else {
            fail("No se encuentra valor buscado");
        }
    }    

//   @Test
    public void test4delete() throws NamingException, SessionError, Exception {
        System.out.println("5");
        BxCampo campo = new BxCampo();
        campo.setCodigo("codigo");
        campo.setIdempresa(10L);
        BxCampo camporesult = dataLink.findByQuery(BxCampo.class,"select o from BxCampo o where o.codigo='12345' and o.idempresa=10",null);
        IDataResult resultado;
        if (camporesult != null) {
            resultado = dataLink.remove(camporesult);
            assertTrue(resultado.isSuccessFul());
        } else {
            fail("No se encuentra valor buscado");
        }
    }    
    
   @Test
    public void test5persistList() throws NamingException, SessionError, Exception {
        System.out.println("6");
        List<BxCampo> campolist = new ArrayList();
        
        BxCampo campo = new BxCampo();
        campo.setCodigo("54321");
        campo.setNombre("Codigo 001");
        campo.setTipo("C");
        campo.setIdempresa(10L);
        
        BxCampo campo2 = new BxCampo();
        campo2.setCodigo("65432");
        campo2.setNombre("Codigo 002");
        campo2.setTipo("C");
        campo2.setIdempresa(10L);
        //genera un error a proposito y verificamos si la transaccion en si revierte
        
        campolist.add(campo);
        campolist.add(campo2);
        IDataResult resultado;
        resultado = dataLink.persist(campolist);
        assertTrue(resultado.isSuccessFul());
    }        
}
