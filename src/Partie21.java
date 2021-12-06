import paquet.Paquet;
import utilitaire.Util;

public class Partie21 {
    private final String MSG_JOUEUR_GAGNE_PARTIE = "Le joueur gagne la partie";
    private final String MSG_BANQUIER_GAGNE_PARTIE = "Le banquier gagne la partie";
    private final String MSG_JOUEUR_BANQUIER_GAGNENT_PARTIE = "Le joueur et le banquier gagnent la partie";
    private final String MSG_BANQUIER_DEMANDE_CARTE = "Le banquier demande une carte";
    private final String MSG_NOUVELLE_PARTIE = "Nouvelle partie";
    private final String MSG_JEU_JOUEUR = "Jeu du joueur";
    private final String MSG_JEU_BANQUIER = "jeu du banquier";
    private final String QUEST_CONSERVER_DEMANDER_CARTE = "(C)onserver son jeu ou (d)emander une carte ?";
    private final String MSG_DEMANDER_CARTE_CHOIX_VALIDE = "Entrez un choix valide (cd)";
    private final String CHOIX_DEMANDER_CARTE_CONSERVER = "c";
    private final String CHOIX_DEMANDER_CARTE_DEMANDER = "d";

    private Paquet paquet;
    private Main21 jeuBanquier;
    private Main21 jeuJoueur;

    private boolean rejouerPartie;

    public Partie21() {
        jouer();
    }

    public void jouer() {
        rejouerPartie = false;

        System.out.println(MSG_NOUVELLE_PARTIE);

        if (debuterPartie()) {
            if (faireJouerLeJoueur()) {
                if (!this.jeuJoueur.main21Gagnante())
                    System.out.println(MSG_BANQUIER_GAGNE_PARTIE);
                else
                    faireJouerLeBanquier();
            } else
                faireJouerLeBanquier();
        }
    }

    public void afficherJeuJoueur() {
        System.out.println(MSG_JEU_JOUEUR);
        System.out.println(jeuJoueur.toString());
    }

    public void afficherJeuBanquier() {
        System.out.println(MSG_JEU_BANQUIER);
        System.out.println(jeuBanquier.toString());
    }

    private boolean debuterPartie() {
        this.paquet = new Paquet(true);
        this.jeuJoueur = new Main21(this.paquet, 2);
        this.jeuBanquier = new Main21(this.paquet, 2);

        if (this.jeuJoueur.getValeurMainDe21() == 21) {
            if (this.jeuBanquier.getValeurMainDe21() == 21) {
                afficherJeuBanquier();
                System.out.println(MSG_JOUEUR_BANQUIER_GAGNENT_PARTIE);
            } else {
                afficherJeuBanquier();
                System.out.println(MSG_JOUEUR_GAGNE_PARTIE);
            }

            return false;
        } else if (this.jeuBanquier.getValeurMainDe21() == 21) {
            afficherJeuBanquier();
            System.out.println(MSG_BANQUIER_GAGNE_PARTIE);
            return false;
        }

        if (this.jeuJoueur.getValeurMainDe21() > 21) {
            afficherJeuBanquier();
            System.out.println(MSG_BANQUIER_GAGNE_PARTIE);
            return false;
        } else if (this.jeuJoueur.getValeurMainDe21() > 21) {
            afficherJeuJoueur();
            System.out.println(MSG_JOUEUR_GAGNE_PARTIE);
            return false;
        }

        return true;
    }

    private boolean faireJouerLeJoueur() {
        String reponse;

        afficherJeuJoueur();

        do {
            do {
                reponse = Util.lireString(QUEST_CONSERVER_DEMANDER_CARTE);

                if (!(reponse.toLowerCase().equals(CHOIX_DEMANDER_CARTE_CONSERVER) || reponse.toLowerCase().equals(CHOIX_DEMANDER_CARTE_DEMANDER)))
                    System.out.println(MSG_DEMANDER_CARTE_CHOIX_VALIDE);

            } while (!(reponse.toLowerCase().equals(CHOIX_DEMANDER_CARTE_CONSERVER) || reponse.toLowerCase().equals(CHOIX_DEMANDER_CARTE_DEMANDER)));

            if (reponse.toLowerCase().equals(CHOIX_DEMANDER_CARTE_DEMANDER)) {
                this.jeuJoueur.pigerAu21();
                afficherJeuJoueur();
            } else
                return false;

        } while (!this.jeuJoueur.main21GagnanteOuPerdante());

        return this.jeuJoueur.main21GagnanteOuPerdante();
    }

    private void faireJouerLeBanquier() {
        boolean estGagnantOuPerdant = false;

        afficherJeuBanquier();

        do {
            if (this.jeuBanquier.getValeurMainDe21() > 21) {
                System.out.println(MSG_JOUEUR_GAGNE_PARTIE);
                estGagnantOuPerdant = true;
            } else if (this.jeuBanquier.getValeurMainDe21() > this.jeuJoueur.getValeurMainDe21()) {
                System.out.println(MSG_BANQUIER_GAGNE_PARTIE);
                estGagnantOuPerdant = true;
            } else {
                this.jeuBanquier.pigerAu21();
                System.out.println(MSG_BANQUIER_DEMANDE_CARTE);
                afficherJeuBanquier();
            }
        } while (!estGagnantOuPerdant);
    }

    public static void main(String[] args) {
        new Partie21();
    }

}
