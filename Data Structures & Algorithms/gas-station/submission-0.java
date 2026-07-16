class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int gasSum = 0;
        int costSum = 0;

        for(int i = 0; i < n; i++) {
            gasSum += gas[i];
        }

        for(int j = 0; j < n; j++) {
            costSum += cost[j];
        }

        if(gasSum < costSum) {
            return -1;
        }

        int index = 0;
        int total = 0;

        for(int i = 0; i < n; i++) {
            total += (gas[i] - cost[i]);

            if(total < 0) {
                total = 0;
                index = i + 1;
            }
        }

        return index;
    }
}
