/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.xml;

import java.io.File;
//import org.jdom.Element;
//import org.jdom.output.Format;
//import org.jdom.output.XMLOutputter;

/**
 *
 * @author alberto
 */
public class Test {
//
//    public static void main(String[] args) {
//    
//            String xml = "<productos>"
//            + "                <producto id='10' activo='true'>"
//            + "                     <nombre>Producto 1</nombre>"
//            + "                     <precio moneda='Gs'>15000</precio>"
//            + "                         <colores>"
//            + "                             <color>Rojo</color>"
//            + "                             <color>Blue</color>"
//            + "                         </colores>"
//            + "                 </producto>"
//            + "                 <producto id='20' activo='true'>"
//            + "                     <nombre>Producto 2</nombre>"
//            + "                     <precio moneda='Gs'>5800</precio>"
//            + "                 </producto>"                    
//            + "           </productos>";
//        XmlDocument oxml = new XmlDocument();
//        //boolean obj = oxml.Configurar(xml, "/productos/producto/colores", true);
//        
//        //File fxml = new File("c:/proyectos/java/JDOM/pruebas/jdom/productos.xml");
//        File fxml = new File("/home/alberto/proyectos/java/JDOM/pruebas/jdom/productos.xml");
//        //boolean obj = oxml.configurar(fxml, "/productos/producto/nombre/xx", true);
//        //boolean obj = oxml.configurar(fxml, "/productos/producto", true);
//        boolean obj = oxml.configurar(fxml, "/productos", true);
//        
//        if(obj) {
//            // Imprime el conenido del xml
//            System.out.println("CONTENIDO DEL XML");
//            System.out.println(oxml.toString(Format.getPrettyFormat()));
//            
//            // Obtiene el valor del atributo id del nodo
//            System.out.println("OBTIENE EL VALOR DE UN ATRIBUTO");
//            System.out.println(oxml.getPropertyValue("id", "/productos/producto"));
//            
//            // Retornar objeto de tipo Element
//            System.out.println("\nRETORNAR OBJETO DE TIPO ELEMENT");
//            Element el = oxml.getElement("/productos/producto");
//            System.out.println(el != null ? new XMLOutputter(Format.getPrettyFormat()).outputString(el): "No encontrado");
//            
//            // Cambiar el valor de la propiedad de un nodo
//            System.out.println("\nANTES DE CAMBIAR PROPIEDAD DEL NODO\n" + oxml.toString());
//            oxml.setProperty("false", "activo", "/productos/producto");
//            System.out.println("DESPUES DE CAMBIAR PROPIEDAD DEL NODO\n" + oxml.toString());
//            
//            // Borrar nodo
//            System.out.println("ANTES DE BORRAR NODO\n" + oxml.toString());
//            oxml.removeElement("/productos/producto");
//            System.out.println("DESPUES DE BORRAR NODO\n" + oxml.toString());
//            
//            
//            // Agregar elemento
//            System.out.println("ANTES DE AGREGAR ELEMENTO\n" + oxml.toString());
//            oxml.createElement("color", "/productos/producto[2]").setAttribute("estilo", "rgb").setText("ROJO");
//            System.out.println("DESPUES DE AGREGAR ELEMENTO\n" + oxml.toString());
//            
//        }
//    }
//
}
