package dao.bddsql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import classes.Classe;
import classes.Student;
import classes.Teacher;
import connection.Connection;
import dao.DAO;
import dao.DAOFactory;

/**
 * @author karima,thomas
 *
 */

public class ClasseDAO extends DAO<Classe> {



	@Override
	public Classe find(int id) {

		Classe cls = new Classe();
		Teacher tea = new Teacher();
		String niv=null;

		int idtea=0;

		int[] idstu = new int[35];
		int i=0;
		int j=0;


		DAO <Teacher> teacherDAO = DAOFactory.getTeacherDAO();
		DAO <Student> studentDAO = DAOFactory.getStudentDAO();
		ArrayList<Student> stu=new ArrayList<Student>();

		//Recherche de la classe

		ResultSet result = Connection.selectFrom("SELECT Niveau ,id_Enseignant "
						                        + "FROM Classe AS C "
						                        + "INNER JOIN Enseignant AS E "
						                        + "ON C.id_Classe=E.id_Classe "
						                        + "WHERE C.id_Classe="
						                        +id
						                        +";");

		try {
			while(result.next())
			{
				niv= result.getString("Niveau");
				idtea=result.getInt("id_Enseignant");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//Recherche du nombre d'eleve et enregistrement des eleves
		ResultSet result2 =         Connection.selectFrom("SELECT id_Eleve "
										                  + "FROM Eleve "
										                  + "WHERE "
										                  + "id_Classe="
										                  +id
										                  +";");

		//Recuperation des id eleve
		try {
			while(result2.next())
			{
				idstu[i]=result2.getInt("id_Eleve");
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		for(j=0;j<i;j++)
		{
			stu.add(studentDAO.find(idstu[j]));
		}
		tea=teacherDAO.find(idtea);

		if(niv != null)
		{
			cls=new Classe(id,niv,tea,stu);
		}
		return cls;	
	}

	@Override
	public Classe create(Classe obj) {

		Connection.update("INSERT INTO Classe (Niveau) VALUES(\'"
      					  +obj.getNiveau()+"\')");

		ResultSet result =  Connection.selectFrom("SELECT id_Classe "
				+ "FROM Classe "
				+";");
		
		int i = 0;
		
		try
		{
			result.last();

			i = result.getInt("Id_Classe");

		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		obj.setId(i);

		return obj;
	}

	@Override

	public Classe update(Classe obj) {

		Connection.update("UPDATE classe SET Niveau ='"+obj.getNiveau()
						  +";"); 

		return obj;
	}


	@Override
	public void delete(Classe obj) {
		Connection.update("DELETE FROM classe WHERE id_Classe="
						  +obj.getId()
						  +";");
	}

}
