import java.util.ArrayList;

public class Paquet {
    public ArrayList<Carte> cartes;

    public Paquet(boolean ordonne)  {
        Carte carte;

        cartes = new ArrayList<Carte>();

        for (int x = 1; x <= 13; x++) {
            for (int y = 1; y <= 4; y++) {
                carte = new Carte(x, Carte.COULEURS_VALIDES[y-1]);
                cartes.add(carte);
            }
        }

    }

    public int getNombreDeCartes() {
        return 52;
    }

    public Carte piger() {
        return new Carte(1, "coeur");
    }
}
