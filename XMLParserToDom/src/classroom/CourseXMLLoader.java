/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classroom;

import java.io.File;
import java.util.ArrayList;
import java.util.Stack;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


/**
 *
 * @author dale
 * modified by Ben
 * http://www.saxproject.org/apidoc/org/xml/sax/helpers/DefaultHandler.html
 * https://docs.oracle.com/javase/8/docs/api/org/xml/sax/SAXException.html#SAXException--
 */
public class CourseXMLLoader {
    static XMLNode root;
    static Stack<XMLNode> stack;
    static XMLNode currentNode;
    
    
    public static Course load(File xmlCourseFile) throws Exception {
        Course course = new Course();
        stack = new Stack<>();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            
            DefaultHandler handler = new DefaultHandler() {
   
                
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                 
                    XMLNode node = new XMLNode();
                    node.name = qName;
                    int n = attributes.getLength();
                    for(int i = 0; i < n; i++){
                        node.attributes.put(attributes.getQName(i), attributes.getValue(i));
                        
                    }
                    stack.push(node);
                    if(currentNode == null){
                        currentNode = new XMLNode();
    
                    }
                    if(currentNode.properties.get(qName) != null){
                        currentNode.properties.get(qName).add(node);
                    }
                    else{
                        ArrayList temp = new ArrayList();
                        temp.add(node);
                        currentNode.properties.put(qName, temp);
                    }
                    
                    currentNode = node;
                }
                
                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    
                    XMLNode p = stack.pop();
                    p.content = p.content.trim();
                    if(stack.isEmpty()){
                        root = p;
                        currentNode = null;
                    }
                    else{
                        currentNode = stack.lastElement();
                    }
                }
                
                @Override
                public void characters(char ch[], int start, int length) throws SAXException {
                    String string = new String(ch, start, length);
                    currentNode.content += string;
                }
            };
            
            saxParser.parse(xmlCourseFile.getAbsoluteFile(), handler);
            
        } catch (Exception e) {
            throw e;
        }
        
      return course; 
    }
}
