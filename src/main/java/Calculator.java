import static java.lang.Double.NaN;
import static java.lang.Math.*;

public class Calculator {
    public static double arccos(double x) {
        if (abs(x) > 1) return NaN;

        double result = PI / 2 - x;
        double subtrahend;
        double multiplier = 1;

        for (int n = 1; n < 1000000; n++) {
            multiplier *= 2 * n + 1;
            multiplier /= 2 * n;
            subtrahend = multiplier * (pow(x, 2 * n + 1) / pow(2 * n + 1, 2));
            result -= subtrahend;
        }

        return result;
    }
}
