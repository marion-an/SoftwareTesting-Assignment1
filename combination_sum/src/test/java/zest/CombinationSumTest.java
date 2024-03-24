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
        assertTrue(expected.containsAll(result));
        assertTrue(result.containsAll(expected));
    }

    @Test
    void emptyArrayAndNonZero() {
        int[] candidates = {};
        int target = 1;
        List<List<Integer>> expected = Arrays.asList();
        List<List<Integer>> result = CombinationSum.combinationSum(candidates, target);
        assertEquals(0, result.size());
        assertTrue(expected.containsAll(result));
        assertTrue(result.containsAll(expected));
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
        assertTrue(expected.containsAll(result));
        assertTrue(result.containsAll(expected));
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
        assertTrue(expected.containsAll(result));
        assertTrue(result.containsAll(expected));
    }

    @Test
    void nonEmptyArrayAndLessThanZero() {
        int[] candidates = {1, 2, 3};
        int target = -2;
        List<List<Integer>> expected = Arrays.asList();
        List<List<Integer>> result = CombinationSum.combinationSum(candidates, target);
        assertEquals(0, result.size());
        assertTrue(expected.containsAll(result));
        assertTrue(result.containsAll(expected));
    }

    @Test
    void noCombination() {
        int[] candidates = {2, 3};
        int target = 1;
        List<List<Integer>> expected = Arrays.asList(
        );
        List<List<Integer>> result = CombinationSum.combinationSum(candidates, target);
        assertEquals(0, result.size());
        assertTrue(expected.containsAll(result));
        assertTrue(result.containsAll(expected));
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

    @Test
    void noCombinationSumUpToTarget() {
        int[] candidates = {2, 4, 6};
        int target = 7;

        List<List<Integer>> result = CombinationSum.combinationSum(candidates, target);
        assertEquals(0, result.size());
    }

    @Test
    void oneCandidate() {
        int[] candidates = {1};
        int target = 7;

        List<List<Integer>> result = CombinationSum.combinationSum(candidates, target);
        assertEquals(1, result.size());
    }

    @Test
    void notSorted() {
        int[] candidates = {6, 1, 2, 3};
        int target = 5;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 1, 1, 1, 1),
                Arrays.asList(1, 1, 1, 2),
                Arrays.asList(1, 2, 2),
                Arrays.asList(1, 1, 3),
                Arrays.asList(2, 3)
        );
        List<List<Integer>> result = CombinationSum.combinationSum(candidates, target);
        assertEquals(5, result.size());
        assertTrue(expected.containsAll(result));
        assertTrue(result.containsAll(expected));
    }

    @Test
    void descendingSort() {
        int[] candidates = {6, 3, 2, 1};
        int target = 5;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 1, 1, 1, 1),
                Arrays.asList(1, 1, 1, 2),
                Arrays.asList(1, 2, 2),
                Arrays.asList(1, 1, 3),
                Arrays.asList(2, 3)
        );
        List<List<Integer>> result = CombinationSum.combinationSum(candidates, target);
        assertEquals(5, result.size());
        assertTrue(expected.containsAll(result));
        assertTrue(result.containsAll(expected));
    }


}