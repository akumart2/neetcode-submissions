class TimeMap {
    public record KeyValuePair<K, V>(K key, V value) {} // After java 14
    private HashMap<String, List<KeyValuePair<Integer, String>>> keyStore;
    public TimeMap() {
        keyStore = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!keyStore.containsKey(key))
            keyStore.put(key, new ArrayList<>());
        
        keyStore.get(key).add(new KeyValuePair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<KeyValuePair<Integer, String>> values = keyStore.getOrDefault(key, new ArrayList<>());
        int start = 0, end = values.size() - 1;
        String result = "";
        while (start <= end) {
            int mid = (start + end) / 2;
            if (values.get(mid).key() <= timestamp) {
                result = values.get(mid).value();
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return result;
    }
}
