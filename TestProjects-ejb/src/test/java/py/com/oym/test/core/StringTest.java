/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
public class StringTest {

    public StringTest() {
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
        System.out.println(str.replaceAll("\\(.*?\\)", ""));

        str = "I <strong>really</strong> want <strong>to get rid of the</strong> strong-tags!";
        System.out.println(str.replaceAll("<.*?>", ""));

        str = "I <strong>really</strong> want to get <strong>rid</strong> of the strong-tags!";
        System.out.println(str.replaceAll("(<strong>).*?(</strong>)", ""));

        str = "INI Galery something something.... jssdk FIN";
        System.out.println(str.replaceAll("(Galery).*?(jssdk)", ""));
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

        for (String ssn : input) {
            if (ssn.matches("^(\\d{3}-?\\d{2}-?\\d{4})$")) {
                System.out.println("Found good SSN: " + ssn);
            }
        }
    }
    
    @Test
    public void testSubstring(){
        String var = "Enero";
        System.out.println(var.substring(0, 3));
    }
    
    @Test
    public void testStringToDate(){
        Date var = new Date();
        System.out.println(Strings.dateToString(var));
        System.out.println(Fn.toString(var, "yyyyMMdd"));        
    }
}
