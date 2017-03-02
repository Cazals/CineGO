package xmltest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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
             * Etape 2 : création d'un parseur
             */
            final DocumentBuilder builder = factory.newDocumentBuilder();
			
		    /*
		     * Etape 3 : création d'un Document
		     */
		    final Document document= builder.parse(new File("PlansSalle.xml"));
		    
		    
		    final Element racine = document.getDocumentElement();
		    
		    System.out.println("\n*************RACINE************");
		    System.out.println(racine.getNodeName());
		    
//		    for (int i = 0; i<nbRacineNoeuds; i++) {
//		        if(racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
//		            final Element personne = (Element) racineNoeuds.item(i);
//					
//			    //Affichage d'une personne
//			    System.out.println("\n*************PERSONNE************");
//			    System.out.println("sexe : " + personne.getAttribute("sexe"));
//		    
		    
	            
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
        		        final Element numSalle = (Element) Salle.getElementsByTagName("numSalle").item(0);
        		        final Element nomSalle = (Element) Salle.getElementsByTagName("nomSalle").item(0);
        		        
        		        
        		        
        		        
        	            System.out.println("numSalle: " + numSalle.getTextContent());
        	            System.out.println("nomSalle: " + nomSalle.getTextContent());
        	            
        	           


        		        final NodeList Sieges= Salle.getElementsByTagName("Siege");
        		        final int nbSiegesElements = Sieges.getLength();
        		        
        	            for(int k = 0; k<nbSiegesElements; k++) {
        	            	final Element Siege = (Element) Sieges.item(k);
        	            	final Element nomTypeSiege = (Element) Siege.getElementsByTagName("nomTypeSiege").item(0);
            		        final Element x = (Element) Siege.getElementsByTagName("x").item(0);
            		        final Element y = (Element) Siege.getElementsByTagName("y").item(0);
            		        
            		        
            	            System.out.println("nomTypeSiege: " + nomTypeSiege.getTextContent());
            	            System.out.println("x: " + x.getTextContent());
            	            System.out.println("y: " + y.getTextContent());
            	            
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
	
	
	public void saveToXML(String xml) {
	/*
	 * Etape 1 : récupération d'une instance de la classe "DocumentBuilderFactory"
	 */
	final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
	try {
	    /*
	     * Etape 2 : création d'un parseur
	     */
	    final DocumentBuilder builder = factory.newDocumentBuilder();
	    		
	    /*
	     * Etape 3 : création d'un Document
	     */
	    final Document document= builder.newDocument();
					
	    /*
	     * Etape 4 : création de l'Element racine
	     */
	    final Element racine = document.createElement("CineGo");
	    document.appendChild(racine);			
			
	    /*
	     * Etape 5 : création d'une personne
	     */
	    final Comment commentaire = document.createComment("John DOE");
	    racine.appendChild(commentaire);
			
	    final Element personne = document.createElement("personne");
	    personne.setAttribute("sexe", "masculin");
	    racine.appendChild(personne);
			
	    /*
	     * Etape 6 : création du nom et du prénom
	     */
	    final Element nom = document.createElement("nom");
	    nom.appendChild(document.createTextNode("DOE"));
			
	    final Element prenom = document.createElement("prenom");
	    prenom.appendChild(document.createTextNode("John"));
			
	    personne.appendChild(nom);
	    personne.appendChild(prenom);			
							
	    /*
	     * Etape 7 : récupération des numéros de téléphone
	     */
	    final Element telephones = document.createElement("telephones");
	    
	    final Element fixe = document.createElement("telephone");
	    fixe.appendChild(document.createTextNode("01 02 03 04 05"));
	    fixe.setAttribute("type", "fixe");
			
	    final Element portable = document.createElement("telephone");
	    portable.appendChild(document.createTextNode("06 07 08 09 10"));
	    portable.setAttribute("type", "portable");
			
	    telephones.appendChild(fixe);
	    telephones.appendChild(portable);
	    personne.appendChild(telephones);
			
	    /*
	     * Etape 8 : affichage
	     */
	    final TransformerFactory transformerFactory = TransformerFactory.newInstance();
	    final Transformer transformer = transformerFactory.newTransformer();
	    final DOMSource source = new DOMSource(document);
	    final StreamResult sortie = new StreamResult(new File("F:\\file.xml"));
	    //final StreamResult result = new StreamResult(System.out);
			
	    //prologue
	    transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
	    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	    transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");			
	    		
	    //formatage
	    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			
	    //sortie
	    transformer.transform(source, sortie);	
	}
	catch (final ParserConfigurationException e) {
	    e.printStackTrace();
	}
	catch (TransformerConfigurationException e) {
	    e.printStackTrace();
	}
	catch (TransformerException e) {
	    e.printStackTrace();
	}			
	}
	    

	
}