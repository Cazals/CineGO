/**
 * 
 */
package xmltest;
import java.util.ArrayList;

import xmltest.xmlReadAndWrite; 

/**
 * @author thoma
 *
 */
public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		
//		ArrayList<String> valeurs = new ArrayList<String>();
//		
//		xmlReadAndWrite xmltest = new xmlReadAndWrite();
//		xmltest.readXML("bob.xml");
//		valeurs=xmltest.getRolev();
//		
//		for(String val : valeurs) {
//		    
//		    System.out.println(val);
//		}
		xmlReadAndWrite xmltest = new xmlReadAndWrite();
    	xmltest.readXML();

	}
}