package zest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyAtoiTest {

    @Test
    void inputNull() {
        assertEquals(0, MyAtoi.myAtoi(null));
    }

    @Test
    void inputNoInteger() {
        assertEquals(0, MyAtoi.myAtoi("abc"));
    }

    @Test
    void inputLeadingWhiteSpaces() {
        assertEquals(-1, MyAtoi.myAtoi("              -1"));
    }

    @Test
    void charactersInFrontOfString() {
        assertEquals(0, MyAtoi.myAtoi("avc123"));
    }

    @Test
    void gapInBetween() {
        assertEquals(45, MyAtoi.myAtoi("   +45 78"));
    }

}