/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.testvarios;

import clases.ITestLoadClass;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 *
 * @author jenci_000
 */
public class TestLoadClass {

    public static void main(String[] args) throws Exception {
        String folder="/proyectos/java/oym/TestProjects/TestProjects-jar/varios";
        String classPath = "clases.TestLoadClass";
        Class clazz = loadClass(folder,classPath);
        ITestLoadClass obj = (ITestLoadClass) clazz.newInstance();
        obj.holaMundo();
    }

    static Class loadClass(String folder, String classPath) {
        Class cls = null;
        try {
            // Create a File object on the root of the directory containing the class file
            File file = new File(folder);
            // Convert File to a URL
            URL url = file.toURL();
            URL[] urls = new URL[]{url};

            // Create a new class loader with the directory
            ClassLoader cl = new URLClassLoader(urls);

            // Load in the class; 
            cls = cl.loadClass(classPath);
        } catch (MalformedURLException e) {

        } catch (ClassNotFoundException e) {
            System.out.println("Error no encuentra la clase");
        }
        return cls;
    }
}
