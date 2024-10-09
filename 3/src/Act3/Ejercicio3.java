package Act3;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



public class Ejercicio3 {
	public static void main(String[] args) throws XPathExpressionException{	
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();	
		factory.setValidating(true);
		factory.setIgnoringElementContentWhitespace(true);
		
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			File file = new File("tema3_3.xml");
			Document doc = (Document) builder.parse(file);
			doc.getDocumentElement().normalize();
			
			XPath xPath = XPathFactory.newInstance().newXPath();
			String expression = "/class/student";
			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);
			
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node nNode = nodeList.item(i);
				System.out.println("\nCurrent Element:" + nNode.getNodeName());
				Element eElement = (Element) nNode;
				System.out.println("Student roll no: " + eElement.getAttributes());
				
				System.out.println("First Name: " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		
	}

}
