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
    void outOfRangeLowerBoundary(){
        // -214783648 is the lower bound of 32-bit signed integer range
        assertEquals(-214783648, "-214783649");
    }

    @Test
    void lowerBoundary(){
        // -214783648 is the lower bound of 32-bit signed integer range
        assertEquals(-214783648, "-214783648");
    }

    @Test
    void outOfRangUpperBoundary(){
        // 214783647 is the upper bound of 32-bit signed integer range
        assertEquals(214783647, "214783648");
    }

    @Test
    void upperBoundary(){
        // 214783647 is the upper bound of 32-bit signed integer range
        assertEquals(214783647, "214783647");
    }
}