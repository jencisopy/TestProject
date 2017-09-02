/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.data;

import java.util.List;
import java.util.Map;
import javax.naming.NamingException;
import org.junit.Test;

import org.javabeanstack.data.DataExpression;
import org.javabeanstack.data.DataNativeQuery;
import org.javabeanstack.data.IDataExpression;
import org.javabeanstack.data.IDataNativeQuery;
import org.javabeanstack.data.IDataQueryModel;
import org.javabeanstack.security.ISecManager;
import org.javabeanstack.security.IUserSession;
import py.com.oym.frame.data.DataUtil;

import static py.com.oym.test.data.TestClass.context;

/**
 *
 * @author Jorge Enciso
 */
public class TestDataNativeQuery extends TestClass{
    DataNativeQuery query;    
    
    public TestDataNativeQuery() {
    }
    
    @Test
    public void testExpr() {
        System.out.println("\nTESTEXPR");
        System.out.println("==========================");
        query = (DataNativeQuery)dataLink.newDataNativeQuery();        
        
        query.select(""                  
                + "b.monto - b.capital as interes,\n"
                + "(case when b.fec_ven > b.ultpago then\n"
                + "     {schema}.fn_getinteresmoratorio((CASE when b.saldoanterior <> 0 then b.saldoanterior when b.capital <> 0 then b.capital else b.monto end),b.fec_ven,:saldoFecha,a.tasamoratoria,a.tolerancia)\n"
                + " else\n"
                + "     {schema}.fn_getinteresmoratorio((CASE when b.saldoanterior <> 0 then b.saldoanterior when b.capital <> 0 then b.capital else b.monto end),b.ultpago,:saldoFecha,a.tasamoratoria,a.tolerancia)\n"
                + " end) as interesmoratorio,\n"
                + "b.interesdevengar,\n");

        System.out.println("\nCOLUMN EXPR1");        
        System.out.println("===========");  
        System.out.println(query.getColumnExpr());
        String[] lista = query.getColumnList();
        for (String lista1 : lista) {
            System.out.println(lista1);
        }
                
                
        System.out.println("\nCOLUMN EXPR");        
        System.out.println("===========");    
        query.select(""
                + "a.idctacte, a.ctacte, a.ctactenombre, a.moneda, \n" +
                    "a.fecha, a.ruc, ctacte.telefonoctacte as telefono,\n" +
                    "a.rubro, a.rubronombre,a.subrubro,a.subrubronombre, \n" +
                    "a.iddocumento, a.iddocumentotipo,\n" +
                    "a.confirmado, a.idempresa, a.anulado,\n" +
                    "CASE when b.monto is NOT null then x.codigo else a.itemmovcondicion end  as itemmovcondicion,	\n" +
                    "CASE when a.ctacteafecta IN (1,3)  and b.monto is null then a.totalmonto when  a.ctacteafecta IN(1,3)  then b.monto else 00000000000.000  END  as debito,\n" +
                    "CASE when a.ctacteafecta IN (2) and b.monto is null then a.totalmonto when  a.ctacteafecta IN(2) then b.monto else 00000000000.000  END  as credito");

        System.out.println(query.getColumnExpr()+"\n");        
        lista = query.getColumnList();
        for (String lista1 : lista) {
            System.out.println(lista1);
        }
        
        System.out.println("\nENTITY EXPR");
        System.out.println("===========");
        query.from("itemmovimiento a, itemmovimientodetalle b");
        System.out.println(query.getEntityExpr()+"\n");         
        lista = query.getEntityList();
        for (String lista1 : lista) {
            System.out.println(lista1);
        }

        System.out.println("\nFILTER EXPR");
        System.out.println("===========");
        query.where("item = :item and vendedor = :vendedor");
        lista = query.getFilterExprList();
        for (String lista1 : lista) {
            System.out.println(lista1);
        }
        System.out.println("\nSENTENCE PARAM");
        System.out.println("================");
        for (Map.Entry<String,Object> entry:query.getQueryParams().entrySet()){
            System.out.println(entry.getKey()+"="+entry.getValue().toString());
        }        
        
//        System.out.println("\nQUERY PARAM");
//        System.out.println("=============");
//        Map<String, Object> params = new HashMap<>();
//        params.put("item",     "001");
//        params.put("vendedor", "002");
//        query.setQueryParams(params);
        
//        Iterator it = params.keySet().iterator();
//        while(it.hasNext()){
//          String key = (String)it.next();
//          System.out.println("Clave: " + key + " -> Valor: " + params.get(key));
//        }
//        
        System.out.println("\nORDER EXPR");
        System.out.println("===========");
        query.orderBy("b.item, c.vendedor");
        System.out.println(query.getOrderExpr()+"\n");
        lista = query.getOrderList();
        for (String lista1 : lista) {
            System.out.println(lista1);
        }        
        
        System.out.println("\nGROUP EXPR");
        System.out.println("===========");
        query.groupBy("item, vendedor");
        System.out.println(query.getGroupExpr()+"\n");        
        lista = query.getGroupList();
        for (String lista1 : lista) {
            System.out.println(lista1);
        } 
        
        System.out.println("\nHAVING EXPR");
        System.out.println("===========");
        query.having("COUNT(*) > 0");
        System.out.println(query.getFilterGroupExpr()+"\n");        
        lista = query.getFilterGroupExprList();
        for (String lista1 : lista) {
            System.out.println(lista1);
        }           
        
        System.out.println("\nQUERY SENTENCE");
        System.out.println("================");
        query.createQuery();
        System.out.println(query.getQuerySentence());
    }

