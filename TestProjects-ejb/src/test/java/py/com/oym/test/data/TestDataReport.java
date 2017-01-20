/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.data;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import py.com.oym.frame.data.DataExpression;
import py.com.oym.frame.data.IDataExpression;
import py.com.oym.frame.data.IDataQueryModel;
import py.com.oym.frame.report.DataReport;


/**
 *
 * @author Jorge Enciso
 */
public class TestDataReport extends TestClass {
    public TestDataReport() {
    }
    

    @Test
    public void testSqlDataReport1() throws Exception {
        DataReport sqlDataReport = new DataReport(dataLink);

        IDataExpression filters = new DataExpression();
        filters.addExpression("confirmado = {true}");
        
        // Define propiedades
        sqlDataReport.setColumnsGroup1("vendedor.codigo as vendedor, vendedor.nombre as vendedornombre");
        sqlDataReport.setColumnsGroup2("item.codigo as item, item.nombre as itemnombre");
        sqlDataReport.setColumns("a.fecha, a.gravado, a.exento, a.impuesto");
        sqlDataReport.setEntityRoot("itemmovimiento");        
        sqlDataReport.setEntitiesToJoin("");
        sqlDataReport.setEntitiesAlias("itemmovimiento a, itemmovimientodetalle b");
        sqlDataReport.setWhereFilter(filters);
        sqlDataReport.setOrderBy("vendedor.codigo, vendedor.nombre");

        // Crea la sentencia
        sqlDataReport.sqlSentenceCreate();
        /*
        List<IDataQueryModel> result = sqlDataReport.sqlSentenceExecute();
        */
        
        System.out.println(sqlDataReport.getSqlSentence());
        assertNotEquals(sqlDataReport.getSqlSentence(), "");
    }
    
    /**
     *      SqlGetData (vfp)      DataReport (java)
     * ------------------------------------------------
     *       campocorte1    --> columnGroup1
     *       campocorte2    --> columnGroup2 
     *       columnas       --> columns
     *       listaTablas    --> entitiesToJoin
     *       excepciones    --> entitiesAlias
     *       entidadprincipal  --> entityRoot
     *       condicion      --> whereFilter
     *       ordenar        --> orderBy
     *       agrupar        --> groupBy
     *       sentenciaSql   --> sqlSentence
     * 
     */
}
