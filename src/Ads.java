// Task 1 – DFS
// Traversal order: A → C → B → E → G → F → D
// Task 2 – BFS
// Traversal order: A → C → B → D → E → G → F
// Task 4 – Shortest Path (Edinburgh → Dundee)
// Shortest path: Edinburgh → Perth → Dundee

import java.util.*;

public class Ads {
    private Map<String, List<String>> graph = new HashMap<>();
    private Set<String> visited = new HashSet<>();

    public Ads() {
        graph.put("A", Arrays.asList("C","B","D"));
        graph.put("B", Arrays.asList("A","C","E","G"));
        graph.put("C", Arrays.asList("A","B","D"));
        graph.put("D", Arrays.asList("C","A"));
        graph.put("E", Arrays.asList("G","F","B"));
        graph.put("F", Arrays.asList("G","E"));
        graph.put("G", Arrays.asList("F","B"));
    }

    // DFS
    public void dfs(String node) {
        if (visited.contains(node)) return;
        visited.add(node);
        System.out.print(node + " ");
        for (String neighbor : graph.get(node)) {
            dfs(neighbor);
        }
    }

    // BFS
    public void bfs(String start) {
        Set<String> visitedBfs = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        visitedBfs.add(start);

        while (!queue.isEmpty()) {
            String node = queue.poll();
            System.out.print(node + " ");
            for (String neighbor : graph.get(node)) {
                if (!visitedBfs.contains(neighbor)) {
                    visitedBfs.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    // Dijkstra
    public void dijkstra(String start, String target) {
        Map<String, Map<String, Integer>> weightedGraph = new HashMap<>();
        weightedGraph.put("Edinburgh", Map.of("Perth", 45, "Glasgow", 50));
        weightedGraph.put("Perth", Map.of("Edinburgh", 45, "Dundee", 25));
        weightedGraph.put("Glasgow", Map.of("Edinburgh", 50, "Dundee", 70));
        weightedGraph.put("Dundee", Map.of("Perth", 25, "Glasgow", 70));

        Map<String, Integer> dist = new HashMap<>();
        Map<String, String> prev = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(dist::get));

        for (String v : weightedGraph.keySet()) {
            dist.put(v, Integer.MAX_VALUE);
            prev.put(v, null);
        }
        dist.put(start, 0);
        pq.add(start);

        while (!pq.isEmpty()) {
            String u = pq.poll();
            for (Map.Entry<String, Integer> e : weightedGraph.get(u).entrySet()) {
                String v = e.getKey();
                int alt = dist.get(u) + e.getValue();
                if (alt < dist.get(v)) {
                    dist.put(v, alt);
                    prev.put(v, u);
                    pq.add(v);
                }
            }
        }

        List<String> path = new ArrayList<>();
        for (String at = target; at != null; at = prev.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        System.out.println("\nShortest path: " + path);
        System.out.println("Distance: " + dist.get(target));
    }

    public static void main(String[] args) {
        Ads ads = new Ads();

        System.out.println("DFS:");
        ads.dfs("A");

        System.out.println("\n\nBFS:");
        ads.bfs("A");

        System.out.println("\n\nDijkstra:");
        ads.dijkstra("Edinburgh", "Dundee");
    }
}
