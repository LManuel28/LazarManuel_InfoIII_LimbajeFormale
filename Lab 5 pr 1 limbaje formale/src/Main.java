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

    // Cheia va fi: "S0_0_1" pentru starea S0 cu intrare (0,1)
    private static final Map<String, Transition> transitionTable = new HashMap<>();
    private State currentState;

    public TrafficMealyTable() {
        this.currentState = State.S0;
        initTable();
    }

    private void initTable() {
        // Format: transitionTable.put("Stare_A_B", new Transition(UrmStare, Iesire));

        transitionTable.put("S0_0_0", new Transition(State.S0, 0));
        transitionTable.put("S0_0_1", new Transition(State.S1, 1));
        transitionTable.put("S0_1_0", new Transition(State.S0, 0));
        transitionTable.put("S0_1_1", new Transition(State.S1, 1));

        transitionTable.put("S1_0_0", new Transition(State.S1, 1));
        transitionTable.put("S1_0_1", new Transition(State.S1, 1));
        transitionTable.put("S1_1_0", new Transition(State.S0, 0));
        transitionTable.put("S1_1_1", new Transition(State.S0, 0));
    }

    public int transition(int A, int B) {
        String key = currentState.name() + "_" + A + "_" + B;
        Transition t = transitionTable.get(key);
        if (t != null) {
            currentState = t.nextState;
            return t.output;
        } else {
            throw new IllegalArgumentException("Intrare invalidă: " + key);
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
            System.out.println("Input: (" + input[0] + "," + input[1] + ") -> Output: " + output);
        }
    }
}
