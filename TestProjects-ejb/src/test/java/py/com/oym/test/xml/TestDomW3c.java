/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import org.w3c.dom.Document;
import org.javabeanstack.xml.DomW3cParser;
import javax.xml.transform.TransformerException;

import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.javabeanstack.xml.IXmlCache;
import org.javabeanstack.xml.IXmlCacheKey;
import org.javabeanstack.xml.IXmlDom;
import org.javabeanstack.xml.XmlCache;
import org.javabeanstack.xml.XmlCacheKey;
import org.javabeanstack.xml.XmlDomW3c;

import static org.junit.Assert.*;



/**
 *
 * @author Jorge Enciso
 */
public class TestDomW3c {
    private String xml = "<?xml version=\"1.0\" encoding=\"Windows-1252\" standalone=\"yes\" ?>\n"
                + "         <productos>\n"
                + "                textnode"
                + "                <prueba  prop1='test1'/>\n"
                + "                <prueba2 prop1='test1'/>\n"            
                + "                <prueba3 prop1='test1'/>\n"            
                + "                <producto id='10' activo='true' valor='${reemplazar}' valor2='#{reemplazar}'>\n"
                + "                     <nombre>Producto 1</nombre>\n"
                + "                     <precio moneda='Gs'>15000</precio>\n"
                + "                         <colores>\n"
                + "                             <color>Rojo</color>\n"
                + "                             <color>Blue</color>\n"
                + "                         </colores>\n"
                + "                 </producto>\n"
                + "                 <producto id='20' activo='true'>\n"
                + "                     <nombre>Producto 2</nombre>\n"
                + "                     <precio moneda='Gs'>5800</precio>\n"
                + "                 </producto>\n"
                + "                 <tag1>\n"
                + "                     <tag1/>\n"
                + "                 </tag1>\n"
                + "           </productos>\n";

    //@Test
    public void test() throws Exception {
        Document document = DomW3cParser.loadXml(xml);
        assertNotNull(document);
        System.out.println(DomW3cParser.getXmlText(document.getDocumentElement()));
    }
    
    @Test
    public void test2() throws Exception {
        IXmlDom document = new XmlDomW3c();
        Map<String, String> params = new HashMap();
        params.put("REEMPLAZAR", "valor reemplazado");
        
        //document.setAllowChangeAttrWithParam(false);
        boolean obj = document.config("", xml, "/productos/producto", true, params);
        System.out.println("Hashcode param " + params.hashCode());
        System.out.println("Hashcode param " + document.getConfigParam().hashCode());

        
//        List<Element> elements
//                = JDom.selectNodes(document.getXmlJDom(),
//                        "//*[contains(@valor, '{') and contains(@valor ,'}')]");
        
        NodeList elements
                = DomW3cParser.selectNodes(document.getDom(),
                        "//*[@*[starts-with(., '#{') or starts-with(., '${') or starts-with(., '{')]]");
        
        elements
                = DomW3cParser.selectNodes(document.getDom(),
                        "//*[@*[(starts-with(., '#{') or starts-with(., '${') or starts-with(., '{'))  and (contains(.,'}')) ]]");
        
        
        
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
    }
    
    //@Test
    // Test convertir file a objeto DOM
    public void test3() throws ParserConfigurationException, IOException, FileNotFoundException, SAXException, TransformerException {
        File file = new File("/proyectos/java/oym/TestProjects/clasemaker.xml");
        Document dom = DomW3cParser.loadXml(file);
        assertNotNull(dom);
        System.out.println(DomW3cParser.getXmlText(dom));
    }
    
    //@Test
    // Test convertir a objeto DOM a partir de un pathfile
    public void testDocumentPath() throws ParserConfigurationException, IOException, FileNotFoundException, SAXException, TransformerException {
        IXmlDom xmlDom = new XmlDomW3c();
        boolean obj = xmlDom.config("file:///proyectos/java/oym/TestProjects/clasemaker.xml", "", "", true);
        assertTrue(obj);
        System.out.println(xmlDom.getXml());
    }
    
    
    //@Test
    // Prueba creacion y borrado de elementos
    public void testElement() throws ParserConfigurationException, IOException, FileNotFoundException, SAXException, TransformerException, Exception {
        Document document = DomW3cParser.loadXml(xml);
        assertNotNull(document);
        Element nodeRef = DomW3cParser.getElement(document, "/productos/producto");

        // Crear textnode
        Node nodeText = document.createTextNode("\n");
        // Crear element
        Element element = document.createElement("prueba4");        
        element.appendChild(nodeText);
        // Crear antes de /productos/producto
        DomW3cParser.insertElementBefore(element, document.getDocumentElement(), nodeRef);
        
        System.out.println(DomW3cParser.getXmlText(document));        
        System.out.println("==================================");
        
        // Eliminar 2 veces a ver si da error
        DomW3cParser.removeElement(document,"/productos/prueba4");
        DomW3cParser.removeElement(document,"/productos/prueba4");        
        
        // Crear elemento a partir de un string
        element = DomW3cParser.createElement(document, "prueba5", "/productos");
        assertNotNull(element);

        //========================================================
        // Crear elemento desde otro elemento de otro documento
        Document document2 = DomW3cParser.loadXml(xml);
        Element element2 = DomW3cParser.getElement(document2, "/productos/prueba");
        Element elementNew = DomW3cParser.getElement(document2, "/productos/producto/colores");
        element = (Element)element2.cloneNode(true);
        element = DomW3cParser.createElement(document, element, "/productos");
        assertNotNull(element);

        //========================================================
        // Agregar un elemento al final
        element = document.createElement("prueba6");
        DomW3cParser.insertElementBefore(element, document.getDocumentElement(), null);
        
        //=======================================================
        // Replace child
        DomW3cParser.replaceChild(document.getDocumentElement(), elementNew, element);
        
        System.out.println(DomW3cParser.getXmlText(document));        
    }
    
