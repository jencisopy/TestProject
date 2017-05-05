/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Test;
import static org.junit.Assert.*;
import py.com.oym.frame.util.Fn;
import py.com.oym.frame.util.Strings;
import static py.com.oym.frame.util.Strings.convertToList;
import static py.com.oym.frame.util.Strings.inString;
import static py.com.oym.frame.util.Strings.isNullorEmpty;
import static py.com.oym.frame.util.Strings.left;
import static py.com.oym.frame.util.Strings.substring;
import static py.com.oym.frame.util.Fn.iif;

/**
 *
 * @author jenci_000
 */
public class StringTest {

    public StringTest() {
    }

    //@Test
    public void test() {
        String str = "fn_idvendedor(0,1,1) as vendedor, fn_iditem(0,1,1) as item";
        //System.out.println(str.replaceAll("(.*?)",""));
        int pos  = str.indexOf("(");
        int pos2 = str.indexOf(")");
        while ((pos > 0)) {
            System.out.println(str.substring(pos + 1, pos2));
            pos = str.indexOf("(", pos + 1);
            pos2 = str.indexOf(")", pos2 + 1);
        }
    }

    //@Test
    public void test2() {
        String str = "this (#?anystring; is  #?anystring2jk;) test";
//        System.out.println(str.replaceAll("\\(.*?\\)", ""));
//
//        str = "I <strong>really</strong> want <strong>to get rid of the</strong> strong-tags!";
//        System.out.println(str.replaceAll("<.*?>", ""));
//
//        str = "I <strong>really</strong> want to get <strong>rid</strong> of the strong-tags!";
//        System.out.println(str.replaceAll("(<strong>).*?(</strong>)", ""));
//
//        str = "INI Galery something something.... jssdk FIN";
//        System.out.println(str.replaceAll("(Galery).*?(jssdk)", ""));
        
        str = "xx{valor}xx";
        Map<String,String> params = new HashMap();
        params.put("valor", "reemplazo");
        System.out.println(Strings.textMerge(str, params ,"$#?"));
    }

    //@Test
    public void testMacher() {
        String REGEX = "\\bdog\\b";
        //String REGEX = "dog";
        String INPUT = "dog dog dog (dog dogg)";
        Pattern p = Pattern.compile(REGEX);
        //  get a matcher object
        Matcher m = p.matcher(INPUT);
        int count = 0;
        while (m.find()) {
            count++;
            System.out.print("Match number " + count);
            System.out.print(" start(): " + m.start());
            System.out.println(" end(): " + m.end());
        }
        //System.out.println("end(3): " + m.end(2));
    }

    //@Test
    public void testMacher2() {
        String REGEX = "\\(.*?\\)";
        //String REGEX = "dog";
        String INPUT = "dog dog dog (dog dogg)";
        String REPLACE = "()";

        Pattern p = Pattern.compile(REGEX);
        // get a matcher object
        Matcher m = p.matcher(INPUT);
        INPUT = m.replaceAll(REPLACE);
        System.out.println(INPUT);
    }

