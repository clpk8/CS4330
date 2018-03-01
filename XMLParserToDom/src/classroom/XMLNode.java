/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classroom;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Ben
 */
public class XMLNode {
    String name;
    String content;
    HashMap<String, ArrayList<XMLNode>> properties;
    HashMap<String, String> attributes;
    
    XMLNode(){
        content = new String();
        name = new String();
        properties = new HashMap();
        attributes = new HashMap();
        
    }
}
