/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.data;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.javabeanstack.data.DataQueryModel;
import org.javabeanstack.data.IDataQueryModel;

/**
 *
 * @author Jorge Enciso
 */
public class TextDataModelIndexOf {
    
    public TextDataModelIndexOf() {
    }
    
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
