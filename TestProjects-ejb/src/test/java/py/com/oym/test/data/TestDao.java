/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.javabeanstack.data.IDBLinkInfo;
import org.junit.Test;
import static org.junit.Assert.*;
import org.javabeanstack.data.IGenericDAORemote;


/**
 *
 * @author Jorge Enciso
 */
public class TestDao extends TestClass{
    public TestDao() {
    }

    @Test
    public void testInstance() throws Exception {
        IGenericDAORemote instance  = 
                (IGenericDAORemote) context.lookup(jndiProject+"GenericDAO!org.javabeanstack.data.IGenericDAORemote");
        assertNotNull(instance);
    }
    
    @Test
    public void testDao() throws Exception{
        IGenericDAORemote dao  = 
                (IGenericDAORemote) context.lookup(jndiProject+"GenericDAO!org.javabeanstack.data.IGenericDAORemote");
        System.out.println(dao.getDataEngine("PU1"));
        System.out.println(dao.getSchema("PU1"));
    }    
    
    @Test
    public void testDao2() throws Exception{
        IGenericDAORemote dao  = 
                (IGenericDAORemote) context.lookup(jndiProject+"GenericDAO!org.javabeanstack.data.IGenericDAORemote");
        Map<String, Object> params = new HashMap<>();
        params.put("idempresa", 2L);
        IDBLinkInfo dbInfo = dataLink.getUserSession().getDbLinkInfo();
        List<Object> list = dao.findByNativeQuery(dbInfo,"select codigo, nombre from datos.item where idempresa = :idempresa", params, 10, 10);
        assertNotNull(list);
    }
}
