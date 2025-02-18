import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//ex1
/*
class Operatii_string {
    public static String concatenare(String s1, String s2) {
        return s1 + s2;
    }

    public static String inversare(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static String substituire(String s, char a, char b) {
        return s.replace(a, b);
    }

    public static int lungime(String s) {
        return s.length();
    }

    public static void main(String[] args) {
        String[] alfabet_a = {"a", "b", "c"};
        String[] alfabet_b = {"x", "y", "z"};
        String[] alfabet_c = {"1", "2", "3"};

        String s1 = "abc";
        String s2 = "xyz";

        System.out.println("Concatenare: " + concatenare(s1, s2));
        System.out.println("Inversare: " + inversare(s1));
        System.out.println("Substituire: " + substituire(s1, 'a', 'x'));
        System.out.println("Lungime: " + lungime(s1));
    }
}
*/
//ex2
/*
class operatii_limbaj_formal {
    public static String concatenare(String s1, String s2) {
        return s1 + s2;
    }

    public static String repetare(String s, int n) {
        return s.repeat(n);
    }

    public static String inversare(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static String extragere(String s, int i, int j) {
        return s.substring(i, j + 1);
    }

    public static String inlocuire(String s, String sub, String nou_sub) {
        return s.replace(sub, nou_sub);
    }

    public static void main(String[] args) {
        String[] alfabet_1 = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] alfabet_2 = {"a", "b", "c", "d", "e", "f", "g", "i", "j", "k"};
        String[] alfabet_3 = {"x1", "y1", "x2", "y2", "x3", "y3", "x4", "y4", "x5", "y5"};

        String s1 = "abc123";
        String s2 = "xyz456";

        System.out.println("Concatenare: " + concatenare(s1, s2));
        System.out.println("Repetare: " + repetare(s1, 2));
        System.out.println("Inversare: " + inversare(s1));
        System.out.println("Extragere: " + extragere(s1, 1, 3));
        System.out.println("Înlocuire: " + inlocuire(s1, "abc", "XYZ"));
    }
}
*/
//ex3
/*
class generare_palindroame {
    static char[] alfabet = {'0', '1', '2'};

    // Verificare palindrom
    public static boolean este_palindrom(String s) {
        int stanga = 0, dreapta = s.length() - 1;
        while (stanga < dreapta) {
            if (s.charAt(stanga) != s.charAt(dreapta)) {
                return false;
            }
            stanga++;
            dreapta--;
        }
        return true;
    }

    // Generarea palindroamelor de la 1 la 5
    public static List<String> genereaza_palindroame(int lungime) {
        List<String> rezultat = new ArrayList<>();
        int max = (int) Math.pow(alfabet.length, lungime);

        for (int i = 0; i < max; i++) {
            StringBuilder s = new StringBuilder();
            int num = i;

            // Construim un sir
            for (int j = 0; j < lungime; j++) {
                s.append(alfabet[num % alfabet.length]);
                num /= alfabet.length;
            }

            // Verificare palindrom
            if (este_palindrom(s.toString())) {
                rezultat.add(s.toString());
            }
        }
        return rezultat;
    }

    public static void main(String[] args) {
        for (int lungime = 1; lungime <= 5; lungime++) {
            List<String> palindroame = genereaza_palindroame(lungime);
            System.out.println("Palindroame de lungime " + lungime + ": " + palindroame);
        }
    }
}
*/
//ex4

class generare_cuvinte_gramatica {
    public static void genereaza_cuvinte(String parte_a, String parte_b, Set<String> cuvinte) {
        cuvinte.add(parte_a + parte_b);

        if (parte_a.length() < 4) genereaza_cuvinte(parte_a + "a", parte_b, cuvinte);
        if (parte_b.length() < 4) genereaza_cuvinte(parte_a, parte_b + "b", cuvinte);
    }

    public static void main(String[] args) {
        Set<String> cuvinte = new HashSet<>();
        genereaza_cuvinte("", "", cuvinte);

        System.out.println("Cuvintele generate: " + cuvinte);
    }
}
