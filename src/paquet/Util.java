package paquet;/*
420-201 – TP4b
Groupe : 2 – mardi & jeudi
Nom : Marceau
Prénom : Jérémy
DA : 2140653
 */
import java.util.Random;
import java.util.Scanner;

public class Util {

    //F5
    public static String getLigneDeCaracteres(int nombreCaracteres, char caractere) {
        String retour;

        retour = "";

        for (int x = 1; x <= nombreCaracteres; x++)
            retour = retour + caractere;

        return retour;
    }

    public static String lireString(String question) {
        System.out.println(question);
        Scanner sc;
        sc = new Scanner(System.in);

        String reponse = sc.nextLine();

        return reponse;
    }

    //F6
    public static int getNbValeursPositives(int tE[]) {
        int nbValeursPositives;

        nbValeursPositives = 0;

        for (int i = 0; i < tE.length; i++) {
            if (tE[i] >= 0)
                nbValeursPositives++;
        }

        return nbValeursPositives;
    }

    public static int trouverIndice(int tE[], int nombre) {

        for (int i = 0; i < tE.length; i++) {
            if (tE[i] == nombre)
                return i;
        }

        return -1;
    }

    public static void remplacerValeur(int tE[], int ancienneVal, int nouvelleVal) {

        for (int i = 0; i < tE.length; i++) {
            if (tE[i] == ancienneVal)
                tE[i] = nouvelleVal;
        }
    }

    public static int[] sortirLesNombresPositifs (int t1[]) {
        int t2[];
        int j;
        int compteurPositif;

        j=0;
        compteurPositif = 0;

        for (int i = 0; i < t1.length; i++) {
            if (t1[i] >= 0) {
                compteurPositif++;
            }
        }

        t2 = new int[compteurPositif];

        for (int i = 0; i < t1.length; i++) {
            if (t1[i] >= 0) {
                t2[j] = t1[i];
                j++;
            }
        }

        return t2;
    }

    public static int lireEntier(String question) {
        System.out.println(question);
        Scanner sc;
        sc = new Scanner(System.in);

        int entier = Integer.parseInt(sc.nextLine());

        return entier;
    }

    public static boolean estProche(double x1, double y1, double x2, double y2, double valeur) {
        boolean estProche;
        double distance;

        distance = calculerDistance(x1, y1, x2, y2);

        if (distance <= valeur)
            estProche = true;
        else
            estProche = false;

        return estProche;
    }

    public static double calculerDistance(double x1, double y1, double x2, double y2) {
        double distance;

        distance = Math.sqrt((Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));

        return distance;
    }

    //TP3
    public static boolean tousInferieursAuSuivant(int t1[]) {

        for (int i = 0; i < t1.length - 1; i++) {
            if (t1[i] > t1[i + 1])
                return false;
        }

        return true;
    }

    public static boolean estEnOrdreCroissant(int t1[]) {
        boolean valRetour;

        if (t1.length == 0 || t1.length == 1 || tousInferieursAuSuivant(t1) == true)
            valRetour = true;
        else
            valRetour = false;

        return valRetour;
    }

    public static boolean estVoyelle(char c) {
        char tVoyelles[] = {'a', 'e', 'i', 'o', 'u', 'y'};

        for (int i = 0; i < tVoyelles.length; i++) {
            if (c == tVoyelles[i] || c == Character.toUpperCase(tVoyelles[i]))
                return true;
        }

        return false;
    }

    public static int compterVoyelles(String chDeCar) {
        int compteur;

        compteur = 0;

        for (int i = 0; i < chDeCar.length(); i++) {
            if (estVoyelle(chDeCar.charAt(i)) == true)
                compteur++;
        }

        return compteur;
    }

    public static boolean sontDesTableauxEgaux(int tE1[], int tE2[]) {

        if (tE1.length == tE2.length) {
            for (int i = 0; i < tE1.length; i++) {
                if (tE1[i] != tE2[i])
                    return false;
            }
        } else
            return false;

        return true;
    }

    public static int[] tronquerTableau(int tE[], int quantite) {
        int tS[];
        tS = new int[quantite];

        for (int i = 0; i < quantite; i++) {
            tS[i] = tE[i];
        }

        return tS;
    }



    //F7
    public static boolean estRayonValide(double rayon) {
        if (rayon < 0)
            return false;
        else
            return true;
    }

    //TP4a

    //TP4b
    public static int trouverStr(String str1, String[] tabStr) {
        int indice;

        indice = -1;

        for (int x = 0; x < tabStr.length; x++) {
            if (str1.toUpperCase().equals(tabStr[x].toUpperCase())) {
                indice = x;
                break;
            }
        }

        return indice;

    }

}