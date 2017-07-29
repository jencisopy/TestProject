/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.xml;

import javax.naming.NamingException;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

import org.javabeanstack.xml.IXmlDom;
import org.javabeanstack.xml.IXmlManager;
import org.javabeanstack.xml.IXmlSearcher;
import org.javabeanstack.xml.XmlDomW3c;
import py.com.oym.test.data.TestClass;

/**
 *
 * @author Jorge Enciso
 */
public class TestFileSearcher extends TestClass {

    //@Test
    public void testInstance() throws Exception {
        IXmlManager instance
                = (IXmlManager) context.lookup("/TestProjects-ear/TestProjects-ejb/XmlManager!py.com.oym.frame.xml.IXmlManagerRemote");
        assertNotNull(instance);
    }

    //@Test
    public void test1() throws Exception {
        IXmlManager xmlManager
                = (IXmlManager) context.lookup("/TestProjects-ear/TestProjects-ejb/XmlManager!py.com.oym.frame.xml.IXmlManagerRemote");

        assertNotNull(xmlManager.getXmlSearcher());

    }

    //@Test

    public void test2() throws NamingException {
        IXmlDom xmlDom = new XmlDomW3c();
        IXmlSearcher xmlSearcher;
        xmlSearcher = (IXmlSearcher) context.lookup("/TestProjects-ear/TestProjects-ejb/XmlSearcher!py.com.oym.frame.xml.IXmlSearcher");
        String result = xmlSearcher.search(xmlDom,
                "file:///proyectos/java/oym/TestProjects/clasemaker.xml");
        assertNotNull(result);
    }

    
    @Test
    public void test3() {
        Thread thread1 = new Thread(new Thread1());
        thread1.start();
    }

    class Thread1 implements Runnable {

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "-" + i);
                    Thread.sleep(100);
                }
            } catch (Exception exp) {
                Thread.currentThread().interrupt();
            }

        }
    }

}
