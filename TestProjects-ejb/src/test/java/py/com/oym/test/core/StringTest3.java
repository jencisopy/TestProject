/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.core;

import org.junit.Test;
import py.com.oym.frame.util.Strings;

/**
 *
 * @author Jorge Enciso
 */
public class StringTest3 {
    
    public StringTest3() {
    }
    
    @Test
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
        
    }
    
}
