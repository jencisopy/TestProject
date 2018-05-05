/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.core;

import org.apache.commons.io.FilenameUtils;
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
public class TestFileUtils {
    
    public TestFileUtils() {
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

    // The methods must be annotated with annotation @Test. For example:
    //
//    @Test
    public void testFileName() {
        String file = "c:/carpeta1/carpeta2/archivo.xml";
        System.out.println("GETPATH");
        System.out.println("===========================");
        System.out.println(FilenameUtils.getPath(file));
        
        System.out.println("FULLPATH");
        System.out.println("===========================");
        System.out.println(FilenameUtils.getFullPath(file));

        System.out.println("FULLPATHWITHNOENDSEPARATOR");
        System.out.println("===========================");
        System.out.println(FilenameUtils.getFullPathNoEndSeparator(file));
        
        System.out.println("BASENAME");
        System.out.println("===========================");
        System.out.println(FilenameUtils.getBaseName(file));
        
        System.out.println("NAME");
        System.out.println("===========================");
        System.out.println(FilenameUtils.getName(file));

        System.out.println("EXTENSION");
        System.out.println("===========================");
        System.out.println(FilenameUtils.getExtension(file));
        
        System.out.println("NAME");
        System.out.println("===========================");
    }
    
    //@Test
    public void testFileName2() {
        String file = "file://carpeta1/carpeta2/archivo.xml";
        System.out.println("GETPATH");
        System.out.println("===========================");
        System.out.println(FilenameUtils.getPath(file));
        
        System.out.println("FULLPATH");
        System.out.println("===========================");
        System.out.println(FilenameUtils.getFullPath(file));

        System.out.println("FULLPATHWITHNOENDSEPARATOR");
        System.out.println("===========================");
        System.out.println(FilenameUtils.getFullPathNoEndSeparator(file));
        
        System.out.println("BASENAME");
        System.out.println("===========================");
        System.out.println(FilenameUtils.getBaseName(file));
        
        System.out.println("NAME");
        System.out.println("===========================");
        System.out.println(FilenameUtils.getName(file));

        System.out.println("EXTENSION");
        System.out.println("===========================");
        System.out.println(FilenameUtils.getExtension(file));
        
        System.out.println("NAME");
        System.out.println("===========================");
        
    }

    @Test
    public void testFileName3() {
        String file = "/carpeta1/carpeta2/";
        System.out.println("GETPATH");
        System.out.println("===========================");
        System.out.println(FilenameUtils.getPath(file));
        
        System.out.println("FULLPATH");
        System.out.println("===========================");
        System.out.println(FilenameUtils.getFullPath(file));

        System.out.println("FULLPATHWITHNOENDSEPARATOR");
        System.out.println("===========================");
        System.out.println(FilenameUtils.getFullPathNoEndSeparator(file));
        
        System.out.println("BASENAME");
        System.out.println("===========================");
        System.out.println(FilenameUtils.getBaseName(file));
        
        System.out.println("NAME");
        System.out.println("===========================");
        System.out.println(FilenameUtils.getName(file));

        System.out.println("EXTENSION");
        System.out.println("===========================");
        System.out.println(FilenameUtils.getExtension(file));
        
        System.out.println("NAME");
        System.out.println("===========================");
        
    }
    
}
