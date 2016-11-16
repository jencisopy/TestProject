/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.data;

import java.util.Properties;
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
import py.com.oym.frame.data.IGenericDAO;
import py.com.oym.frame.data.IGenericDAORemote;
import py.com.oym.frame.web.remote.EjbApiRemote;
import static py.com.oym.test.data.TestDao.context;

/**
 *
 * @author jenci_000
 */
public class TestEjbApi {
    

    @BeforeClass
    public static void setUpClass() throws Exception {
        Properties props = new Properties();
        props.put(context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        props.put("endpoint.name", "client-endpoint");
        props.put("remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED","false");
        props.put("remote.connections","default");
        props.put("remote.connection.default.host","localhost");
        props.put("remote.connection.default.port","8280");
        props.put("remote.connection.default.connect.options.org.xnio.Options.SASL_POLICY_NOANONYMOUS","false");
        props.put("remote.connection.default.username","jenciso");
        props.put("remote.connection.default.password","Oym1282873");
        EJBClientContext.setSelector(new 
                            ConfigBasedEJBClientContextSelector(
                                    new PropertiesBasedEJBClientConfiguration(props)));        
        context = new InitialContext(props);
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
    public void testApi1() throws Exception{
        EjbApiRemote ejbRemote = new EjbApiRemote();
        ejbRemote.setApi(EjbApiRemote.EJBAPI);
        System.out.println(ejbRemote.getApi());
        System.out.println(ejbRemote.getAppName());
        System.out.println(ejbRemote.getModuleName());
        IDataLink data = ejbRemote.lookupDataLink();
        Long rec = data.getCount("select o FROM Empresa o", null);
        System.out.println(rec);
    }
    
    //@Test
    public void testGetCount() throws Exception{
        IGenericDAORemote dao  = (IGenericDAORemote) context.lookup("ejb:TestProjects-ear/TestProjects-ejb//GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
        Long rec = dao.getCount("PU1", "select o FROM Empresa o", null);
        //IGenericDAO dao = (IGenericDAO) context.lookup("ejb:Maker-ear-9.5-SNAPSHOT/Maker-ejb-9.5-SNAPSHOT//GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
        System.out.println(rec);
    }
    
    @Test
    public void testGetCount2() throws Exception{
        String appName = "Maker-ear-9.5-SNAPSHOT";
        String moduleName = "Maker-ejb-9.5-SNAPSHOT";
       
        IGenericDAO dao = (IGenericDAO) context.lookup("ejb:" + appName + "/" + moduleName + "//GenericDAO!py.com.oym.frame.data.IGenericDAORemote");        
        Long rec = dao.getCount("PU1", "select o FROM Empresa o", null);
        //IGenericDAO dao = (IGenericDAO) context.lookup("ejb:Maker-ear-9.5-SNAPSHOT/Maker-ejb-9.5-SNAPSHOT//GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
        System.out.println(rec);
    }
    
    
}
