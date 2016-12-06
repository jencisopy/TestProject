/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.data;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import org.jboss.ejb.client.EJBClientContext;
import org.jboss.ejb.client.PropertiesBasedEJBClientConfiguration;
import org.jboss.ejb.client.remoting.ConfigBasedEJBClientContextSelector;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import py.com.oym.frame.data.IDataLink;
import py.com.oym.frame.data.IGenericDAORemote;
import py.com.oym.frame.web.remote.EjbApiRemote;
import py.com.oym.frame.data.IGenericDAO;

/**
 *
 * @author jenci_000
 */
public class TestEjbApi {

    private static Context context;

    @BeforeClass
    public static void setUpClass() throws Exception {
        Properties props = new Properties();
        props.put(context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        props.put( "org.jboss.ejb.client.scoped.context", "true" );

        // props.put("endpoint.name", "client-endpoint");
        props.put("remote.connections", "one");
        props.put("remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED", "false");
        props.put("remote.connection.one.connect.options.org.xnio.Options.SASL_POLICY_NOANONYMOUS", "false");
        props.put("remote.connection.one.port", "8080");
        props.put("remote.connection.one.host", "localhost");
        context = new InitialContext(props);        

//        Properties p = new Properties();
//        p.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
//        p.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
//        p.put(Context.SECURITY_PRINCIPAL, "jenciso");
//        p.put(Context.SECURITY_CREDENTIALS, "Oym1282873");
//        p.put("jboss.naming.client.ejb.context", true);
//        context = new InitialContext(p);

//        Properties props = new Properties();
//        props.put(context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
//        props.put("endpoint.name", "client-endpoint");
//        props.put("remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED","false");
//        props.put("remote.connections","default");
//        props.put("remote.connection.default.host","localhost");
//        props.put("remote.connection.default.port","8280");
//        props.put("remote.connection.default.connect.options.org.xnio.Options.SASL_POLICY_NOANONYMOUS","false");
//        props.put("remote.connection.default.username","jenciso");
//        props.put("remote.connection.default.password","Oym1282873");
//        EJBClientContext.setSelector(new 
//                            ConfigBasedEJBClientContextSelector(
//                                    new PropertiesBasedEJBClientConfiguration(props)));        
//        context = new InitialContext(props);
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
    public void testApi1() throws Exception {
        EjbApiRemote ejbRemote = new EjbApiRemote();
        ejbRemote.setApi(EjbApiRemote.EJBAPI);
        ejbRemote.setAppName("TestProjects-ear");
        ejbRemote.setModuleName("TestProjects-ejb");
        //ejbRemote.setAppName("Maker95-ear");
        //ejbRemote.setModuleName("Maker95-ejb");
        System.out.println(ejbRemote.getApi());
        System.out.println(ejbRemote.getAppName());
        System.out.println(ejbRemote.getModuleName());
        IDataLink data = ejbRemote.lookupDataLink();
        Long rec = data.getCount("select o FROM Empresa o", null);
        System.out.println(rec);
    }

    //@Test
    public void testGetCount() throws Exception {
        IGenericDAORemote dao = (IGenericDAORemote) context.lookup("ejb:TestProjects-ear/TestProjects-ejb//GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
        Long rec = dao.getCount("PU1", "select o FROM Empresa o", null);
        //IGenericDAO dao = (IGenericDAO) context.lookup("ejb:Maker-ear-9.5-SNAPSHOT/Maker-ejb-9.5-SNAPSHOT//GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
        System.out.println(rec);
    }

    @Test
    public void testGetCount2() throws Exception {
        String appName = "TestProjects-ear";
        String moduleName = "TestProjects-ejb";

        IGenericDAO dao = (IGenericDAO) context.lookup("ejb:" + appName + "/" + moduleName + "//GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
        Long rec = dao.getCount("PU1", "select o FROM Empresa o", null);
        //IGenericDAO dao = (IGenericDAO) context.lookup("ejb:Maker-ear-9.5-SNAPSHOT/Maker-ejb-9.5-SNAPSHOT//GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
        System.out.println(rec);
    }

}
