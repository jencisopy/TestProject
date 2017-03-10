/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.xml;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jdom2.Element;
import org.jdom2.Document;
import static org.junit.Assert.*;
import static py.com.oym.frame.util.Strings.fileToString;
import org.junit.Test;
import py.com.oym.frame.xml.IXmlCache;
import py.com.oym.frame.xml.IXmlCacheKey;
import py.com.oym.frame.xml.JDom;
import py.com.oym.frame.xml.XmlCache;
import py.com.oym.frame.xml.XmlCacheKey;
import py.com.oym.frame.xml.XmlJDom;
import py.com.oym.frame.xml.XmlSearcher;
import static py.com.oym.frame.xml.XmlSearcher.getJustPath;

/**
 *
 * @author Jorge Enciso
 */
public class TestJDom {

    //@Test
    public void test() throws Exception {
        long tiempoInicio = System.currentTimeMillis();
        String xml = "<?xml version=\"1.0\" encoding=\"Windows-1252\" standalone=\"yes\" ?>"
                + "         <productos>"
                + "                <prueba/>"
                + "                <producto id='10' activo='true' valor='${reemplazar}' valor2='#{reemplazar}'>"
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
        Map<String, String> params = new HashMap();
        params.put("REEMPLAZAR", "valor reemplazado");

        boolean obj = document.config("", xml, "/productos/producto", true, params);
        System.out.println("Hashcode param " + params.hashCode());
        System.out.println("Hashcode param " + document.getConfigParam().hashCode());

        
//        List<Element> elements
//                = JDom.selectNodes(document.getXmlJDom(),
//                        "//*[contains(@valor, '{') and contains(@valor ,'}')]");
        
        List<Element> elements
                = JDom.selectNodes(document.getXmlJDom(),
                        "//*[@*[starts-with(., '#{') or starts-with(., '${')]]");
        

        assertTrue(obj);

        System.out.print(document.toString());
        System.out.println("OBTIENE EL VALOR DE UN ATRIBUTO");
        String value = document.getPropertyValue("id", "/producto");
        assertNotNull(value);
        System.out.println(value);

        //Cambiar el valor de la propiedad de un nodo
        System.out.println("\nANTES DE CAMBIAR PROPIEDAD DEL NODO\n" + document.toString());
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
        boolean obj = document.config(file, "XML/THEMES", true, null);
        assertTrue(obj);
        System.out.print(document.getXml());
    }

    //@Test
    public void test3() {
        File file = new File("/proyectos/java/oym/TestProjects/clasemaker.xml");
        XmlJDom document = new XmlJDom();
        boolean obj = document.config(file, "XML/THEMES", true, null);
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
        boolean obj = document.config(file, "XML/THEMES", true, null);
        assertTrue(obj);
        org.w3c.dom.Document doc = document.getDom();
        System.out.println(doc.getFirstChild().getNodeName());
    }

    //@Test
    public void testHerencia() {
        String documentPath = "file:///proyectos/java/oym/TestProjects/dic_ag_log.xml";
        XmlJDom document = new XmlJDom();
        document.addConfigParam("path", "/proyectos/java/oym/TestProjects/");
        document.addConfigParam("pathtype", "FILE");
        boolean obj = document.config(documentPath, "", "/XML/AG_LOG_VIEW", false, null);
        System.out.println(document.toString());
        assertTrue(obj);
    }

    //@Test
    public void testInsertElement() {
        long tiempoInicio = System.currentTimeMillis();
        String xml = "<?xml version=\"1.0\" encoding=\"Windows-1252\" standalone=\"yes\" ?>"
                + "         <productos>"
                + "                <prueba1/>"
                + "                <prueba2/>"
                + "                <prueba3/>"
                + "                <prueba5/>"
                + "           </productos>";
        XmlJDom document = new XmlJDom();
        boolean obj = document.config("", xml, "/productos", false, null);
        assertTrue(obj);

        System.out.println("ANTES DE INSERTAR ELEMENTO PRUEBA 4\n" + document.toString());

        assertTrue(obj);

        obj = document.insertElement("prueba4", "productos", 3);
        assertTrue(obj);

        System.out.println("DESPUES DE INSERTAR ELEMENTO PRUEBA 4 (inserta 3er lugar)\n" + document.toString());

        assertTrue(obj);

        long totalTiempo = System.currentTimeMillis() - tiempoInicio;
        System.out.println("Tiempo: " + totalTiempo + " miliseg");
    }

    //@Test
    public void testRemoveChildren() {
        long tiempoInicio = System.currentTimeMillis();
        String xml = "<?xml version=\"1.0\" encoding=\"Windows-1252\" standalone=\"yes\" ?>"
                + "         <productos>"
                + "                hola"
                + "                <prueba1/>"
                + "                <prueba2/>"
                + "                <prueba3/>"
                + "                <prueba5/>"
                + "           </productos>";
        XmlJDom document = new XmlJDom();
        boolean obj = document.config("", xml, "/productos", false, null);
        assertTrue(obj);

        System.out.println("ANTES DE ELIMINAR CHILDREN PRODUCTOS\n" + document.toString());
        assertTrue(obj);

        obj = document.removeChildren("productos");
        assertTrue(obj);

        System.out.println("DESPUES DE ELIMINAR CHILDREN\n" + document.toString());

        long totalTiempo = System.currentTimeMillis() - tiempoInicio;
        System.out.println("Tiempo: " + totalTiempo + " miliseg");
    }
    
