package dao.bddsql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import classes.Address;
import classes.Classe;
import classes.Ecole;
import connection.Connection;
import dao.DAO;
import dao.DAOFactory;

/**
 * @author Vincent
 *
 */

public class EcoleDAO extends DAO<Ecole> {

	@Override
	public Ecole find(int id) {

		// TODO Auto-generated method stub
		Ecole E=new Ecole();
		Address A=new Address();
		ArrayList<Classe> cls=new ArrayList<Classe>();

		String nome=null,numt=null,mel=null;
		int idadd=0;
		int[] idcla = new int[15];
		int i=0;
		int j=0;

		DAO <Classe> classeDAO = DAOFactory.getClasseDAO();
		DAO <Address> addressDAO = DAOFactory.getAddressDAO();

		ResultSet rs = Connection.selectFrom("SELECT Nom_Ecole,Num_tel, Mail, ecole.id_Adresse "
											 + "FROM ecole "
											 + "INNER JOIN adresse "	
											 + "ON ecole.id_Adresse=adresse.id_Adresse "
											 + "WHERE id_Ecole = " + id +";");

		try {
			while(rs.next())
			{
				nome = rs.getString("Nom_Ecole");
				numt=rs.getString("Num_tel");
				mel=rs.getString("Mail");
				idadd=rs.getInt("ecole.id_Adresse");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//Recherche du nombre de classes 
		ResultSet result2 = Connection.selectFrom("SELECT id_Classe "
												  + "FROM Classe "
												  + "WHERE "
												  + "id_Ecole="
												  +id
												  +";");

		//Recuperation des id classe
		try {
			while(result2.next())
			{
				idcla[i]=result2.getInt("id_Classe");
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		

		for(j=0;j<i;j++)
		{
			cls.add(classeDAO.find(idcla[j]));
		}

		A=addressDAO.find(idadd);
		
		
		//if(nome != null && numt != null && mel != null)
		//{
			E = new Ecole(id,nome,A,numt,mel,cls); 
		//}

		return E;
	}

	@Override
	public Ecole create(Ecole obj) {

		Connection.update("INSERT INTO Ecole VALUES('', '"
					   	  +obj.getNom() + "','"
						  +obj.getAddress()+"','"	
						  +obj.getNumTel()+"','"
						  +obj.getMail()+"')");

		ResultSet result = Connection.selectFrom("SELECT id_Ecole "
											   	 + "FROM Ecole "
												 +";");
		int i = 0;
		try
		{
			result.last();
			i = result.getInt("Id_Ecole");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		obj.setId(i);

		return obj;
	}

	@Override
	public Ecole update(Ecole obj) {

		// TODO Auto-generated method stub
		Connection.update("UPDATE ecole SET "
				          + "Ecole ='" + obj.getNom()
						  +"',id_Adresse=" + obj.getAddress()
						  +",numTel='"        +(obj.getNumTel())
						  +"' WHERE id_Ecole=" + obj.getId() + ";");        
		return obj;
	}

	@Override
	public void delete(Ecole obj) {
		// TODO Auto-generated method stub
		Connection.update("DELETE FROM ecole WHERE id_Ecole ="
						  +obj.getId()
						  +";");
	}

}