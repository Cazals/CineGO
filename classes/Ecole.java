package classes;

import java.util.ArrayList;

public class Ecole
{
	private int id;
	private String nom;
	private Address address;
	private String numTel;
	private String mail;
	private ArrayList<Classe> listeClasse = new ArrayList<Classe>(); 
	
	
	public Ecole()	{};
	
	public Ecole(int id, String nom, Address address, String numTel, String mail, ArrayList<Classe> listeClasse)
	{
		super();
		this.id = id;
		this.nom = nom;
		this.address = address;
		this.numTel = numTel;
		this.mail = mail;
		this.listeClasse = listeClasse;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
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
	 * @param nom the nom to set
	 */
	public void setNom(String nom)
	{
		this.nom = nom;
	}

	/**
	 * @return the adresse
	 */
	public Address getAddress()
	{
		return address;
	}

	/**
	 * @param address the adresse to set
	 */
	public void setAddress(Address address)
	{
		this.address = address;
	}

	/**
	 * @return the numTel
	 */
	public String getNumTel()
	{
		return numTel;
	}

	/**
	 * @param numTel the numTel to set
	 */
	public void setNumTel(String numTel)
	{
		this.numTel = numTel;
	}

	/**
	 * @return the mail
	 */
	public String getMail()
	{
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail)
	{
		this.mail = mail;
	}

	
	
	public ArrayList<Classe> getListeClasse() {
		return listeClasse;
	}

	public void setListeClasse(ArrayList<Classe> listeClasse) {
		this.listeClasse = listeClasse;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Ecole [id=" + id + ", nom=" + nom + ", adresse=" + address + ", numTel=" + numTel + ", mail=" + mail
				+ "]";
	}



}
