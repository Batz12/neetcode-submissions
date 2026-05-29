class TimeMap {
    public class ValueInfo {
        String value;
        int timestamp;

        public ValueInfo(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    public HashMap<String, List<ValueInfo>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<String, List<ValueInfo>>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.putIfAbsent(key, new ArrayList<ValueInfo>());
        timeMap.get(key).add(new ValueInfo(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!timeMap.containsKey(key)) {
            return "";
        }

         List<ValueInfo> values = timeMap.get(key);

         int low = 0;
         int high = values.size() - 1;
         String result = "";

         while(low <= high) {
            int mid = low + (high - low)/2;

            if(values.get(mid).timestamp <= timestamp) {
                result = values.get(mid).value;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
         }

         return result;
    }
}
