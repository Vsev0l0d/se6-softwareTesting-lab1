import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {
    private Graph graph;

    @BeforeEach
    private void createGraph() {
        graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(1, 0);
        graph.addEdge(1, 5);
        graph.addEdge(3, 5);
        graph.addEdge(3, 7);
        graph.addEdge(5, 7);
        graph.addEdge(5, 6);
        graph.addEdge(7, 6);
        graph.addEdge(6, 4);
    }

    private static Stream<Arguments> simpleCases() {
        return Stream.of(
                Arguments.of(3, new Integer[]{3, 5, 6, 4, 7}),
                Arguments.of(5, new Integer[]{5, 6, 4, 7}),
                Arguments.of(7, new Integer[]{7, 6, 4})
        );
    }

    @ParameterizedTest(name = "{index}: DFS({0}) = {1}")
    @MethodSource
    public void simpleCases(int in, Integer[] expected) {
        assertArrayEquals(expected, graph.DFS(in));
    }

    @Test
    @DisplayName("alone nodes")
    void aloneNodes() {
        assertAll(
                () -> assertArrayEquals(graph.DFS(2), new Integer[]{2}),
                () -> assertArrayEquals(graph.DFS(4), new Integer[]{4})
        );
    }

    @Test
    @DisplayName("pair of nodes")
    void pairOfNodes() {
        assertArrayEquals(graph.DFS(6), new Integer[]{6, 4});
    }

    @Test
    @DisplayName("cycle of nodes")
    void cycleOfNodes() {
        assertAll(
                () -> assertArrayEquals(graph.DFS(0), new Integer[]{0, 1, 5, 6, 4, 7}),
                () -> assertArrayEquals(graph.DFS(1), new Integer[]{1, 0, 5, 6, 4, 7})
        );
    }

    @Test
    @DisplayName("empty graph")
    void empty() {
        assertNull(new Graph(0).DFS(1));
    }

    @Test
    @DisplayName("node doesn't exist")
    void nodeNotExist() {
        assertNull(new Graph(3).DFS(3));
    }
}
