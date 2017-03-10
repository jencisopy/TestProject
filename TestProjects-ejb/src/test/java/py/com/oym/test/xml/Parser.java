/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.oym.test.xml;
import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;  

/**
 *
 * @author jenciso
 */
public class Parser {
    private static DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    // Parses an XML file and returns a DOM document.
    // If validating is true, the contents is validated against the DTD
    // specified in the file.
    public static Document parseXmlFile(String filename, boolean validating) {
        try {
            factory.setValidating(validating);
            // Create the builder and parse the file
            Document doc = factory.newDocumentBuilder().parse(new File(filename));
            return doc;
        }
        catch (SAXException e) {
            // A parsing error occurred; the xml input is not valid
        }
        catch (ParserConfigurationException e) {
        }
        catch (IOException e) {
        }
        return null;
    }
}
