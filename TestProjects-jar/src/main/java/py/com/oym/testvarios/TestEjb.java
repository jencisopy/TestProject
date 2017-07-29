/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.testvarios;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.javabeanstack.xml.IXmlSearcher;

/**
 *
 * @author Jorge Enciso
 */
public class TestEjb {
    private Context context;

    public TestEjb() throws NamingException{
        Properties props = new Properties();
        props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        props.put("org.jboss.ejb.client.scoped.context", "true");

        // props.put("endpoint.name", "client-endpoint");
        props.put("remote.connections", "one");
        props.put("remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED", "false");
        props.put("remote.connection.one.connect.options.org.xnio.Options.SASL_POLICY_NOANONYMOUS", "false");
        props.put("remote.connection.one.port", "8080");
        props.put("remote.connection.one.host", "localhost");
        context = new InitialContext(props);
    }

    void test() throws Exception {

        IXmlSearcher xmlSearcher;
        xmlSearcher = (IXmlSearcher) context.lookup("ejb:TestProjects-ear/TestProjects-ejb/XmlSearcher!py.com.oym.frame.xml.IXmlSearcher");
        String result = xmlSearcher.search(null,
                "file:///proyectos/java/oym/TestProjects/clasemaker.xml");

    }
}
