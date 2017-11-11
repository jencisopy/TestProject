/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.testvarios;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 *
 * @author jenci_000
 */
public class JarFileLoader extends URLClassLoader {

    public static void main(String args[]) {
        String cp = System.getenv("CLASSPATH");
        System.out.println(cp);        
        try {
            System.out.println("First attempt...");
            Class.forName("py.com.oym.testvarios.TestClassLoad2");
        } catch (Exception ex) {
            System.out.println("Failed.");
        }
        try {
            URL urls[] = {};
            JarFileLoader cl = new JarFileLoader(urls);
            cl.addFile("/proyectos/java/oym/TestProjects/TestProjects-jar/varios/TestLoadFromJAR.jar");
            System.out.println("Second attempt...");
            cl.loadClass("py.com.oym.testvarios.TestClassLoad2");
            System.out.println("Success!");
        } catch (Exception ex) {
            System.out.println("Failed.");
            ex.printStackTrace();
        }
    }

    public JarFileLoader(URL[] urls) {
        super(urls);
    }

    public void addFile(String path) throws MalformedURLException {
        String urlPath = "jar:file://" + path + "!/";
        addURL(new URL(urlPath));
    }
}
