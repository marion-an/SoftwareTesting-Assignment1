package zest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CombinationSumTest {
    @Test
    void emptyArrayAndZero() {
        int[] candidates = {};
        int target = 0;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList()
        );
        List<List<Integer>> result = CombinationSum.combinationSum(candidates, target);
        assertEquals(1, result.size());
        assertEquals(expected, result);
    }

    @Test
    void emptyArrayAndNonZero() {
        int[] candidates = {};
        int target = 1;
        List<List<Integer>> expected = Arrays.asList();
        List<List<Integer>> result = CombinationSum.combinationSum(candidates, target);
        assertEquals(0, result.size());
        assertEquals(expected, result);
    }

    @Test
    void nonEmptyArrayAndZero() {
        int[] candidates = {1, 2, 3};
        int target = 0;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList()
        );
        List<List<Integer>> result = CombinationSum.combinationSum(candidates, target);
        assertEquals(1, result.size());
        assertEquals(expected, result);
    }

    @Test
    void nonEmptyArrayAndNonZero() {
        int[] candidates = {1, 2, 3};
        int target = 2;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 1),
                Arrays.asList(2)
        );
        List<List<Integer>> result = CombinationSum.combinationSum(candidates, target);
        assertEquals(2, result.size());
        assertEquals(expected, result);
    }

    @Test
    void nonEmptyArrayAndLessThanZero() {
        int[] candidates = {1, 2, 3};
        int target = -2;
        List<List<Integer>> expected = Arrays.asList();
        List<List<Integer>> result = CombinationSum.combinationSum(candidates, target);
        assertEquals(0, result.size());
        assertEquals(expected, result);
    }

    @Test
    void noCombination() {
        int[] candidates = {2, 3};
        int target = 1;
        List<List<Integer>> expected = Arrays.asList(
        );
        List<List<Integer>> result = CombinationSum.combinationSum(candidates, target);
        assertEquals(0, result.size());
        assertEquals(expected, result);
    }

    @Test
    void moreThanBoundaryCombinations() {
        int[] candidates = {1, 2};
        int target = 299;
        //actual would be 150 combinations

        List<List<Integer>> result = CombinationSum.combinationSum(candidates, target);
        assertEquals(149, result.size());
    }

    @Test
    void boundaryCombinations() {
        int[] candidates = {1, 2};
        int target = 297;

        List<List<Integer>> result = CombinationSum.combinationSum(candidates, target);
        assertEquals(149, result.size());
    }


}