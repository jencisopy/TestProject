/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.data;

import java.util.List;
import org.javabeanstack.security.ISecManager;
import org.javabeanstack.security.model.IUserSession;
import org.junit.Test;
import py.com.oym.frame.data.DataUtil;
import static py.com.oym.test.data.TestClass.sessionId;

/**
 *
 * @author Jorge Enciso
 */
public class TestDataUtil extends TestClass {
    @Test
    public void testEmpresaList() throws Exception{
        ISecManager secMngr = (ISecManager)context.lookup(jndiProject+"SecManager!org.javabeanstack.security.ISecManagerRemote");
        IUserSession userSession = secMngr.createSession("J", "", 50L, null, null);        
        sessionId = userSession.getSessionId();
        List<Long> empresaList = DataUtil.getEmpresaList(userSession);
        empresaList.forEach((idempresa) -> {
            System.out.println(idempresa);
        });
        System.out.println(userSession.getDBFilter().getAllFilterExpr());
    }   
}
