package zest;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MaximumSubarrayTest {


    @Test
    void emptyArrayInputReturnsZero(){
        int[] a = {};
        assertEquals(MaximumSubarray.maxSubArray(a),0);
    }

    @Test
    void oneElementInputRetunsValue(){
        int[] a = {5};
        assertEquals(MaximumSubarray.maxSubArray(a),5);
    }

    @Test
    void multipleElementsInputReturnsValue(){
        int[] a = {1,2,3,4,5};
        assertEquals(MaximumSubarray.maxSubArray(a),15);
    }

    @Test
    void negativeElementsInputReturnsZero(){
        int[] a = new int[7];
        a[2] = -2;
        a[4] = -3;
        assertEquals(MaximumSubarray.maxSubArray(a),0);
    }

    @Test
    void multipleElementsHighestSumOnLeftReturnsValue(){
        int[] a = {3,2,1,-10,2,3};
        assertEquals(MaximumSubarray.maxSubArray(a),6);
    }

    @Test
    void multipleElementsHighestSumInMiddleReturnsValue(){
        int[] a = {1,2,3,-10,4,5,6,-10,1,2,3};
        assertEquals(MaximumSubarray.maxSubArray(a),15);
    }

    @Test
    void multipleElementsHighestSumExistsTwice(){
        int[] a = {1,2,3,-20,1,2,3};
        assertEquals(MaximumSubarray.maxSubArray(a),6);
    }

    @Test
    void multipleElementsWithNegativesSumAllUp(){
        int[] a = {1,2,3,4,-2,5,6};
        assertEquals(MaximumSubarray.maxSubArray(a),19);
    }

    @Test
    void multipleElementsAllNegativeReturnsSmallestNumber(){
        int[] a = {-2,-1,-3};
        assertEquals(MaximumSubarray.maxSubArray(a),-1);
    }

    @Test
    void instantiateClassAndCheckIfWorks(){
        int[] a = {1};
        MaximumSubarray m = new MaximumSubarray();
        assertEquals(1,m.maxSubArray(a));
    }

}