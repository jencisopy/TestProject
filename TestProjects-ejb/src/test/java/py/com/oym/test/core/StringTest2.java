/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.core;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.*;
import py.com.oym.frame.util.Fn;
import py.com.oym.frame.util.Strings;

/**
 *
 * @author jenci_000
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
    @Test
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
    public void test3() {
        assertTrue(toLogical("1"));
        assertFalse(toLogical("0"));
        assertTrue(toLogical(1));
        assertFalse(toLogical(0));
        assertTrue(toLogical(1L));
        assertFalse(toLogical(0L));
        assertTrue(toLogical(true));
        assertFalse(toLogical(false));
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
    
    public String varReplace(String var, String limit){   
        return varReplace(var, limit, "*");
    } 
    
    public String varReplace(String var, String limit, String replace){
        String result=var;
        // Si esta vacio la variable       
        if (Strings.isNullorEmpty(var)){
            return var;
        }
        String limit1, limit2;
        
        if (limit.length() == 2){
            limit1 = StringUtils.left(limit, 1);
            limit2 = StringUtils.right(limit,1);
        }
        else {
            limit1 = limit.substring(0,1);
            limit2 = limit.substring(1,1);
        }
        int c=0, p1=0, p2=0, c2=0;
        while (true){
            c = c + 1;
            p1 = findString(limit1, result, c);
            if (limit1.equals(limit2)){
                c = c + 1;
            }
            p2 = findString(limit2, result, c);
            // Verificar que el caracter no sea un limitador interno
            if (!limit1.equals(limit2)){
                c2 = c;
                while (p1 >= 0){
                    int innerLimit1 = occurs(limit1, result.substring(p1,p2));
                    int innerLimit2 = occurs(limit2, result.substring(p1,p2+1));
                    if (innerLimit2==0){
                        break;
                    }
                    if (innerLimit1 - innerLimit2 != 0){
                        c2 = c2 + innerLimit1 - innerLimit2;
                        p2 = findString(limit2, result, c2);
                    }
                    else{
                        break;
                    }
                }
            }
            if (p1 == -1 || p2 == -1){
                break;
            }
            result = StringUtils.left(result, p1+1)+StringUtils.repeat(replace, p2-p1-1)+result.substring(p2);
        }
        return result;
    }
    
    public int findString(String searchExpr, String exprSearched){
        return findString(searchExpr,exprSearched,1);
    }    
    
    public int findString(String searchExpr, String exprSearched,int nOccurrence){
        int pos=-1;
        for (int i = 1;i <= nOccurrence;i++){
            pos = exprSearched.indexOf(searchExpr,pos+1);
        }
        return pos;
    }
    
    public int occurs( String searchExpr, String exprSearched){
        return StringUtils.countMatches(exprSearched, searchExpr);
    }

    public int findLimit(String limit, String expr){
        return findLimit(limit, expr, 1);
    }
    
    public int findLimit(String limit, String expr, int occurs){
        expr = varReplace(expr,"'");
        expr = varReplace(expr,"()");
        // Buscar limitador de la cadena
        return findString(limit,expr,occurs);
    }    
    
    public Boolean toLogical(Object value){
        if (value == null){
            return false;
        }
        else if (value instanceof Boolean){
            return (Boolean)value;
        }
        else if ("1".equals(value.toString())){
            return true;
        }
        else if ("0".equals(value.toString())){
            return false;
        }
        return false;
    }
    
    public List<String> stringToList(String expr){
        List<String> lista = new ArrayList<>();
        int k   = 0;
        int ini = 0;
        while (true){
            k = k + 1;
            int fin = findLimit(",",expr,k);
            if (fin < 0){
                fin = expr.length();
            }
            lista.add(expr.substring(ini,fin).trim());
            ini = fin + 1;
            if (fin == expr.length()){
                break;
            }
        }
        return lista;
    }
    
    
    public String[] convertToMatrix(String expr, String separador) {
        String[] exprList = expr.split("\\"+separador);
        for (int i = 0; i < exprList.length; i++) {
            exprList[i] = exprList[i].trim();
        }
        return exprList;
    }

    public List<String> convertToList(String expr, String separador) {
        List<String> lista = new ArrayList<>();
        String[] exprList = expr.split("\\"+separador);
        for (int i = 0; i < exprList.length; i++) {
            lista.add(exprList[i].trim());
        }
        return lista;
    }
    
}
