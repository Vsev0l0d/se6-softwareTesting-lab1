import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.lang.Double.NaN;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
    private static Stream<Arguments> testArccos() {
        return Stream.of(
                Arguments.of(-1.1, NaN),
                Arguments.of(1.1, NaN),
                Arguments.of(-1, Math.PI)
        );
    }

    @ParameterizedTest(name = "{index}: arccos({0}) = {1}")
    @MethodSource
    public void testArccos(double in, double expected) {
        assertEquals(expected, Calculator.arccos(in));
    }
}