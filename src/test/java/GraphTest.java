import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class GraphTest {
    private static Graph graph1;
    private static Graph graph2;

    private static Stream<Arguments> testGraph() {
        return Stream.of(
                Arguments.of(0, new Integer[]{0, 1, 5, 6, 4, 7}),
                Arguments.of(6, new Integer[]{6, 4}),
                Arguments.of(3, new Integer[]{3, 5, 6, 4, 7}),
                Arguments.of(2, new Integer[]{2}),
                Arguments.of(1, new Integer[]{1, 0, 5, 6, 4, 7})
        );
    }

    private static Stream<Arguments> testGraph2() {
        return Stream.of(
                Arguments.of(1, new Integer[]{1, 0, 2, 3, 5, 6, 7}),
                Arguments.of(4, new Integer[]{4, 7}),
                Arguments.of(3, new Integer[]{3, 1, 0, 2, 5, 6, 7})
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

    @Test
    @DisplayName("empty graph")
    void empty() {
        assertNull(new Graph(0).DFS(1));
    }

    @Test
    @DisplayName("node doesn't exist")
    void nodeNotExist() {
        assertNull(new Graph(2).DFS(3));
    }

    @ParameterizedTest(name = "{index}: DFS({0}) = {1}")
    @MethodSource
    public void testGraph(int in, Integer[] expected) {
        assertArrayEquals(expected, graph1.DFS(in));
    }

    @ParameterizedTest(name = "{index}: DFS({0}) = {1}")
    @MethodSource
    public void testGraph2(int in, Integer[] expected) {
        assertArrayEquals(expected, graph2.DFS(in));
    }
}
