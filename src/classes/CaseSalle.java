																	/**
 * 
 */
package classes;

/**
 * @author thomas
 *
 */
public class CaseSalle {
	
	private int id;
	private String nomSiegeCase;
	private int idPlanSalle;
	private int idPositionCase;
	private int idTypeCase;
	private TypeCase classTypeCase;
	private PositionCase classPositionCase;
	
	public CaseSalle() {};
	
	public CaseSalle(int id, String nomSiegeCase,int idPlanSalle, int idPositionCase, int idTypeCase){
		this.id=id;
		this.nomSiegeCase=nomSiegeCase;
		this.idPlanSalle=idPlanSalle;
		this.idPositionCase=idPositionCase;
		this.idTypeCase=idTypeCase;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomSiegeCase() {
		return nomSiegeCase;
	}

	public void setNomSiegeCase(String nomSiegeCase) {
		this.nomSiegeCase = nomSiegeCase;
	}

	public int getIdPlanSalle() {
		return idPlanSalle;
	}

	public void setIdPlanSalle(int idPlanSalle) {
		this.idPlanSalle = idPlanSalle;
	}

	public int getIdPositionCase() {
		return idPositionCase;
	}

	public void setIdPositionCase(int idPositionCase) {
		this.idPositionCase = idPositionCase;
	}

	public int getIdTypeCase() {
		return idTypeCase;
	}

	public void setIdTypeCase(int idTypeCase) {
		this.idTypeCase = idTypeCase;
	}
	

	public TypeCase getClassTypeCase() {
		return classTypeCase;
	}

	public void setClassTypeCase(TypeCase classTypeCase) {
		this.classTypeCase = classTypeCase;
	}

	public PositionCase getClassPositionCase() {
		return classPositionCase;
	}

	public void setClassPositionCase(PositionCase classPositionCase) {
		this.classPositionCase = classPositionCase;
	}

	@Override
	public String toString() {
		return "CaseSalle [id=" + id + ", nomSiegeCase=" + nomSiegeCase + ", idPlanSalle=" + idPlanSalle
				+ ", idPositionCase=" + idPositionCase + ", idTypeCase=" + idTypeCase + ", classTypeCase="
				+ classTypeCase + ", classPositionCase=" + classPositionCase + "]";
	}

	
	
	
}
