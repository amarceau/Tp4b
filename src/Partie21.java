import paquet.Paquet;
import utilitaire.Util;

public class Partie21 {
    Paquet paquet;
    Main21 jeuBanquier;
    Main21 jeuJoueur;

    boolean rejouerPartie;

    public Partie21() {
        jouer();
    }

    public void jouer() {
        String reponse = "o";
        rejouerPartie = false;

        do {
            if (debuterPartie()) {
                if (faireJouerLeJoueur()) {
                    if (!this.jeuJoueur.main21Gagnante())
                        System.out.println("Vous dépassé 21 et le banquier gagne!");
                    else
                        faireJouerLeBanquier();
                } else
                    faireJouerLeBanquier();
            }

            System.out.println("Partie terminée.");
            reponse = Util.lireString("Voulez-vous recommencer une partie ? (o/n)");
            rejouerPartie = (reponse.equals("o") ? true : false);

        } while (rejouerPartie == true);

        System.out.println("Au revoir.");

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
            //System.out.println("Vous avez " + this.jeuJoueur.getValeurMainDe21());
            reponse = Util.lireString("Voulez-vous piger une carte ? (o/n)");

            if (reponse.equals("o")) {
                this.jeuJoueur.pigerAu21();
                System.out.println("Vous pigez et avez maintenant " + this.jeuJoueur.getValeurMainDe21());
            }
            else
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
