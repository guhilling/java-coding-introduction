import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EuclidTest {

    @Test
    void greatestCommonDenominatorOfEqualNumbers() {
        int testValue = 7;
        assertEquals(testValue, Euclid.greatestCommonDenominator(testValue, testValue));
    }

    @Test
    void greatestCommonDenominatorOfDifferentNumbers() {
        int a = 320;
        int b = 15;
        assertEquals(5, Euclid.greatestCommonDenominator(a, b));
    }
    @Test
    void greatestCommonDenominatorOfDifferentNumbersWithZeroB() {
        int a = 320;
        int b = 0;
        assertEquals(320, Euclid.greatestCommonDenominator(a, b));
    }
    @Test
    void greatestCommonDenominatorOfDifferentNumbersWithZeroA() {
        int a = 0;
        int b = 320;
        assertEquals(320, Euclid.greatestCommonDenominator(a, b));
    }
    @Test
    void greatestCommonDenominatorOfDifferentNumbersWithNegativeNumber() {
        int a = 320;
        int b = -15;
        try {
            Euclid.greatestCommonDenominator(a, b);
            fail("should throw a RuntimeException");
        } catch (RuntimeException throwException) {
            assertEquals("arguments must be greater than 0", throwException.getMessage());
        }
    }
}