    //@Test
    // Test selectNodes
    public void test4() throws Exception {
        Document document = DomW3cParser.loadXml(xml);
        assertNotNull(document);
        NodeList nodes = DomW3cParser.selectNodes(document, "//producto");
        
        System.out.println(nodes.getLength());
    }
    
    //@Test
    // Test getProperty, setProperty
    public void testProperties() throws Exception {
        Document document = DomW3cParser.loadXml(xml);
        assertNotNull(document);
        String attrValue = DomW3cParser.getPropertyValue(document, "prop1", "productos/prueba");
        assertNotNull(attrValue);        
        attrValue = DomW3cParser.getPropertyValue(document, "prop1", "//prueba");
        assertNotNull(attrValue);        
        
        Element element = DomW3cParser.getElement(document, "productos/prueba");
        attrValue = DomW3cParser.getPropertyValue("prop1",element);
        System.out.println(attrValue);
        
        DomW3cParser.setPropertyValue("testCambio", "prop1", element);
        attrValue = DomW3cParser.getPropertyValue("prop1",element);        
        System.out.println(attrValue);
        
        DomW3cParser.setPropertyValue(document, "testCambio2", "prop1", "//prueba");
        attrValue = DomW3cParser.getPropertyValue("prop1",element);        
        System.out.println(attrValue);
    }
    
    //@Test
    public void testGetChildren() throws Exception {
        Document document = DomW3cParser.loadXml(xml);
        List<Element> children = DomW3cParser.getChildren(document, "productos");
        children.forEach((element) -> {
            System.out.println(element.getNodeName());
        });
    }
    
    //@Test
    public void testRemoveChildren() throws Exception {
        Document document = DomW3cParser.loadXml(xml);
        Element node = DomW3cParser.getElement(document, "productos");
        while (node.hasChildNodes()){
            Node child = node.getChildNodes().item(0);
            node.removeChild(child);
        }
        assertFalse(node.hasAttributes());
    }    
    
    //@Test
    public void testGetElementByTagName() throws Exception{
        Document document = DomW3cParser.loadXml(xml);
        Element root = document.getDocumentElement();
        NodeList nodeList = root.getElementsByTagName("tag1");
        System.out.println(nodeList.getLength());
        
    }
    
    //@Test
    public void test10() {
        File file = new File("/proyectos/java/oym/TestProjects/clasemaker.xml");
        IXmlDom document = new XmlDomW3c();
        boolean obj = document.config(file, "XML/THEMES", true, null);
        assertTrue(obj);
        System.out.print(document.getXml());
    }
    
    //@Test
    public void test11() {
        File file = new File("/proyectos/java/oym/TestProjects/clasemaker.xml");
        IXmlDom document = new XmlDomW3c();
        boolean obj = document.config(file, "XML/THEMES", true, null);
        assertTrue(obj);
        // Borrar nodo
        System.out.println("ANTES DE BORRAR NODO\n" + document.toString());
        obj = document.removeElement("/THEMES/THEME1");
        assertTrue(obj);
        System.out.println("DESPUES DE BORRAR NODO\n" + document.toString());
    }

    //@Test
    public void test12() {
        File file = new File("/proyectos/java/oym/TestProjects/clasemaker.xml");
        IXmlDom document = new XmlDomW3c();
        boolean obj = document.config(file, "XML/THEMES", true, null);
        assertTrue(obj);
        org.w3c.dom.Document doc = document.getDom();
        System.out.println(doc.getFirstChild().getNodeName());
    }
    
