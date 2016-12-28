/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.core;

/**
 *
 * @author jenci_000
 */
public class TestExecMethodParent {
    public String testReturn(){
        return "parent";
    }
    
    public String test1(){
        return testReturn();
    }
}