    @Test
    public void testQuery() throws Exception {
        query = (DataNativeQuery)dataLink.newDataNativeQuery();
        List<IDataQueryModel> data = 
            query.select("{SCHEMa}.fn_iditem(b.iditem,b.item,a.idempresa,'P') as item")
                .from("itemmovimiento_view a")
                .join("itemmovimientodetalle_view b","a.iditemmovimiento = b.iditemmovimiento")
                .join("vendedor", "a.idvendedor = vendedor.idvendedor")
                .where("vendedor = :vendedor")
                .orderBy("item")
                .addParam("vendedor","001")
                .execQuery();

        System.out.println("\nTESTQUERY");
        System.out.println("================");
        System.out.println(query.getQuerySentence());
        System.out.println("\nSENTENCE PARAM");
        System.out.println("================");
        query.getQueryParams().entrySet().forEach((entry) -> {
            System.out.println(entry.getKey()+"="+entry.getValue().toString());
        });
        
        System.out.println("\nENTITY EXPR");
        System.out.println("===========");
        System.out.println(query.getEntityExpr()+"\n");         
        String[] lista = query.getEntityList();
        for (String lista1 : lista) {
            System.out.println(lista1);
        }
        System.out.println("\nFROM EXPR");
        System.out.println("===========");
        System.out.println(query.getFromExpr());
        System.out.println("");
        System.out.println("");
    }

    @Test
    public void testQuery2() throws Exception {
        query = (DataNativeQuery)dataLink.newDataNativeQuery();
//        List<IDataQueryModel>
//            data = query.select("datos.fn_iditem(iditem,item,idempresa) as item")
//                    .from("datos.itemmovimiento")
//                    .where("vendedor = :vendedor")
//                    .addParam("vendedor","001")                
//                    .orderBy("item")
//                    .execQuery();

        List<IDataQueryModel>
            data = query.select("x.item as productos")
                    .from("datos.itemmovimientodetalle_view x")
                    .orderBy("x.item")
                    .execQuery(6,5);
        
        System.out.println("TESTQUERY2");
        System.out.println("====================");
        System.out.println(query.getQuerySentence());
        System.out.println(data.size());
        System.out.println(data.get(0).getColumn("productos"));
        System.out.println(data.get(0).getColumn(1));        
    }

    @Test
    public void testQuery3() throws Exception {
        query = (DataNativeQuery)dataLink.newDataNativeQuery();

        query.select("a.nro")
                .from("itemmovimiento a")
                .join("itemmovimientodetalle b","a.iditemmovimiento = b.iditemmovimiento")
                .leftJoin("vendedor","a.idvendedor = vendedor.idvendedor") 
                .where("vendedor.codigo = :vendedor")
                .orderBy("")
                .createQuery();

        System.out.println("\nTESTQUERY3");
        System.out.println("================");
        
        System.out.println(query.getQuerySentence());
    }

    @Test
    public void testQuery4() throws Exception {
        query = (DataNativeQuery)dataLink.newDataNativeQuery();

        query.select("a.nro")
                .from("itemmovimiento a, itemmovimientodetalle b, vendedor")
                .where("vendedor.codigo = :vendedor")
                .orderBy("")
                .createQuery();
        
        System.out.println("\nTESTQUERY4");
        System.out.println("================");
        
        System.out.println(query.getQuerySentence());
        System.out.println(query.getEntityExpr());        
    }

