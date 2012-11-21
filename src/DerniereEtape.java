/**
 * 21 nov. 2012 by  maxime
 * LivreDesVisages
 */

/**
 * @author maxime
 *
 */
public class DerniereEtape {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Utilisateur B = Utilisateur.addUtilisateur("B","B@ec-nantes.fr");
		Utilisateur T = Utilisateur.addUtilisateur("T","T@ec-nantes.fr");
		Utilisateur J = Utilisateur.addUtilisateur("J","J@ec-nantes.fr");
		Information bDebout = B.addInfo("Je suis debout");
		Information tReponse1 = T.addComment("Bonne journée", bDebout);
		Information bReponse1 = B.addComment("Merci",tReponse1);
		@SuppressWarnings("unused")
		Information jReponse1 = J.addComment("Quelle politesse", bReponse1);
		Information jReponse2 = J.addComment("C'est très intéressant", bDebout);
		Information bReponse2 = B.addComment("Pas obligé de me lire", jReponse2);
		@SuppressWarnings("unused")
		Information tReponse2 = T.addComment("De quoi il se mêle ?", bReponse2);
		bDebout.afficherConversation();
	}

}
