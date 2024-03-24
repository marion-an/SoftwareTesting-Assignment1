package zest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Frac2DecTest {

    @Test
    void inputsAreZero() {
        assertEquals("0", Frac2Dec.fractionToDecimal(0,1));   //T1
        assertEquals(null, Frac2Dec.fractionToDecimal(1,0));   //T2
    }

    @Test
    void inputsSign() {
        assertEquals("0.5", Frac2Dec.fractionToDecimal(1,2));   //T3
        assertEquals("-0.5", Frac2Dec.fractionToDecimal(1,-2));   //T4
        assertEquals("0.5", Frac2Dec.fractionToDecimal(-1,-2));   //T5
    }

    @Test
    void fractionWholeInteger() {
        assertEquals("2", Frac2Dec.fractionToDecimal(4,2)); //T6
    }


    @Test
    void fractionNonPeriodic() {
        assertEquals("0.25", Frac2Dec.fractionToDecimal(1,4)); //T7
        assertEquals("0.025", Frac2Dec.fractionToDecimal(1,40)); //T8
    }

    @Test
    void fractionPeriodic() {
        assertEquals("0.(3)", Frac2Dec.fractionToDecimal(1,3)); //T9
        assertEquals("0.0(3)", Frac2Dec.fractionToDecimal(1,30)); //T10
    }

    @Test
    void fractionBiggerThanOne() {
        assertEquals("1.25", Frac2Dec.fractionToDecimal(5,4)); //T11
        assertEquals("1.(3)", Frac2Dec.fractionToDecimal(4,3)); //T12
    }

    @Test
    void fractionMultipleDigitPeriodicity() {
        assertEquals("0.(81)", Frac2Dec.fractionToDecimal(9,11)); //T13
        assertEquals("0.(1886792452830)", Frac2Dec.fractionToDecimal(10,53)); //T14
    }

    @Test
    void outputLengthBoundary() {
        assertEquals("0.(005025125628140703517587939698492462311557788944723618090452261306532663316582914572864321608040201)", Frac2Dec.fractionToDecimal(1, 199)); //T15
        assertEquals(null, Frac2Dec.fractionToDecimal(1, 60101)); //T18
    }

    @Test
    void inputsLeadingZero() {
        assertEquals("0.5", Frac2Dec.fractionToDecimal(01,2)); //T16
        assertEquals("0.5", Frac2Dec.fractionToDecimal(1,02)); //17
    }


 }