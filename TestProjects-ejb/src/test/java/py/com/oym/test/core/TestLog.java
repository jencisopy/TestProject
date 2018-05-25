/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.core;

import javax.naming.NamingException;
import org.junit.Test;
import static org.junit.Assert.*;

import org.javabeanstack.error.ErrorReg;
import org.javabeanstack.error.IErrorReg;

import py.com.oym.model.tables.DicLog;
import org.javabeanstack.model.IAppLogRecord;
import org.javabeanstack.log.ILogManager;
import py.com.oym.test.data.TestClass;


/**
 *
 * @author Jorge Enciso
 */
public class TestLog extends TestClass {


    public TestLog() {
    }



    @Test
    public void test1() throws NamingException {
        ILogManager logManager = (ILogManager) context.lookup("/TestProjects-ear/TestProjects-ejb/LogManager!org.javabeanstack.frame.log.ILogManagerRemote");
        assertNotNull(logManager);
    }

    @Test
    public void test3() throws NamingException {
        ILogManager logManager = (ILogManager) context.lookup("/TestProjects-ear/TestProjects-ejb/LogManager!org.javabeanstack.log.ILogManagerRemote");
        IErrorReg errorReg = new ErrorReg("PRUEBA DE ERROR2", 10, "prueba");
        assertTrue(logManager.dbWrite(DicLog.class, sessionId, errorReg));
    }

    @Test
    public void test4() throws NamingException {
        ILogManager logManager = (ILogManager) context.lookup("/TestProjects-ear/TestProjects-ejb/LogManager!org.javabeanstack.log.ILogManagerRemote");
        boolean result
                = logManager.dbWrite(DicLog.class, sessionId,
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

        boolean result = logManager.dbWrite(dicLog, sessionId);
        assertTrue(result);
    }

}
