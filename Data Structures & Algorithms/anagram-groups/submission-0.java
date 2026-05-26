class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       // Each word can be sorted and this can be the key. Whatever is matching to that key is an anagram
        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<String, List<String>> resultMap = new HashMap<String, List<String>>();

        for(int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);
            if(resultMap.containsKey(sortedWord)) {
                List<String> updatedList = resultMap.get(sortedWord);
                updatedList.add(strs[i]);
                resultMap.put(sortedWord, updatedList);
            } else {
                resultMap.put(sortedWord, new ArrayList<String>(List.of(strs[i])));
            }
        }

        for(List<String> list : resultMap.values()) {
            result.add(list);
        }

        return result; 
    }
}
