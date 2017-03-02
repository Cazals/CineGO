package classes;

import java.util.ArrayList;
import java.util.Date;

public class Teacher extends Person
{

	public Teacher()
	{
		super();
	}

	public Teacher(int id, String nom, String prenom, char sexe, Date dateNaissance,int id_cl,int id_add, ArrayList<Address> address) 
	{
		super(id, nom, prenom, sexe, dateNaissance,id_cl,id_add, address);
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe + ", dateNaissance="
				+ dateNaissance + ", id_cl=" + id_cl + ", id_add=" + id_add + ", address=" + address + "]";
	}
}
