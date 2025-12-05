/**
 * Euclidean algorithm.
 * <br/>
 * See especially the section about
 * <a href="https://en.wikipedia.org/wiki/Euclidean_algorithm#Implementations">Implementations</a>
 * on Wikipedia.
 */
public class Euclid {

    /**
     * Compute GCD using Euclidean algorithm.
     *
     * @param a first number
     * @param b second number
     *
     * @return gcd
     *
     * @throws RuntimeException if a or b < 0
     */
    public static int greatestCommonDenominator(int a, int b) {
        if(a<0 || b<0) {
            throw new RuntimeException("arguments must be greater than 0");
        }
        if(a==0) {
            return b;
        }
        if(b==0) {
            return a;
        }
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return b;
    }
}
