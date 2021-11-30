import java.util.ArrayList;
import java.util.Random;

public class Paquet {
    private ArrayList<Carte> paquet;

    private Carte carte;

    private int cartesRestantes;

    public Paquet() {

    }

    public Paquet(boolean melange) {

        remplirPaquet();

        cartesRestantes = paquet.size();

        if (melange == true)
            melanger();

    }

    public boolean estVide() {
        if (paquet.isEmpty())
            return false;
        else
            return true;
    }

    private void melanger(){
        Random rdm = new Random();

        for (int x = 0; x < 52; x++) {
            permuter(x, rdm.nextInt(52));
        }

    }

    private void permuter(int i, int j){
        ArrayList<Carte> paquetTemp = new ArrayList<Carte>();
        paquetTemp.add(paquet.get(i));
        paquetTemp.add(paquet.get(j));
        paquet.set(i, paquetTemp.get(1));
        paquet.set(j, paquetTemp.get(0));
    }

    public Carte piger() {
        int indice;
        Carte carte = null;

        if (cartesRestantes == 0)
            return null;

        else if (cartesRestantes > 1)
            indice = Util.getNombreAleatoireEntreBorne(0, cartesRestantes - 1);
        else
            indice = 0;

        carte = paquet.get(indice);

        paquet.remove(indice);

        cartesRestantes = cartesRestantes - 1;

        return carte;
    }

    private void remplirPaquet() {
        paquet = new ArrayList<Carte>();

        for (int x = 1; x <= 13; x++) {
            for (int y = 1; y <= 4; y++) {
                carte = new Carte(x, Carte.COULEURS_VALIDES[y-1]);
                paquet.add(carte);
            }
        }
    }

    public int getNombreDeCartes() {
        return paquet.size();
    }

    @Override
    public String toString() {
        String retour = "";
        Carte carte;

        for (int x = 0; x < 52; x++) {
            carte = paquet.get(x);
            retour = retour + carte.toString();
        }

        return retour;
    }
}
