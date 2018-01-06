/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.data;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import py.com.oym.model.tables.Usuario;
import org.javabeanstack.data.IGenericDAO;

/**
 *
 * @author Jorge Enciso
 */
public class TestRefreshRow extends TestClass{

    public TestRefreshRow() {
    }

  
    @Test
    public void testRefreshRow() throws Exception{
        IGenericDAO dao  = 
                (IGenericDAO) context.lookup(jndiProject+"GenericDAO!org.javabeanstack.data.IGenericDAORemote");
        
        Usuario row = dao.findById(Usuario.class,null ,14L);
        assertNotNull(row.getUserMemberList().get(0));
        row = dao.refreshRow(null, row);
        System.out.println(row.getFullName());        
        System.out.println(row.getUserMemberList().get(0));
        assertNotNull(row.getUserMemberList().get(0));
    }        
}
