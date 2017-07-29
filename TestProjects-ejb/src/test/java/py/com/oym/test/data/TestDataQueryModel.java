/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.data;

import org.junit.Test;
import static org.junit.Assert.*;
import org.javabeanstack.data.DataQueryModel;
import org.javabeanstack.data.IDataQueryModel;

/**
 *
 * @author Jorge Enciso
 */
public class TestDataQueryModel {
    
    public TestDataQueryModel() {
    }
    
    @Test
    public void test() {
        IDataQueryModel data = new DataQueryModel(); 
        Object[] row = new Object[2];
        row[0] = "001";
        row[1] = "PEPE GONZALEZ";
        
        String[] columnList = new String[2];
        columnList[0] = "codigo";
        columnList[1] = "nombre";
        
        data.setRow(row);
        data.setColumnList(columnList);
        
        assertEquals("codigo", data.getColumnName(0));
        assertEquals("nombre", data.getColumnName(1));
        
        assertEquals("001", data.getColumn("codigo"));
        assertEquals("PEPE GONZALEZ", data.getColumn("NOMBRE"));        
        
        assertEquals("001",data.getColumn(0));
        assertEquals("001",data.getColumnId());
        
        data.setColumnId(1);
        assertEquals("PEPE GONZALEZ",data.getColumnId());
    }
    
    @Test
    public void test2() {
        IDataQueryModel data = new DataQueryModel(); 
        Object[] row = new Object[2];
        row[0] = "001";
        row[1] = "PEPE GONZALEZ";
        
        String[] columnList = new String[2];
        columnList[0] = "codigo";
        columnList[1] = "nombre";
        
        data.setRow(row);
        data.setColumnList(columnList);
        
        assertEquals("codigo", data.getColumnName(0));
        assertEquals("nombre", data.getColumnName(1));
        
        assertEquals("001", data.getColumn("codigo"));
        assertEquals("PEPE GONZALEZ", data.getColumn("NOMBRE"));        
        
        assertEquals("001",data.getColumn(0));
        assertEquals("001",data.getColumnId());
        
        data.setColumnId(1);
        assertEquals("PEPE GONZALEZ",data.getColumnId());
        
        data.setColumn(0, "002");
        System.out.println(data.getColumn("codigo"));
        assertEquals("002", data.getColumn("codigo"));        
        data.setColumn("nombre", "JUAN PEREZ");
        assertEquals("JUAN PEREZ", data.getColumn("NOMBRE"));        
        
    }
}
