/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.xml;

import com.google.common.base.Strings;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.jdom2.Attribute;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.output.DOMOutputter;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import py.com.oym.frame.error.ErrorManager;
import py.com.oym.frame.util.Fn;
import static py.com.oym.frame.util.Strings.*;

/**
 * Su función es devolver un objeto XML (xdom) a partir de una serie de
 * parametros que permite al algoritmo encontrar o establecer el texto xml que
 * se convertirá en el objeto mencionado. El texto XML puede derivar de otros
 * textos, para ello la función utiliza un esquema de clases implementando el
 * paradigma de la orientación a objetos (herencia, encapsulación polimorfismo)
 *
 * @author Jorge Enciso
 */
public class XmlJDomBak {

    private static final Logger LOGGER = Logger.getLogger(XmlJDomBak.class);

    /**
     * En esta propiedad se le asignará el objeto XMLDOM.
     */
    private Document xmlDom;

    private Map<String, Document> cache = new HashMap();

    /**
     * Determina si se guardará información desde donde derivó el atributo
     */
    private boolean infoProperty = false;

    private Map<String, String> configParam = new HashMap();

    /**
     * Aqui se almacena el error ocurrido
     */
    private Exception exception;

    public XmlJDomBak() {
    }

    public boolean isInfoProperty() {
        return infoProperty;
    }

    public void setInfoProperty(boolean infoProperty) {
        this.infoProperty = infoProperty;
    }

    public Exception getException() {
        return exception;
    }

    public Document getXmlJDom() {
        return xmlDom;
    }

    public org.w3c.dom.Document getXmlDom() {
        try {
            DOMOutputter dout = new DOMOutputter();
            org.w3c.dom.Document domdoc = dout.output(this.xmlDom);
            return domdoc;
        } catch (JDOMException ex) {
            ErrorManager.showError(ex, LOGGER);
            exception = ex;
        }
        return null;
    }

    public String getXml() {
        return toString(Format.getPrettyFormat());
    }

    public Map<String, String> getConfigParam() {
        return configParam;
    }

    public void setConfigParam(Map<String, String> configParam) {
        this.configParam = configParam;
    }

    public void addConfigParam(String key, Object value) {
        configParam.put(key, value.toString());
    }

    public void addConfigParam(String key, String value) {
        configParam.put(key, value);
    }

    /**
     * Se ejecuta por intrucción explicita del sistema. <br/>
     * Su función es crear el objeto XMLDOM a partir de un archivo XML dado.
     *
     * @param file archivo dentro del cual se buscará el texto
     * @param element nombre del tag del texto xml
     * @param notInherit Para que no considere las clases derivadas
     * @return Verdadero si tuvo exito en la creación y configuración del objeto
     * XMLDOM
     * <br/>Falso si no.
     */
    public boolean config(File file, String element, boolean notInherit) {
        return this.config("file://" + file.getPath(), "", element, notInherit);
    }


    /**
     * Se ejecuta por intrucción explicita del sistema. <br>
     * Su función es crear el objeto XMLDOM a partir de un objeto DOM dado.
     *
     * @param documentPath      path del documento (opcional)
     * @param xmlText           texto xml que se convertira en objeto DOM
     * @param elementPath       nombre del tag del texto xml
     * @param notInherit        Para que no considere las clases derivadas
     * @return Verdadero si tuvo exito en la creación y configuración del objeto
     * XMLDOM
     * <br>Falso si no.
     * 
     */
    public boolean config(String documentPath, String xmlText, String elementPath, boolean notInherit) {
        try {
            exception = null;
            this.xmlDom = getObject(documentPath, xmlText, elementPath, notInherit);
            return true;
        } catch (Exception ex) {
            ErrorManager.showError(ex, LOGGER);
            exception = ex;
        }
        return false;
    }

