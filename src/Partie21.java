import paquet.Paquet;
import paquet.Util;

public class Partie21 {
    Paquet paquet;
    Main21 jeuBanquier;
    Main21 jeuJoueur;

    public Partie21() {
        jouer();
    }

    public void jouer() {
        if (debuterPartie()) {
            if (faireJouerLeJoueur()) {
                if (!jeuJoueur.main21Gagnante())
                    System.out.println("Vous perdez!");
                else
                    faireJouerLeBanquier();
            } else
                faireJouerLeBanquier();
        }
    }

    private boolean debuterPartie() {
        paquet = new Paquet(true);
        jeuJoueur = new Main21(paquet, 2);
        jeuBanquier = new Main21(paquet, 2);

        if (jeuJoueur.getValeurMainDe21() > 21 || jeuBanquier.getValeurMainDe21() > 21)
            return false;
        else
            return true;
    }

    private boolean faireJouerLeJoueur() {
        String reponse;

        do {
            System.out.println("Vous avez " + jeuJoueur.getValeurMainDe21());
            reponse = Util.lireString("Voulez-vous arrêter ? (o/n)");

            if (reponse.equals("o"))
                return false;
            else
                jeuJoueur.pigerAu21();

        } while (!jeuJoueur.main21GagnanteOuPerdante());

        System.out.println("Vous avez " + jeuJoueur.getValeurMainDe21());
        return jeuJoueur.main21GagnanteOuPerdante();
    }

    private void faireJouerLeBanquier() {
        boolean estGagnantOuPerdant = false;

        System.out.println("Le banquier débute avec " + jeuBanquier.getValeurMainDe21());

        do {
            if (jeuBanquier.getValeurMainDe21() > 21) {
                System.out.println("Vous gagnez!");
                estGagnantOuPerdant = true;
            }
            else if (jeuBanquier.getValeurMainDe21() == 21 || jeuBanquier.getValeurMainDe21() > jeuJoueur.getValeurMainDe21()) {
                System.out.println("Le banquier gagne!");
                estGagnantOuPerdant = true  ;
            } else {
                jeuBanquier.pigerAu21();
                System.out.println("Le banquier a maintenant " + jeuBanquier.getValeurMainDe21());
            }
        } while (!estGagnantOuPerdant);
    }

    public static void main(String[] args) {
        new Partie21();
    }

}
