import java.util.Scanner;

class AutomatFinit {
    enum Stare {
        Q0, Q1, Q2, Q3
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Ex1
        System.out.println("Introduceti un sir de caractere pentru automatul general:");
        String inputGeneral = scanner.nextLine();
        if (automatGeneral(inputGeneral)) {
            System.out.println("Cuvant acceptat de automatul general!");
        } else {
            System.out.println("Cuvant respins de automatul general!");
        }

        //Ex2
        System.out.println("Introduceti un sir de caractere pentru verificarea subsirului 'cat':");
        String inputCat = scanner.nextLine();
        if (verificaAutomat(inputCat)) {
            System.out.println("Cuvantul a fost gasit!");
        } else {
            System.out.println("Cuvantul nu a fost gasit!");
        }
        //Tabel ex1
        System.out.println("\nTabelul de tranzitie pentru automatul general:");
        System.out.println("Stare curenta | Caracter citit | Stare urmatoare");
        System.out.println("Q0            | 'a'            | Q1");
        System.out.println("Q0            | altceva        | Q0");
        System.out.println("Q1            | 'b'            | Q2");
        System.out.println("Q1            | altceva        | Q0");
        System.out.println("Q2            | 'c'            | Q3");
        System.out.println("Q2            | altceva        | Q0");

        //Tabel ex2
        System.out.println("\nTabelul de tranzitie pentru automatul 'cat':");
        System.out.println("Stare curenta | Caracter citit | Stare urmatoare");
        System.out.println("Q0            | 'c'           | Q1");
        System.out.println("Q0            | altceva       | Q0");
        System.out.println("Q1            | 'a'           | Q2");
        System.out.println("Q1            | 'c'           | Q1");
        System.out.println("Q1            | altceva       | Q0");
        System.out.println("Q2            | 't'           | Q3");
        System.out.println("Q2            | 'c'           | Q1");
        System.out.println("Q2            | altceva       | Q0");
    }


    //Ex1
    public static boolean automatGeneral(String input) {
        Stare stareCurenta = Stare.Q0;

        for (char c : input.toCharArray()) {
            switch (stareCurenta) {
                case Q0:
                    if (c == 'a') {
                        stareCurenta = Stare.Q1;
                    }
                    break;
                case Q1:
                    if (c == 'b') {
                        stareCurenta = Stare.Q2;
                    } else {
                        stareCurenta = Stare.Q0;
                    }
                    break;
                case Q2:
                    if (c == 'c') {
                        stareCurenta = Stare.Q3;
                    } else {
                        stareCurenta = Stare.Q0;
                    }
                    break;
                case Q3:
                    return true;
            }
        }

        return stareCurenta == Stare.Q3;
    }

    //Ex2
    public static boolean verificaAutomat(String input) {
        Stare stareCurenta = Stare.Q0;

        for (char c : input.toCharArray()) {
            switch (stareCurenta) {
                case Q0:
                    if (c == 'c') {
                        stareCurenta = Stare.Q1;
                    }
                    break;

                case Q1:
                    if (c == 'a') {
                        stareCurenta = Stare.Q2;
                    } else if (c == 'c') {
                        stareCurenta = Stare.Q1;
                    } else {
                        stareCurenta = Stare.Q0;
                    }
                    break;

                case Q2:
                    if (c == 't') {
                        stareCurenta = Stare.Q3;
                    } else if (c == 'c') {
                        stareCurenta = Stare.Q1;
                    } else {
                        stareCurenta = Stare.Q0;
                    }
                    break;

                case Q3:
                    return true;
            }
        }

        return stareCurenta == Stare.Q3;
    }
}
