package zest;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NeedleInHayTest {
    @Test
    void haystackAndOrNeedleAreNull(){
        assertEquals(-1 ,NeedleInHay.find(null, null));
        assertEquals(-1, NeedleInHay.find(null, "needle"));
        assertEquals(-1, NeedleInHay.find("haystack", null));
    }

    @Test
    void haystackAndOrNeedleAreEmpty(){
        assertEquals(0, NeedleInHay.find("", ""));
        assertEquals(-1, NeedleInHay.find("Haystack", ""));
        assertEquals(-1, NeedleInHay.find("", "needle"));
    }

    @Test
    void needleOfLength1(){
        assertEquals(-1, NeedleInHay.find("haystack", "x"));
        assertEquals(3, NeedleInHay.find("haystack", "s"));
        assertEquals(1, NeedleInHay.find("haystack", "a"));
    }

    @Test
    void haystackOfLengthOne(){
        assertEquals(0, NeedleInHay.find("a", "a"));
        assertEquals(-1, NeedleInHay.find("a", "b"));
        assertEquals(-1, NeedleInHay.find("a", "aa"));
    }

    @Test
    void hayStackAndNeedleOfLengthLarger1(){
        assertEquals(0, NeedleInHay.find("haystack", "hay"));
        assertEquals(0, NeedleInHay.find("ananas", "an"));
        assertEquals(10, NeedleInHay.find("This is a very very large haystack", "very"));
        assertEquals(-1, NeedleInHay.find("haystack", "needle"));
    }

    @Test
    void instantiateClassAndCheckIfWorks(){
        int[] a = {1};
        NeedleInHay n = new NeedleInHay();
        assertEquals(-1,n.find("haystack", "needle"));
    }
}