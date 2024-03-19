# Combination Sum

## Specification-based testing

### 1. Understand the requirement, inputs, and outputs

Method: `combinationSum(int[] candidates, int target)`

returns a combination of integers where the sum of these integers is equal to the provided `target` parameter

- `candidates`: array with distinct integers
- `target`: integer which the integers of `candidates` have to sum up to

return a list of unique lists, where the integers of each list sum up to `target`

if no combination of the `candidates` integers are possible to sum up to `target`, return `[]`

### 2. Explore the program

We wrote some tests to see how the program behaves

### 3. Explore possible inputs and outputs, and identify partitions

Input parameters:

- `candidates` parameter: `candidates` is an array with distinct (positive) integers
    - empty array
    - non-empty array
- `target` parameter: `target` is an integer
    - negative integers
    - 0
    - positive integers

- combination of input parameters:
    - all integers in `candidates` are larger than `target`
    - combination of integers of `candidates` to sum up to `target` is possible
    - no combination of integers in `candidates` are equal to `target`

Output parameters:

- list of all unique combinations of candidates where the chosen numbers sum to target
- size of list < 150

### 4. Analyze the boundaries

- `candidates` having size 1
- `target` being 0

### 5. Devise test cases

- T1: `candidates` is an empty array and `target` is 0
- T2: `candidates` is an empty array and `target` is not zero
- T3: `candidates` is a non-empty array and `target` is 0
- T4: `candidates` is a non-empty array and `target` is not zero
- T5: `candidates` is a non-empty array and `target` is less than zero
- T6: all integers in `candidates` are larger than `target`
- T7: 150 combinations
    - This test revealed a bug, the code didn't ensure that less than 150 combinations are created
- T8: 149 combinations
- T9: no combination of integers in `candidates` are equal to `target`

### 6. Automate the test cases

see: [CombinationSumTest.java](combination_sum/src/test/java/zest/CombinationSumTest.java)

### 7. Augment the test suite with creativity and experience

- T10: `candidates` only contains one integer
- T11: `candidates` are not sorted
- T12: `candidates` are descending sorted

## Structural testing

- line coverage: 100% (95% overall, because the method is static. The class is never instantiated)
- branch coverage: 100%

## Mutation testing

- mutation coverage: 100% --> 15 out of 15 mutants were killed

