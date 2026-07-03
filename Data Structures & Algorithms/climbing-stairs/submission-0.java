class Solution {

    public int climb(HashMap<Integer, Integer> cache, int i, int n) {
        if(i == n) {
            return 1;
        }

        if(i > n) {
            return 0;
        }

        if(cache.containsKey(i)) {
            return cache.get(i);
        }

        int ways = climb(cache, i + 1, n) + climb(cache, i + 2, n);

        cache.put(i, ways);

        return ways;
    }

    public int climbStairs(int n) {
        HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
        
        return climb(cache, 0, n);
    }
}
