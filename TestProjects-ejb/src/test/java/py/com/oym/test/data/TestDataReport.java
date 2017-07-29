package py.com.oym.test.data;

import org.junit.Test;
import static org.junit.Assert.*;

import org.javabeanstack.data.DataExpression;
import org.javabeanstack.data.IDataExpression;
import org.javabeanstack.report.DataReport;


/**
 *
 * @author Jorge Enciso
 */
public class TestDataReport extends TestClass {
    public TestDataReport() {
    }
    

    //@Test
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
        sqlDataReport.createSqlSentence();
        /*
        List<IDataQueryModel> result = sqlDataReport.executeSqlSentence();
        */
        
        System.out.println(sqlDataReport.getSqlSentence());
        assertNotEquals(sqlDataReport.getSqlSentence(), "");
    }

    @Test
    public void testSqlDataReport2() throws Exception {
        DataReport sqlDataReport = new DataReport(dataLink);

        IDataExpression filters = new DataExpression();
        filters.addExpression("confirmado = {true}");
        
        // Define propiedades
        
        sqlDataReport.setColumnsGroup1("vendedor, vendedornombre");
        sqlDataReport.setColumnsGroup2("");
        sqlDataReport.setColumns("year(fecha) as anho, sum(gravado) as gravado");
        sqlDataReport.setEntityRoot("itemmovimiento");        
        sqlDataReport.setWhereFilter(filters);
        sqlDataReport.setOrderBy("vendedor, vendedornombre");
        String columns = sqlDataReport.getColumnsGroup1()+","+sqlDataReport.getColumns();
        sqlDataReport.setGroupBy(sqlDataReport.createGroupBy(columns));

        // Crea la sentencia
        sqlDataReport.createSqlSentence();
        /*
        List<IDataQueryModel> result = sqlDataReport.executeSqlSentence();
        */
        
        System.out.println(sqlDataReport.getSqlSentence());
        assertNotEquals(sqlDataReport.getSqlSentence(), "");
    }
    
    /**
     *      SqlGetData (vfp)      DataReport (java)
     * ------------------------------------------------
     *       campocorte1    --> columnGroup1
     *       campocorte2    --> columnGroup2 
     *       campocorte3    --> columnGroup3
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
