import java.util.LinkedList;

/**
 * 21 nov. 2012 by  maxime
 * LivreDesVisages
 */

/**
 * @author maxime
 *
 */
public class Information {
	protected Utilisateur emetteur;
	protected String message;
	protected long datation;
	protected LinkedList<Commentaire> commentaires = new LinkedList<Commentaire>();
	
	/**
	 * @return the commentaires
	 */
	public LinkedList<Commentaire> getCommentaires() {
		return this.commentaires;
	}

	/**
	 * @param commentaires the commentaires to set
	 */
	public void setCommentaires(LinkedList<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Information(Utilisateur e, String m) {
		this.emetteur = e;
		this.message = m;
		this.datation = System.currentTimeMillis();
	}
	
	public String toString() {
		return (this.emetteur.toString() + " : " + this.message);
	}
	
	public void affichageHierarchique(Information info, String s) {
		for (Commentaire comm : info.commentaires) {
			System.out.println(s+comm.toString());
			affichageHierarchique(comm, s+"-");
		}
	}
	
	public void afficherConversation() {
		System.out.println(this.toString());
		affichageHierarchique(this, "-");
	}
}
