import utilitaire.Util;

public class App21 {
    private final String QUEST_JOUER_NOUVELLE_PARTIE = "Voulez-vous jouer une autre partie ? (o/n)";
    private final String MSG_NOUVELLE_PARTIE_CHOIX_VALIDE = "Entrez un choix valide (on)";
    private final String CHOIX_NOUVELLE_PARTIE_OUI = "o";
    private final String CHOIX_NOUVELLE_PARTIE_NON = "n";
    private final String MSG_AU_REVOIR = "Au revoir !";

    private Partie21 p;
    private boolean rejouerPartie;

    public App21() {
        String reponse = CHOIX_NOUVELLE_PARTIE_OUI;
        rejouerPartie = false;

        do {
            p = new Partie21();

            do {
                reponse = Util.lireString(QUEST_JOUER_NOUVELLE_PARTIE);

                if (!(reponse.toLowerCase().equals(CHOIX_NOUVELLE_PARTIE_OUI) || reponse.toLowerCase().equals(CHOIX_NOUVELLE_PARTIE_NON)))
                    System.out.println(MSG_NOUVELLE_PARTIE_CHOIX_VALIDE);

            } while (!(reponse.toLowerCase().equals(CHOIX_NOUVELLE_PARTIE_OUI) || reponse.toLowerCase().equals(CHOIX_NOUVELLE_PARTIE_NON)));

            rejouerPartie = (reponse.toLowerCase().equals("o") ? true : false);

        } while (rejouerPartie);

        System.out.println(MSG_AU_REVOIR);
    }

    public static void main(String[] args) {
        new App21();
    }
}
