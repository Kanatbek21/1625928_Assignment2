//imported files
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class XML_Reader 
{
	private static Document doc;
	
	//class for reading the xml file
	public static Document Reader(String filename) {
		try {
			//get the xml file path
			File inputFile = new File(filename);
			// Defines a factory API that enables applications to obtain a parser that produces DOM object trees from XML documents
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			// Protected constructor to prevent instantiation
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(inputFile);
			
			doc.getDocumentElement().normalize();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doc;
	}
}