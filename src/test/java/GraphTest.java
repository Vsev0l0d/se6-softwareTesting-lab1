import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class GraphTest {
    private static Graph graph1;
    private static Graph graph2;

    private static Stream<Arguments> testGraph() {
        return Stream.of(
                Arguments.of(0, new Integer[]{0, 1, 5, 7, 6, 4}),
                Arguments.of(6, new Integer[]{6, 4}),
                Arguments.of(3, new Integer[]{3, 5, 7, 6, 4}),
                Arguments.of(2, new Integer[]{2}),
                Arguments.of(1, new Integer[]{1, 0, 5, 7, 6, 4})
        );
    }

    @BeforeEach
    private void createGraph() {
        graph1 = new Graph(8);
        graph1.addEdge(0, 1);
        graph1.addEdge(1, 0);
        graph1.addEdge(1, 5);
        graph1.addEdge(3, 5);
        graph1.addEdge(3, 7);
        graph1.addEdge(5, 7);
        graph1.addEdge(5, 6);
        graph1.addEdge(7, 6);
        graph1.addEdge(6, 4);

        graph2 = new Graph(8);
        graph2.addEdge(0, 3);
        graph2.addEdge(1, 0);
        graph2.addEdge(1, 2);
        graph2.addEdge(1, 3);
        graph2.addEdge(2, 5);
        graph2.addEdge(2, 6);
        graph2.addEdge(3, 1);
        graph2.addEdge(3, 5);
        graph2.addEdge(4, 7);
        graph2.addEdge(5, 6);
        graph2.addEdge(6, 7);
    }

    @ParameterizedTest(name = "{index}: DFS({0}) = {1}")
    @MethodSource
    public void testGraph(int in, Integer[] expected) {
        assertArrayEquals(expected, graph1.DFS(in));
    }
}
