import paquet.Carte;
import paquet.Paquet;

import java.util.ArrayList;

public class Main21 {
    private ArrayList<Carte> mainDe21;
    private Paquet paquet;

    public Main21(Paquet paquet, int nbCarte) {
        this.paquet = paquet;

        this.mainDe21 = new ArrayList<Carte>();

        for (int x = 0; x < nbCarte; x++)
           pigerAu21();

    }

    public void pigerAu21() {
        Carte carte;
        carte = paquet.piger();

        mainDe21.add(carte);
    }

    public int getNbCartesDsMain() {
        return mainDe21.size();
    }

    public int getValeurCarte21(Carte carte) {
        int carteValeur;
        carteValeur = carte.getValeur();

        if (carteValeur == 1)
            return 11;
        else if (carteValeur > 10)
            return 10;
        else
            return carteValeur;
    }

    public int getValeurMainDe21() {
        int valeurTotale;

        valeurTotale = 0;

        for (int x = 0; x < mainDe21.size(); x++)
            valeurTotale += getValeurCarte21(mainDe21.get(x));

        return valeurTotale;

    }

    public boolean main21Gagnante() {
        return (getValeurMainDe21() == 21 ? true : false);
    }

    public boolean main21Perdante() {
        return (getValeurMainDe21() > 21 ? true : false);
    }

    public boolean main21GagnanteOuPerdante() {
        return (main21Gagnante() || main21Perdante() ? true : false);
    }

    public String getStrMain() {
        String retour = "";

        for (int x = 0; x < mainDe21.size(); x++)
            retour += +(x + 1) + " - " + mainDe21.get(x).getValeur() + " de " + mainDe21.get(x).getCouleur() + " (" + mainDe21.get(x).getCharCarte() + ")\n";

        return retour;
    }

    @Override
    public String toString() {
        String retour = "";
        String commentaire;

        retour = getStrMain();

        if (getValeurMainDe21() <= 21)
            commentaire = (21 - getValeurMainDe21()) + " pour dépasser.";
        else
            commentaire = " 21 est dépassé";

        retour += "valeur du jeu 21 : " + getValeurMainDe21() + " -> " + commentaire + "\n";

        return retour;
    }
}
