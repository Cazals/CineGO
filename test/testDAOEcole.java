package test;

import java.util.Scanner;

import classes.Ecole;
import dao.DAO;
import dao.bddsql.EcoleDAO;

public class testDAOEcole {

	public static void main(String[] args) {
		
		DAO<Ecole> idDAO = new EcoleDAO();
		Ecole E = new Ecole();
		E=idDAO.find(1);
		
		System.out.println("Ecole :"+E+"\n\nAffichage des classes et eleves: \n----------------------------");
		
		for(int i=0;i<7;i++)
		{
			System.out.println("Classe"+i+":"+E.getListeClasse().get(i));
		}
		
		
		System.out.println("\n\nClasse 0 :"+E.getListeClasse().get(0)+" Enseignant :"+E.getListeClasse().get(0).getClassTeacher());
		for(int i=0;i<3;i++)
		{
			System.out.println("Classe"+i+":"+E.getListeClasse().get(0).getListStudent().get(i));
		}
	}		
}
