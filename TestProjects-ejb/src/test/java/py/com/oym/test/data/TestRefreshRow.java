/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.data;

import org.javabeanstack.model.appcatalog.AppUser;
import org.javabeanstack.data.IGenericDAO;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

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
        
        AppUser row = dao.findById(AppUser.class,null ,14L);
        assertNotNull(row.getUserMemberList().get(0));
        row = dao.refreshRow(null, row);
        System.out.println(row.getFullName());        
        System.out.println(row.getUserMemberList().get(0));
        assertNotNull(row.getUserMemberList().get(0));
    }        
}
