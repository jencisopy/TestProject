/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.itbox.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import py.com.itbox.model.tables.BxCampo;
import py.com.itbox.model.tables.BxDocumentotipo;
import py.com.itbox.model.tables.BxIndex;
import py.com.itbox.model.tables.BxIndexdetalle;
import py.com.itbox.model.tables.BxPlantilla;
import py.com.itbox.model.tables.BxPlantilladetalle;
import py.com.itbox.model.tables.BxRepositorio;
import py.com.oym.frame.data.DataLink;
import py.com.oym.frame.data.DataSet;
import py.com.oym.frame.data.IDataRow;
import py.com.oym.frame.data.IDataSet;
import py.com.oym.frame.exceptions.SessionError;
import py.com.oym.frame.data.IGenericDAO;

/**
 *
 * @author jenci_000
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestDatos2 {
    static Context context;
    static DataLink dataLink;
    static IGenericDAO dao;
            
    public TestDatos2() {
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
        dao  = (IGenericDAO) context.lookup("/ItBox-1.0//GenericDAO!py.com.oym.frame.data.IGenericDAORemote");
        dataLink = new DataLink(dao);

        dao.sqlExec("PU2", "delete from {schema}.bx_index;", null);                
        dao.sqlExec("PU2", "delete from {schema}.bx_documentotipo;", null);                
        dao.sqlExec("PU2", "delete from {schema}.bx_plantilla;", null);        
        dao.sqlExec("PU2", "delete from {schema}.bx_repositorio;", null);                        
        dao.sqlExec("PU2", "delete from {schema}.bx_campo;", null);        
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

    @Test
    public void test0AddData() throws NamingException, SessionError, Exception{
        System.out.println("1");        
        //Campo
        BxCampo bxCampo = new BxCampo();
        bxCampo.setCodigo("001");
        bxCampo.setIdempresa(10L);
        bxCampo.setNombre("Nro.Str");
        bxCampo.setTipo("C");
        bxCampo.setOperation(IDataRow.AGREGAR);

        //Repositorio
        BxRepositorio bxRepositorio = new BxRepositorio();
        bxRepositorio.setCodigo("001");
        bxRepositorio.setNombre("CENTRAL");
        bxRepositorio.setIdempresa(10L);
        bxRepositorio.setInactivo(false);
        bxRepositorio.setPath1("/servidor/path1");
        bxRepositorio.setPath2("/servidor/path2");
        bxRepositorio.setOperation((Integer)1);
        
        IDataSet dataSet = new DataSet();
        dataSet.add("bxcampo", bxCampo);
        dataSet.add("bxrepositorio", bxRepositorio);        
        
        boolean result = dao.update("PU2", dataSet,"").isSuccessFul();
        assertTrue(result);        
    }

    @Test
    public void test1AddBxPlantilla() throws Exception{
        //Plantilla
        BxPlantilla bxPlantilla = new BxPlantilla();
        bxPlantilla.setIdempresa(10L);
        bxPlantilla.setCodigo("001");
        bxPlantilla.setNombre("PLANTILLA 1");
        bxPlantilla.setInactivo(false);        
        bxPlantilla.setOperation(IDataRow.AGREGAR);
        //Plantilladetalle
        String queryString = "select o from BxCampo o where idempresa = 10 and codigo = '001'";
        BxCampo bxCampo = dao.findByQuery(BxCampo.class, "PU2", queryString, null);
        BxPlantilladetalle bxPlantillaDetalle = new BxPlantilladetalle();
        bxPlantillaDetalle.setBxPlantilla(bxPlantilla);
        bxPlantillaDetalle.setBxCampo(bxCampo);
        bxPlantillaDetalle.setOrden(1);
        bxPlantillaDetalle.setValorDefecto("xx");
        bxPlantillaDetalle.setOperation(IDataRow.AGREGAR);

        BxPlantilladetalle bxPlantillaDetalle2 = new BxPlantilladetalle();
        bxPlantillaDetalle2.setBxPlantilla(bxPlantilla);
        bxPlantillaDetalle2.setBxCampo(bxCampo);
        bxPlantillaDetalle2.setOrden(2);
        bxPlantillaDetalle2.setValorDefecto("xx");
        bxPlantillaDetalle2.setOperation(IDataRow.AGREGAR);
        
        List<BxPlantilladetalle> list = new ArrayList();
        list.add(bxPlantillaDetalle);
        list.add(bxPlantillaDetalle2);        
        
        bxPlantilla.setBxPlantilladetalle(list);
        IDataSet dataSet = new DataSet();
        dataSet.add("bxplantilla", bxPlantilla);
        dataSet.add("bxplantilladetalle", bxPlantilla.getBxPlantilladetalle());        

        boolean result = dao.update("PU2", dataSet,"").isSuccessFul();
        assertTrue(result);        
    }
        
    //@Test
    public void test1AddData() throws NamingException, SessionError, Exception{
        System.out.println("1");        
        //Campo
        BxCampo bxCampo = new BxCampo();
        bxCampo.setCodigo("001");
        bxCampo.setIdempresa(10L);
        bxCampo.setNombre("Nro.Str");
        bxCampo.setTipo("C");
        bxCampo.setOperation(IDataRow.AGREGAR);
        //Repositorio
        BxRepositorio bxRepositorio = new BxRepositorio();
        bxRepositorio.setCodigo("001");
        bxRepositorio.setNombre("CENTRAL");
        bxRepositorio.setIdempresa(10L);
        bxRepositorio.setInactivo(false);
        bxRepositorio.setPath1("/servidor/path1");
        bxRepositorio.setPath2("/servidor/path2");
        bxRepositorio.setOperation((Integer)1);
        //Plantilla
        BxPlantilla bxPlantilla = new BxPlantilla();
        bxPlantilla.setIdempresa(10L);
        bxPlantilla.setCodigo("001");
        bxPlantilla.setNombre("PLANTILLA 1");
        bxPlantilla.setInactivo(false);        
        bxPlantilla.setOperation((Integer)1);
        //Plantilladetalle
        String queryString = "select o from BxCampo o where idempresa = 10 and codigo = '001'";
        bxCampo = dao.findByQuery(BxCampo.class, "PU2", queryString, null);
        BxPlantilladetalle bxPlantillaDetalle = new BxPlantilladetalle();
        bxPlantillaDetalle.setBxPlantilla(bxPlantilla);
        bxPlantillaDetalle.setBxCampo(bxCampo);
        bxPlantillaDetalle.setOrden(1);
        bxPlantillaDetalle.setValorDefecto("xx");
        bxPlantillaDetalle.setOperation(1);

        BxPlantilladetalle bxPlantillaDetalle2 = new BxPlantilladetalle();
        bxPlantillaDetalle2.setBxPlantilla(bxPlantilla);
        bxPlantillaDetalle2.setBxCampo(bxCampo);
        bxPlantillaDetalle2.setOrden(2);
        bxPlantillaDetalle2.setValorDefecto("xx");
        bxPlantillaDetalle2.setOperation(1);
        
        List<BxPlantilladetalle> list = new ArrayList();
        list.add(bxPlantillaDetalle);
        list.add(bxPlantillaDetalle2);        
        
        bxPlantilla.setBxPlantilladetalle(list);

        BxDocumentotipo bxDoc = new BxDocumentotipo();
        bxDoc.setIdempresa(10L);
        bxDoc.setCodigo("001");
        bxDoc.setNombre("STR");
        bxDoc.setOperation((Integer)1);
        queryString = "select o from BxPlantilla o where idempresa = 10 and codigo = '001'";
        bxPlantilla = dao.findByQuery(BxPlantilla.class, "PU2", queryString, null);
        bxDoc.setBxPlantilla(bxPlantilla);
        queryString = "select o from BxRepositorio o where idempresa = 10 and codigo = '001'";
        bxRepositorio = dao.findByQuery(BxRepositorio.class, "PU2", queryString, null);
        bxDoc.setBxRepositorio(bxRepositorio);
        
        // BxIndex
        BxIndex bxIndex = new BxIndex();
        bxIndex.setIdempresa(10L);
        bxIndex.setFileorigen("prueba.tiff");
        bxIndex.setFileresulttiff("prueba.tiff");
        bxIndex.setFileresultpdf("prueba.pdf");
        bxIndex.setNrolote(1L);
        bxIndex.setNrotrabajo(1L);
        bxIndex.setOperation((Integer)1);
        queryString = "select o from BxDocumentotipo o where idempresa = 10 and codigo = '001'";
        bxDoc = dao.findByQuery(BxDocumentotipo.class, "PU2", queryString, null);
        bxIndex.setBxRepositorio(bxDoc.getBxRepositorio());
        bxIndex.setBxDocumentotipo(bxDoc);
        // BxIndexDetalle
        queryString = "select o from BxCampo o where idempresa = 10 and codigo = '001'";
        bxCampo = dao.findByQuery(BxCampo.class, "PU2", queryString, null);        
        BxIndexdetalle bxIndexDet = new BxIndexdetalle();
        bxIndexDet.setBxIndex(bxIndex);
        bxIndexDet.setBxCampo(bxCampo);
        bxIndexDet.setBxCampovalor("prueba");
        
        List<BxIndexdetalle> list2 = new ArrayList();
        list2.add(bxIndexDet);
        bxIndex.setBxIndexdetalle(list2);
        
        IDataSet dataSet = new DataSet();
        dataSet.add("bxcampo", bxCampo);
        dataSet.add("bxrepositorio", bxRepositorio);        
        dataSet.add("bxplantilla", bxPlantilla);                
        dataSet.add("bxplantilladetalle", bxPlantilla.getBxPlantilladetalle());                        
        dataSet.add("bxdocumentotipo", bxDoc);
        dataSet.add("bxindex", bxIndex);        

        dao.update("PU2", dataSet,"");
    }
}