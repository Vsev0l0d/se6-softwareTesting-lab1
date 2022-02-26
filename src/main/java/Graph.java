import java.util.*;

public class Graph {
    private List<Integer>[] graph;
    private Integer edgeCount;

    public Graph(int v) {
        edgeCount = v;
        graph = new LinkedList[edgeCount];
        for (int i = 0; i < graph.length; i++)
            graph[i] = new LinkedList<>();
    }

    void addEdge(int a, int b) {
        graph[a].add(b);
    }

    Integer[] DFS(Integer node) {
        if (graph.length == 0 || node > graph.length) return null;

        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[edgeCount];
        Queue<Integer> queue = new PriorityQueue<>();

        queue.add(node);

        int current;
        while (queue.size() > 0) {
            node = queue.peek();
            queue.poll();

            if (!visited[node]) {
                result.add(node);
                visited[node] = true;
            }

            for (int i = 0; i < graph[node].size(); i++) {
                current = graph[node].get(i);
                if (!visited[current]) queue.add(current);
            }
        }
        return result.toArray(new Integer[0]);
    }
}
