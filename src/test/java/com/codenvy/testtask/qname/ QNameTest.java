package com.codenvy.testtask.qname;

import static org.junit.Assert.*;
import org.junit.Test;

/** 
* JUnit test.
* @version		1.1     07 July 2014
* @author 		Vinokur Igor
*/
public class QNameTest {
    
    /**
    * Method tests Qname class by parsing correct names.
    */
    @Test
    public void checkCorrectQNames() {
        String [] illegalQNames = new String []{"prefix:name", "prefix:na me"
                                            , "name", "n", "p:n", "n-:-"};

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < illegalQNames.length; i++) {
            try{
                Parser.parse(illegalQNames[i]);
            }catch(IllegalNameException e){
                sb.append("\nException not expected in: "+illegalQNames[i]+"\"");
            }
        }
        if (sb.length() > 0) {
            fail(sb.toString());
        }
    }                
    
    /** 
     * Method tests Qname class by throwing IllegalNameException
     * while parsing incorrect names.
     */
    @Test
    public void checkIllegalQNames() {
        
        String [] illegalQNames = new String []{"",":name",".","..","prefix:",
            " name"," prefix:name","prefix: name","prefix:name ",
            "pre fix:name","name/name","name[name","prefix:name:name"};

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < illegalQNames.length; i++) {
            try{
                Parser.parse(illegalQNames[i]);
                sb.append("Exception expected in: "+illegalQNames[i]);
            }catch(IllegalNameException e){}
        }
        if (sb.length() > 0) {
            fail(sb.toString());
        }
    }

}
