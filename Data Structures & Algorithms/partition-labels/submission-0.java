class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<Integer>();
        HashMap<Character, Integer> lastIndexMap = new HashMap<Character, Integer>();

        for(int i = 0; i < s.length(); i++) {
            lastIndexMap.put(s.charAt(i), i);
        }

        int start = 0;
        int end = 0;

        for(int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIndexMap.get(s.charAt(i)));

            if(i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }

        return result;
    }
}
