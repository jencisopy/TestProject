/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.data;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import py.com.oym.frame.data.DataQueryModel;
import py.com.oym.frame.data.IDataQueryModel;

/**
 *
 * @author jenci_000
 */
public class TextDataModelIndexOf {
    
    public TextDataModelIndexOf() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void text1() {
        List<IDataQueryModel> lista = new ArrayList();
        String[] columnList = {"id","nombre","apellido"};        
        IDataQueryModel r1 = new DataQueryModel();
        Object[] row =  {1L,"María", "Rojas"};
        r1.setRow(row);
        r1.setColumnList(columnList);
        lista.add(r1);
        IDataQueryModel r2 = new DataQueryModel();        
        Object[] row2 =  {2L,"Jose", "Perez"};
        r2.setRow(row2);
        r2.setColumnList(columnList);        
        lista.add(r2);        
        
        System.out.println(r1.getColumn(0));
        System.out.println(lista.indexOf(r2));
        assertTrue(lista.indexOf(r2) == 1);
        
        Integer searchId = 2;
        int result = DataQueryModel.searchById(lista, searchId);
        System.out.println(result);
        assertTrue(result == 1);
    }
}
