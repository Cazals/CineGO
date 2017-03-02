/**
 * 
 */
package dao.bddsql;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classes.CaseSalle;
import connection.Connection;
import dao.DAO;
import dao.DAOFactory;

/**
 * @author thomas
 *
 */
public class CaseSalleDAO extends DAO<CaseSalle> {
	
	@Override
	public CaseSalle find(int id) {
		
		CaseSalle case_find = new CaseSalle();
		String nomm=null,pren=null;
		char sex='\0';
		String temp;
		Date dtn=null;
		int idadd=0;
		int idcls=0;
		DAO<Address> addressDAO = DAOFactory.getAddressDAO();
		ArrayList<Address> add1=new ArrayList<Address>();
		
		ResultSet result = Connection.selectFrom("SELECT Nom, Prenom,Sexe,Date_Naissance,id_Adresse, id_Classe "
												+ "FROM Enseignant "
												+ "WHERE id_Enseignant="
												+id
												+";");
		try {
			while(result.next())
			{
				nomm = result.getString("Nom");
				pren=result.getString("Prenom");
				temp=result.getString("Sexe");
				sex=temp.charAt(0);
				dtn=result.getDate("Date_Naissance");
				idadd=result.getInt("id_Adresse");
				idcls=result.getInt("id_Classe");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		add1.add(addressDAO.find(idadd));
		
		if(nomm != null && pren !=null)
		{
			tea = new CaseSalle(id,nomm,pren,sex,dtn,idcls,idadd,add1); 
		}
		
		return tea;
	}

	
	@Override
	public CaseSalle create(CaseSalle obj) {
		
		Connection.update("INSERT INTO Enseignant (Nom,Prenom,Sexe,Date_Naissance,id_Adresse,id_Classe) VALUES(\'"
						  +obj.getNom()+"\',\'"
						  +obj.getPrenom()+"\',\'"
						  +obj.getSexe()+"\',\'"
						  +obj.getDateNaissance()+"\',\'"
						  +obj.getId_add()+"\',\'"
						  +obj.getId_cl()+"\',\'"
						  +"\')");


		ResultSet result = 	Connection.selectFrom("SELECT id_Enseignant "
												  + "FROM Enseignant "
												  +";");
		
		int i = 0;
		try
		{
			result.last();
			i = result.getInt("Id_Enseignant");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	
		obj.setId(i);
		
		return obj;
		
		
	
	}

	@Override
	public CaseSalle update(CaseSalle obj) {
		
		Connection.update("UPDATE Enseignant SET Nom ='"+obj.getNom()
						  +"',Prenom='"+obj.getPrenom()
						  +"',Sexe='"+obj.getSexe()
						  +"',Date_Naissance='"+obj.getDateNaissance()
						  +"' WHERE id_Enseignant="
						  +obj.getId()
						  +";");	
						
		return obj;
	}

	@Override
	public void delete(CaseSalle obj) {
		
		Connection.update("DELETE FROM Enseignant WHERE id_Enseignant="
						  +obj.getId()
						  +";");
		
	}

	

}
