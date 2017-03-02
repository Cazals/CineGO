/**
 * 
 */
package classes;

import java.util.ArrayList;

/**
 * @author thomas
 *
 */
public class PlanSalle {
	
	private int id;
	private int numPlanSalle;
	private String nomPlanSalle;
	private int idCinema;
	private ArrayList<CaseSalle> listPlanSalle = new ArrayList<CaseSalle>();
	
	public PlanSalle() {};
	
	public PlanSalle(int id, int numPlanSalle, int idCinema){
		this.id=id;
		this.numPlanSalle=numPlanSalle;
		this.nomPlanSalle=nomPlanSalle;
		this.idCinema=idCinema;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumPlanSalle() {
		return numPlanSalle;
	}

	public void setNumPlanSalle(int numPlanSalle) {
		this.numPlanSalle = numPlanSalle;
	}

	public String getNomPlanSalle() {
		return nomPlanSalle;
	}

	public void setNomPlanSalle(String nomPlanSalle) {
		this.nomPlanSalle = nomPlanSalle;
	}

	public int getIdCinema() {
		return idCinema;
	}

	public void setIdCinema(int idCinema) {
		this.idCinema = idCinema;
	}
	
	
	public ArrayList<CaseSalle> getListPlanSalle() {
		return listPlanSalle;
	}

	public void setListPlanSalle(ArrayList<CaseSalle> listPlanSalle) {
		this.listPlanSalle = listPlanSalle;
	}

	@Override
	public String toString() {
		return "PlanSalle [id=" + id + ", numPlanSalle=" + numPlanSalle + ", nomPlanSalle=" + nomPlanSalle
				+ ", idCinema=" + idCinema + ", listPlanSalle=" + listPlanSalle + "]";
	}

	
	
}
