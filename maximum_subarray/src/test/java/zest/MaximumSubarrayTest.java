package zest;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class MaximumSubarrayTest {


    @Test
    void emptyArrayInputReturnsZero(){
        int[] a = {};
        assertEquals(0,MaximumSubarray.maxSubArray(a));
    }

    @Test
    void oneElementInputReturnsValue(){
        int[] a = {5};
        assertEquals(5,MaximumSubarray.maxSubArray(a));
    }

    @Test
    void multipleElementsInputReturnsValue(){
        int[] a = {1,2,3,4,5};
        assertEquals(15,MaximumSubarray.maxSubArray(a));
    }

    @Test
    void negativeElementsInputReturnsZero(){
        int[] a = new int[7];
        a[2] = -2;
        a[4] = -3;
        assertEquals(0,MaximumSubarray.maxSubArray(a));
    }

    @Test
    void multipleElementsHighestSumOnLeftReturnsValue(){
        int[] a = {3,2,1,-10,2,3};
        assertEquals(6,MaximumSubarray.maxSubArray(a));
    }

    @Test
    void multipleElementsHighestSumOnRightReturnsValue(){
        int[] a = {3,2,1,-10,2,3,4};
        assertEquals(9,MaximumSubarray.maxSubArray(a));
    }

    @Test
    void multipleElementsHighestSumInMiddleReturnsValue(){
        int[] a = {1,2,3,-10,4,5,6,-10,1,2,3};
        assertEquals(15,MaximumSubarray.maxSubArray(a));
    }

    @Test
    void multipleElementsHighestSumExistsTwice(){
        int[] a = {1,2,3,-20,1,2,3};
        assertEquals(6,MaximumSubarray.maxSubArray(a));
    }

    @Test
    void multipleElementsWithNegativesSumAllUp(){
        int[] a = {1,2,3,4,-2,5,6};
        assertEquals(19,MaximumSubarray.maxSubArray(a));
    }

    @Test
    void multipleElementsAllNegativeReturnsSmallestNumber(){
        int[] a = {-2,-1,-3};
        assertEquals(-1,MaximumSubarray.maxSubArray(a));
    }

    @Test
    void instantiateClassAndCheckIfWorks(){
        int[] a = {1};
        MaximumSubarray m = new MaximumSubarray();
        assertEquals(1,m.maxSubArray(a));
    }

}