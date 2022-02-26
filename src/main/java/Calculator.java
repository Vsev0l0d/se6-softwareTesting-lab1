import static java.lang.Double.NaN;
import static java.lang.Math.*;

public class Calculator {
    private static final double ACCURATE = 0.0001;

    public static double getAccurate() {
        return ACCURATE;
    }

    public static double arccos(double x) {
        if (abs(x) > 1) return NaN;

        double result = PI/2 - x;
        double subtrahend;
        double numerator = 1;
        double denominator = 1;
        int n = 1;

        do {
            numerator *= 2*n + 1;
            denominator *= 2*n;
            subtrahend = (numerator/denominator) * (pow(x, 2*n + 1) / pow(2*n + 1, 2));
            result -= subtrahend;
            n++;
        } while (abs(subtrahend) >= ACCURATE / 10);

        return result;
    }
}
