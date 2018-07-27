/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

/**
 *
 * @author JORGE
 */
public class TestCompleteText {
    
    @Test
    public void completeTextFilter(){
        String text = "hola";
        String filter = "";
        String separador = "";
        Map<String, String> searchFields = new HashMap();
        searchFields.put("nombre", "like");
        searchFields.put("codigo", "like");
        searchFields.put("nro", "=");
        
        //TODO definir más generico este código  
        for (Map.Entry<String, String> entry : searchFields.entrySet()){
            if ("like".equalsIgnoreCase(entry.getValue().trim())){
                filter += separador + "LOWER("+entry.getKey()+")" + " ";                
                filter += entry.getValue() + " '%"+text.trim().toLowerCase()+ "%' " ;
            }
            else {
                filter += separador + entry.getKey() + " " + entry.getValue() + "'" + text + "'";
            }
            separador = " or ";
        }
        System.out.println(filter);
    } 
    
    
}
