package zest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyAtoiTest {

    @Test
    void inputNull() {
        assertEquals(0, MyAtoi.myAtoi(null));
    }

    @Test
    void inputEmptyString(){
        assertEquals(0, MyAtoi.myAtoi(""));
    }

    @Test
    void inputNonEmptyString(){
        assertEquals(1, MyAtoi.myAtoi("1"));
    }

    @Test
    void inputNoInt(){
        assertEquals(0, MyAtoi.myAtoi("abc"));
    }

    @Test
    void leadingWhiteSpaces(){
        assertEquals(-123, MyAtoi.myAtoi("   -123"));
        assertEquals(123, MyAtoi.myAtoi(" 123"));
    }

    @Test
    void leadingZeroes(){
        assertEquals(-123, MyAtoi.myAtoi("-000123"));
        assertEquals(123, MyAtoi.myAtoi("000123"));
    }

    @Test
    void outOfRangeLowerBoundary(){
        // -2147483647 is the lower bound of 32-bit signed integer range
        assertEquals(-2147483648, MyAtoi.myAtoi("-2147483649"));
    }

    @Test
    void lowerBoundary(){
        // -2147483648 is the lower bound of 32-bit signed integer range
        assertEquals(-2147483648, MyAtoi.myAtoi("-2147483648"));
    }

    @Test
    void outOfRangUpperBoundary(){
        // 2147483647 is the upper bound of 32-bit signed integer range
        assertEquals(2147483647, MyAtoi.myAtoi("2147483648"));
    }

    @Test
    void upperBoundary(){
        // 2147483647 is the upper bound of 32-bit signed integer range
        assertEquals(2147483647, MyAtoi.myAtoi("2147483647"));
    }

    @Test
    void splitInteger(){
        assertEquals(123, MyAtoi.myAtoi("123abc456"));
    }

    @Test
    void splitIntegerByWhiteSpace(){
        assertEquals(123, MyAtoi.myAtoi("123abc456"));
    }
}