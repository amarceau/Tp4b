package paquet;

import utilitaire.Util;

import java.util.Objects;

/*
420-201 – TP4b
Groupe : 2 – mardi & jeudi
Nom : Marceau
Prénom : Jérémy
DA : 2140653
 */

public class Carte {

    public static final String[] COULEURS_VALIDES = {"pique", "trèfle", "carreau", "coeur"};
    public static final char[] COULEURS_CAR = {'\u2660', '\u2663', '\u2666', '\u2764'};

    public Carte(int valeur, String couleur) {
        setValeur(valeur);
        setCouleur(couleur);
    }

    private int valeur;
    private String couleur;

    private int indiceCouleur;


    public int getValeur() {
        return this.valeur;
    }

    public void setValeur(int valeur) {
        if (valeurEstValide(valeur) == true)
            this.valeur = valeur;
        else
            throw new IllegalArgumentException();
    }

    public String getCouleur() {
        return this.couleur.toLowerCase();
    }

    public void setCouleur(String couleur) {
        this.indiceCouleur = Util.trouverStr(couleur.toLowerCase(), COULEURS_VALIDES);
        if (this.indiceCouleur >= 0)
            this.couleur = couleur;
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

    public char getCharCarte() {
        return COULEURS_CAR[this.indiceCouleur];
    }

    @Override
    public String toString() {
        String retour;

        retour = this.valeur + " de " + this.couleur + " (" + getCharCarte() + ")";
        return retour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carte carte = (Carte) o;
        return this.valeur == carte.valeur && indiceCouleur == carte.indiceCouleur && Objects.equals(couleur, carte.couleur);
    }

    public static void main(String[] args) {

    }


}
