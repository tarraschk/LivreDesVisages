import java.util.LinkedList;

/**
 * 21 nov. 2012 by  maxime
 * LivreDesVisages
 */

/**
 * @author maxime
 *
 */
public class Utilisateur {
	protected String surnom;
	protected String adresseMail;
	protected LinkedList<Utilisateur> listeAmis = new LinkedList<Utilisateur>();
	protected LinkedList<Information> listeInfos = new LinkedList<Information>();
	public static LinkedList<Utilisateur> listeUtilisateurs = new LinkedList<Utilisateur>();
	
	private Utilisateur(String s, String aM) {
		this.surnom = s;
		this.adresseMail = aM;
	}
	
	public Information addInfo(String information) {
		Information info = new Information(this, information);
		this.listeInfos.addFirst(info);
		return info;
	}
	
	public Commentaire addComment(String commentaire, Information information) {
		Commentaire comm = new Commentaire(this, commentaire, information);
		this.listeInfos.addFirst(comm);
		information.commentaires.addLast(comm); // Attention à cette convention Last/First entre listeInfos et commentaires
		return comm;
	}
	
	public static Utilisateur addUtilisateur(String surnom, String adresseMail) {
		boolean found = false;
		for(Utilisateur user : listeUtilisateurs) {
			found = ((user.adresseMail.equals(adresseMail)) || (user.surnom.equals(surnom)) || found);
		}
		try {
			if (found) {
				throw new UtilisateurExistantException();
			}
			else {
				Utilisateur user = new Utilisateur(surnom, adresseMail);
				listeUtilisateurs.addFirst(user);
				return user;
			}
		}
		catch (UtilisateurExistantException e){
			System.out.println("Erreur lors de la création de l'utilisateur !");
		}
		return null;
	}
	
	public void afficherFacade() {
		int i = 0;
		for(Information info : this.listeInfos) {
			if ((i<5) && (info.getClass().getName().equals("Information"))) {
				System.out.println(info.toString());
				i++;
			}
		}
	}
	
	public void getFacade(Utilisateur user) {
		if(this.listeAmis.contains(user)) {
			user.afficherFacade();
		}
	}
	
	public void getLastNewsFriends() {
		for(Utilisateur user : this.listeAmis) {
			System.out.println(user.listeInfos.getFirst().toString());
		}
	}
	
	public String toString() {
		return this.surnom;
	}
	
}