    //@Test
    public void testMacher3() {
        String text
                = "John writes about this, and John Doe writes about that,"
                + " and John Wayne writes about everything. ";

        String patternString1 = "(John) (.+?)[ ]";

        Pattern pattern = Pattern.compile(patternString1);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("found: '" + matcher.group(0) + "' '" + matcher.group() + "' '" + matcher.group(2));
        }
    }

    //@Test
    public void testRegex() {
        List<String> input = new ArrayList<>();
        input.add("123-45-6789");
        input.add("9876-5-4321");
        input.add("987-65-4321 (attack)");
        input.add("987-65-4321 ");
        input.add("192-83-7465");
        input.add("xx${192-83-7465}xx");        
        input.add("xx${192-83-7465}");                
        input.add("${192-83-7465}");                        

        for (String ssn : input) {
            if (ssn.matches("^(\\d{3}-?\\d{2}-?\\d{4})$")) {
                System.out.println("Found good SSN: " + ssn);
            }
        }
        
        for (String ssn : input) {
            if (ssn.matches(".*(\\$\\{.*\\}).*")) {
                System.out.println("Found good: " + ssn);
            }
        }
        
    }
    
    //@Test
    public void testSubstring(){
        String var = "Enero";
        System.out.println(var.substring(0, 3));
    }
    
    //@Test
    public void testStringToDate(){
        Date var = new Date();
        System.out.println(Strings.dateToString(var));
        System.out.println(Fn.toString(var, "yyyyMMdd"));        
    }
    
    //@Test
    public void testSubstr(){
        String var = "Enero";
        System.out.println(Strings.substr(var,0,10));
        System.out.println(Strings.substr(var,1));        
    }
    
    @Test
    public void testStringToList(){
        String xx = "item_view.familia, item_view.familianombre, "
                + "SUM(case when mes =  1 then subtotal else 000000000000.0000 end) as Mes1 ,"
                + "SUM(case when mes =2 then subtotal else 000000000000.0000 end) as Mes2 ,"
                + "SUM(case when mes =3 then subtotal else 000000000000.0000 end) as Mes3 ,"
                + "SUM(case when mes =1 then subtotal else 000000000000.0000 end) as Mes4 ,"
                + "SUM(case when mes =2 then subtotal else 000000000000.0000 end) as Mes5 ,"
                + "SUM(case when mes =3 then subtotal else 000000000000.0000 end) as Mes6 ,"
                + "SUM(case when mes =4 then subtotal else 000000000000.0000 end) as Mes7 ,"
                + "SUM(case when mes =5 then subtotal else 000000000000.0000 end) as Mes8 ,"
                + "SUM(case when mes =6 then subtotal else 000000000000.0000 end) as Mes9 ,"
                + "SUM(case when mes =7 then subtotal else 000000000000.0000 end) as Mes10,"
                + "SUM(case when mes =8 then subtotal else 000000000000.0000 end) as Mes11,"
                + "SUM(case when mes =9 then subtotal else 000000000000.0000 end) as Mes12,"
                + "SUM(subtotal) as subtotal,SUM(subtotal) as total";
        List<String> list = Strings.stringToList(xx);
    }
    
    //@Test
    public void testInString(){
        String comodinIni = ",(. ";
        String comodinFin = ".";
        String expresion = "c.item, b.item";
        String search = "b";
        assertTrue(Strings.inString(comodinIni, search, comodinFin, expresion));

        /*
        expresion = "c.item,c.item from datos.itemmovimiento_view c";
        search = "ITEMMOVIMIENTO_VIEW";
        comodinFin = "., *)";
        assertTrue(Strings.inString(comodinIni, search, comodinFin, expresion));
        */
        comodinIni = ",( ";
        expresion = "c.impuesto ";
        search = "impuesto";
        comodinFin = "., *)";
        assertTrue(Strings.inString(comodinIni, search, comodinFin, expresion));
        
    }
    
    //@Test
    public void testEntityRelationList(){    
        EntitiesToRelation prueba = new EntitiesToRelation();
        String lista = prueba.get("itemmovimiento", 
                                    "itemmovimiento a, itemmovimientodetalle b", 
                                    "select a.*", 0, "");
        System.out.println(lista);
    }
    
    
    class EntitiesToRelation{
        String listEntities="";
        String track="";
        private String get(String mainEntity, String entityAlias, String sentence,
                            int level, String processList){
            if (level == 0){
                listEntities = "";
                track = "";
            }
            if (level == 10){
                return listEntities;
            }
            if (isNullorEmpty(processList)){
                processList = "";
            }
            mainEntity = mainEntity.toLowerCase().trim();
            sentence = sentence.toLowerCase();
            track += mainEntity+",";
            if (!isNullorEmpty(entityAlias)){
                // Generar expresiones separadas por coma
                List<String> tokenList = convertToList(entityAlias,",");
                for (String token:tokenList){
                    // Determinar valor de la entidad y del alisa
                    String entity = left(token,token.indexOf(" ")).toLowerCase().trim();
                    String alias = substring(token,token.indexOf(" ")+1).toLowerCase().trim();
                    // Ver si existe el alias en la expresion de sentencia
                    if (inString(",(. ",alias,".",sentence)){
                        // Agregar a la lista de entidades si no se encuentra ya
                        if (!inString(",(. ",entity,"., *)",this.listEntities)){
                            this.listEntities += 
                                    iif(!this.listEntities.isEmpty(),", ","") + entity+" "+alias;
                        }
                    }
                }
            }
            return listEntities;
        }
    }
}
