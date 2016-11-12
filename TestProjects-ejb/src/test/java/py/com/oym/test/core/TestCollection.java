/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.core;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jenci_000
 */
public class TestCollection {
    
    public TestCollection() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testtSet() {
        // HashSet
        java.util.Set<String> x = new HashSet();
        x.add("B");
        x.add("A");
        x.add("A");
        System.out.println("HashSet");
        System.out.println(x);
//        String element;
//        for (Iterator<String> it = x.iterator(); it.hasNext();) {
//            element = it.next();
//            System.out.println(element);
//        }

        // create a hash set
        LinkedHashSet hs = new LinkedHashSet();
        // add elements to the hash set
        hs.add("B");
        hs.add("A");
        hs.add("D");
        hs.add("E");
        hs.add("C");
        hs.add("F");
        System.out.println("LinkedHashSet");        
        System.out.println(hs);
        
        // Create a tree set
        TreeSet ts = new TreeSet();
        // Add elements to the tree set
        ts.add("C");
        ts.add("A");
        ts.add("B");
        ts.add("E");
        ts.add("F");
        ts.add("D");
        System.out.println("TreeSet");        
        System.out.println(ts);

        // Create the sorted set
        SortedSet set = new TreeSet();

        // Add elements to the set
        set.add("b");
        set.add("c");
        set.add("a");

        // Iterating over the elements in the set
        System.out.println("SortedSet");                
        System.out.println(set);                        
//       Iterator it = set.iterator();
//        while (it.hasNext()) {
//            // Get element
//            Object element = it.next();
//            System.out.println(element.toString());
//        }
        
    }
    
    @Test
    public void textList(){
        // create a linked list
        LinkedList ll = new LinkedList();
        // add elements to the linked list
        ll.add("F");
        ll.add("B");
        ll.add("D");
        ll.add("E");
        ll.add("C");
        ll.addLast("Z");
        ll.addFirst("A");
        ll.add(1, "A2");
        System.out.println("LinkedList");                
        System.out.println("Original contents of ll: " + ll);

        // remove elements from the linked list
        ll.remove("F");
        ll.remove(2);
        System.out.println("Contents of ll after deletion: "
                + ll);

        // remove first and last elements
        ll.removeFirst();
        ll.removeLast();
        System.out.println("ll after deleting first and last: "
                + ll);

        // get and set a value
        Object val = ll.get(2);
        ll.set(2, (String) val + " Changed");
        System.out.println("ll after change: " + ll);
    }
    
    @Test
    public void testMap(){
        Map<String, String> map = new LinkedHashMap();
        map.put("B", "1");
        map.put("A", "2");
        map.put("C", "3");
        for (Map.Entry<String, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }
        
        Map<String, String> map2 = new HashMap();
        map2.put("B", "1");
        map2.put("A", "2");
        map2.put("C", "3");
        for (Map.Entry<String, String> entry : map2.entrySet()){
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }

        SortedMap<String, String> map3 = new TreeMap();
        map3.put("B", "1");
        map3.put("A", "2");
        map3.put("C", "3");
        map3.put("C", "4");        
        for (Map.Entry<String, String> entry : map3.entrySet()){
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }
        
    }
}
