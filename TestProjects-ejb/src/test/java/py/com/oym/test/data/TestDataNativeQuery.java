/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.data;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import py.com.oym.frame.data.IGenericDAORemote;
import py.com.oym.frame.data.DataLink;
import py.com.oym.frame.data.DataNativeQuery;

/**
 *
 * @author jenci_000
 */
public class TestDataNativeQuery {
    static Context context;
    DataNativeQuery query;    
    
    public TestDataNativeQuery() {
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
    }

    @Before
    public void setUp() {
    }
    
    //@Test
    public void testExpr() {
        System.out.println("\nCOLUMN EXPR");        
        System.out.println("===========");    
        query.select(""
                + "SELECT 	a.idctacte, a.ctacte, a.ctactenombre, a.moneda, \n" +
                    "a.fecha, a.ruc, ctacte.telefonoctacte as telefono,\n" +
                    "a.rubro, a.rubronombre,a.subrubro,a.subrubronombre, \n" +
                    "a.iddocumento, a.iddocumentotipo,\n" +
                    "a.confirmado, a.idempresa, a.anulado,\n" +
                    "CASE when b.monto is NOT null then x.codigo else a.itemmovcondicion end  as itemmovcondicion,	\n" +
                    "CASE when a.ctacteafecta IN (1,3)  and b.monto is null then a.totalmonto when  a.ctacteafecta IN(1,3)  then b.monto else 00000000000.000  END  as debito,\n" +
                    "CASE when a.ctacteafecta IN (2) and b.monto is null then a.totalmonto when  a.ctacteafecta IN(2) then b.monto else 00000000000.000  END  as credito");
        String[] lista = query.getColumnList();
        for (int i=0; i < lista.length; i++){
            System.out.println(lista[i]);
        }
        
        System.out.println("\nENTITY EXPR");
        System.out.println("===========");        
        query.from("itemmovimiento, itemmovimientodetalle");
        lista = query.getEntityList();
        for (int i=0; i < lista.length; i++){
            System.out.println(lista[i]);
        }

        System.out.println("\nFILTER EXPR");
        System.out.println("===========");
        query.where("item = :item and vendedor = :vendedor");
        lista = query.getFilterExprList();
        for (int i=0; i < lista.length; i++){
            System.out.println(lista[i]);
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
        lista = query.getOrderList();
        for (int i=0; i < lista.length; i++){
            System.out.println(lista[i]);
        }        
        
        System.out.println("\nGROUP EXPR");
        System.out.println("===========");
        query.groupBy("item, vendedor");
        lista = query.getGroupList();
        for (int i=0; i < lista.length; i++){
            System.out.println(lista[i]);
        } 
        
        System.out.println("\nHAVING EXPR");
        System.out.println("===========");
        query.having("COUNT(*) > 0");
        lista = query.getFilterGroupExprList();
        for (int i=0; i < lista.length; i++){
            System.out.println(lista[i]);
        }           
        
        System.out.println("\nQUERY SENTENCE");
        System.out.println("================");
        query.createQuery();
        System.out.println(query.getQuerySentence());
    }

    @Test
    public void testQuery() throws Exception {
        IGenericDAORemote dao  = (IGenericDAORemote) context.lookup("/TestProjects-ear/TestProjects-ejb/GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
        DataLink dataLink = new DataLink(dao);
        query = (DataNativeQuery)dataLink.newDataNativeQuery();
        query.select("{SCHEMa}.fn_iditem(iditem,item,idempresa) as item")
            .from("{schema}.itemmovimiento")
            .where("vendedor = :vendedor")
            .orderBy("item")
            .addParam("vendedor","001")
            .createQuery();
        
        System.out.println(query.getQuerySentence());
    }
//
//    @Test
//    public void testFilterExpr() {
//    }
    
    @After
    public void tearDown() {
    }
    
    
    @AfterClass
    public static void tearDownClass() {
    }
}
