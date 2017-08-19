/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.resources;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.Test;
import org.javabeanstack.resources.IAppResource;
import org.javabeanstack.xml.IXmlDom;
import py.com.oym.test.generic.TestClass;
import static org.junit.Assert.*;

/**
 *
 * @author Jorge Enciso
 */
public class TestAppResource extends TestClass{
    //@Test
    public void test() throws Exception{
        IAppResource appResource  = (IAppResource) context.lookup("/TestProjects-ear/TestProjects-ejb/AppResource!org.javabeanstack.resources.IAppResource");
        assertNotNull(appResource);
    }    
    
    //@Test
    public void testXmlDom() throws Exception{
        IAppResource appResource  = (IAppResource) context.lookup("/TestProjects-ear/TestProjects-ejb/AppResource!org.javabeanstack.resources.IAppResource");
        assertNotNull(appResource);
        String resourcePath = "file:///xml/itemventa_cliente_operativo.xml";
        IXmlDom xmlDom = appResource.getResourceAsXmlDom(sessionId, resourcePath, "", null);
        assertNotNull(xmlDom);
        System.out.println(xmlDom.getXml());
    }    
    
    //@Test
    public void testXmlDom2() throws Exception{
        IAppResource appResource  = (IAppResource) context.lookup("/TestProjects-ear/TestProjects-ejb/AppResource!org.javabeanstack.resources.IAppResource");
        assertNotNull(appResource);
        String resourcePath = "file:///xml/itemventa_cliente_operativo1.xml";
        IXmlDom xmlDom = appResource.getResourceAsXmlDom(sessionId, resourcePath, "", null);
        assertNull(xmlDom);
    }    
    
    @Test
    public void testGetJRXml() throws Exception{
        IAppResource appResource  = (IAppResource) context.lookup("/TestProjects-ear/TestProjects-ejb/AppResource!org.javabeanstack.resources.IAppResource");
        assertNotNull(appResource);
        String resourcePath = "file:///reports/itemventa_cliente_operativo01.jrxml";
        byte[] result = appResource.getResourceAsBytes(sessionId, resourcePath);
        assertNotNull(result);
        InputStream in = new ByteArrayInputStream(result);
    }    
}
