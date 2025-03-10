import java.util.Scanner;

class AutomatCafea {
    private String stare;

    public AutomatCafea() {
        stare = "ALEGERE_BAUTURA";
    }

    public void selecteazaBautura(char bautura) {
        if (stare.equals("ALEGERE_BAUTURA")) {
            switch (bautura) {
                case 'C':
                    stare = "CAFE";
                    System.out.println("Ati ales cafeaua.");
                    break;
                case 'T':
                    stare = "CEAI";
                    System.out.println("Ati ales ceaiul.");
                    break;
                case 'A':
                    stare = "CAPPUCCINO";
                    System.out.println("Ati ales cappuccino-ul.");
                    break;
                case 'H':
                    stare = "CIOCOLATA_CALDA";
                    System.out.println("Ati ales ciocolata calda.");
                    break;
                default:
                    System.out.println("Nu exista aceasta optiune. Incercati din nou.");
            }
        } else {
            System.out.println("Confirmati alegerea inainte de alta selectie.");
        }
    }

    public void confirmaComanda() {
        if (!stare.equals("ALEGERE_BAUTURA")) {
            stare = "FINALIZAT";
            System.out.println("Comanda confirmata. Bautura e pregatita!");
        } else {
            System.out.println("Nu ati selectat nicio bautura.");
        }
    }

    public void reset() {
        if (stare.equals("FINALIZAT")) {
            stare = "ALEGERE_BAUTURA";
            System.out.println("Puteti face o noua alegere.");
        } else {
            System.out.println("Finalizati comanda curenta inainte de resetare.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AutomatCafea automat = new AutomatCafea();

        while (true) {
            System.out.println("\nAlegeti: C (Cafea), T (Ceai), A (Cappuccino), H (Ciocolata), 0 (Confirmare), R (Resetare), Q (Iesire)");
            char input = scanner.next().charAt(0);
            input = Character.toUpperCase(input);

            if (input == 'Q') {
                System.out.println("Iesire...");
                break;
            }

            switch (input) {
                case 'C': case 'T': case 'A': case 'H':
                    automat.selecteazaBautura(input);
                    break;
                case '0':
                    automat.confirmaComanda();
                    break;
                case 'R':
                    automat.reset();
                    break;
                default:
                    System.out.println("Optiune invalida.");
            }
        }
        scanner.close();
    }
}