    @Test
    public void testQuery5() throws Exception {
        query = (DataNativeQuery)dataLink.newDataNativeQuery();

        query.select("nro")
                .from("{schema}.itemmovimiento")
                .where("vendedor.codigo = :vendedor")
                .orderBy("")
                .createQuery();
        
        System.out.println("\nTESTQUERY5");
        System.out.println("================");

        System.out.println(query.getQuerySentence());
        System.out.println(query.getEntityExpr());
    }

    @Test
    public void testQuery6() throws Exception {
        query = (DataNativeQuery)dataLink.newDataNativeQuery();

        query.select("nro")
                .from("itemmovimiento")
                .where("vendedor.codigo = :vendedor")
                .orderBy("")
                .createQuery();
        
        System.out.println("\nTESTQUERY6");
        System.out.println("================");

        System.out.println(query.getQuerySentence());
        System.out.println(query.getEntityExpr());
    }

    @Test
    public void testQuery7() throws Exception {
        query = (DataNativeQuery)dataLink.newDataNativeQuery();
        IDataExpression exprFilter = new DataExpression();
        exprFilter.addExpression("vendedor = :vendedor");
        exprFilter.addExpression("ctacte = :ctacte");        
        exprFilter.addSentenceParam("vendedor", "001");
        exprFilter.addSentenceParam("ctacte", "001");     
        
        query.select("nro")
                .from("itemmovimientob_view")
                .where(exprFilter)
                .orderBy("")
                .createQuery();
        
        System.out.println("\nTESTQUERY7");
        System.out.println("================");

        System.out.println(query.getQuerySentence());
    }
    
    @Test
    public void testQuery8() throws Exception {
        query = (DataNativeQuery)dataLink.newDataNativeQuery();
        
        IDataNativeQuery subquery = (DataNativeQuery)dataLink.newDataNativeQuery();
        subquery.select("idctacte, total")
                .from("itemmovimiento");
                
        query.select("idctacte, sum(total) as total")
                .from(subquery, "a")
                .groupBy("idctacte")
                .orderBy("")
                .createQuery();

        System.out.println("\nTESTQUERY8");
        System.out.println("================");
        
        System.out.println(query.getQuerySentence());
    }
    
    @Test
    public void testQuery9() throws Exception {
        query = (DataNativeQuery)dataLink.newDataNativeQuery();
        
        IDataNativeQuery subquery1 = (DataNativeQuery)dataLink.newDataNativeQuery();
        IDataNativeQuery subquery2 = (DataNativeQuery)dataLink.newDataNativeQuery();
        subquery1.select("idctacte, total")
                .from("itemmovimiento");

        subquery2.select("idctacte, total")
                .from("itemmovimiento");
        
        query.select("idctacte, sum(total) as total")
                .from(subquery1, "a")
                .join(subquery2, "b", "a.idctacte = b.idctacte")
                .groupBy("idctacte")
                .orderBy("")
                .createQuery();

        System.out.println("\nTESTQUERY9");
        System.out.println("================");
        
        System.out.println(query.getQuerySentence());
    }

    @Test
    public void testQuery10() throws Exception {
        query = (DataNativeQuery)dataLink.newDataNativeQuery();
        
        IDataNativeQuery subquery1 = (DataNativeQuery)dataLink.newDataNativeQuery();
        subquery1.select("idctacte, total")
                .from("itemmovimiento");

        
        query.select("idctacte, sum(total) as total")
                .from("ctactemovimiento a")
                .join(subquery1, "b", "a.idctacte = b.idctacte")
                .groupBy("idctacte")
                .orderBy("")
                .createQuery();

        System.out.println("\nTESTQUERY10");
        System.out.println("================");
        
        System.out.println(query.getQuerySentence());
    }
    
    //@Test
    public void testEmpresaFilter() throws NamingException {
        ISecManager secMngr = 
                (ISecManager)context.lookup(jndiProject+"SecManager!org.javabeanstack.security.ISecManagerRemote");
        
        IUserSession userSession = secMngr.createSession("J", "", 6L, null);        
        System.out.println(DataUtil.getEmpresaFilter(userSession,"a"));
        System.out.println(DataUtil.getEmpresaAndPeriodoFilter(userSession));
        userSession = secMngr.createSession("J", "", 1L, null);                
        System.out.println(DataUtil.getEmpresaFilter(userSession,"a"));        
        System.out.println(DataUtil.getEmpresaAndPeriodoFilter(userSession,"a"));        
    }
    
    @Test
    public void testDBFilter() throws Exception {
        query = (DataNativeQuery)dataLink.newDataNativeQuery();
        
        query.select("codigo, nombre")
                .from("moneda a")
                .createQuery();


        System.out.println("\nTESTDBFILTER");
        System.out.println("================");
        
        System.out.println(query.getQuerySentence());
    }
    
}
