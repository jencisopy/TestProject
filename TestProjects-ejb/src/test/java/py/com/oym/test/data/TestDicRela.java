/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import py.com.oym.frame.data.DataLink;
import py.com.oym.frame.data.DataNativeQuery;
import py.com.oym.frame.data.IDataLink;
import py.com.oym.frame.data.IDataNativeQuery;
import py.com.oym.frame.data.IDataQueryModel;
import py.com.oym.frame.data.IGenericDAO;
import static py.com.oym.frame.util.Strings.isNullorEmpty;

/**
 *
 * @author jenci_000
 */
public class TestDicRela {

    static private Context context;

    public TestDicRela() {
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

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    //@Test
    public void test() throws Exception {
        IGenericDAO dao = (IGenericDAO) context.lookup("/TestProjects-ear/TestProjects-ejb/GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
        DataLink dataLink = new DataLink(dao);

        String entidades = "itemmovimiento a, itemmovimientodetalle b, vendedor";
        String result = dataLink.getEntitiesRelation(entidades, "", "datos");
        assertFalse(result.isEmpty());
        System.out.println(result);

    }

    @Test
    public void testDic() throws Exception {
        IGenericDAO dao = (IGenericDAO) context.lookup("/TestProjects-ear/TestProjects-ejb/GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
        DataLink dataLink = new DataLink(dao);
        EntitiesRelation dic = new EntitiesRelation();
        List<IDataQueryModel> data = dic.get(dataLink, "itemmovimiento", "");
        assertNotNull(data);
        for (IDataQueryModel row:data){
            System.out.println(row.getColumn("entity"));
        }
    }

    class EntitiesRelation {
        List<IDataQueryModel> get(IDataLink dao, String entity, String relationType) throws Exception {
            String select = "", select1 = "", select2 = "";
            if (isNullorEmpty(relationType) || "*-1".equals(relationType)) {
                select1 = "select principal      as entity,"
                        + "expresion_principal   as expr1,"
                        + "expresion_externa     as expr2,"
                        + "tiporelacion          as typeRela,"
                        + "'*-1'                 as relation "
                        + "from {schema}.Dic_TablaRelacion "
                        + "where externa    = :entity "
                        + "and   incluir    = {true}";
            }
            if (isNullorEmpty(relationType) || "1-*".equals(relationType)) {
                select2 = "select principal      as entity,"
                        + "expresion_principal   as expr1,"
                        + "expresion_externa     as expr2,"
                        + "tiporelacion          as typeRela,"
                        + "'1-*'                 as relation "
                        + "from {schema}.Dic_TablaRelacion "
                        + "where principal  = :entity "
                        + "and   incluir    = {true}";
            }
            if (!select1.isEmpty() && !select2.isEmpty()) {
                select = select1 + " union all " + select2;
            } else {
                select = select1 + select2;
            }
            Map<String, Object> params = new HashMap();
            params.put("entity", entity);
            List<Object> list = dao.findByNativeQuery(select, params);
            return DataNativeQuery.converToNativeQuery(list, "entity, expr1, expr2, typerela, relation");
        }
    }
}
