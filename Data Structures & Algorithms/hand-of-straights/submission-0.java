class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        HashMap<Integer, Integer> freqTable = new HashMap<Integer, Integer>();

        if((hand.length % groupSize) != 0) {
            return false;
        }

        for(int i = 0; i < hand.length; i++) {
            freqTable.putIfAbsent(hand[i], 0);
            freqTable.put(hand[i], freqTable.get(hand[i]) + 1);
        }

        Arrays.sort(hand);

        for(int i = 0; i < hand.length; i++) {
            if(freqTable.get(hand[i]) == 0) {
                continue;
            }

            for(int j = 0; j < groupSize; j++) {
                int card = hand[i] + j;

                if(freqTable.getOrDefault(card, 0) == 0) {
                    return false;
                }

                freqTable.put(card, freqTable.get(card) - 1);
            }
        }

        return true;
    }
}
