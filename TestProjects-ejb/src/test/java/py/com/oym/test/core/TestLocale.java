/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.core;

import java.text.DateFormat;
import java.util.Locale;
import org.junit.Test;

/**
 *
 * @author jenci_000
 */
public class TestLocale {
    @Test
    public void test1(){
        Locale list[] = DateFormat.getAvailableLocales();
        for (Locale aLocale : list) {
            //System.out.println(aLocale.toString());
            System.out.println(aLocale.getDisplayName());
        }
    }
}
