import paquet.Util;

public class Testeur {

    public Testeur() {
        testerTrouverStr();
    }

    private void testerTrouverStr() {
        String[] tVide = {};
        String[] t1 = {"chat", "Chien", "Grizzly", "chat", "Panda", ""};

        System.out.println("testerTrouverStr()");
        System.out.println(Util.trouverStr("", tVide) == -1);
        System.out.println(Util.trouverStr("lion", tVide) == -1);
        System.out.println(Util.trouverStr("", t1) == 5);
        System.out.println(Util.trouverStr("Chien", t1) == 1);
        System.out.println(Util.trouverStr("Chienne", t1) == -1);
        System.out.println(Util.trouverStr("ChiEn", t1) == 1);
        System.out.println(Util.trouverStr("chat", t1) == 0);
    }

    public static void main(String[] args) {
        new Testeur();
    }
}
