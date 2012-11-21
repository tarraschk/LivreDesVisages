/**
 * 21 nov. 2012 by  maxime
 * LivreDesVisages
 */

/**
 * @author maxime
 *
 */
public class Commentaire extends Information{
	protected Information parent;
	
	public Commentaire(Utilisateur e, String m, Information p) {
		super(e,m);
		this.parent = p;
	}
	
	public String toString() {
		return (this.emetteur + " : " + this.message + " / en réponse à " + this.parent.emetteur);
	}
	
}
