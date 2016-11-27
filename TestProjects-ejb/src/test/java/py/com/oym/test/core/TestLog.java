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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import py.com.oym.frame.error.ErrorReg;
import py.com.oym.frame.error.IErrorReg;
import py.com.oym.frame.log.ILogManager;
import py.com.oym.frame.security.ISecManager;
import py.com.oym.frame.security.IUserSession;
import py.com.oym.model.tables.DicLog;
import py.com.oym.frame.model.ILogRecord;

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

        ISecManager secMngr = (ISecManager) context.lookup("/TestProjects-ear/TestProjects-ejb/SecManager!py.com.oym.frame.security.ISecManagerRemote");

        userSession = secMngr.createSession("J", "", 98L);
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test1() throws NamingException {
        ILogManager logManager = (ILogManager) context.lookup("/TestProjects-ear/TestProjects-ejb/LogManager!py.com.oym.frame.log.ILogManagerRemote");
        assertNotNull(logManager);
    }

    @Test
    public void test2() throws NamingException {
        ILogManager logManager = (ILogManager) context.lookup("/TestProjects-ear/TestProjects-ejb/LogManager!py.com.oym.frame.log.ILogManagerRemote");
        IErrorReg errorReg = new ErrorReg("PRUEBA DE ERROR", 10, "prueba");
        assertTrue(logManager.dbWrite(DicLog.class, errorReg, userSession));
    }

    @Test
    public void test3() throws NamingException {
        ILogManager logManager = (ILogManager) context.lookup("/TestProjects-ear/TestProjects-ejb/LogManager!py.com.oym.frame.log.ILogManagerRemote");
        IErrorReg errorReg = new ErrorReg("PRUEBA DE ERROR2", 10, "prueba");
        assertTrue(logManager.dbWrite(DicLog.class, errorReg, userSession.getSessionId()));
    }

    @Test
    public void test4() throws NamingException {
        ILogManager logManager = (ILogManager) context.lookup("/TestProjects-ear/TestProjects-ejb/LogManager!py.com.oym.frame.log.ILogManagerRemote");
        boolean result
                = logManager.dbWrite(DicLog.class, userSession.getSessionId(),
                        "PRUEBA DE MENSAJE 3", "PRUEBA DE MENSAJE INFO",
                        100, ILogRecord.CATEGORY_APP, ILogRecord.LEVEL_ERROR, "xx", "xx1",
                        0, 0);
        assertTrue(result);
    }

    @Test
    public void test5() throws NamingException {
        ILogManager logManager = (ILogManager) context.lookup("/TestProjects-ear/TestProjects-ejb/LogManager!py.com.oym.frame.log.ILogManagerRemote");
        ILogRecord dicLog = new DicLog();
        dicLog.setCategory(ILogRecord.CATEGORY_APP);
        dicLog.setLevel(ILogRecord.LEVEL_INFO);
        dicLog.setMessage("PRUEBA MENSAJE 4");
        dicLog.setMessageInfo("PRUEBA MENSAJE INFO");

        boolean result = logManager.dbWrite(dicLog, userSession);
        assertTrue(result);
    }

    /*
    public void testBak() {
        String queryString;

        queryString = "insert into {schema}.dic_log "
                + "  (sesionid, fechahoracliente, maquina, idempresa, idusuario, nroerror, "
                + "   nromensaje, mensaje, eleccion, otros, clase, tipo, objeto, "
                + "   objetoelemento, nrolinea) "
                + " values "
                + "  (:sesionid, :fechahoracliente, :maquina, :idempresa, :idusuario, :nroerror, "
                + "   :nromensaje, :mensaje, :eleccion, :otros, :clase, :tipo, :objeto, "
                + "   :objetoelemento, :nrolinea) ";

        Long idempresa = null;
        Long idusuario = null;
        String ipClient = "";
        String sesionId = "NINGUNA";
        String otros = "";

        if (!Strings.isNullorEmpty(sessionId)) {
            IUserSession userSession = sessions.getUserSession(sessionId);
            if (userSession != null) {
                idempresa = userSession.getIdEmpresa();
                idusuario = userSession.getUser().getIdusuario();
                ipClient = userSession.getIp();
                sesionId = Strings.dateToString(userSession.getTimeLogin())
                        + userSession.getUser().getCodigo().trim();
            }
        }
        if (errorReg.getException() != null) {
            otros = ErrorManager.getStackCause(errorReg.getException());
        }

        Map<String, Object> parameters = new HashMap();
        parameters.put("sesionid", sesionId);
        parameters.put("fechahoracliente", new Date());
        parameters.put("maquina", ipClient);
        parameters.put("idempresa", idempresa);
        parameters.put("idusuario", idusuario);
        parameters.put("nroerror", 0L);
        parameters.put("nromensaje", errorReg.getErrorNumber());
        parameters.put("mensaje", errorReg.getMessage());
        parameters.put("eleccion", 0L);
        parameters.put("otros", otros);
        parameters.put("tipo", "E");
        parameters.put("clase", "A");
        parameters.put("objeto", "");
        parameters.put("objetoelemento", errorReg.getFieldName());
        parameters.put("nrolinea", 0L);

        IErrorReg errorSql = dao.sqlExec(IDBManager.CATALOGO, queryString, parameters);
        return errorSql == null;

    }
    */
}
