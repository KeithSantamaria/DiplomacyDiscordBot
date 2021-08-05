package backend.svg;

import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author Keith Santamara
 * @version 1
 * 
 * The goal of this class is to handle the building of the images for the game
 */

 public class SvgBuilder {

    private static Element createElement(Document doc, String elementName, HashMap<String, String> attributes){
        
        Element element = doc.createElement(elementName);

        for( String attribute : attributes.keySet() ){
            element.setAttribute(attribute, attributes.get(attribute));
        }

        return element;
    }


    public static void createImage (){

        HashMap<String, String> baseSvg = new HashMap<>();
        HashMap<String, String> redRect = new HashMap<>();

        baseSvg.put( "version" , "1.0");
        baseSvg.put( "encoding", "UTF-8");
        baseSvg.put( "standalone" , "no");
        redRect.put( "width", "100%");
        redRect.put( "height", "100%");
        redRect.put( "fill", "red");


        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder =factory.newDocumentBuilder();
            Document svg = builder.newDocument(); 
            
            Element rootElement = createElement( svg, "svg", baseSvg);
            svg.appendChild(rootElement);

            Element tempRect = createElement( svg, "rect", redRect);
            rootElement.appendChild(tempRect);

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(svg);
            StreamResult result = new StreamResult(new File("test.svg"));
            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }


    }
    
}
