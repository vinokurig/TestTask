package com.codenvy.testtask.qname;

import java.util.regex.Pattern;

/**
 * QName class that contains the local name, 
 * and may contain the prefix.
 * 
 * @version		1.1     07 July 2014
 * @author 		Vinokur Igor
 */
public class QName {
    private String name;
    
    private String oneCharSimpleName  = "[^\\u002E\\u002F\\u003A\\u005B\\u005D"
            + "\\u002A\\u0027\\u0022\\u007C\\s]";  
    private String nonSpace  = "[^\\u002F\\u003A\\u005B\\u005D\\u002A\\u0027"
            + "\\u0022\\u007C\\s]";
    private String threeOrMoreCharName = nonSpace+"["+nonSpace+" ]+"+nonSpace;
    private String simpleName = oneCharSimpleName +"|\\."+oneCharSimpleName 
            +"|"+oneCharSimpleName +"\\.|"+oneCharSimpleName+oneCharSimpleName
            +"|"+threeOrMoreCharName;        
    private String nameStartChar = "[A-Za-z\\u005F\\u00C0-\\u00D6"
            + "\\u00D8-\\u00F6\\u00F8-\\u02FF\\u0370-\\u037D\\u037F-\\u1FFF"
            + "\\u200C-\\u200D\\u2070-\\u218F\\u2C00-\\u2FEF\\u3001-\\uD7FF"
            + "\\uF900-\\uFDCF\\uFDF0-\\uFFFD]";
    private String nameChar = nameStartChar+"|[0-9\\u002D\\u002E\\u00B7"
            + "\\u0300-\\u036F\\u203F-\\u2040]";
    private String prefix = nameStartChar+"("+nameChar+")*";
    private String localName = "("+nonSpace +"|"+nonSpace+nonSpace
            +"|"+threeOrMoreCharName+")";   
    
    private String regularExpression = simpleName+"|"+prefix+":"+localName;
    
    /** 
    * Constructor for QName
    * @param name
    */
    public QName(String name) throws IllegalNameException{
	this.name = name;
        if (Pattern.matches(regularExpression, name)){
        }        
        else{
            throw new IllegalNameException();
        }
    }

    /** 
     * Method that returns prefix.
     */
    public String getPrefix(){     
        if (name.contains(":")){
            return name.substring(0, name.indexOf(":"));
        }        
        else{
            System.out.println("The entered name is a Simple Name, there is no Prefix!");
            return "";
        }
    }
	
    /** 
    * Method that returns local name.
    */
    public String getLocalName(){        
        if (name.contains(":")){
            return name.substring(name.indexOf(":")+1);
        }        
        else{
            return name;
        }
    }
    
    /** 
    * Method that returns full name.
    */
    public String getAsString(){                
        if(name.contains(":")){
            return this.getPrefix() + ":" + this.getLocalName();
        }else{
            return this.getLocalName();
        }
    }

}
