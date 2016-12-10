/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.core;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import py.com.oym.frame.util.Fn;
import py.com.oym.frame.util.Strings;

/**
 *
 * @author jenci_000
 */
public class StringTest3 {
    
    public StringTest3() {
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

}
