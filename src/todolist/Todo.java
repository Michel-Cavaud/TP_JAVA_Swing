package todolist;

	

public class Todo {
	private String valeurTodo;
	private boolean faite = false;
	
	private static int nbTodo = 0;
	private int numeroTodo;
	
	public Todo(String valeur){
		setValeurTodo(valeur);
		setNbTodo(getNbTodo() + 1);
		setNumeroTodo(nbTodo);
		
	}
	
	public String toString() {
		String retour = getNumeroTodo() + " " + getValeurTodo();
		if (isFaite()) {
			retour += " -Fait";
		}
		return retour;
	}

	
	/**
	 * @param nbTodo the nbTodo to set
	 */
	public static void setNbTodo(int nbTodo) {
		Todo.nbTodo = nbTodo;
	}

	/**
	 * @return the numeroTodo
	 */
	public int getNumeroTodo() {
		return numeroTodo;
	}

	/**
	 * @param numeroTodo the numeroTodo to set
	 */
	public void setNumeroTodo(int numeroTodo) {
		this.numeroTodo = numeroTodo;
	}

	/**
	 * @return the nbTodo
	 */
	public int getNbTodo() {
		return nbTodo;
	}

	public void toggleFaite() {
		setFaite(!isFaite());
	}
	/**
	 * @return the valeurTodo
	 */
	public String getValeurTodo() {
		return valeurTodo;
	}

	/**
	 * @param valeurTodo the valeurTodo to set
	 */
	public void setValeurTodo(String valeurTodo) {
		this.valeurTodo = valeurTodo;
	}

	/**
	 * @return the faite
	 */
	public boolean isFaite() {
		return faite;
	}

	/**
	 * @param faite the faite to set
	 */
	public void setFaite(boolean faite) {
		this.faite = faite;
	}
	
	
}

