package bieres;

public class Beer {
	
	private String nom;
	private String variete;
	private Float degre;
	
	public  Beer(String Nom, String variete, Float degre) {
		setNom(Nom);
		setVariete(variete);
		setDegre(degre);
	}

	public Object[] toRow() {
		Object[] row = {getNom(), getVariete(), getDegre()};
		return row;
		
	};
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the variete
	 */
	public String getVariete() {
		return variete;
	}

	/**
	 * @param variete the variete to set
	 */
	public void setVariete(String variete) {
		this.variete = variete;
	}

	/**
	 * @return the degre
	 */
	public Float getDegre() {
		return degre;
	}

	/**
	 * @param degre the degre to set
	 */
	public void setDegre(Float degre) {
		this.degre = degre;
	}
	
	

}
