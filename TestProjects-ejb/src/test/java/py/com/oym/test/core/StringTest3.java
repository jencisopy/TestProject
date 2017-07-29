/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.core;

import java.util.List;
import org.junit.Test;

import org.javabeanstack.util.Strings;
import static org.javabeanstack.util.Strings.stringToList;

/**
 *
 * @author Jorge Enciso
 */
public class StringTest3 {
    
    public StringTest3() {
    }
    
    //@Test
    public void test1(){
        String msg = "hola que tal";
        System.out.println(Strings.left(msg, 5));
        System.out.println(Strings.left(msg, 5).length());
        System.out.println(Strings.right(msg, 50));
        System.out.println(Strings.right(msg, 50).length());        
        System.out.println(Strings.substring(msg, 0,50));
        System.out.println(Strings.substring(msg, 0,50).length());
    }
    
    @Test
    public void test2(){
        String expr = "item, itemnombre, itemelemento,"
                + "sum(cantidadpedido) as cantidadpedido,"
                + "sum(cantidad) as cantidad,"
                + "sum(cantidadbonificacion) as cantidadbonificacion,"
                + "sum(kilos) as kilos,";
                                                /*
                + "sum(pendiente) as pendiente,"
                + "itemmedida,MAX(fecha) as ultmov,"
                + "SUM(costo) as costome,";

                + "SUM(costolocal / cotizacioninforme)    as costo,"
                + "SUM(impuestolocal / cotizacioninforme) as impuesto,"
                + "SUM(subtotallocal / cotizacioninforme) as subtotal,"
                + "SUM((subtotallocal + impuestolocal) / cotizacioninforme) as total,"
                + "0.00000 as porcentaje,monedainforme as moneda";
*/
        List<String> lista = stringToList(expr);        
        for (int i=0;i < lista.size() ;i++){
            System.out.println(lista.get(i));
        }     
    }
    
}
