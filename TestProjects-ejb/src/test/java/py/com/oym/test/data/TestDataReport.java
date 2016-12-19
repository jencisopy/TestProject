/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.data;

import org.junit.Test;
import static org.junit.Assert.*;
import py.com.oym.frame.data.DataExpression;
import py.com.oym.frame.data.IDataExpression;
import py.com.oym.frame.report.DataReport;


/**
 *
 * @author Jorge Enciso
 */
public class TestDataReport extends TestClass {
    public TestDataReport() {
    }
    

    @Test
    public void testSqlDataReport1() {
        DataReport sqlDataReport = new DataReport(dataLink);

        IDataExpression filters = new DataExpression();
        filters.addExpression("confirmado = {true}");
        
        sqlDataReport.setColumns("fecha, vendedor.codigo as vendedor, b.iditem");
        sqlDataReport.setEntitiesToJoin("itemmovimiento a");
        sqlDataReport.setEntitiesAlias("vendedor ven");
        sqlDataReport.setEntityRoot("itemmovimiento");
        sqlDataReport.setWhereFilter(filters);

        sqlDataReport.sqlSentenceCreate();
        System.out.println(sqlDataReport.getSqlSentence());
        assertNotEquals(sqlDataReport.getSqlSentence(), "");
    }
}
