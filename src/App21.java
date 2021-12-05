import utilitaire.Util;

public class App21 {

    private Partie21 p;
    private boolean rejouerPartie;

    public App21() {
        String reponse = "o";
        rejouerPartie = false;

        do {
            p = new Partie21();

            do {
                reponse = Util.lireString("Voulez-vous jouer une autre partie ? (o/n)");

                if (!(reponse.toLowerCase().equals("o") || reponse.toLowerCase().equals("n")))
                    System.out.println("Entrez un choix valide (on)");

            } while (!(reponse.toLowerCase().equals("o") || reponse.toLowerCase().equals("n")));

            rejouerPartie = (reponse.toLowerCase().equals("o") ? true : false);

        } while (rejouerPartie == true);

        System.out.println("Au revoir !");
    }

    public static void main(String[] args) {
        new App21();
    }
}
