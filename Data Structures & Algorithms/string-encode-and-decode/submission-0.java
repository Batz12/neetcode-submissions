class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String str: strs) {
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<String>();

        int currentIndex = 0;

        while(currentIndex < str.length()) {
            int endIndex = currentIndex;

            while(str.charAt(endIndex) != '#') {
                endIndex++;
            }

            String lengthString = str.substring(currentIndex, endIndex);

            endIndex++;

            int length = Integer.parseInt(lengthString);

            result.add(str.substring(endIndex, endIndex + length));

            currentIndex = (endIndex + length);
        }

        return result;
    }
}