    //@Test
    public void testXpath() throws Exception {
        long tiempoInicio = System.currentTimeMillis();
        String xml = "<?xml version=\"1.0\" encoding=\"Windows-1252\" standalone=\"yes\" ?>"
                + "         <productos>"
                + "                <prueba/>"
                + "                <producto id='10' activo='true' valor='${reemplazar}'>"
                + "                     <nombre>Producto 1</nombre>"
                + "                     <precio moneda='Gs' valor2='{reemplazar}'>15000</precio>"
                + "                         <colores>"
                + "                             <color>Rojo</color>"
                + "                             <color>Blue</color>"
                + "                         </colores>"
                + "                 </producto>"
                + "                 <producto id='20' activo='true'  valor1='#{reemplazar}'>"
                + "                     <nombre valor1='xx#{reemplazar}xx'>Producto 2</nombre>"
                + "                     <precio moneda='Gs'>5800</precio>"
                + "                 </producto>"
                + "           </productos>";
        XmlJDom document = new XmlJDom();
        Map<String, String> params = new HashMap();
        params.put("REEMPLAZAR", "valor reemplazado");
        document.setAllowChangeAttrWithParam(true);

        boolean obj = document.config("", xml, "/productos", true, params);
        
        System.out.println("TEXTO PROCESADO");
        System.out.println("===============");                        
        System.out.println(document.toString());
        System.out.println("TEXTO ORIGINAL");
        System.out.println("===============");        
        System.out.println(document.getOriginalXmlText());
        
        IXmlCache<Document> cache = new XmlCache(document.getXmlJDom(),new Date());
        System.out.println(cache.getDom().getClass().getName());
        //assertTrue(elements.size() == 3);
    }
    
    //@Test
    public void testCache() {
        File file = new File("/proyectos/java/oym/TestProjects/clasemaker.xml");
        XmlJDom document = new XmlJDom();
        boolean obj = document.config(file, "XML/THEMES", true, null);
        assertTrue(obj);
        obj = document.config(file, "XML/THEMES", true, null);
        assertTrue(obj);
        System.out.print(document.getXml());        
    }

    //@Test
    public void testCache2() {
        String documentPath = "file:///proyectos/java/oym/TestProjects/dic_ag_log.xml";
        XmlJDom document = new XmlJDom();
        document.addConfigParam("path", "/proyectos/java/oym/TestProjects/");
        document.addConfigParam("pathtype", "FILE");
        boolean obj = document.config(documentPath, "", "/XML/AG_LOG_VIEW", false, null);
        System.out.println(document.toString());
        assertTrue(obj);
    }

    
    //@Test
    public void textCacheKey(){
        Map<IXmlCacheKey, String> cache = new HashMap();

        IXmlCacheKey key = new XmlCacheKey("file","/folder1/document.xml","element"); 
        assertEquals("/folder1/document.xml", key.getDocumentPath());
        assertEquals("file",key.getPathType());        

        key = new XmlCacheKey("file:","/folder1/document.xml","element"); 
        assertEquals("/folder1/document.xml", key.getDocumentPath());
        assertEquals("file",key.getPathType()); 
        
        key = new XmlCacheKey("FILE","file:///folder1/document.xml","element"); 
        assertEquals("/folder1/document.xml", key.getDocumentPath());
        assertEquals("file",key.getPathType());
        
        key = new XmlCacheKey("","file:///folder1/document.xml","element"); 
        assertEquals("/folder1/document.xml", key.getDocumentPath());
        assertEquals("file",key.getPathType());        
        
        key = new XmlCacheKey("file:///folder1/document.xml","element"); 
        assertEquals("/folder1/document.xml", key.getDocumentPath());
        assertEquals("file",key.getPathType());        
        
        key = new XmlCacheKey("/folder1/document.xml","element"); 
        assertEquals("/folder1/document.xml", key.getDocumentPath());
        assertEquals("file",key.getPathType());    
        
        key = new XmlCacheKey("file://folder1/document.xml","element"); 
        assertEquals("folder1/document.xml", key.getDocumentPath());
        assertEquals("file",key.getPathType()); 
    }
    
    @Test
    public void testJustPath(){
        String result = getJustPath("file://folder1/document.xml");
        assertEquals("folder1/document.xml", result);

        result = getJustPath("/folder1/document.xml");
        assertEquals("/folder1/document.xml", result);

        result = getJustPath("file:///folder1/document.xml");
        assertEquals("/folder1/document.xml", result);

        result = getJustPath("folder1/document.xml");
        assertEquals("folder1/document.xml", result);
    }
}

