/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.*;
import org.junit.Test;
import org.javabeanstack.data.DataNativeQuery;
import org.javabeanstack.data.IDataLink;
import org.javabeanstack.data.IDataQueryModel;
import static org.javabeanstack.util.Strings.isNullorEmpty;

/**
 *
 * @author Jorge Enciso
 */
public class TestDicRela extends TestClass{
    public TestDicRela() {
    }

    //@Test
    public void test() throws Exception {
        String entidades = "itemmovimiento a, itemmovimientodetalle b, vendedor";
        String result = dataLink.getEntitiesRelation(entidades, "", "datos");
        assertFalse(result.isEmpty());
        System.out.println(result);
    }

    @Test
    public void testDic() throws Exception {
        EntitiesRelation dic = new EntitiesRelation();
        List<IDataQueryModel> data = dic.get(dataLink, "itemmovimiento", "");
        assertNotNull(data);
        data.forEach((row) -> {
            System.out.println(row.getColumn("entity"));
        });
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
                        + "from {schemacatalog}.Dic_TablaRelacion "
                        + "where externa    = :entity "
                        + "and   incluir    = {true}";
            }
            if (isNullorEmpty(relationType) || "1-*".equals(relationType)) {
                select2 = "select principal      as entity,"
                        + "expresion_principal   as expr1,"
                        + "expresion_externa     as expr2,"
                        + "tiporelacion          as typeRela,"
                        + "'1-*'                 as relation "
                        + "from {schemacatalog}.Dic_TablaRelacion "
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
