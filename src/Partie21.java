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
                    System.out.println("Vous dépassez 21 et le banquier gagne!");
                else
                    faireJouerLeBanquier();
            } else
                faireJouerLeBanquier();
        }

        System.out.println("Partie terminée.");
    }

    public void afficherJeuJoueur() {

    }

    public void afficherJeuBanquier() {

    }

    private boolean debuterPartie() {
        this.paquet = new Paquet(true);
        this.jeuJoueur = new Main21(this.paquet, 2);
        this.jeuBanquier = new Main21(this.paquet, 2);

        if (this.jeuJoueur.getValeurMainDe21() == 21) {
            if (this.jeuBanquier.getValeurMainDe21() == 21)
                System.out.println("Le banquier et vous débutez avec 21 et gagnez tous les deux la partie.");
            else
                System.out.println("Vous débutez avec 21 et gagnez la partie.");

            return false;
        } else if (this.jeuBanquier.getValeurMainDe21() == 21) {
            System.out.println("Le banquier débute avec 21 et gagne la partie.");
            return false;
        }

        if (this.jeuJoueur.getValeurMainDe21() > 21) {
            System.out.println("Vous débutez avec plus de 21 et le banquier gagne la partie.");
            return false;
        } else if (this.jeuJoueur.getValeurMainDe21() > 21) {
            System.out.println("Le banquier débute avec plus de 21 et vous gagnez la partie.");
            return false;
        }

        System.out.println("Vous débutez avec " + this.jeuJoueur.getValeurMainDe21());

        return true;
    }

    private boolean faireJouerLeJoueur() {
        String reponse;

        do {
            do {
                reponse = Util.lireString("(C)onserver son jeu ou (d)emander une carte ?");

                if (!(reponse.toLowerCase().equals("c") || reponse.toLowerCase().equals("d")))
                    System.out.println("Entrez un choix valide (cd)");

            } while (!(reponse.toLowerCase().equals("c") || reponse.toLowerCase().equals("d")));

            if (reponse.toLowerCase().equals("d")) {
                this.jeuJoueur.pigerAu21();
                System.out.println("Vous avez demandé une carte et avez maintenant " + this.jeuJoueur.getValeurMainDe21());
            } else
                return false;

        } while (!this.jeuJoueur.main21GagnanteOuPerdante());

        return this.jeuJoueur.main21GagnanteOuPerdante();
    }

    private void faireJouerLeBanquier() {
        boolean estGagnantOuPerdant = false;

        System.out.println("Le banquier débute avec " + this.jeuBanquier.getValeurMainDe21());

        do {
            if (this.jeuBanquier.getValeurMainDe21() > 21) {
                System.out.println("Le banquier a dépassé 21 et vous gagnez la partie.");

                estGagnantOuPerdant = true;
            } else if (this.jeuBanquier.getValeurMainDe21() > this.jeuJoueur.getValeurMainDe21()) {
                System.out.println("Le banquier a une main plus élevé que vous et gagne la partie.");
                estGagnantOuPerdant = true;
            } else {
                this.jeuBanquier.pigerAu21();
                System.out.println("Le banquier pige une carte et a maintenant " + this.jeuBanquier.getValeurMainDe21());
            }
        } while (!estGagnantOuPerdant);
    }

    public static void main(String[] args) {
        new Partie21();
    }

}
