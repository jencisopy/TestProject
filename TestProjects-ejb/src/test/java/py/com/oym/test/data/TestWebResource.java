/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.data;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;

import org.javabeanstack.security.ISecManager;
import org.javabeanstack.security.model.IUserSession;
import org.javabeanstack.ws.resources.IWebResource;
import py.com.oym.frame.ws.resources.remote.WebResource;

/**
 *
 * @author Jorge Enciso
 */
public class TestWebResource extends TestClass {
    public TestWebResource() {
    }


    
    //@Test
    public void testWebResource1() throws Exception {
        IWebResource webResource = new WebResource();
        assertNotNull(webResource.getSecManager(jndiProject+"SecManager!org.javabeanstack.security.ISecManagerRemote"));
    }
    
    @Test
    /** Prueba de crear y cerrar sesión */
    public void testWebResource2() throws Exception {
        IWebResource webResource = new WebResource();        
        ISecManager secManager = 
              (ISecManager)webResource.getSecManager("ejb:TestProjects-ear/TestProjects-ejb/SecManager!org.javabeanstack.security.ISecManagerRemote");
        IUserSession userSession = secManager.createSession("J", "", 98L, null, null);
        assertNotNull(userSession);
        secManager.logout(userSession);
    }
    
    @Test
    /** Prueba de Buscar registros */
    public void testWebResource3() throws Exception {
    }

    @Test
    //TODO Prueba de count
    /** Prueba de count */
    public void testWebResource4() throws Exception {
    }

    @Test
    /** Prueba grabación */
    public void testWebResource5() throws Exception {
    }
}
