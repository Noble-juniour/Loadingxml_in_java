
package loadingxml4;

import java.io.IOException;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Loadingxml4 {

    public static void main(String[] args) throws IOException{
        Document dom;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        try{
        DocumentBuilder builder = factory.newDocumentBuilder();
        dom = builder.parse("build.xml");
        printxml(dom);
            
        }
        catch(ParserConfigurationException pce){
            System.out.println(pce.getMessage());
        }
        catch(SAXException se)
        {
            System.out.println(se.getMessage());
        }
        catch(IOException ioe)
        {
            System.err.println(ioe.getMessage());
        }

    }
    
    public static void printxml(Document xml)
    {
        try{
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        StreamResult result = new StreamResult(new StringWriter());
        DOMSource source    = new DOMSource(xml);
        transformer.transform(source , result);
            System.out.println(result.getWriter().toString());
        }
        catch(TransformerConfigurationException e)
        {
            System.err.println("1");
        }
        catch(TransformerException e)
        {
            System.err.println("1");
        }
        }
    
}
