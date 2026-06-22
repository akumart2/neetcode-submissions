class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        /*
        The key point in solving this problem is that if the total amount of gas is greater than or eaqul to costs, then even if gas runs out midway, starting from a different location will allow a full circuit.
        */

        int totalGas = 0, totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if (totalGas >= totalCost) {
            // This ensures the solution exists and it is given that the solution is unique.
            // So we can simply start iterating over the array to find from which index we
            // reach end without loosing the gas.
            int currentGas = 0;
            int start = 0;
            for (int i = 0; i < gas.length - 1; i++) {
                currentGas += gas[i];
                if (currentGas < cost[i]) {
                    start = i + 1;
                    currentGas = 0;
                }
                else {
                    currentGas -= cost[i];
                }
            }

            return start;
        }

        return -1;
    }
}