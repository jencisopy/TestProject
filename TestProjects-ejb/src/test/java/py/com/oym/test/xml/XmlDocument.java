/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.oym.test.xml;

import py.com.oym.frame.error.ErrorReg;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
//import org.jdom.Document;
//import org.jdom.Element;
//import org.jdom.JDOMException;
//import org.jdom.input.SAXBuilder;
//import org.jdom.output.Format;
//import org.jdom.output.XMLOutputter;
//import org.jdom.xpath.XPath;


/**
 * Su función es devolver un objeto XML (xdom) a partir de una serie de parametros
 * que permite al algoritmo encontrar o establecer el texto xml que se convertirá
 * en el objeto mencionado. El texto XML puede derivar de otros textos, para ello
 * la función utiliza un esquema de clases implementando el paradigma de la orientación
 * a objetos (herencia, encapsulación polimorfismo)
 * @author jenciso
 */
public class XmlDocument {
//    
//    private String xml="";
//    
//    /** En esta propiedad se le asignará el objeto XMLDOM.*/
//    private Document xmlDom;
//    
//    /** Determina si se guardará información desde donde derivó el atributo*/
//    private boolean infpropiedad = false;
//    
//    /** Aqui se almacena el error ocurrido */
//    private ErrorReg Error = new ErrorReg();
//    
//    public XmlDocument() {
//    }
//
//    public boolean isInfpropiedad() {
//        return infpropiedad;
//    }
//
//    public void setInfpropiedad(boolean infpropiedad) {
//        this.infpropiedad = infpropiedad;
//    }
//
//    public ErrorReg getError() {
//        return Error;
//    }
//
//    public void setError(ErrorReg oError) {
//        this.Error = oError;
//    }
//
//    public Document getXmlDom() {
//        return xmlDom;
//    }
//
//    public void setXmlDom(Document XmlDom) {
//        this.xmlDom = XmlDom;
//    }
//
//    public String getXml() {
//        return xml;
//    }
//
//    public void setXml(String xml) {
//        this.xml = xml;
//    }
//
//    /**
//     * Se ejecuta por intrucción explicita del sistema. <br>
//     * Su función es crear el objeto XMLDOM a partir de un objeto DOM dado.
//     * ok
//     * 
//     * @param xmlDom           objeto dentro del cual se buscará el texto
//     * @param elemento         nombre del tag del texto xml
//     * @param noHerencia       Para que no considere las clases derivadas
//     * @return                 Verdadero si tuvo exito en la creación y configuración del objeto XMLDOM
//     *				<br>Falso si no.
//     */
//    public boolean configurar(Document xmlDom, String elemento, boolean noHerencia){
//        try {
//            Element el = null;
//            if("".equals(elemento) || null == elemento || "/".equals(elemento)) {
//                this.xmlDom = xmlDom;
//                el = xmlDom.getRootElement();
//            }
//            else {
//                Element raiz = xmlDom.getRootElement();
//                el = (Element)((Element)XPath.selectSingleNode(raiz, elemento)).clone();
//                this.xmlDom = new Document(el);
//            }
//            String clase = el.getAttributeValue("clase");
//            
//            // Si existe elementos que derivan de clases
//            if((null == clase) || (clase.length() > 0)) {
//                
//            }
//            return true;
//        } catch (JDOMException ex) {
//            System.out.println(ex.getMessage());
//        } catch (ClassCastException ex) {
//            System.out.println(ex.getMessage());
//        } catch (NullPointerException ex) {
//            System.out.println(ex.getMessage());
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//        return false;
//    }
//
//    /**
//     * Se ejecuta por intrucción explicita del sistema. <br>
//     * Su función es crear el objeto XMLDOM a partir de un texto XML dado.
//     * 
//     * @param filepath        texto dentro del cual se buscará el texto
//     * @param elemento         nombre del tag del texto xml
//     * @param noHerencia       Para que no considere las clases derivadas
//     * @return                  Verdadero si tuvo exito en la creación y configuración del objeto XMLDOM
//     *				<br>Falso si no.
//     */
//    public boolean configurar(String filepath, String elemento, boolean noHerencia){
//        SAXBuilder builder = new SAXBuilder();
//        try {
//            Document xmlDoc = builder.build(new StringReader(filepath));
//            return this.configurar(xmlDoc, elemento, noHerencia);
//        } catch (JDOMException ex) {
//            System.out.println(ex.getMessage());
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return false;
//    }
//    /**
//     * Se ejecuta por intrucción explicita del sistema. <br/>
//     * Su función es crear el objeto XMLDOM a partir de un archivo XML dado.
//     * 
//     * @param ubicacion        archivo dentro del cual se buscará el texto
//     * @param elemento         nombre del tag del texto xml
//     * @param noHerencia       Para que no considere las clases derivadas
//     * @return                  Verdadero si tuvo exito en la creación y configuración del objeto XMLDOM
//     *				<br/>Falso si no.
//     */
//    public boolean configurar(File file, String elemento, boolean noHerencia){
//        if(file.exists() && file.isFile() && file.canRead() && file.length() > 0)
//        {
//            BufferedInputStream  f = null;
//            try {
//                byte[] buffer = new byte[(int) file.length()];
//                f = new BufferedInputStream(new FileInputStream(file));
//                f.read(buffer);
//                return this.configurar(new String(buffer), elemento, noHerencia);
//            } catch (FileNotFoundException ex) {
//                System.out.println(ex.getMessage());
//            }
//            catch (IOException ex) {
//                System.out.println(ex.getMessage());
//            } finally {
//                try {
//                    f.close();
//                } catch (IOException ex) {
//                    System.out.println(ex.getMessage());
//                }
//            }
//        }
//        return false;
//    }
//    /**
//     *Su función es<br><br>
//     *	Devolver un objeto XMLDOM a partir de:<br>
//     *	a) Un archivo xml o<br>
//     *	b) Una cadena con formato xml<br>
//     * 
//     * @param cUbicacion        clave para encontrar el texto XML dentro de la tabla objetos, o	un archivo de texto.
//     * @param cXml              cadena dentro del cual se buscará el texto
//     * @param cElemento         nombre del tag del texto xml
//     * @param lNoHerencia       Para que no considere las clases derivadas
//     * @return                  Objeto XMLDOM si tuvo exito y nulo si hubo algún error.
//     */
//    private Document getObject(String ubicacion, String xml, String elemento, boolean noHerencia){
//        return null;
//    }
//
//    private Element heredar(Element xmlNodo, String clase, String src){
//        return null;
//    }
//
//    private Element heredarAtributos(Element xmlNodo, Element xmlNodoClase, String src){
//        return null;
//    }
//
//    private Element heredarNodos(Element xmlNodo, Element xmlNodoClase, String src){
//        return null;
//    }
//    private String getString(String ubicacion, String xml, String elemento){
//        return "";
//    }
//
//    private String findObject(String ubicacion){
//        return "";
//    }
//
//    /**
//     *	Crea nuevo elemento
//     * 
//     * @param elemento         nombre del elemento que se va crear
//     * @param nodoPath         nodo en la que se va crear (en formato XPath)
//     * @return                  elemento creado o null en caso contrario.
//     */
//    public Element createElement(String elemento, String nodoPath){
//        try {
//            Element oElemento = new Element(elemento);
//            Element oNodo = (Element)XPath.selectSingleNode(this.xmlDom, nodoPath);
//            if(oNodo != null) {
//                return this.createElement(oElemento, oNodo);
//            }
//        } catch (JDOMException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return null;
//    }
//
//    /**
//     *	Crea nuevo elemento
//     * 
//     * @param oEl           nombre del elemento que se va crear (de tipo org.jdom.Element)
//     * @param nodoPath      nodo en la que se va crear (en formato XPath)
//     * @return              elemento creado o null en caso contrario.
//     */
//    public Element createElement(Element elemento, String nodoPath) {
//        try {
//            Element oNodo = (Element)XPath.selectSingleNode(this.xmlDom, nodoPath);
//            if(elemento != null && elemento instanceof Element && oNodo != null) {
//                return this.createElement(elemento, oNodo);
//            }
//        } catch (JDOMException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return null;
//    }
//
//    /**
//     *	Crea nuevo elemento
//     * 
//     * @param elemento         nombre del elemento que se va crear (de tipo org.jdom.Element)
//     * @param nodoPath         nodo en la que se va crear (de tipo org.jdom.Element)
//     * @return                  elemento creado o null en caso contrario.
//     */
//    public Element createElement(Element elemento, Element nodoPath) {
//        if(elemento != null && elemento instanceof Element && elemento != null && nodoPath instanceof Element) {
//            nodoPath.addContent(elemento);
//            return elemento;
//        }
//        return null;
//    }
//    
//    /**
//     *	Borra un nodo
//     * 
//     * @param nodoPath         nodo a borrar (en formato XPath)
//     * @return                  true si se borrado correctamente o false en caso contrario.
//     */
//    public boolean removeElement(String nodoPath){
//        try {
//            Element oNodo = (Element)XPath.selectSingleNode(this.xmlDom, nodoPath);
//            return oNodo.getParent().removeContent(oNodo);
//        } catch (JDOMException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return false;
//    }
//    
//    /**
//     *	Devuelve un objeto org.jdom.Element
//     * 
//     * @param nodoPath         nodo a buscar (en formato XPath)
//     * @return                  org.jdom.Element o null en caso que no exista.
//     */
//    public Element getElement(String nodoPath) {
//        try { 
//            Element oNodo = (Element)XPath.selectSingleNode(this.xmlDom, nodoPath);
//            if(oNodo != null && oNodo instanceof Element) {
//                return oNodo;
//            }
//        } catch (JDOMException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return null;
//    }
//
//    /**
//     *	Devuelve el valor del atributo de un nodo
//     * 
//     * @param atributo        nombre del atributo
//     * @param nodoPath         nodo en la que se realizará la búsqueda (en formato XPath)
//     * @return                  valor del atributo o null en caso que no exista.
//     */
//    public String getPropertyValue(String atributo, String nodoPath) {
//        try {   
//            Element nodo = (Element)XPath.selectSingleNode(this.xmlDom, nodoPath);
//            if(nodo != null && nodo instanceof Element) {
//                return this.getPropertyValue(atributo, nodo);
//            }
//        } catch (JDOMException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return null;
//    }
//    
//    /**
//     *	Devuelve el valor del atributo de un nodo
//     * 
//     * @param atributo        nombre del atributo
//     * @param nodoPath        nodo en la que se realizará la búsqueda (de org.jdom.Element)
//     * @return                valor del atributo o null en caso que no exista.
//     */
//    public String getPropertyValue(String atributo, Element nodoPath) {
//        if(nodoPath != null && nodoPath instanceof Element) {
//            return nodoPath.getAttributeValue(atributo);
//        }
//        return null;
//    }
//    
//    /**
//     *	Crea o cambia la propiedad de un nodo
//     * 
//     * @param valor       nuevo valor de la propiedad
//     * @param atributo    nombre de la propiedad
//     * @param nodoPath    nodo en la que se realizará la búsqueda (en formato XPath)
//     * @return            true si se completó la operación con éxito o false en caso contrario.
//     */
//    public boolean setProperty(String valor, String atributo, String nodoPath){
//        try {   
//            Element oNodo = (Element)XPath.selectSingleNode(this.xmlDom, nodoPath);
//            return this.setProperty(valor, atributo, oNodo);
//        } catch (JDOMException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return false;
//    }
//
//    /**
//     *	Crea o cambia la propiedad de un nodo
//     * 
//     * @param valor       nuevo valor de la propiedad
//     * @param atributo    nombre de la propiedad
//     * @param nodoPath    Objeto de tipo org.jdom.Element en la que se realizará la búsqueda
//     * @return            true si se completó la operación con éxito o false en caso contrario.
//     */
//    public boolean setProperty(String valor, String atributo, Element nodoPath){
//        if(nodoPath != null && nodoPath instanceof Element) {
//            nodoPath.setAttribute(atributo, valor);
//            return true;
//        }
//        return false;
//    }
//    /**
//     *	Devuelve un objeto XMLDOM en formato texto.
//     * 
//     * @return      objeto XMLDOM en formato texto formateada.
//     */
//    @Override
//    public String toString() {
//        return this.toString(Format.getPrettyFormat());
//    }
//    /**
//     *	Devuelve un objeto XMLDOM en formato texto.
//     * 
//     * @param format        clave para encontrar el texto XML dentro de la tabla objetos, o	un archivo de texto.
//     * @return              objeto XMLDOM en formato texto formateada.
//     */    
//    public String toString(Format format) {
//        XMLOutputter outputter = new XMLOutputter(format);
//        return outputter.outputString(xmlDom);
//    }
}
