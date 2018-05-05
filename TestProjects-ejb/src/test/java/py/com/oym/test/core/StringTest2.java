/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.core;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

import org.javabeanstack.util.Fn;
import static org.javabeanstack.util.Strings.*;

/**
 *
 * @author Jorge Enciso
 */
public class StringTest2 {
    
    public StringTest2() {
    }
    
    
    //@Test
    public void test5(){
        System.out.println("LIST");
        String expr = "fn_iditem(pp,yy,xx) as column1, fn_xx(xx,xx) as column2";
        List<String> lista = convertToList(expr,",");
        for (int i=0;i < lista.size() ;i++){
            System.out.println(lista.get(i));
        }
        
        System.out.println("MATRIX");
        expr = "fn_iditem(pp,yy,xx) as column1, ss,";
        String[] lista1 = convertToMatrix(expr,",");
        for (int i=0;i < lista1.length ;i++){
            System.out.println(lista1[i]);
        }        
    }
    
    //@Test
    public void test7(){
        String xx = "hola";
        System.out.println(Fn.inList(xx, "hola","que tal"));
    }

    //@Test
    public void test4(){
        String expr = "fn_iditem(pp,yy,xx) as column1, fn_xx(xx,xx) as column2";
        List<String> lista = stringToList(expr);
        for (int i=0;i < lista.size() ;i++){
            System.out.println(lista.get(i));
        }
        
        expr = "fn_iditem(pp,yy,xx) as column1, ss,";
        lista = stringToList(expr);
        for (int i=0;i < lista.size() ;i++){
            System.out.println(lista.get(i));
        }     
        expr = "item, itemnombre, itemelemento,sum(cantidadpedido) as cantidadpedido,sum(cantidad) as cantidad,sum(cantidadbonificacion) as cantidadbonificacion,sum((kilos) as kilos,sum(pendiente) as pendiente,itemmedida,MAX(fecha) as ultmov,SUM(costo) as costome,SUM(costolocal / cotizacioninforme)    as costo,SUM(impuestolocal / cotizacioninforme) as impuesto,SUM(subtotallocal / cotizacioninforme) as subtotal,SUM((subtotallocal + impuestolocal) / cotizacioninforme) as total,0.00000 as porcentaje,monedainforme as moneda";
        lista = stringToList(expr);
        for (int i=0;i < lista.size() ;i++){
            System.out.println(lista.get(i));
        }     
    }
    
//    @Test
    public void test() {
        String var = "12(z1z2(y1y2)z1z2)12";
        String expected = "12(**************)12";
        String result = varReplace(var,"()","*");
        System.out.println(result);
        assertEquals(expected, result);
    }

    
    //@Test
    public void test2() {
        String var = "select fn_idvendedor( where idvendedor,codigo,idempresa) as idvendedor, "
                + "item "
                + "from itemmovimiento "
                + "where (xx=1) group by xx";
        int result = findLimit("where ",var);
        String expected = "where (";
        String resultStr = var.substring(result,result+7);
        System.out.println(resultStr);
        System.out.println(var);
        assertEquals(expected, resultStr);
    }
    
    @Test
    public void test3() {
        String var = "select fn_idvendedor( where idvendedor,codigo,idempresa) as idvendedor, "
                + "item "
                + "from itemmovimiento "
                + "where (xx=1) group by xx";
        int result = findLimit("where ",var);
        String expected = "where (";
        String resultStr = var.substring(result,result+7);
        assertEquals(expected, resultStr);
        
        result = findLimit(null,var);
        assertEquals(-1, result);
        
    }
}
