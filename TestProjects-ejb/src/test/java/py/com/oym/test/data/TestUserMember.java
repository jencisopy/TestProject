/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.data;

import javax.naming.NamingException;
import org.javabeanstack.security.ISecManager;
import org.junit.Test;
import static org.junit.Assert.*;
import static py.com.oym.test.data.TestClass.context;


/**
 *
 * @author jenci_000
 */
public class TestUserMember extends TestClass{
   
    public TestUserMember() {
    }
   

    @Test
    public void test() throws NamingException {
        ISecManager secMngr = (ISecManager)context.lookup(jndiProject+"SecManager!org.javabeanstack.security.ISecManagerRemote");
        assertTrue(secMngr.isUserMemberOf("J", "Administradores"));
    }
}
