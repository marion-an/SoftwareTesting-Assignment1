package zest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CombinationSumTest {
    @Test
    void test_1() {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        assertEquals(CombinationSum.combinationSum(candidates, target).size(), 2);
    }

    @Test
    void test_2() {
        int[] candidates = {};
        int target = 7;
        assertEquals(CombinationSum.combinationSum(candidates, target).size(), 0);
    }

    @Test
    void test_3() {
        int[] candidates = {8};
        int target = 7;
        assertEquals(CombinationSum.combinationSum(candidates, target).size(), 0);
    }

    @Test
    void test_4() {
        int[] candidates = {1,2, 2};
        int target = 7;
        assertEquals(CombinationSum.combinationSum(candidates, target).size(), 0);
    }


}