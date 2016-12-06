/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.data;

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
import py.com.oym.frame.data.DataExpression;
import py.com.oym.frame.data.DataLink;
import py.com.oym.frame.data.IDataExpression;
import py.com.oym.frame.data.IDataLink;
import py.com.oym.frame.data.IGenericDAO;
import py.com.oym.frame.report.SqlDataReport;
import py.com.oym.frame.security.ISecManager;
import py.com.oym.frame.security.IUserSession;

/**
 *
 * @author jenci_000
 */
public class TestSqlDataReport {
    static private Context context; 
    static private IDataLink dataLink;
    
    public TestSqlDataReport() {
    }
    
    @BeforeClass
    public static void setUpClass() throws NamingException, Exception {
        Properties p = new Properties();
        p.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        p.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        p.put(Context.SECURITY_PRINCIPAL, "jenciso");
        p.put(Context.SECURITY_CREDENTIALS, "Oym1282873");
        p.put("jboss.naming.client.ejb.context", true);
        context = new InitialContext(p);
        
        ISecManager secMngr = (ISecManager)context.lookup("/TestProjects-ear/TestProjects-ejb/SecManager!py.com.oym.frame.security.ISecManagerRemote");
        IUserSession userSession = secMngr.createSession("J", "", 98L, null);        

        IGenericDAO dao  = (IGenericDAO) context.lookup("/TestProjects-ear/TestProjects-ejb/GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
        dataLink = new DataLink(dao);
        dataLink.setUserSession(userSession);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSqlDataReport1() {
        SqlDataReport sqlDataReport = new SqlDataReport(dataLink);

        IDataExpression filters = new DataExpression();
        filters.addExpression("confirmado = {true}");
        
        sqlDataReport.setColumns("fecha");
        sqlDataReport.setEntities("itemmovimiento a, itemmovimientodetalle b");
        sqlDataReport.setEntity("itemmovimiento");
        sqlDataReport.setWhereFilter(filters);

        sqlDataReport.SqlSentenceCreate();
        System.out.println(sqlDataReport.getSqlSentence());
        assertNotEquals(sqlDataReport.getSqlSentence(), "");
    }
}
