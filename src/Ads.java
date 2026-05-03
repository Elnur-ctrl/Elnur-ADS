// Task 1 – DFS
// Traversal order: A → C → B → E → G → F → D

import java.util.*;

public class ADS {
    private Map<String, List<String>> graph = new HashMap<>();
    private Set<String> visited = new HashSet<>();

    public ADS() {
        graph.put("A", Arrays.asList("C","B","D"));
        graph.put("B", Arrays.asList("A","C","E","G"));
        graph.put("C", Arrays.asList("A","B","D"));
        graph.put("D", Arrays.asList("C","A"));
        graph.put("E", Arrays.asList("G","F","B"));
        graph.put("F", Arrays.asList("G","E"));
        graph.put("G", Arrays.asList("F","B"));
    }

    public void dfs(String node) {
        if (visited.contains(node)) return;
        visited.add(node);
        System.out.print(node + " ");
        for (String neighbor : graph.get(node)) {
            dfs(neighbor);
        }
    }

    public static void main(String[] args) {
        ADS d = new ADS();
        d.dfs("A");
    }
}




// Task 2 – BFS
// Traversal order: A → C → B → D → E → G → F

import java.util.*;

public class ADS {
    private Map<String, List<String>> graph = new HashMap<>();

    public ADS() {
        graph.put("A", Arrays.asList("C","B","D"));
        graph.put("B", Arrays.asList("A","C","E","G"));
        graph.put("C", Arrays.asList("A","B","D"));
        graph.put("D", Arrays.asList("C","A"));
        graph.put("E", Arrays.asList("G","F","B"));
        graph.put("F", Arrays.asList("G","E"));
        graph.put("G", Arrays.asList("F","B"));
    }

    public void bfs(String start) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String node = queue.poll();
            System.out.print(node + " ");
            for (String neighbor : graph.get(node)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        ADS b = new ADS();
        b.bfs("A");
    }
}






// Task 3 – Comparison
// DFS program output matches Task 1 order.
// BFS program output matches Task 2 order.





// Task 4 – Shortest Path (Edinburgh → Dundee)
// Using Dijkstra’s algorithm, the shortest path is Edinburgh → Perth → Dundee





// Task 5 – Dijkstra Implementation

import java.util.*;

public class ADS {
    private Map<String, Map<String, Integer>> graph = new HashMap<>();

    public ADS() {
        graph.put("Edinburgh", Map.of("Perth", 45, "Glasgow", 50));
        graph.put("Perth", Map.of("Edinburgh", 45, "Dundee", 25));
        graph.put("Glasgow", Map.of("Edinburgh", 50, "Dundee", 70));
        graph.put("Dundee", Map.of("Perth", 25, "Glasgow", 70));
    }

    public void dijkstra(String start, String target) {
        Map<String, Integer> dist = new HashMap<>();
        Map<String, String> prev = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(dist::get));

        for (String v : graph.keySet()) {
            dist.put(v, Integer.MAX_VALUE);
            prev.put(v, null);
        }
        dist.put(start, 0);
        pq.add(start);

        while (!pq.isEmpty()) {
            String u = pq.poll();
            for (Map.Entry<String, Integer> e : graph.get(u).entrySet()) {
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
        System.out.println("Shortest path: " + path);
        System.out.println("Distance: " + dist.get(target));
    }

    public static void main(String[] args) {
        ADS d = new ADS();
        d.dijkstra("Edinburgh", "Dundee");
    }
}

