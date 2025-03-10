import java.util.Scanner;

class ParcareAutomata {
    private int locuriLibere;
    private int locuriOcupate;

    public ParcareAutomata(int totalLocuri) {
        this.locuriLibere = totalLocuri;
        this.locuriOcupate = 0;
    }

    public void parcheaza() {
        if (locuriLibere > 0) {
            locuriLibere--;
            locuriOcupate++;
            System.out.println("Masina parcata. Locuri libere ramase: " + locuriLibere);
        } else {
            System.out.println("Parcarea este plina!");
        }
    }

    public void pleaca() {
        if (locuriOcupate > 0) {
            locuriOcupate--;
            locuriLibere++;
            System.out.println("Masina a plecat. Locuri libere disponibile: " + locuriLibere);
        } else {
            System.out.println("Parcarea este deja goala!");
        }
    }

    public void afiseazaStare() {
        System.out.println("Locuri ocupate: " + locuriOcupate + ", Locuri libere: " + locuriLibere);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParcareAutomata parcare = new ParcareAutomata(5);

        while (true) {
            System.out.println("\nOptiuni: P (Parcare), L (Plecare), S (Stare), Q (Iesire)");
            char input = scanner.next().charAt(0);
            input = Character.toUpperCase(input);

            if (input == 'Q') {
                System.out.println("Iesire din sistemul de parcare...");
                break;
            }

            switch (input) {
                case 'P':
                    parcare.parcheaza();
                    break;
                case 'L':
                    parcare.pleaca();
                    break;
                case 'S':
                    parcare.afiseazaStare();
                    break;
                default:
                    System.out.println("Optiune invalida. Incercati din nou.");
            }
        }
        scanner.close();
    }
}
