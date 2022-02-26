import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static java.lang.Double.*;
import static java.lang.Math.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
    private static final double ACCURATE = 0.001;

    @ParameterizedTest(name = "{index}: arccos({0}) = {1}")
    @DisplayName("Values in [-1, 1]")
    @CsvSource({
            "-0.9,2.6905658417935308",
            "-0.6,2.214297435588181",
            "-0.3,1.8754889808102941",
            "0.3,1.2661036727794992",
            "0.6,0.9272952180016123",
            "0.9,0.45102681179626236",
    })
    void convergingValues(double x, double expected) {
        assertEquals(expected, Calculator.arccos(x), ACCURATE);
    }

    private static Stream<Arguments> testArccos() {
        return Stream.of(
                Arguments.of(-1.1, NaN),
                Arguments.of(-1, PI),
                Arguments.of(-sqrt(3)/2, 5*PI/6),
                Arguments.of(-sqrt(2)/2, 3*PI/4),
                Arguments.of(-0.5, 2*PI/3),
                Arguments.of(0, PI/2),
                Arguments.of(0.5, PI/3),
                Arguments.of(sqrt(2)/2, PI/4),
                Arguments.of(sqrt(3)/2, PI/6),
                Arguments.of(1, 0),
                Arguments.of(1.1, NaN)
        );
    }

    @ParameterizedTest(name = "{index}: arccos({0}) = {1}")
    @DisplayName("Table values")
    @MethodSource
    void testArccos(double in, double expected) {
        assertEquals(expected, Calculator.arccos(in), ACCURATE);
    }

    @ParameterizedTest(name = "{index}: arccos({0}) = NaN")
    @DisplayName("Values not in [-1, 1]")
    @ValueSource(doubles = {-10000, -100, -1.000001, 1.000001, 100, 10000})
    void convergingValues(double x) {
        assertEquals(NaN, Calculator.arccos(x));
    }

    @Test
    @DisplayName("NaN")
    void nan() {
        assertEquals(NaN, Calculator.arccos(NaN));
    }

    @Test
    @DisplayName("Positive infinity")
    void positiveInfinity() {
        assertEquals(NaN, Calculator.arccos(POSITIVE_INFINITY));
    }

    @Test
    @DisplayName("Negative infinity")
    void negativeInfinity() {
        assertEquals(NaN, Calculator.arccos(NEGATIVE_INFINITY));
    }
}