import java.util.HashMap;
import java.util.Map;

class TrafficMealyTable {

    enum State {
        S0, S1
    }

    static class Transition {
        State nextState;
        int output;

        Transition(State nextState, int output) {
            this.nextState = nextState;
            this.output = output;
        }
    }

    private static final Map<String, Transition> transitionTable = new HashMap<>();
    private State currentState;

    public TrafficMealyTable() {
        this.currentState = State.S0;
        initTable();
        printTable();
    }

    private void initTable() {
        transitionTable.put("S0_0_0", new Transition(State.S0, 0));
        transitionTable.put("S0_0_1", new Transition(State.S1, 1));
        transitionTable.put("S0_1_0", new Transition(State.S0, 0));
        transitionTable.put("S0_1_1", new Transition(State.S1, 1));
        transitionTable.put("S1_0_0", new Transition(State.S1, 1));
        transitionTable.put("S1_0_1", new Transition(State.S1, 1));
        transitionTable.put("S1_1_0", new Transition(State.S0, 0));
        transitionTable.put("S1_1_1", new Transition(State.S0, 0));
    }

    private void printTable() {
        System.out.println("Tabela de Tranzitii:");
        System.out.println("Stare | Intrare | Urmatoare | Iesire");
        System.out.println("-------------------------------");

        for (Map.Entry<String, Transition> entry : transitionTable.entrySet()) {
            String key = entry.getKey();
            Transition t = entry.getValue();

            String[] parts = key.split("_");
            String state = parts[0];
            String A = parts[1];
            String B = parts[2];

            System.out.printf("%5s |   (%s,%s)  | %9s |   %d\n",
                    state, A, B, t.nextState, t.output);
        }

        System.out.println();
    }

    public int transition(int A, int B) {
        String key = currentState.name() + "_" + A + "_" + B;
        Transition t = transitionTable.get(key);
        if (t != null) {
            System.out.printf("Din %s cu (%d,%d) -> %s, iesire: %d\n",
                    currentState, A, B, t.nextState, t.output);
            currentState = t.nextState;
            return t.output;
        } else {
            throw new IllegalArgumentException("Cheie invalida: " + key);
        }
    }

    public static void main(String[] args) {
        TrafficMealyTable controller = new TrafficMealyTable();

        int[][] inputs = {
                {0, 0},
                {0, 1},
                {1, 1},
                {1, 0},
                {0, 0}
        };

        for (int[] input : inputs) {
            int output = controller.transition(input[0], input[1]);
            System.out.println("Output: " + output + "\n");
        }
    }
}