    /**
     * Su función es<br><br>
     * Devolver un objeto XMLDOM a partir de:<br>
     * a) Un archivo xml o<br>
     * b) Una cadena con formato xml<br>
     *
     * @param documentPath clave para encontrar el texto XML dentro de la tabla
     * objetos, o un archivo de texto.
     * @param xml cadena dentro del cual se buscará el texto
     * @param element nombre del tag del texto xml
     * @param notInherit Para que no considere las clases derivadas
     * @return Objeto XMLDOM si tuvo exito y nulo si hubo algún error.
     */
    private Document getObject(String documentPath, Object xml, String elementPath, boolean notInherit) throws Exception {
        Document document = new Document();
        boolean processed = false;
        // Validar viabilidad devolver el objeto requerido
        if ((xml instanceof String) && isNullorEmpty((String) xml) && isNullorEmpty(elementPath)) {
            return null;
        }
        if ((xml instanceof String)) {
            // Si se tiene el texto xml y el elementPath, conseguir solo lo que corresponde el elementPath
            if (!isNullorEmpty((String) xml) && !isNullorEmpty(elementPath)) {
                xml = this.getString(documentPath, (String) xml, elementPath);
            } // Si no se tiene el texto xml y se tiene el elementPath
            else if (!isNullorEmpty(elementPath)) {
                document = getFromCache(documentPath);
                // Si existe en cache
                if (document != null) {
                    // Traer solo del elementpath
                    document = new Document(JDomBak.selectSingleNode(document, elementPath).clone());
                    processed = true;
                } // Si no existe en cache buscar el texto xml
                else {
                    xml = this.getString(documentPath, "", elementPath);
                }
            }
        }
        if (!processed) {
            if (xml instanceof String) {
                if (isNullorEmpty((String) xml)) {
                    return null;
                }
                document = JDomBak.loadXml((String) xml);
            } else if (xml instanceof Document) {
                document = (Document) xml;
            }
        }
        if (document == null) {
            return null;
        }
        // Si se heredará el texto de las clases
        if (!notInherit) {
            Element node = document.getRootElement();
            String xmlText = JDomBak.getXmlText(node);
            // Si existe elementos que derivan de clases
            // TODO corregir findString("clase",xmlText.toLowerCase()) > 0
            if (!isNullorEmpty(node.getAttributeValue("clase")) || findString("clase", xmlText.toLowerCase()) > 0) {
                if (isNullorEmpty(node.getAttributeValue("src"))) {
                    node.setAttribute("src", documentPath);
                }
                // Heredar elementos y atributos
                this.inherit(node,
                        node.getAttributeValue("clase"),
                        node.getAttributeValue("src"));
            }
        }
        return document;
    }

    private Element inherit(Element node, String className, String src) throws Exception {
        Document doc = this.getObject(src, "", className, false);
        Element nodeClass = null;
        if (doc != null) {
            nodeClass = doc.getRootElement();
            // Heredar los atributos de las clases
            inheritAttribute(node, nodeClass, src);
        }
        // Heredar los nodos o elementos de las clases
        inheritNode(node, nodeClass, src);
        /*
            System.out.println("===========================================");
            System.out.println(className+"-----"+src.trim());
            System.out.println("===========================================");
            System.out.println(JDomBak.getXmlText(node));
         */
        return node;
    }

    private Element inheritAttribute(Element node, Element nodeClass, String src) {
        if (nodeClass == null) {
            return node;
        }
        // Heredar las propiedades
        for (Attribute attribute : nodeClass.getAttributes()) {
            if ("__".equals(left(attribute.getName(), 2))) {
                continue;
            }
            if (node.getAttribute(attribute.getName()) == null) {
                if (infoProperty) {
                    // Se guarda la información desde donde derivo el atributo
                    if (nodeClass.getAttribute("__" + attribute.getName()) == null) {
                        node.setAttribute("__" + attribute.getName(), src);
                    } else {
                        node.setAttribute("__" + attribute.getName(), nodeClass.getAttributeValue("__" + attribute.getName()));
                    }
                }
                node.setAttribute(attribute.getName(), attribute.getValue());
            }
        }
        return node;
    }

    private Element inheritNode(Element node, Element nodeClass, String src) throws Exception {
        if (nodeClass != null) {
            Element firstChild;
            firstChild = getFirstElement(node);
            int index = 0;
            // Heredar de la clase los objetos componentes
            for (Element childNodeClass : nodeClass.getChildren()) {
                // Ver si existe
                Element nodeFound = node.getChild(childNodeClass.getName());
                if (nodeFound == null) {
                    // Insertar antes del primer nodo hijo si existe nodo hijo
                    if (firstChild != null) {
                        node.addContent(index, childNodeClass.clone());
                        index++;
                    } else {
                        node.addContent(childNodeClass.clone());
                    }
                } else {
                    inheritAttribute(nodeFound, childNodeClass, src);
                    Element firstNodeChild = getFirstElement(nodeFound);
                    int index1 = 0;
                    // Heredar los nodos que no existen en el original                    
                    for (Element nodeAdd : childNodeClass.getChildren()) {
                        // Ver si existe
                        Element nodeChildFound = nodeFound.getChild(nodeAdd.getName());
                        if (nodeChildFound == null) {
                            // Insertar antes del primer nodo hijo si existe nodo hijo
                            if (firstNodeChild != null) {
                                nodeFound.addContent(index1, nodeAdd.clone());
                                index1++;
                            } else {
                                nodeFound.addContent(nodeAdd.clone());
                            }
                        }
                    }
                }
            }
        }
        List<Element> children = node.getChildren();
        String xmlNodo = JDomBak.getXmlText(node);
        for (int i = 0; i < children.size(); i++) {
            Element nodeChild = children.get(i);
            if (findString("clase", xmlNodo.toLowerCase()) > 0) {
                Document dom = getObject(src, JDomBak.getXmlText(nodeChild), "", false);
                node.removeChild(nodeChild.getName());
                node.addContent(i, dom.getRootElement().clone());
            }
        }
        return node;
    }

