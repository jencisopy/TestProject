/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.core;

import org.junit.Test;

/**
 *
 * @author Jorge Enciso
 */
public class TestExecMethod extends TestExecMethodParent{
    public TestExecMethod() {
    }

    @Test
    public void test() {
        System.out.println(super.test1());
    }
    
    @Override
    public String testReturn(){
        return "child";
    }    

}
