/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.data;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import org.junit.BeforeClass;
import org.junit.Test;
import org.javabeanstack.data.IDataLink;
import org.javabeanstack.data.IGenericDAORemote;
import py.com.oym.frame.web.remote.EjbApiRemote;
import org.javabeanstack.data.IGenericDAO;

/**
 *
 * @author Jorge Enciso
 */
public class TestEjbApi {

    private static Context context;

    @BeforeClass
    public static void setUpClass() throws Exception {
        Properties props = new Properties();
        props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        props.put( "org.jboss.ejb.client.scoped.context", "true" );

        // props.put("endpoint.name", "client-endpoint");
        props.put("remote.connections", "one");
        props.put("remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED", "false");
        props.put("remote.connection.one.connect.options.org.xnio.Options.SASL_POLICY_NOANONYMOUS", "false");
        props.put("remote.connection.one.port", "8080");
        props.put("remote.connection.one.host", "localhost");
        context = new InitialContext(props);        
    }

    @Test
    public void testApi1() throws Exception {
        EjbApiRemote ejbRemote = new EjbApiRemote();
        ejbRemote.setApi(EjbApiRemote.EJBAPI);
        ejbRemote.setAppName("TestProjects-ear");
        ejbRemote.setModuleName("TestProjects-ejb");
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
        System.out.println(rec);
    }

    @Test
    public void testGetCount2() throws Exception {
        String appName = "TestProjects-ear";
        String moduleName = "TestProjects-ejb";

        IGenericDAO dao = (IGenericDAO) context.lookup("ejb:" + appName + "/" + moduleName + "//GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
        Long rec = dao.getCount("PU1", "select o FROM Empresa o", null);
        System.out.println(rec);
    }

}
