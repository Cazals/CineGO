package test;

import java.util.ArrayList;

import classes.PositionCase;
import dao.DAO;
import dao.DAOFactory;

public class testDAOPositionCase {
	
	public static void main(String[] args) {
		
		DAO<PositionCase> PositionCaseDAO = DAOFactory.getPositionCaseDAO();
		ArrayList<PositionCase> addss=new ArrayList<PositionCase>();
		System.out.println("\n Avant cr�ation d'un nouveau langage :");
		
		
		for(int i = 1; i <5; i++)
		{
			System.out.println(PositionCaseDAO.find(i).toString());
			
			if(PositionCaseDAO.find(i).getId() != 0)
			addss.add(PositionCaseDAO.find(i));
		}
		
		
		
		//*
		PositionCase ad = new PositionCase();
		ad.setPosX(25);
		ad.setPosY(20);
	
		
		ad = PositionCaseDAO.create(ad);
		//*/
		System.out.println("\n Apr�s cr�ation d'un nouveau langage :");
		for(int i = 1; i < 5; i++)
		System.out.println(PositionCaseDAO.find(i).toString());
		
		
		
		
		System.out.println("\n Apr�s mise � jour de l'objet langage :");
		for(int i = 1; i < 5; i++)
		System.out.println(PositionCaseDAO.find(i).toString());
		
		PositionCaseDAO.delete(ad);
		System.out.println("\n Apr�s suppression l'objet langage :");
		for(int i = 1; i < 5; i++)
		System.out.println(PositionCaseDAO.find(i).toString());
		
		
		System.out.println("Nonononono nonnononononon");
		for(PositionCase b:addss)
		{
			System.out.println(b.toString());
		}
	}

}
