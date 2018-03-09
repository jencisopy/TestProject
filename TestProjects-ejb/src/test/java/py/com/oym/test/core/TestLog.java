/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.core;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import org.javabeanstack.error.ErrorReg;
import org.javabeanstack.error.IErrorReg;
import org.javabeanstack.security.ISecManager;
import org.javabeanstack.security.IUserSession;

import py.com.oym.model.tables.DicLog;
import org.javabeanstack.model.IAppLogRecord;
import org.javabeanstack.log.ILogManager;


/**
 *
 * @author Jorge Enciso
 */
public class TestLog {

    static Context context;
    static IUserSession userSession;

    public TestLog() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        Properties p = new Properties();
        p.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        p.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        p.put(Context.SECURITY_PRINCIPAL, "jenciso");
        p.put(Context.SECURITY_CREDENTIALS, "Oym1282873");
        p.put("jboss.naming.client.ejb.context", true);
        context = new InitialContext(p);

        ISecManager secMngr = (ISecManager) context.lookup("/TestProjects-ear/TestProjects-ejb/SecManager!org.javabeanstack.security.ISecManagerRemote");

        userSession = secMngr.createSession("J", "", 98L, null);
    }


    @Test
    public void test1() throws NamingException {
        ILogManager logManager = (ILogManager) context.lookup("/TestProjects-ear/TestProjects-ejb/LogManager!org.javabeanstack.frame.log.ILogManagerRemote");
        assertNotNull(logManager);
    }

    @Test
    public void test2() throws NamingException {
        ILogManager logManager = (ILogManager) context.lookup("/TestProjects-ear/TestProjects-ejb/LogManager!org.javabeanstack.log.ILogManagerRemote");
        IErrorReg errorReg = new ErrorReg("PRUEBA DE ERROR", 10, "prueba");
        assertTrue(logManager.dbWrite(DicLog.class, errorReg, userSession));
    }

    @Test
    public void test3() throws NamingException {
        ILogManager logManager = (ILogManager) context.lookup("/TestProjects-ear/TestProjects-ejb/LogManager!org.javabeanstack.log.ILogManagerRemote");
        IErrorReg errorReg = new ErrorReg("PRUEBA DE ERROR2", 10, "prueba");
        assertTrue(logManager.dbWrite(DicLog.class, errorReg, userSession.getSessionId()));
    }

    @Test
    public void test4() throws NamingException {
        ILogManager logManager = (ILogManager) context.lookup("/TestProjects-ear/TestProjects-ejb/LogManager!org.javabeanstack.log.ILogManagerRemote");
        boolean result
                = logManager.dbWrite(DicLog.class, userSession.getSessionId(),
                        "PRUEBA DE MENSAJE 3", "PRUEBA DE MENSAJE INFO",
                        100, IAppLogRecord.CATEGORY_APP, IAppLogRecord.LEVEL_ERROR, "xx", "xx1",
                        0, 0);
        assertTrue(result);
    }

    @Test
    public void test5() throws NamingException {
        ILogManager logManager = (ILogManager) context.lookup("/TestProjects-ear/TestProjects-ejb/LogManager!org.javabeanstack.log.ILogManagerRemote");
        IAppLogRecord dicLog = new DicLog();
        dicLog.setCategory(IAppLogRecord.CATEGORY_APP);
        dicLog.setLevel(IAppLogRecord.LEVEL_INFO);
        dicLog.setMessage("PRUEBA MENSAJE 4");
        dicLog.setMessageInfo("PRUEBA MENSAJE INFO");

        boolean result = logManager.dbWrite(dicLog, userSession);
        assertTrue(result);
    }

}
