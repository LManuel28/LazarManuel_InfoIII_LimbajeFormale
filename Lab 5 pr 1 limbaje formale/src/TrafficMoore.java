public class TrafficMoore {
    enum State {
        M0, M1
    }

    private State currentState;

    public TrafficMoore() {
        this.currentState = State.M0;
    }

    public int transition(int A, int B) {
        switch (currentState) {
            case M0:
                if ((A == 0 && B == 1) || (A == 1 && B == 1)) {
                    currentState = State.M1;
                }
                break;

            case M1:
                if ((A == 1 && B == 0) || (A == 1 && B == 1)) {
                    currentState = State.M0;
                }
                break;
        }

        // Ieșirea în Moore este dată de starea curentă
        return (currentState == State.M0) ? 0 : 1;
    }

    public static void main(String[] args) {
        TrafficMoore controller = new TrafficMoore();

        int[][] inputs = {
                {0, 0}, {0, 1}, {1, 1}, {1, 0}, {0, 0}
        };

        for (int[] input : inputs) {
            int output = controller.transition(input[0], input[1]);
            System.out.println("Input: (" + input[0] + "," + input[1] + ") -> Output: " + output);
        }
    }
}
