/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.data;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import py.com.oym.frame.data.DataLink;
import py.com.oym.frame.data.IGenericDAORemote;


/**
 *
 * @author Jorge Enciso
 */
public class TestVarios extends TestClass{
    
    public TestVarios() {
    }
    

    //@Test
    public void testGetCount() throws Exception{
        IGenericDAORemote dao  = (IGenericDAORemote) context.lookup("/TestProjects-ear/TestProjects-ejb/GenericDAO!py.com.oym.frame.data.IGenericDAORemote");        
        Long rec = dao.getCount("PU1", "select o FROM Empresa o", null);
        System.out.println(rec);
    }

    
    @Test
    public void testMapPut() {
        Map<String, Object> params = new HashMap<>();
        params.put("valor", "1");
        System.out.println(params.get("valor"));
        params.put("valor", "2");
        System.out.println(params.get("valor"));
    }    
    
    //@Test
    public void testParam() throws Exception{
        IGenericDAORemote dao  = (IGenericDAORemote) context.lookup("/TestProjects-ear/TestProjects-ejb/GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
        DataLink dataLink1 = new DataLink(dao);
        Long rec = dataLink1.getCount2("select * FROM {schema}.usuario where disable = :true", null);
        System.out.println(rec);
    }
}
