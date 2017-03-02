/**
 * 
 */
package classes;

import java.util.ArrayList;

/**
 * @author thomas
 * 
 *
 */
public class Cinema {
	
	private int id;
	private String nomCine;
	private String nVoieCine;
	private int idVille;
	private ArrayList<PlanSalle> listPlanSalle = new ArrayList<PlanSalle>();
	
	public Cinema() {};
	
	public Cinema(int id, String nomCine, String nVoieCine, int idVille){
		this.id=id;
		this.nomCine=nomCine;
		this.nVoieCine=nVoieCine;
		this.idVille=idVille;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomCine() {
		return nomCine;
	}

	public void setNomCine(String nomCine) {
		this.nomCine = nomCine;
	}

	public String getnVoieCine() {
		return nVoieCine;
	}

	public void setnVoieCine(String nVoieCine) {
		this.nVoieCine = nVoieCine;
	}

	public int getIdVille() {
		return idVille;
	}

	public void setIdVille(int idVille) {
		this.idVille = idVille;
	}
	
	
	public ArrayList<PlanSalle> getListPlanSalle() {
		return listPlanSalle;
	}

	public void setListPlanSalle(ArrayList<PlanSalle> listPlanSalle) {
		this.listPlanSalle = listPlanSalle;
	}

	@Override
	public String toString() {
		return "Cinema [id=" + id + ", nomCine=" + nomCine + ", nVoieCine=" + nVoieCine + ", idVille=" + idVille
				+ ", listPlanSalle=" + listPlanSalle + "]";
	}

}
