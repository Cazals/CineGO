/**
 * 
 */
package dao.bddsql;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classes.Address;
import classes.Student;
import connection.Connection;
import dao.DAO;
import dao.DAOFactory;

/**
 * @author thomas
 *
 */
public class StudentDAO extends DAO<Student> {

	@Override
	public Student find(int id) {
		
		Student stu = new Student();
		String nomm=null,pren=null;
		String temp;
		char sex='\0';
		Date dtn=null;
		int idadd=0;
		int idcls=0;
		DAO<Address> addressDAO = DAOFactory.getAddressDAO();
		ArrayList<Address> add1=new ArrayList<Address>();
		
		
		ResultSet result = Connection.selectFrom("SELECT Nom, Prenom,Sexe,Date_Naissance,id_Adresse,id_Classe "
												+ "FROM Eleve "
												+ "WHERE id_Eleve="
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
	
		
		if(nomm != null && pren !=null )
		{
			stu = new Student(id,nomm,pren,sex,dtn,idcls,idadd,add1);
		}
		
		return stu;
	}

	
	@Override
	public Student create(Student obj) {
		
		Connection.update("INSERT INTO Eleve (Nom,Prenom,Sexe,Date_Naissance,id_Adresse,id_Classe) VALUES(\'"
						  +obj.getNom()+"\',\'"
						  +obj.getPrenom()+"\',\'"
						  +obj.getSexe()+"\',\'"
						  +obj.getDateNaissance()+"\',\'"
						  +obj.getId_add()+"\',\'"
						  +obj.getId_cl()+"\')");


		ResultSet result = 	Connection.selectFrom("SELECT id_Eleve "
												  + "FROM Eleve "
												  +";");
		
		int i = 0;
		try
		{
			result.last();
			i = result.getInt("Id_Eleve");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	
		obj.setId(i);
		
		return obj;
		
		
	
	}

	@Override
	public Student update(Student obj) {
		
		Connection.update("UPDATE Eleve SET Nom ='"+obj.getNom()
						  +"',Prenom='"+obj.getPrenom()
						  +"',Sexe='"+obj.getSexe()
						  +"',Date_Naissance='"+obj.getDateNaissance()
						  +"' WHERE id_Eleve="
						  +obj.getId()
						  +";");	
						
		return obj;
	}

	@Override
	public void delete(Student obj) {
		
		Connection.update("DELETE FROM Eleve WHERE id_Eleve="
						  +obj.getId()
						  +";");
		
	}

}