    private String getString(String xmlPath, String xml, String elementPath) {
        Document document = null;
        // Buscar en el cache si no se paso el texto xml
        if (isNullorEmpty(xml)) {
            document = getFromCache(xmlPath);
        }
        try {
            // Si no se encontro en el cache y no se tiene el texto xml
            if (document == null && isNullorEmpty(xml)) {
                xml = findObject(xmlPath);
                document = JDomBak.loadXml(xml);
                addToCache(xmlPath, document);
            } // Si se tiene el texto xml
            else if (!isNullorEmpty(xml)) {
                document = JDomBak.loadXml(xml);
            }
            if (!isNullorEmpty(elementPath)) {
                document = new Document(JDomBak.selectSingleNode(document, elementPath).clone());
            }
            XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
            return outputter.outputString(document);
        } catch (JDOMException | IOException ex) {
            ErrorManager.showError(ex, LOGGER);
            exception = ex;
        } catch (Exception ex) {
            ErrorManager.showError(ex, LOGGER);
            exception = ex;
        }
        return "";
    }

    private String findObject(String xmlPath) {
        if (Strings.isNullOrEmpty(xmlPath)) {
            return "";
        }
        xmlPath = xmlPath.trim();
        int pos1 = xmlPath.indexOf("//");
        if (pos1 < 0) {
            return "";
        }
        String pathType = left(xmlPath, pos1 - 1).toUpperCase();
        if (isNullorEmpty(pathType)) {
            pathType = Fn.nvl(configParam.get("pathtype").toUpperCase(), "noexiste");
        }
        xmlPath = substr(xmlPath, pos1 + 2);
        String devolver = "";
        if (Fn.inList(pathType, "FILE", "FILE:")) {
            // Ver si no puede ubicar el archivo agregarle el path
            if (!xmlPath.contains("/") && !Fn.isFileExist(xmlPath)) {
                xmlPath = Fn.nvl(configParam.get("path"), "") + xmlPath;
            }
            devolver = fileToString(xmlPath);
        }
        return devolver;
    }

    private Element getFirstElement(Element parent) {
        List<Element> children = parent.getChildren();
        if (children.isEmpty()) {
            return null;
        }
        return children.get(0);
    }

    /**
     * Crea nuevo elemento
     *
     * @param elementName nombre del elemento que se va crear.
     * @param nodePath nodo padre en la que se va crear el elemento
     * @return elemento creado o null en caso contrario.
     */
    public Boolean createElement(String elementName, String nodePath) {
        try {
            Element element = JDomBak.createElement(xmlDom, elementName, nodePath);
            return (element != null);
        } catch (Exception ex) {
            ErrorManager.showError(ex, LOGGER);
            exception = ex;
        }
        return false;
    }

    /**
     * Borra un elemento
     *
     * @param nodePath nodo a borrar (en formato XPath)
     * @return true si se borrado correctamente o false en caso contrario.
     */
    public boolean removeElement(String nodePath) {
        try {
            boolean result = JDomBak.removeElement(xmlDom, nodePath);
            return result;
        } catch (Exception ex) {
            ErrorManager.showError(ex, LOGGER);
            exception = ex;
        }
        return false;
    }

    /**
     * Devuelve el valor del atributo de un nodo
     *
     * @param property nombre del atributo
     * @param nodePath nodo en la que se realizará la búsqueda (en formato
     * XPath)
     * @return valor del atributo o null en caso que no exista.
     */
    public String getPropertyValue(String property, String nodePath) {
        try {
            String attributeValue = JDomBak.getPropertyValue(xmlDom, property, nodePath);
            return attributeValue;
        } catch (Exception ex) {
            ErrorManager.showError(ex, LOGGER);
            exception = ex;
        }
        return null;
    }

    /**
     * Crea o cambia la propiedad de un nodo
     *
     * @param value nuevo valor de la propiedad
     * @param property nombre de la propiedad
     * @param nodePath nodo en la que se realizará la búsqueda (en formato
     * XPath)
     * @return true si se completó la operación con éxito o false en caso
     * contrario.
     */
    public boolean setPropertyValue(String value, String property, String nodePath) {
        try {
            return JDomBak.setPropertyValue(xmlDom, value, property, nodePath);
        } catch (Exception ex) {
            ErrorManager.showError(ex, LOGGER);
            exception = ex;
        }
        return false;
    }

    private void addToCache(String key, Document document) {
        if (!isNullorEmpty(key) && document != null) {
            cache.put(key, document);
        }
    }

    private Document getFromCache(String key) {
        if (isNullorEmpty(key)) {
            return null;
        }
        return cache.get(key);
    }

    /**
     * Devuelve un objeto XMLDOM en formato texto.
     *
     * @return objeto XMLDOM en formato texto formateada.
     */
    @Override
    public String toString() {
        return this.toString(Format.getPrettyFormat());
    }

    /**
     * Devuelve un objeto XMLDOM en formato texto.
     *
     * @param format clave para encontrar el texto XML dentro de la tabla
     * objetos, o	un archivo de texto.
     * @return objeto XMLDOM en formato texto formateada.
     */
    public String toString(Format format) {
        XMLOutputter outputter = new XMLOutputter(format);
        return outputter.outputString(xmlDom);
    }
}
