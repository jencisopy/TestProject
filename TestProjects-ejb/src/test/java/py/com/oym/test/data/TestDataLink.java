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
import static org.junit.Assert.*;
import net.makerapp.services.IUsuarioSrv;

import org.javabeanstack.data.IDataNativeQuery;
import org.javabeanstack.data.IDataQueryModel;
import org.javabeanstack.data.DataLink;
import org.javabeanstack.exceptions.SessionError;
import org.javabeanstack.data.IGenericDAO;

import net.makerapp.model.tables.AppUser;


/**
 *
 * @author Jorge Enciso
 */
public class TestDataLink  extends TestClass{

    public TestDataLink() {
    }
    
    
    @Test
    public void test() throws NamingException, SessionError, Exception{
        IGenericDAO dao  = 
                (IGenericDAO) context.lookup(jndiProject+"GenericDAO!org.javabeanstack.data.IGenericDAORemote");
        //IGenericDAO dao  = (IGenericDAO) context.lookup("/Maker-ear-9.5-SNAPSHOT/Maker-ejb-9.5-SNAPSHOT/GenericDAO!org.javabeanstack.data.IGenericDAORemote");

        DataLink dataLinkTest = new DataLink(dao);

        Map<String, Object> persistProp = dataLinkTest.getPersistUnitProp();
        assertNotNull(dao);
        IDataNativeQuery query = dataLinkTest.newDataNativeQuery();
        
        List<IDataQueryModel> result = query.select("idempresa, nombre").
                                                    from("{schema}.empresa").
                                                    execQuery();
        
        assertNotNull(result);
    }
    
    @Test
    public void test2() throws NamingException, Exception{
        IGenericDAO dao  = 
                (IGenericDAO) context.lookup(jndiProject+"GenericDAO!org.javabeanstack.data.IGenericDAORemote");
        DataLink dataLinkTest = new DataLink(dao);

        List<Object> result = 
                dataLinkTest.findByNativeQuery("select * from {schema}.empresa", null);
        
        assertNotNull(result);
        
    }

    @Test
    public void test3() throws NamingException, SessionError, Exception{
        IGenericDAO dao  = 
                (IGenericDAO) context.lookup(jndiProject+"GenericDAO!org.javabeanstack.data.IGenericDAORemote");
        
        DataLink dataLinkTest = new DataLink(dao);
        AppUser usuario = dataLinkTest.find(AppUser.class, 3L);
        System.out.println(usuario.getValue("idempresa"));
        assertNotNull(usuario.getValue("idempresa"));
    }
    
    @Test
    public void test4() throws NamingException, SessionError, Exception{
        IUsuarioSrv dao  = 
                (IUsuarioSrv)context.lookup(jndiProject+"UsuarioSrv!net.makerapp.services.IUsuarioSrvRemote");
        
        DataLink dataLinkTest = new DataLink(dao);
        assertNotNull(dataLinkTest.getDataService());
        assertNotNull((IUsuarioSrv)dataLinkTest.getDataService());
    }
    
    @Test
    public void test5() throws NamingException, SessionError, Exception{
        IGenericDAO dao  = 
                (IGenericDAO) context.lookup(jndiProject+"GenericDAO!org.javabeanstack.data.IGenericDAORemote");
        
        DataLink dataLinkTests = new DataLink(dao);
        assertNull(dataLinkTests.getDataService());
    }
}
