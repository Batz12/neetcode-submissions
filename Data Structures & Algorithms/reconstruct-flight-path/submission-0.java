class Solution {
    public void dfs(String airport, Map<String, PriorityQueue<String>> graph, LinkedList<String> result) {
        PriorityQueue<String> minHeap = graph.get(airport);

        while(minHeap != null && !minHeap.isEmpty()) {
            dfs(minHeap.poll(), graph, result);
        }

        result.addFirst(airport);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<String, PriorityQueue<String>>(); 

        for(List<String> ticket : tickets) {
            graph.putIfAbsent(ticket.get(0), new PriorityQueue<String>());
            graph.get(ticket.get(0)).add(ticket.get(1));
        }

        LinkedList<String> result = new LinkedList<String>();

        dfs("JFK", graph, result);

        return result;
    }
}
