/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.config;

import java.util.List;
import org.junit.Test;
import org.javabeanstack.config.IAppConfig;
import py.com.oym.test.data.TestClass;
import org.w3c.dom.Document;
import org.javabeanstack.model.IAppSystemParam;
import org.javabeanstack.xml.DomW3cParser;
import static org.junit.Assert.*;


/**
 *
 * @author Jorge Enciso
 */
public class TestConfig extends TestClass {
    //@Test
    public void test1() throws Exception{
        IAppConfig appConfig  = (IAppConfig) context.lookup("/TestProjects-ear/TestProjects-ejb/AppConfig!org.javabeanstack.config.IAppConfig");
        assertNotNull(appConfig);
    }
    
    //@Test
    public void test2() throws Exception{
        IAppConfig appConfig  = (IAppConfig) context.lookup("/TestProjects-ear/TestProjects-ejb/AppConfig!org.javabeanstack.config.IAppConfig");
        assertNotNull(appConfig);
        
        String attr = appConfig.getProperty("nombre", "System", "Sistema");
        System.out.println(attr);
        assertEquals("Maker",attr);
        
        boolean result = appConfig.setProperty("Prueba","edicion", "SYSTEM", "/Configuration/Sistema");
        assertTrue(result);        
        attr = appConfig.getProperty("edicion", "SYSTEM", "Sistema");
        assertEquals("Prueba",attr);
    }
    
    @Test
    public void test3() throws Exception{
        IAppConfig appConfig  = (IAppConfig) context.lookup("/TestProjects-ear/TestProjects-ejb/AppConfig!org.javabeanstack.config.IAppConfig");
        assertNotNull(appConfig);
        
        IAppSystemParam param = appConfig.getSystemParam("Passwordminchar");
        System.out.println(param.getId());
        
        param = appConfig.getSystemParam(param.getIdAppSystemParam());
        System.out.println(param.getParam());
        
        List<IAppSystemParam> params = appConfig.getSystemParams();
        assertNotNull(params);
        System.out.println(params.size());
        
        Document dom = appConfig.getConfigDOM("SYSTEM");
        assertNotNull(dom);
        System.out.println(DomW3cParser.getXmlText(dom));
    }
}
