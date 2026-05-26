class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqTable = new HashMap<Integer, Integer>();
        List<Integer>[] bucketList = new ArrayList[nums.length + 1];

        for(int num : nums) {
            freqTable.putIfAbsent(num, 0);
            freqTable.put(num, freqTable.get(num) + 1);
        }

        for(int num : freqTable.keySet()) {
            int freq = freqTable.get(num);

            if(bucketList[freq] == null) {
                bucketList[freq] = new ArrayList<Integer>();
            }

            bucketList[freq].add(num);
        }

        int[] result = new int[k];
        int resultIndex = 0;

        for(int i = bucketList.length - 1; i >=0; i--) {
            if(bucketList[i] != null) {
                for(int j = 0; j < bucketList[i].size(); j++) {
                    result[resultIndex] = bucketList[i].get(j);
                    resultIndex++;

                    if(resultIndex == k) {
                        return result;
                    }
                }
                
            } 
        }

        return result;
    }
}
