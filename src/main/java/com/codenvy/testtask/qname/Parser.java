package com.codenvy.testtask.qname;

/**
 * Parser class is used to parse string names
 * and create instance of QName class.
 * 
 * @version		1.1     07 July 2014
 * @author 		Vinokur Igor
 */
public class Parser {

    /**
     * Main Method to parse name.
     */
    public static void main(String args[]){
        try{
            QName qn = parse("prefix:name");
            System.out.println(qn.getAsString());
        }catch(IllegalNameException e){
            System.out.print("invailed data!");
        }
    }
    
    /**
     * Method that creates QName class instance.
     */	    
    public static QName parse(String name) throws IllegalNameException {
        return new QName(name);
    }
    
}
