package xmltest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.events.Comment;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class xmlReadAndWrite {
	
	

	public boolean readXML() {
		
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    	
        try {
            /*
             * Etape 2 : cr�ation d'un parseur
             */
            final DocumentBuilder builder = factory.newDocumentBuilder();
			
		    /*
		     * Etape 3 : cr�ation d'un Document
		     */
		    final Document document= builder.parse(new File("PlansSalle.xml"));
		    
		    
		    final Element racine = document.getDocumentElement();
		    
		    System.out.println("\n*************RACINE************");
		    System.out.println(racine.getNodeName());
		    
	            
            final NodeList cinemaNoeuds = racine.getChildNodes();
            final int nbCinemaNoeuds = cinemaNoeuds.getLength();
            
            
            
            for (int i = 0; i<nbCinemaNoeuds; i++) {
    	        if(cinemaNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
    	            final Element Cinema = (Element) cinemaNoeuds.item(i);
//    	            final Element idCinema = (Element) Cinema.getElementsByTagName("idCinema").item(0);
    	            
//    	            System.out.println("idCinema: " + idCinema.getTextContent());
    	            System.out.println("idCinema: " + Cinema.getAttribute("idCinema"));
    	      
    	            
    	            final NodeList Salles = Cinema.getElementsByTagName("Salle");
        		    final int nbSalleElements = Salles.getLength();
        		    
    	            for(int j = 0; j<nbSalleElements; j++) {
    	            	
        		        final Element Salle = (Element) Salles.item(j);
        		        System.out.println("numSalle: " + Salle.getAttribute("numSalle"));
        		        System.out.println("nomSalle: " + Salle.getAttribute("nomSalle"));
        

        		        final NodeList Sieges= Salle.getElementsByTagName("Siege");
        		        final int nbSiegesElements = Sieges.getLength();
        		        
        	            for(int k = 0; k<nbSiegesElements; k++) {
        	            	final Element Siege = (Element) Sieges.item(k);
        	            	System.out.println("nomTypeSiege: " + Siege.getAttribute("nomTypeSiege"));
        	            	System.out.println("x: " + Siege.getAttribute("x"));
        	            	System.out.println("y: " + Siege.getAttribute("y"));
        	            	
        	            }
     
        		    }
    	            
    	            
            return true;
    	    }
            
            } 
        }catch (ParserConfigurationException pce) {
        	System.out.println(pce.getMessage());
        } catch (SAXException se) {
            System.out.println(se.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }

        return false;
    
    }
	
	
//	public void saveToXML(String xml) {
//	/*
//	 * Etape 1 : r�cup�ration d'une instance de la classe "DocumentBuilderFactory"
//	 */
//	final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//		
//	try {
//	    /*
//	     * Etape 2 : cr�ation d'un parseur
//	     */
//	    final DocumentBuilder builder = factory.newDocumentBuilder();
//	    		
//	    /*
//	     * Etape 3 : cr�ation d'un Document
//	     */
//	    final Document document= builder.newDocument();
//					
//	    /*
//	     * Etape 4 : cr�ation de l'Element racine
//	     */
//	    final Element racine = document.createElement("CineGo");
//	    document.appendChild(racine);			
//			
//	    /*
//	     * Etape 5 : cr�ation d'une personne
//	     */
//	    final Comment commentaire = document.createComment("John DOE");
//	    racine.appendChild(commentaire);
//			
//	    final Element personne = document.createElement("personne");
//	    personne.setAttribute("sexe", "masculin");
//	    racine.appendChild(personne);
//			
//	    /*
//	     * Etape 6 : cr�ation du nom et du pr�nom
//	     */
//	    final Element nom = document.createElement("nom");
//	    nom.appendChild(document.createTextNode("DOE"));
//			
//	    final Element prenom = document.createElement("prenom");
//	    prenom.appendChild(document.createTextNode("John"));
//			
//	    personne.appendChild(nom);
//	    personne.appendChild(prenom);			
//							
//	    /*
//	     * Etape 7 : r�cup�ration des num�ros de t�l�phone
//	     */
//	    final Element telephones = document.createElement("telephones");
//	    
//	    final Element fixe = document.createElement("telephone");
//	    fixe.appendChild(document.createTextNode("01 02 03 04 05"));
//	    fixe.setAttribute("type", "fixe");
//			
//	    final Element portable = document.createElement("telephone");
//	    portable.appendChild(document.createTextNode("06 07 08 09 10"));
//	    portable.setAttribute("type", "portable");
//			
//	    telephones.appendChild(fixe);
//	    telephones.appendChild(portable);
//	    personne.appendChild(telephones);
//			
//	    /*
//	     * Etape 8 : affichage
//	     */
//	    final TransformerFactory transformerFactory = TransformerFactory.newInstance();
//	    final Transformer transformer = transformerFactory.newTransformer();
//	    final DOMSource source = new DOMSource(document);
//	    final StreamResult sortie = new StreamResult(new File("F:\\file.xml"));
//	    //final StreamResult result = new StreamResult(System.out);
//			
//	    //prologue
//	    transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
//	    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
//	    transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");			
//	    		
//	    //formatage
//	    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//	    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
//			
//	    //sortie
//	    transformer.transform(source, sortie);	
//	}
//	catch (final ParserConfigurationException e) {
//	    e.printStackTrace();
//	}
//	catch (TransformerConfigurationException e) {
//	    e.printStackTrace();
//	}
//	catch (TransformerException e) {
//	    e.printStackTrace();
//	}			
//	}
//	    

	
}