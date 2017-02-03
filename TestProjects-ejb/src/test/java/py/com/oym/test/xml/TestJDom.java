/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.xml;

import java.io.File;
import static org.junit.Assert.*;
import static py.com.oym.frame.util.Strings.fileToString;
import org.junit.Test;

/**
 *
 * @author Jorge Enciso
 */
public class TestJDom {

    //@Test
    public void test() {
        long tiempoInicio = System.currentTimeMillis();        
        String xml = "<?xml version=\"1.0\" encoding=\"Windows-1252\" standalone=\"yes\" ?>"
                + "         <productos>"
                + "                <prueba/>"
                + "                <producto id='10' activo='true'>"
                + "                     <nombre>Producto 1</nombre>"
                + "                     <precio moneda='Gs'>15000</precio>"
                + "                         <colores>"
                + "                             <color>Rojo</color>"
                + "                             <color>Blue</color>"
                + "                         </colores>"
                + "                 </producto>"
                + "                 <producto id='20' activo='true'>"
                + "                     <nombre>Producto 2</nombre>"
                + "                     <precio moneda='Gs'>5800</precio>"
                + "                 </producto>"
                + "           </productos>";
        XmlJDom document = new XmlJDom();
        boolean obj = document.config("",xml, "/productos/producto", true);
        assertTrue(obj);
        System.out.print(document.toString());
        System.out.println("OBTIENE EL VALOR DE UN ATRIBUTO");
        String value = document.getPropertyValue("id", "/producto");
        assertNotNull(value);
        System.out.println(value);

        //Cambiar el valor de la propiedad de un nodo
        //System.out.println("\nANTES DE CAMBIAR PROPIEDAD DEL NODO\n" + document.toString());
        obj = document.setPropertyValue("false", "activo", "/producto");
        assertTrue(obj);
        System.out.println("DESPUES DE CAMBIAR PROPIEDAD DEL NODO\n" + document.toString());
        
        long totalTiempo = System.currentTimeMillis() - tiempoInicio;
        System.out.println("Tiempo: " + totalTiempo + " miliseg");
    }

    //@Test
    public void test2() {
        File file = new File("/proyectos/java/oym/TestProjects/clasemaker.xml");
        XmlJDom document = new XmlJDom();
        boolean obj = document.config(file, "XML/THEMES", true);
        assertTrue(obj);
        System.out.print(document.getXml());
    }

    //@Test
    public void test3() {
        File file = new File("/proyectos/java/oym/TestProjects/clasemaker.xml");
        XmlJDom document = new XmlJDom();
        boolean obj = document.config(file, "XML/THEMES", true);
        assertTrue(obj);
        // Borrar nodo
        System.out.println("ANTES DE BORRAR NODO\n" + document.toString());
        obj = document.removeElement("/THEMES/THEME1");
        assertTrue(obj);
        System.out.println("DESPUES DE BORRAR NODO\n" + document.toString());
    }

    //@Test
    public void test4() {
        String xml = fileToString("/proyectos/java/oym/TestProjects/clasemaker.xml");
        assertFalse(xml.isEmpty());
        System.out.println(xml);
    }

   
    //@Test
    public void test5() {
        File file = new File("/proyectos/java/oym/TestProjects/clasemaker.xml");
        XmlJDom document = new XmlJDom();
        boolean obj = document.config(file, "XML/THEMES", true);
        assertTrue(obj);
        org.w3c.dom.Document doc = document.getXmlDom();
        System.out.println(doc.getFirstChild().getNodeName());
    }
    
    @Test
    public void testHerencia() {
        String documentPath = "file:///proyectos/java/oym/TestProjects/dic_ag_log.xml";
        XmlJDom document = new XmlJDom();
        document.addConfigParam("path", "/proyectos/java/oym/TestProjects/");
        document.addConfigParam("pathtype", "FILE");
        boolean obj = document.config(documentPath,"", "/XML/AG_LOG_VIEW", false);
        System.out.println(document.toString());
        assertTrue(obj);        
    }
}
