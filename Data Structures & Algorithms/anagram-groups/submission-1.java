class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       // Each word can be sorted and this can be the key. Whatever is matching to that key is an anagram
        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<String, List<String>> resultMap = new HashMap<String, List<String>>();

        for(int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            int[] freq = new int[26];
            for(char ch : charArray) {
                freq[ch - 'a']++;
            }

            String key = Arrays.toString(freq);

            if(resultMap.containsKey(key)) {
                List<String> updatedList = resultMap.get(key);
                updatedList.add(strs[i]);
            } else {
                resultMap.put(key, new ArrayList<String>(List.of(strs[i])));
            }
        }

        for(List<String> list : resultMap.values()) {
            result.add(list);
        }

        return result; 
    }
}
