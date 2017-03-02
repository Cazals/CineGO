package classes;

public class Address {

	int id;
	String nomVoie;
	String cp;
	String ville;
	
	public Address () {}
	
	public Address (int id, String nomVoie, String cp, String ville)
	{
		this.id = id;
		this.nomVoie = nomVoie;
		this.cp = cp;
		this.ville = ville;
		return;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nomVoie
	 */
	public String getNomVoie() {
		return nomVoie;
	}

	/**
	 * @param nomVoie the nomVoie to set
	 */
	public void setNomVoie(String nomVoie) {
		this.nomVoie = nomVoie;
	}

	/**
	 * @return the cp
	 */
	public String getCp() {
		return cp;
	}

	/**
	 * @param cp the cp to set
	 */
	public void setCp(String cp) {
		this.cp = cp;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Address [id=" + id + ", nomVoie=" + nomVoie + ", cp=" + cp + ", ville=" + ville + "]";
	}

	
	
}
	
