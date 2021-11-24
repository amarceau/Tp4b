import java.util.Locale;

public class Util {

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
