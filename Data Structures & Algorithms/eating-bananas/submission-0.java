class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;

        int high = 0;
        for(int pile : piles) {
            high = Math.max(high, pile);
        }

        while(low <= high) {
            int mid = low + (high - low)/2;

            long time = 0;
            for(int pile : piles) {
               // time += Math.ceil((double) pile / mid);
               // ceil(pile/mid) = (pile + mid - 1) / mid;
               // This is due to adding just shy of another factor of mid 
               // so that it crosses the ceiling value and will return proper integer on division
               time += (pile + mid - 1) / mid;
            }

            // If the time is lesser or equal to h then it is valid
            if(time <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
