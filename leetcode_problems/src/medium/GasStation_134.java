package medium;

public class GasStation_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // First determine if there is a solution
        int[] arr = new int[gas.length];
        int total = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            arr[i] = diff;
            total += diff;
        }
        if (total < 0) {
            return -1;
        }

        // Find the starting point
        int currentGas = 0;
        int startIndex = 0;
        for (int i = 0; i < gas.length; i++) {
            currentGas += arr[i];
            if (currentGas < 0) {
                currentGas = 0;
                startIndex = i + 1;
            }
        }

        return startIndex;
    }
}
