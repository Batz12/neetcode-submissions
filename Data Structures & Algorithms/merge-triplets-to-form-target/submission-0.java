class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] current = new int[target.length];

        for(int[] t : triplets) {
            if(t[0] > target[0] || 
            t[1] > target[1] || 
            t[2] > target[2]) {
                continue;
            }

            current[0] = Math.max(current[0], t[0]);
            current[1] = Math.max(current[1], t[1]);
            current[2] = Math.max(current[2], t[2]);
        }

        return current[0] == target[0] && current[1] == target[1] && current[2] == target[2];
     }
}
