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
            if (faireJouerLeJoueur() && !this.jeuJoueur.main21Gagnante())
                System.out.println("Vous avez perdu:" + " vous avez dépassé 21");
            else if (this.jeuBanquier.getValeurMainDe21() == this.jeuJoueur.getValeurMainDe21())
                System.out.println("Vous avez perdu:" + " votre main plus faible");
            else
                faireJouerLeBanquier();
        }
    }

    public void afficherJeuBanquier() {
        System.out.println("Jeu du banquier :");
        System.out.println(jeuBanquier.toString());
    }

    public void afficherJeuJoueur() {
        System.out.println("Votre jeu :");
        System.out.println(jeuJoueur.toString());
    }

    public void afficherMessagePartieTermine() {

    }

    private boolean debuterPartie() {
        this.paquet = new Paquet(true);
        this.jeuJoueur = new Main21(this.paquet, 2);
        this.jeuBanquier = new Main21(this.paquet, 2);

        afficherJeuBanquier();

        if (this.jeuJoueur.main21GagnanteOuPerdante() || this.jeuBanquier.main21GagnanteOuPerdante()) {
            afficherJeuJoueur();

            if (this.jeuBanquier.main21Perdante() || this.jeuJoueur.main21Perdante()) {
                if (this.jeuBanquier.main21Perdante())
                    System.out.println("Le banquier a perdu en dépassant 21 !");

                if (this.jeuJoueur.main21Perdante()) {
                    System.out.println("Vous avez perdu en dépassant 21 !");
                }

                return false;
            }

            if (this.jeuJoueur.main21Gagnante()) {
                System.out.println("Vous avez gagné!");
            }

            if (this.jeuBanquier.main21Gagnante()) {
                System.out.println("Le banquier a gagné!");
            }

            return false;
        }

        if (this.jeuBanquier.getValeurMainDe21() == 21) {
            System.out.println("Le banquier a gagné!");
            return false;


        } else if (this.jeuJoueur.getValeurMainDe21() > 21) {
            System.out.println("Le banquier a gagné!");
            return false;
        }

        return true;
    }

    private void faireJouerLeBanquier() {
        boolean estGagnantOuPerdant = false;

        do {
            if (this.jeuBanquier.main21Perdante()) {
                System.out.println("Vous avez gagné! Le banquier a dépassé 21");
                estGagnantOuPerdant = true;
            } else if (this.jeuBanquier.getValeurMainDe21() > this.jeuJoueur.getValeurMainDe21()) {
                System.out.println("Vous avez perdu: votre main plus faible");
                estGagnantOuPerdant = true;
            } else {
                this.jeuBanquier.pigerAu21();
                System.out.println("Le banquier pige...");
                afficherJeuBanquier();
            }
        } while (!estGagnantOuPerdant);
    }

    private boolean faireJouerLeJoueur() {
        String reponse;

        afficherJeuJoueur();

        do {
            do {
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
}
