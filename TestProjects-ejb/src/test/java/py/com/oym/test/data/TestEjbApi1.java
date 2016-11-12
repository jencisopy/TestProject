/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.data;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import org.jboss.ejb.client.ContextSelector;
import org.jboss.ejb.client.EJBClientConfiguration;
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

/**
 *
 * @author jenci_000
 */
public class TestEjbApi1 {
    private static Context context;

    @BeforeClass
    public static void setUpClass() throws Exception {
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

        context = new InitialContext(jndiProperties);

        Properties jbossProperties = new Properties();
        InputStream inputStream;
        inputStream = new FileInputStream("C:\\proyectos\\java\\oym\\TestProject\\TestProject-ejb\\test\\jboss-ejb-client.properties");
        jbossProperties.load(inputStream);
        jbossProperties.put("remote.connection.default.username", "jenciso");
        jbossProperties.put("remote.connection.default.password", "Oym1282873");

        final EJBClientConfiguration ejbClientConfiguration = new PropertiesBasedEJBClientConfiguration(jbossProperties);

        // EJB client context selection is based on selectors. So let's create a ConfigBasedEJBClientContextSelector which uses our EJBClientConfiguration created in previous step
        final ContextSelector<EJBClientContext> ejbClientContextSelector = new ConfigBasedEJBClientContextSelector(ejbClientConfiguration);

        // Now let's setup the EJBClientContext to use this selector
        EJBClientContext.setSelector(ejbClientContextSelector);
        
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
        
    }
    
    @Test
    public void testGetCount() throws Exception{
        IGenericDAORemote dao  = (IGenericDAORemote) context.lookup("ejb:TestProject/TestProject-ejb//GenericDAO!py.com.oym.frame.data.IGenericDAORemote");        
        Long rec = dao.getCount("PU1", "select o FROM Empresa o", null);
        //IGenericDAO dao = (IGenericDAO) context.lookup("ejb:Maker-ear-9.5-SNAPSHOT/Maker-ejb-9.5-SNAPSHOT//GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
        System.out.println(rec);
    }
    
}