    //@Test
    public void testInsertElement() {
        long tiempoInicio = System.currentTimeMillis();
        String xmlText = "<?xml version=\"1.0\" encoding=\"Windows-1252\" standalone=\"yes\" ?>"
                + "         <productos>"
                + "                <prueba1/>"
                + "                <prueba2/>"
                + "                <prueba3/>"
                + "                <prueba5/>"
                + "           </productos>";
        IXmlDom document = new XmlDomW3c();
        boolean obj = document.config("", xmlText, "/productos", false, null);
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
    public void testRemoveChildren2() {
        long tiempoInicio = System.currentTimeMillis();
        String xmlText = "<?xml version=\"1.0\" encoding=\"Windows-1252\" standalone=\"yes\" ?>"
                + "         <productos>"
                + "                hola"
                + "                <prueba1/>"
                + "                <prueba2/>"
                + "                <prueba3/>"
                + "                <prueba5/>"
                + "           </productos>";
        IXmlDom document = new XmlDomW3c();
        boolean obj = document.config("", xmlText, "/productos", false, null);
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
        String xmlText = "<?xml version=\"1.0\" encoding=\"Windows-1252\" standalone=\"yes\" ?>"
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
        IXmlDom document = new XmlDomW3c();
        Map<String, String> params = new HashMap();
        params.put("REEMPLAZAR", "valor reemplazado");
        document.setAllowChangeAttrWithParam(true);

        boolean obj = document.config("", xmlText, "/productos", true, params);
        
        System.out.println("TEXTO PROCESADO");
        System.out.println("===============");                        
        System.out.println(document.toString());
        System.out.println("TEXTO ORIGINAL");
        System.out.println("===============");        
        System.out.println(document.getOriginalXmlText());
        
        IXmlCache<Document> cache = new XmlCache(document.getDom(),new Date());
        System.out.println(cache.getDom().getClass().getName());
        //assertTrue(elements.size() == 3);
    }

    //@Test
    public void testCache() {
        File file = new File("/proyectos/java/oym/TestProjects/clasemaker.xml");
        IXmlDom document = new XmlDomW3c();
        boolean obj = document.config(file, "XML/THEMES", true, null);
        assertTrue(obj);
        obj = document.config(file, "XML/THEMES", true, null);
        assertTrue(obj);
        System.out.print(document.getXml());        
    }
    
    //@Test
    public void testCache2() {
        String documentPath = "file:///proyectos/java/oym/TestProjects/dic_ag_log.xml";
        IXmlDom document = new XmlDomW3c();
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
    
    //@Test
    public void testHerencia() {
        String documentPath = "file:///proyectos/java/oym/TestProjects/dic_ag_log.xml";
        IXmlDom document = new XmlDomW3c();
        document.addConfigParam("path", "/proyectos/java/oym/TestProjects/");
        document.addConfigParam("pathtype", "FILE");
        boolean obj = document.config(documentPath, "", "/XML/AG_LOG_VIEW", false, null);
        System.out.println(document.toString());
        assertTrue(obj);
    }

    
    //@Test
    public void testHerencia2() {
        String documentPath = this.getClass().
                getResource("/xml/itemventa_fechanro_operativo.xml").getFile();
        File file = new File(documentPath);        
        String path = file.getParent();
        IXmlDom document = new XmlDomW3c();
        Map<String, String> params = new HashMap();
        params.put("path", path);
        params.put("pathtype", "FILE");
        //params.put("encoding","UTF-8");
        boolean obj = document.config(documentPath, "", "XML/BODY", false, params);
        System.out.println(document.toString());
        System.out.println(document.getPropertyValue("h","CRITERIOS/CRITERIO2/e2"));
        String property = document.getPropertyValue("h","CRITERIOS/CRITERIO2/e2");
        assertTrue(obj);
        assertTrue(property.equals("Código del Item"));
    }

    //@Test
    public void testHerencia3() {
        String documentPath = "file://C:/proyectos/java/oym/TestProjects/itemventa_fechanro_operativo.xml";
        IXmlDom document = new XmlDomW3c();
        document.addConfigParam("path", "C:/proyectos/java/oym/TestProjects/");
        document.addConfigParam("pathtype", "FILE");
        document.addConfigParam("encoding","UTF-8");

        boolean obj = document.config(documentPath, "", "XML", false);
        System.out.println(document.toString());
        assertTrue(obj);
    }

    @Test
    public void testGetElements() throws Exception {
        String documentPath = "file://C:/proyectos/java/oym/TestProjects/itemventa_fechanro_operativo.xml";
        IXmlDom document = new XmlDomW3c();
        
        document.addConfigParam("path", "C:/proyectos/java/oym/TestProjects/");
        document.addConfigParam("pathtype", "FILE");
        document.addConfigParam("encoding","UTF-8");

        boolean obj = document.config(documentPath, "", "XML", false);
        System.out.println(document.toString());
        
        List<Element> elements = document.getChildren("XML/BODY/RANGOS/GRDRANGOS");
        System.out.println("Cantidad de elementos: "+elements.size());
        elements.forEach((element) -> {
            try {
                System.out.println(DomW3cParser.getXmlText(element));
            } catch (TransformerException ex) {
                Logger.getLogger(TestDomW3c.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        assertTrue(obj);
    }
}
