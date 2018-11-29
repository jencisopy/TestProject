/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.data;

import java.util.HashMap;
import java.util.Map;
import javax.naming.NamingException;
import org.javabeanstack.model.appcatalog.AppUserFormView;
import org.javabeanstack.model.appcatalog.AppUserFormViewColumn;
import org.javabeanstack.model.tables.Pais;
import org.javabeanstack.model.tables.Region;
import org.javabeanstack.data.DataLink;
import org.javabeanstack.data.model.DataSet;
import org.javabeanstack.datactrl.IDataObject;
import org.javabeanstack.data.IDataSet;
import org.javabeanstack.data.IGenericDAO;
import org.javabeanstack.exceptions.SessionError;
import org.javabeanstack.security.ISecManager;
import org.javabeanstack.security.IUserSession;
import org.javabeanstack.data.services.IDataService;
import org.junit.Assert;
import static org.junit.Assert.assertTrue;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.javabeanstack.datactrl.DataObject;
import static py.com.oym.test.data.TestClass.context;

/**
 *
 * @author Jorge Enciso
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestDataObject extends TestClass {

    //@Test
    public void test1AddData() throws NamingException, SessionError, Exception {
        System.out.println("1");
        //Region
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        region.insertRow();
        region.setField("codigo", "ZZZ");
        region.setField("nombre", "ZZZ BORRAR");

        IDataSet dataSet = new DataSet();
        dataSet.addDataObject("region", region);

        boolean result = dataLink.update(dataSet).isSuccessFul();
        assertTrue(result);
    }

    //@Test
    public void test2BorrarData() throws NamingException, SessionError, Exception {
        System.out.println("2");
        boolean result;

        //Campo        
        IDataObject campo = new DataObject(Region.class, null, dataLink, null);
        campo.open();
        campo.find("codigo", "ZZZ");
        campo.deleteRow();
        result = campo.update(false);
        if (!result) {
            System.out.println(campo.getErrorMsg(true));
        }
        assertTrue(result);
    }

    //@Test
    public void test3AddData() throws NamingException, SessionError, Exception {
        System.out.println("3");
        //Region
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        region.insertRow();
        region.setField("codigo", "ZZZ");
        region.setField("nombre", "ZZZ BORRAR");

        //pais
        IDataObject pais = new DataObject(Pais.class, null, dataLink, null);
        pais.open();
        pais.insertRow();
        pais.setField("codigo", "ZZZ");
        pais.setField("nombre", "ZZZ PAIS BORRAR");
        pais.setField("region", region.getRow());

        IDataSet dataSet = new DataSet();
        dataSet.addDataObject("region", region);
        dataSet.addDataObject("pais", pais);

        boolean result = dataLink.update(dataSet).isSuccessFul();
        assertTrue(result);
    }

    //@Test
    public void test4BorrarData() throws NamingException, SessionError, Exception {
        System.out.println("4");
        boolean result;

        //Pais
        IDataObject pais = new DataObject(Pais.class, null, dataLink, null);
        pais.open();
        if (pais.find("codigo", "ZZZ")) {
            pais.deleteRow();
            result = pais.update(false);
            assertTrue(result);
        }

        //Region        
        IDataObject campo = new DataObject(Region.class, null, dataLink, null);
        campo.open();
        campo.find("codigo", "ZZZ");
        campo.deleteRow();
        result = campo.update(false);
        if (!result) {
            System.out.println(campo.getErrorMsg(true));
        }
        assertTrue(result);
    }

    //@Test
    public void test5DBFilter() throws NamingException, SessionError, Exception {
        System.out.println("5");
        //Region
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        String filter = region.getDAO()
                .getUserSession()
                .getDBFilter()
                .getFilterExpr(region.getType(), "");
        System.out.println(filter);
        region.open();
        assertTrue(filter.contains("idempresa"));
    }

    //@Test
    public void test6DBFilter() throws NamingException, SessionError, Exception {
        System.out.println("6");

        ISecManager secMngr = (ISecManager) context.lookup(jndiProject + "SecManager!org.javabeanstack.security.ISecManagerRemote");
        IUserSession userSession = secMngr.createSession("J", "", 50L, null);
        sessionId = userSession.getSessionId();
        IGenericDAO dao = (IGenericDAO) context.lookup(jndiProject + "GenericDAO!org.javabeanstack.data.IGenericDAORemote");
        dataLink = new DataLink(dao);
        dataLink.setUserSession(userSession);

        //Region
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        System.out.println(region.getFilter());
        assertTrue(region.getSelectCmd().contains("IN("));
    }

    //@Test
    public void test7getData() throws NamingException, SessionError, Exception {
        System.out.println("7");
        IDataService dataservice
                = (IDataService) context.lookup(jndiProject + "DataService!org.javabeanstack.data.services.IDataServiceRemote");

        //Region
        dataLink.setDao(dataservice);
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        Assert.assertNotNull(region.getDataRows());

        region.setOrder("codigo desc");
        region.setFilter("codigo = '01'");
        region.requery();
        Assert.assertNotNull(region.getDataRows());
    }

    @Test
    public void test8FormView() throws NamingException, SessionError, Exception {
        IDataObject<AppUserFormView> formViews
                = new DataObject(AppUserFormView.class, null, dataLinkCat, null);

        String formName = "bx_campo.xhtml";
        Map<String, Object> params = new HashMap<>();
        params.put("form", formName);

        // Buscar la lista de columnas del usuario activo del formulario actual, 
        // si no existe buscar lista de columnas en forma generica
        String filter = "form = :form";
        String order = "viewName";
        formViews.setFilterParams(params);
        formViews.open(order, filter, true, -1);

        if (!formViews.isEof()) {
            if (formViews.find("viewname", "DEFAULT")) {
                formViews.deleteRow();
                if (!formViews.update(false)) {
                    System.out.println(formViews.getErrorMsg(true));
                }
            }
        }
        formViews.insertRow();
        formViews.setField("form", formName);
        formViews.setField("viewname", "DEFAULT");
        formViews.setField("iduser", 0L);
        AppUserFormViewColumn detail;

        detail = new AppUserFormViewColumn();
        detail.setIdorder(0);
        detail.setColumnName("nombre");
        detail.setColumnHeader("Nombre");
        detail.setVisible(true);
        detail.setLink("");
        detail.setAppUserFormView(formViews.getRow());
        formViews.getRow().getChild().add(detail);

        detail = new AppUserFormViewColumn();
        detail.setIdorder(1);
        detail.setColumnName("codigo");
        detail.setColumnHeader("Código");
        detail.setVisible(true);
        detail.setLink("");
        detail.setAppUserFormView(formViews.getRow());
        formViews.getRow().getChild().add(detail);

        if (!formViews.update(false)) {
            System.out.println(formViews.getErrorMsg(true));
        }
    }
    
    //@Test
    public void test9FormView() throws NamingException, SessionError, Exception {
        IDataObject<AppUserFormView> formViews
                = new DataObject(AppUserFormView.class, null, dataLinkCat, null);

        String formName = "bx_campo.xhtml";
        Map<String, Object> params = new HashMap<>();
        params.put("form", formName);

        // Buscar la lista de columnas del usuario activo del formulario actual, 
        // si no existe buscar lista de columnas en forma generica
        String filter = "form = :form";
        String order = "viewName";
        formViews.setFilterParams(params);
        formViews.open(order, filter, true, -1);

        if (!formViews.isEof()) {
            if (formViews.find("viewname", "DEFAULT")) {
                formViews.setField("filtertext","xx");
                formViews.getRow().getChild().get(0).setLink("prueba");
                if (!formViews.update(false)) {
                    System.out.println(formViews.getErrorMsg(true));
                }
            }
        }
    }
}
