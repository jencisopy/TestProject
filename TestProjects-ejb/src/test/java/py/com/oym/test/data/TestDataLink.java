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
import javax.naming.NamingException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static py.com.oym.test.data.TestDataNativeQuery.context;
import py.com.oym.frame.data.IDataNativeQuery;
import py.com.oym.frame.data.IDataQueryModel;
import py.com.oym.frame.data.IGenericDAO;
import py.com.oym.frame.data.DataLink;
import py.com.oym.frame.error.SessionError;
import py.com.oym.model.tables.Usuario;

/**
 *
 * @author jenci_000
 */
public class TestDataLink {
    
    public TestDataLink() {
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

    //@Test
    public void test() throws NamingException, SessionError{
        IGenericDAO dao  = (IGenericDAO) context.lookup("/TestProject/TestProject-ejb/GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
        //IGenericDAO dao  = (IGenericDAO) context.lookup("/Maker-ear-9.5-SNAPSHOT/Maker-ejb-9.5-SNAPSHOT/GenericDAO!py.com.oym.frame.data.IGenericDAORemote");

        DataLink dataLink = new DataLink(dao);

        Map<String, Object> persistProp = dataLink.getPersistUnitProp();
        assertNotNull(dao);
        IDataNativeQuery query = dataLink.newDataNativeQuery();
        
        List<IDataQueryModel> result = query.select("idempresa, nombre").
                                                    from("{schema}.empresa").
                                                    execQuery();
        
        assertNotNull(result);
    }
    
    //@Test
    public void test2() throws NamingException, Exception{
        IGenericDAO dao  = (IGenericDAO) context.lookup("/TestProject/TestProject-ejb/GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
        DataLink dataLink = new DataLink(dao);

        List<Object> result = dataLink.findByNativeQuery("select * from {schema}.empresa", null);
        assertNotNull(result);
        
    }

    @Test
    public void test3() throws NamingException, SessionError, Exception{
        IGenericDAO dao  = (IGenericDAO) context.lookup("/TestProject/TestProject-ejb/GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
        DataLink dataLink = new DataLink(dao);
        Usuario usuario = dataLink.find(Usuario.class, 3L);
        System.out.println(usuario.getValue("empresa.nombre"));
        assertNotNull(usuario.getValue("empresa.nombre"));
    }
}
