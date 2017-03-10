/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.xml;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import py.com.oym.frame.error.ErrorManager;
import org.apache.log4j.Logger;
import org.jdom2.Element;
import org.jdom2.filter.Filters;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;

/**
 *
 * @author Jorge Enciso
 */
public class JDomBak {
    private static final Logger LOGGER = Logger.getLogger(JDomBak.class);

    /**
     * Crea y devuelve un documento DOM
     *
     * @param xml texto xml a procesar
     * @return elemento creado o null en caso contrario.
     * @throws org.jdom2.JDOMException
     * @throws java.io.IOException
     */
    public static Document loadXml(String xml) throws JDOMException, IOException {
        SAXBuilder builder = new SAXBuilder();
        Document xmlDocument = builder.build(new StringReader(xml));
        return xmlDocument;
    }

    /**
     * Crea y devuelve un documento DOM
     *
     * @param file archivo a procesar.
     * @return elemento creado o null en caso contrario.
     * @throws org.jdom2.JDOMException
     */
    public static Document loadXml(File file) throws JDOMException {
        if (file.exists() && file.isFile() && file.canRead() && file.length() > 0) {
            BufferedInputStream f = null;
            try {
                byte[] buffer = new byte[(int) file.length()];
                f = new BufferedInputStream(new FileInputStream(file));
                f.read(buffer);
                return loadXml(new String(buffer));
            } catch (FileNotFoundException ex) {
                ErrorManager.showError(ex, LOGGER);
            } catch (IOException ex) {
                ErrorManager.showError(ex, LOGGER);
            } finally {
                try {
                    f.close();
                } catch (IOException ex) {
                    ErrorManager.showError(ex, LOGGER);
                }
            }
        }
        return null;
    }

    /**
     * Crea nuevo elemento
     *
     * @param xmlDom DOM donde se creara el elemento.
     * @param elementName nombre del elemento que se va crear.
     * @param nodePath nodo padre en la que se va crear el elemento
     * @return elemento creado o null en caso contrario.
     * @throws java.lang.Exception
     */
    public static Element createElement(Document xmlDom, String elementName, String nodePath) throws Exception {
        Element element = new Element(elementName);
        Element node = selectSingleNode(xmlDom, nodePath);
        if (node != null) {
            return createElement(element, node);
        }
        return null;
    }

    /**
     * Crea nuevo elemento
     *
     * @param xmlDom DOM donde se creara el elemento.
     * @param element nombre del elemento que se va crear (de tipo
     * org.jdom.Element)
     * @param nodePath nodo en la que se va crear (en formato XPath)
     * @return elemento creado o null en caso contrario.
     * @throws java.lang.Exception
     */
    public static Element createElement(Document xmlDom, Element element, String nodePath) throws Exception {
        Element node = selectSingleNode(xmlDom, nodePath);
        if (element != null && element instanceof Element && node != null) {
            return createElement(element, node);
        }
        return null;
    }

    /**
     * Crea nuevo elemento
     *
     * @param element elemento que se va crear (de tipo org.jdom.Element)
     * @param node nodo en la que se va crear (de tipo org.jdom.Element)
     * @return elemento creado o null en caso contrario.
     */
    public static Element createElement(Element element, Element node) {
        if (element != null && element instanceof Element && node instanceof Element) {
            node.addContent(element);
            return element;
        }
        return null;
    }

    /**
     * Borra un elemento
     *
     * @param xmlDom objeto DOM
     * @param nodePath nodo a borrar (en formato XPath)
     * @return true si se borrado correctamente o false en caso contrario.
     * @throws java.lang.Exception
     */
    public static boolean removeElement(Document xmlDom, String nodePath) throws Exception {
        Element node = selectSingleNode(xmlDom, nodePath);
        if (node == null) {
            return false;
        }
        return node.getParent().removeContent(node);
    }

    /**
     * Borra un elemento
     *
     * @param xmlDom objeto DOM
     * @param nodePath nodo a borrar (en formato XPath)
     * @return true si se borrado correctamente o false en caso contrario.
     * @throws java.lang.Exception
     */
    public static Element getElement(Document xmlDom, String nodePath) throws Exception {
        Element node = selectSingleNode(xmlDom, nodePath);
        if (node != null && node instanceof Element) {
            return node;
        }
        return null;
    }

    /**
     * Devuelve el valor del atributo de un nodo
     *
     * @param xmlDom
     * @param property nombre del atributo
     * @param nodePath nodo en la que se realizará la búsqueda (en formato XPath)
     * @return valor del atributo o null en caso que no exista.
     * @throws java.lang.Exception
     */
    public static String getPropertyValue(Document xmlDom, String property, String nodePath) throws Exception {
        Element node = selectSingleNode(xmlDom, nodePath);
        if (node != null) {
            return JDomBak.getPropertyValue(property, node);
        }
        return null;
    }

    /**
     * Devuelve el valor del atributo de un nodo
     *
     * @param attribute nombre del atributo
     * @param node nodo en la que se realizará la búsqueda (de org.jdom.Element)
     * @return valor del atributo o null en caso que no exista.
     */
    public static String getPropertyValue(String attribute, Element node) {
        if (node != null) {
            return node.getAttributeValue(attribute);
        }
        return null;
    }

    /**
     * Crea o cambia la propiedad de un nodo
     *
     * @param xmlDom
     * @param value nuevo valor de la propiedad
     * @param property nombre de la propiedad
     * @param nodePath nodo en la que se realizará la búsqueda (en formato XPath)
     * @return true si se completó la operación con éxito o false en caso
     * contrario.
     * @throws java.lang.Exception
     */
    public static boolean setPropertyValue(Document xmlDom, String value, String property, String nodePath) throws Exception {
        Element node = selectSingleNode(xmlDom, nodePath);
        if (node == null) {
            return false;
        }
        return JDomBak.setPropertyValue(value, property, node);
    }

    /**
     * Crea o cambia la propiedad de un nodo
     *
     * @param value nuevo valor de la propiedad
     * @param property nombre de la propiedad
     * @param node Objeto de tipo org.jdom.Element en la que se realizará la
     * búsqueda
     * @return true si se completó la operación con éxito o false en caso
     * contrario.
     */
    public static boolean setPropertyValue(String value, String property, Element node) {
        if (node != null) {
            node.setAttribute(property, value);
            return true;
        }
        return false;
    }

    public static Element selectSingleNode(Document document, String nodePath) throws Exception {
        XPathExpression<Element> xpath;
        if (!nodePath.startsWith("/")){
            nodePath = "//"+nodePath;
        }
        xpath = XPathFactory.instance().compile(nodePath, Filters.element());
        Element emt = xpath.evaluateFirst(document);
        return emt;
    }

    public static List<Element> selectNodes(Document document, String nodePath) throws Exception {
        XPathExpression<Element> xpath;
        if (!nodePath.startsWith("/")){
            nodePath = "//"+nodePath;
        }
        xpath = XPathFactory.instance().compile(nodePath, Filters.element());
        List<Element> elements = xpath.evaluate(document);
        return elements;
    }
    
    public static String getXmlText(Element content){
        XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
        return outputter.outputString(content);
    }
    
    public static String getXmlText(Document content){
        XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
        return outputter.outputString(content);
    }
}
