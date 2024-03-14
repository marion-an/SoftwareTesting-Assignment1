package zest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class CombinationSumTest {
    @Test
    void test_1() {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        CombinationSum.combinationSum(candidates, target);
    }

}