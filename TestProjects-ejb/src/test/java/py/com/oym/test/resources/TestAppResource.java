/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.resources;

import static org.junit.Assert.*;
import org.junit.Test;
import py.com.oym.frame.resources.IAppResource;
import py.com.oym.frame.xml.IXmlDom;
import py.com.oym.test.generic.TestClass;

/**
 *
 * @author Jorge Enciso
 */
public class TestAppResource extends TestClass{
    //@Test
    public void test() throws Exception{
        IAppResource appResource  = (IAppResource) context.lookup("/TestProjects-ear/TestProjects-ejb/AppResource!py.com.oym.frame.resources.IAppResource");
        assertNotNull(appResource);
    }    
    
    @Test
    public void testXmlDom() throws Exception{
        IAppResource appResource  = (IAppResource) context.lookup("/TestProjects-ear/TestProjects-ejb/AppResource!py.com.oym.frame.resources.IAppResource");
        assertNotNull(appResource);
        String resourcePath = "file:///xml/itemventa_cliente_operativo.xml";
        IXmlDom xmlDom = appResource.getResourceAsXmlDom(sessionId, resourcePath, "", null);
        assertNotNull(xmlDom);
        System.out.println(xmlDom.getXml());
    }    
    
    //@Test
    public void testXmlDom2() throws Exception{
        IAppResource appResource  = (IAppResource) context.lookup("/TestProjects-ear/TestProjects-ejb/AppResource!py.com.oym.frame.resources.IAppResource");
        assertNotNull(appResource);
        String resourcePath = "file:///xml/itemventa_cliente_operativo1.xml";
        IXmlDom xmlDom = appResource.getResourceAsXmlDom(sessionId, resourcePath, "", null);
        assertNull(xmlDom);
    }    
}