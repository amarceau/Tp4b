public class Carte {
    public static final String[] COULEURS_VALIDES = {"pique", "trèfle", "carreau", "coeur"};
    public static final char[] COULEURS_CAR = {'\u2660', '\u2663', '\u2666', '\u2764'};

    private int valeur;
    private String couleur;
    private char charCarte;

    public Carte(int valeur, String couleur) {
        setValeur(valeur);
        setCouleur(couleur);
    }

    public int getValeur() {
        return this.valeur;
    }

    public void setValeur(int valeur) {
        if (Carte.valeurEstValide(valeur) == true)
            this.valeur = valeur;
        else
            throw new IllegalArgumentException();
    }

    public String getCouleur() {
        return this.couleur.toLowerCase();
    }

    public void setCouleur(String couleur) {
        if (Carte.couleurEstValide(couleur) == true) {
            this.couleur = couleur;
            this.charCarte = getCharCarte(couleur);
        }
        else
            throw new IllegalArgumentException();
    }

    public static boolean couleurEstValide(String couleur) {
        if (Util.trouverStr(couleur, COULEURS_VALIDES) >= 0)
            return true;
        else
            return false;
    }

    public static boolean valeurEstValide(int valeur) {
        if (valeur >= 1 && valeur <= 13)
            return true;
        else
            return false;
    }
    private char getCharCarte(String couleur) {
        return COULEURS_CAR[Util.trouverStr(couleur, COULEURS_VALIDES)];
    }

    @Override
    public String toString() {
        return (valeur + " de " + getCouleur() + " (" + charCarte + ")");
    }

    public static void main(String[] args) {

    }

}
