/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.core;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.SortedSet;
import java.util.TreeSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jorge Enciso
 */
public class FnTest {

    public FnTest() {
    }

    @Test
    public void test1() {
        //Long result=1L;
        //result = (Long)toObject((Integer)1,(Long)1L);
        String codigo = "hola";
        String codigo2 = null;
        if (codigo.equals(codigo2)){
            System.out.println("Esta mal");            
        }
        codigo2 = "";
        if (codigo.equals(codigo2)){
            System.out.println("Esta mal");            
        }
        
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
    public void testInList(){
        int[] lista = {1,2,3};
        int var1 = 1;
        assertTrue(inList(var1,lista));
    }
    
    public static boolean inList(Integer obj, int... list) {
        for (Object e : list) {
            if (obj.equals(e)) {
                return true;
            }
        }
        return false;
    }
    
    public Object toObject(Object source, Object target) {
        if (target instanceof String) {
            return String.valueOf(source);
        } else if (target instanceof Double) {
            return Double.valueOf(source.toString());
        } else if (target instanceof Float) {
            return Float.valueOf(source.toString());
        } else if (target instanceof Long) {
            return Long.valueOf(source.toString());
        } else if (target instanceof Integer) {
            return Integer.valueOf(source.toString());
        } else if (target instanceof Short) {
            return Short.valueOf(source.toString());
        } else if (target instanceof Boolean) {
            return Boolean.valueOf(source.toString());
        }
        return null;
    }

}
