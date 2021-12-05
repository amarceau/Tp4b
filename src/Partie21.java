import paquet.Paquet;
import utilitaire.Util;

public class Partie21 {
    private Paquet paquet;
    private Main21 jeuBanquier;
    private Main21 jeuJoueur;

    private boolean rejouerPartie;

    public Partie21() {
        jouer();
    }

    public void jouer() {
        rejouerPartie = false;

        if (debuterPartie()) {
            if (faireJouerLeJoueur()) {
                if (!this.jeuJoueur.main21Gagnante())
                    System.out.println("Le banquier gagne!");
                else
                    faireJouerLeBanquier();
            } else
                faireJouerLeBanquier();
        }

        System.out.println("Partie terminée.");
    }

    public void afficherJeuJoueur() {
        System.out.println("Jeu du joueur");
        System.out.println(jeuJoueur.toString());
    }

    public void afficherJeuBanquier() {
        System.out.println("Jeu du banquier");
        System.out.println(jeuBanquier.toString());
    }

    private boolean debuterPartie() {
        this.paquet = new Paquet(true);
        this.jeuJoueur = new Main21(this.paquet, 2);
        this.jeuBanquier = new Main21(this.paquet, 2);

        if (this.jeuJoueur.getValeurMainDe21() == 21) {
            if (this.jeuBanquier.getValeurMainDe21() == 21) {
                afficherJeuBanquier();
                System.out.println("Le banquier et vous gagnez tous les deux la partie.");
            }
            else {
                afficherJeuBanquier();
                System.out.println("Vous gagnez la partie.");
            }

            return false;
        } else if (this.jeuBanquier.getValeurMainDe21() == 21) {
            afficherJeuBanquier();
            System.out.println("Le banquier gagne la partie.");
            return false;
        }

        if (this.jeuJoueur.getValeurMainDe21() > 21) {
            afficherJeuBanquier();
            System.out.println("Le banquier gagne la partie.");
            return false;
        } else if (this.jeuJoueur.getValeurMainDe21() > 21) {
            afficherJeuJoueur();
            System.out.println("Vous gagnez la partie.");
            return false;
        }

        return true;
    }

    private boolean faireJouerLeJoueur() {
        String reponse;

        do {
            do {
                afficherJeuJoueur();

                reponse = Util.lireString("(C)onserver son jeu ou (d)emander une carte ?");

                if (!(reponse.toLowerCase().equals("c") || reponse.toLowerCase().equals("d")))
                    System.out.println("Entrez un choix valide (cd)");

            } while (!(reponse.toLowerCase().equals("c") || reponse.toLowerCase().equals("d")));

            if (reponse.toLowerCase().equals("d")) {
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
                System.out.println("le joueur gagne");
                estGagnantOuPerdant = true;
            } else if (this.jeuBanquier.getValeurMainDe21() > this.jeuJoueur.getValeurMainDe21()) {
                System.out.println("Le banquier a une main plus élevée que la vôtre et gagne la partie.");
                estGagnantOuPerdant = true;
            } else {
                this.jeuBanquier.pigerAu21();
                System.out.println("Le banquier demande une carte");
                afficherJeuBanquier();
            }
        } while (!estGagnantOuPerdant);
    }

    public static void main(String[] args) {
        new Partie21();
    }

}
