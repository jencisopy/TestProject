/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.data;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.Ignore;
import org.javabeanstack.data.DataExpression;

/**
 *
 * @author Jorge Enciso
 */
public class TextDataExpression {
    
    public TextDataExpression() {
    }
    
    @Test
    @Ignore    
    public void test() {
        DataExpression sentence = new DataExpression();
        Map<String, String> params = new HashMap<>();
        params.put("var1", "pp");
        sentence.addExpression("pedro = {var1}", params);
        params.put("var1", "pp");
        params.put("var2", "pp");
        sentence.addExpression("juan between '{var1}' and '{var2}'", params);
        String result = sentence.getSentence();
        System.out.println(result);
    }
    
    @Test
    @Ignore
    public void test2() {
        DataExpression sentence = new DataExpression();
        sentence.addExpression("pedro = {var1}", "var1","pp2");
        sentence.addExpression("juan between '{var1}' and '{var2}'", "var1","pp2","var2","pp2");
        String result = sentence.getSentence();
        System.out.println(result);
    }    
    
    @Test
    @Ignore
    public void test3() {
        DataExpression sentence = new DataExpression();
        sentence.openParenthesis();                
        sentence.addExpression("select '' from {schema}.moneda where idmoneda = item.idmoneda", null, "IN");
        sentence.addExpression("juan between '{var1}' and '{var2}'", "var1","pp2","var2","pp2");
        sentence.addExpression("juan like '{var1}%'", "var1","pp2");        
        sentence.closeParenthesis(); 
        
        sentence.addOperator("AND");        
        
        sentence.openParenthesis();        
        sentence.addExpression("fecha = :fecha");
        sentence.addExpression("logico = {true}");                        
        sentence.closeParenthesis();      
        
        String result = sentence.getSentence();
        System.out.println(result);
    }        

    @Test
    @Ignore
    public void test3b() {
        DataExpression sentence = new DataExpression();
        sentence.openParenthesis();                
        sentence.addExpression("juan between '{var1}' and '{var2}'", "var1","pp2","var2","pp2");
        sentence.addExpression("juan like '{var1}%'", "var1","pp2");        
        sentence.closeParenthesis(); 
        
        sentence.addOperator("AND");        
        
        sentence.openParenthesis();        
        sentence.addExpression("fecha = :fecha");
        sentence.addExpression("logico = {true}");                        
        sentence.closeParenthesis();      
        
        String result = sentence.getSentence();
        System.out.println(result);
    }        
    
    //@Test
    public void test4() {
        DataExpression sentence = new DataExpression();
        sentence.addExpression("pedro = {var1}",null, "", "1");
        sentence.addExpression("juan between '{var1}' and '{var2}'", "var1","pp2","var2","pp2");
        String result = sentence.getSentence();
        System.out.println("==============");
        System.out.println(result);
        System.out.println("==============");        
        result = sentence.getSentence("1");
        System.out.println(result);
        System.out.println("==============");
    }    

    @Test
    public void test5() {
        DataExpression sentence = new DataExpression();
        //sentence.openParenthesis();
        sentence.addExpression("pedro1 = {var1}",null, "", "1");
        sentence.addExpression("pedro1b = {var1}",null, "", "1");
        sentence.addExpression("juan1 between '{var1}' and '{var2}'", "var1","pp2","var2","pp2");
        //sentence.closeParenthesis();

        DataExpression sentence2 = new DataExpression();
        //sentence2.openParenthesis();        
        sentence2.addExpression("pedro2 = {var1}",null, "", "1");
        sentence2.addExpression("pedro2b = {var1}",null, "", "1");        
        sentence2.addExpression("juan2 between '{var1}' and '{var2}'", "var1","pp2","var2","pp2");
        //sentence2.closeParenthesis();        
        
        sentence.addExpressions(sentence2);
        String result = sentence.getSentence();
        System.out.println("==============");
        System.out.println(result);
        System.out.println("==============");        
        result = sentence.getSentence("1");
        System.out.println(result);
        System.out.println("==============");
    }    
    
}
