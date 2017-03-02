package classes;

import java.util.ArrayList;
import java.util.Date;
//import java.util.Vector;

/**
 * @author Romain Abstract class parent of student and teacher
 */
public abstract class Person
{
	int id;
	String nom;
	String prenom;
	char sexe;
	Date dateNaissance;
	int id_cl;
	int id_add;
	ArrayList<Address> address=new ArrayList<Address>();

	public Person()
	{
	}

	public Person(int id, String nom, String prenom, char sexe, Date dateNaissance,int id_cl,int id_add,ArrayList<Address> address)
	{
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.dateNaissance = dateNaissance;
		this.id_cl=id_cl;
		this.id_add=id_add;
		this.address = address;
	}

	public Person(int id, String nom, String prenom, char sexe, Date dateNaissance,int id_cl,int id_add) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.dateNaissance = dateNaissance;
		this.id_cl=id_cl;
		this.id_add=id_add;
	}

	/**
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id)
	{
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom()
	{
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom)
	{
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom()
	{
		return prenom;
	}

	/**
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}

	/**
	 * @return the sexe
	 */
	public char getSexe()
	{
		return sexe;
	}

	/**
	 * @param sexe
	 *            the sexe to set
	 */
	public void setSexe(char sexe)
	{
		this.sexe = sexe;
	}

	/**
	 * @return the dateNaissance
	 */
	public Date getDateNaissance()
	{
		return dateNaissance;
	}

	/**
	 * @param dateNaissance
	 *            the dateNaissance to set
	 */
	public void setDateNaissance(Date dateNaissance)
	{
		this.dateNaissance = dateNaissance;
	}

	/**
	 * @return the address
	 */
	public ArrayList<Address> getAddress()
	{
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(ArrayList<Address> address)
	{
		this.address = address;
	}

	public int getId_add() {
		return id_add;
	}

	public void setId_add(int id_add) {
		this.id_add = id_add;
	}

	public int getId_cl() {
		return id_cl;
	}

	public void setId_cl(int id_cl) {
		this.id_cl = id_cl;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe + ", dateNaissance="
				+ dateNaissance + ", id_cl=" + id_cl + ", id_add=" + id_add + ", address=" + address + "]";
	}
	
}
