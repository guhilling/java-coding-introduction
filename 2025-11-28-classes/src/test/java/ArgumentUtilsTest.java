import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArgumentUtilsTest {

    @Test
    void printNoArgs() {
        assertEquals("no args supplied", ArgumentUtils.formatArgs(new String[]{}));
    }

    @Test
    void printOneArgs() {
        assertEquals("one arg: Hello", ArgumentUtils.formatArgs(new String[]{"Hello"}));
    }
}