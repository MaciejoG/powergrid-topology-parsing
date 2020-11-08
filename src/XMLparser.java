
import java.io.File;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


public class XMLparser {
		
    // METHODS
	
	public static String extractAttribute (Node node, String attribute){
		/// extracts an attribute value (as a string) of a given node
		Element element = (Element) node;
		return element.getAttribute(attribute);
		}
	
	public static String extractElement (Node node, String elementName){
		/// extracts an element content (as a string) of a given node
		Element element = (Element) node;
		return element.getElementsByTagName(elementName).item(0).getTextContent();
		}
	
	public static Node findElement (Node node, String elementName){
		/// extracts an element (itself, not its content!) of a given node
		Element element = (Element) node;
		return element.getElementsByTagName(elementName).item(0);
		}
	
	
	public static String[][] extractInformation (Document doc,String searchedObject,String[] attributesArray,String[] elementsArray,String[] childNodesArray){
			/// extracts all attributes, child nodes' attributes and nodes' values the user specifies, returns an array of found information
		
			NodeList searchedElementList = doc.getElementsByTagName(searchedObject);
			// initialize an array of results
			String[][] results = new String[searchedElementList.getLength()][attributesArray.length+elementsArray.length+childNodesArray.length];
			/*String[] foundAttributes = new String[attributesArray.length];
			String[] foundElements = new String[elementsArray.length];
			String[] foundChildNodesAttributes = new String[childNodesArray.length];*/
			
			for (int i = 0; i < searchedElementList.getLength(); i++) {
				
				for (int a = 0; a < attributesArray.length; a++) {
					/*foundAttributes[a] = extractAttribute(searchedElementList.item(i),attributesArray[a]);
					results[i][a] = foundAttributes[a];*/
					results[i][a] = extractAttribute(searchedElementList.item(i),attributesArray[a]);
				}
				
				for (int b = 0; b < elementsArray.length; b++) {
					/*foundElements[b] = extractElement(searchedElementList.item(i),elementsArray[b]);
					results[i][attributesArray.length+b] = foundElements[b];*/
					results[i][attributesArray.length+b] = extractElement(searchedElementList.item(i),elementsArray[b]);
				}
				
				for (int c = 0; c < childNodesArray.length; c++) {
					/*foundChildNodesAttributes[c] = extractAttribute(findElement(searchedElementList.item(i),childNodesArray[c]),"rdf:resource");
					results[i][attributesArray.length+elementsArray.length+c] = foundChildNodesAttributes[c];*/
					results[i][attributesArray.length+elementsArray.length+c] = extractAttribute(findElement(searchedElementList.item(i),childNodesArray[c]),"rdf:resource");
				}
				
				/*System.out.println("Found attributes: " + Arrays.toString(foundAttributes));
				System.out.println("Found elements: " + Arrays.toString(foundElements));
				System.out.println("Found child attributes: " + Arrays.toString(foundChildNodesAttributes) + "\n");
				System.out.println("Results array: " + Arrays.toString(results[i]) + "\n");*/
				
			} // end of for (the main one)

			return results;
		
		} // end of extractInformation
	
	public static Document buildDocument (String fileName){
		/// builds a document out of an XML file
		Document doc = null;
		
		try {
			
			File XmlFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(XmlFile);	 
			doc.getDocumentElement().normalize();
									
			} // end of try
		
		catch(Exception e){
			e.printStackTrace();
			} // end of catch
				
		return doc;
		
		} // end of buildDocument

} // end of class XMLPArser
	

