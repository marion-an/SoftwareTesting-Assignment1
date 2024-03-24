package zest;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MedianOfArraysTest {


    @Test
    void instantiateClassWorks(){
        MedianOfArrays medianOfArrays = new MedianOfArrays();
    }

    MedianOfArrays moa = new MedianOfArrays();
    @Test
    void firstArrayIsNullReturnsZero(){
        int[] a = null;
        int[] b = {1,2,3};

        assertEquals(0.0,moa.findMedianSortedArrays(a,b));
    }

    @Test
    void firstArrayIsNotSortedReturnsZero(){
        int[] a = {3,2};
        int[] b = {1,2,3};

        assertEquals(0.0,moa.findMedianSortedArrays(a,b));
    }

    @Test
    void firstArrayIsEmptySecondHasOneElementReturnsSecondElement(){
        int[] a = {};
        int[] b = {5};

        assertEquals(5.0,moa.findMedianSortedArrays(a,b));
    }

    @Test
    void firstArrayIsEmptySecondHasEvenElementsReturnsMedian(){
        int[] a = {};
        int[] b = {2,7};

        assertEquals(4.5,moa.findMedianSortedArrays(a,b));
    }

    @Test
    void firstArrayIsEmptySecondHasOddElementReturnsMedian(){
        int[] a = {};
        int[] b = {2,5,7};

        assertEquals(5.0,moa.findMedianSortedArrays(a,b));
    }

    @Test
    void firstArrayHasOneElementSecondHasOneElementReturnsMedian(){
        int[] a = {1};
        int[] b = {2};

        assertEquals(1.5,moa.findMedianSortedArrays(a,b));
    }

    @Test
    void firstArrayHasOneElementSecondHasEvenElementsReturnsMedian(){
        int[] a = {1};
        int[] b = {2,3};

        assertEquals(2.0,moa.findMedianSortedArrays(a,b));
    }

    @Test
    void firstArrayHasOneElementSecondHasEvenElementsAndNegativesReturnsMedian(){
        int[] a = {1};
        int[] b = {-4,-3};

        assertEquals(-3.0,moa.findMedianSortedArrays(a,b));
    }

    @Test
    void firstArrayHasEvenElementsSecondHasEvenElementsReturnsMedian(){
        int[] a = {1,2};
        int[] b = {2,3};

        assertEquals(2.0,moa.findMedianSortedArrays(a,b));
    }

    @Test
    void firstArrayHasEvenElementsSecondHasOddElementsReturnsMedian(){
        int[] a = {1,2};
        int[] b = {3,4,5};

        assertEquals(3.0,moa.findMedianSortedArrays(a,b));
    }

    @Test
    void twoEmptyArraysReturnsNegativeOne(){
        int[] a = {};
        int[] b = {};

        assertEquals(-1.0,moa.findMedianSortedArrays(a,b));
    }


    @Test
    void arrayHasTwoTimesSameElementOrdered(){
        int[] a = {1,2,2,3};
        int[] b = {5};

        assertEquals(2.0,moa.findMedianSortedArrays(a,b));
    }

}