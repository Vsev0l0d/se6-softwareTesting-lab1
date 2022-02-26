import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Graph {
    private List<Integer>[] graph;
    private Integer edgeCount;

    public Graph(int v) {
        edgeCount = v;
        graph = new LinkedList[edgeCount];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }
    }

    void addEdge(int a, int b) {
        graph[a].add(b);
    }

    Integer[] DFS(int node) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[edgeCount];
        Stack<Integer> stack = new Stack<>();

        stack.push(node);
        visited[node] = true;
        result.add(node);

        int current;
        while (!stack.empty()) {
            node = stack.peek();
            stack.pop();

            if (!visited[node]) visited[node] = true;

            for (int i = 0; i < graph[node].size(); i++) {
                current = graph[node].get(i);

                if (!visited[current]) {
                    stack.push(current);
                    result.add(current);
                }
            }
        }
        return result.toArray(new Integer[0]);
    }
}
