/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.data;

import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
import py.com.oym.frame.data.DataLink;
import py.com.oym.frame.security.ISecManagerRemote;
import py.com.oym.frame.security.ISessionsRemote;
import py.com.oym.frame.security.IUserSession;
import py.com.oym.frame.data.IGenericDAO;


/**
 *
 * @author Jorge Enciso
 */
public class TestSesiones extends TestClass{
   
    public TestSesiones() {
    }
    
    //@Test
    public void test() throws Exception {
        ISessionsRemote sesiones  = (ISessionsRemote) context.lookup("/TestProjects-ear/TestProjects-ejb/Sessions!py.com.oym.frame.security.ISessionsRemote");
        IUserSession userSession = sesiones.login("J", "");
        assertNotNull(userSession);
    }
    
  
    //@Test
    public void testLogin() throws Exception {
        ISecManagerRemote sesiones  = (ISecManagerRemote) context.lookup("/TestProjects-ear/TestProjects-ejb/SecManager!py.com.oym.frame.security.ISecManagerRemote");
        assertNotNull(sesiones);                
        IUserSession userSession = sesiones.login2("webuser", "123456");
        assertNotNull(userSession);        
        //boolean login = sesiones.login("webuser", "123456");
        //boolean login = sesiones.isSesionIdValid("xx");
        //assertEquals(true, login); 
    }
    
    //@Test
    public void testCreateSession() throws Exception {
        ISecManagerRemote sesiones  = (ISecManagerRemote) context.lookup("/TestProjects-ear/TestProjects-ejb/SecManager!py.com.oym.frame.security.ISecManagerRemote");
        IUserSession userSesion = sesiones.createSession("webuser", "123456",98L, null);
        if (userSesion.getError() != null){
            System.out.println(userSesion.getError().getMessage());
        }
        assertNotNull(userSesion.getSessionId());
        assertTrue(sesiones.isSesionIdValid(userSesion.getSessionId()));
        System.out.println(sesiones.getUserRol("J"));
    }    

    //@Test
    public void testSesionExpirada() throws Exception {
        ISecManagerRemote sesiones  = (ISecManagerRemote) context.lookup("/TestProjects-ear/TestProjects-ejb/SecManager!py.com.oym.frame.security.ISecManagerRemote");
        IUserSession userSesion = sesiones.createSession("webuser", "123456",98L, 0);
        if (userSesion.getError() != null){
            System.out.println(userSesion.getError().getMessage());
        }
        assertFalse(sesiones.isSesionIdValid(userSesion.getSessionId()));
    }    
    
    //@Test
    public void testDataLink() throws Exception {
        IGenericDAO dao  = (IGenericDAO) context.lookup("/TestProjects-ear/TestProjects-ejb/GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
        DataLink dataLink1 = new DataLink(dao);
        //IUserSession userSession = new UserSession();
        //dataLink.setUserSession(userSession);
        
        List<Object> result = dataLink1.findByNativeQuery("select * from {schema}.empresa", null);
        assertNotNull(result);
    }        
    
    //@Test
    public void testDataLink2() throws Exception {
        ISecManagerRemote sesiones  = (ISecManagerRemote) context.lookup("/TestProjects-ear/TestProjects-ejb/SecManager!py.com.oym.frame.security.ISecManagerRemote");        
        IGenericDAO dao  = (IGenericDAO) context.lookup("/TestProjects-ear/TestProjects-ejb/GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
        DataLink dataLink1 = new DataLink(dao); 
        
        IUserSession userSession = sesiones.createSession("webuser", "123456",98L, null);
        if (userSession.getError() != null){
            System.out.println(userSession.getError().getMessage());
        }
        assertNotNull(userSession.getSessionId());
        assertTrue(sesiones.isSesionIdValid(userSession.getSessionId()));

        dataLink1.setUserSession(userSession);
        
        List<Object> result = dataLink1.findByNativeQuery("select * from {schema}.moneda", null);
        assertNotNull(result);
    }            
}
