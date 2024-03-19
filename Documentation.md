# ATOI
## Specification-based testing

### 1. Understand the requirement, inputs, and outputs

Method: `myAtoi(string s)`

converts a string to a 32-bit signed integer

- `s`: String to be converted.
    - if `s` is null, return 0
    - if `s` doesn't contain any digits to convert, return 0

return converted integer, or 0 if the input is null or if there are no digits to be converted

### 2. Explore the program
We wrote some tests to see how the program behaves

### 3. Explore possible inputs and outputs, and identify partitions
Input parameters:
- `s` parameter: `s` can be any string.
    - null string
    - empty string
    - non-empty string
    - leading whitespaces
    - leading zeroes

- no combination of input parameters possible, as only 1 input parameter exists

Output parameters:
-  Integer (positive or negative)

### 4. Analyze the boundaries
- `s` having length 1
- 2^31 - 1 integer
- -2^31 integer

### 5. Devise test cases
- T1: `s` is null
- T2: `s` is the empty string
- T3: `s` is a nonempty string
- T4: `s` doesn't contain any integer
- T5: `s` contains a negative integer with leading whitespaces
- T6: `s` contains a positive integer with leading whitespaces
- T7: `s` contains a negative integer with leading zeroes
- T8: `s` contains a positive integer with leading zeroes
- T9: `s` is out of the lower range: -2^31 - 1
- T10: `s` is exactly the lower range: -2^31
- T11: `s` is out of the upper range: 2^31
- T12: `s` is exactly the upper range: 2^31 - 1
- T13: `s` contains an integer which is split by a character

### 6. Automate the test cases
see: [MyAtoiTest.java](atoi/src/test/java/zest/MyAtoiTest.java)

### 7. Augment the test suite with creativity and experience
- T14: `s` contains an integer which is split by a whitespace
- T15: `s` starts with a '-' sign but no integers afterwards

## Structural testing
- line coverage: 100% (96% overall, because the method is static. The class is never instantiated)
- branch coverage: 88% --> 2 out of 18 branches missed

  line 19: if a '+' is in front of the integer within the string

  line 20: the case where `s.charAt(i) = '+'` and the condition evaluates to false

  add:
- T16: `s` contains an integer with a '+' sign in the beginning

  now:
- 100% branch coverage

## Mutation testing
- mutation coverage: 95% --> 20 out of 21 mutants were killed

  line 28: changed conditional boundary --> survived

- This case is already addressed T10 and T12. 

  Because we get the same result when we evaluate the condition to true in line 28 in case the conditional operator is 
  changed to '>=' or if it evaluates to false if the conditional operator is '>' for 2^31 - 1 and -2^31, the program 
  doesn't realise that the mutant actually would be killed if the results would differ.


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
- T12: `candidates` are in descending order

## Structural testing

- line coverage: 100% (95% overall, because the method is static. The class is never instantiated)
- branch coverage: 100%

## Mutation testing

- mutation coverage: 100% --> 15 out of 15 mutants were killed



# Maximum_Subarray
## Specification based Testing

### 1.Requirements
Method `maxSubArray(int[] a)` takes an integer Array as the input and gives out the highest possible sum of a subarray if the array is empty it should return 0, behaviour if the input is null is not defined.

### 2. Exploring
The program can take an array as input and seems to be working fine from some first manual tests

### 3. Input/Output domains
The Input is the `integer array a`
- `a` can be empty
- `a` can have one element
- `a` can have multiple elements
  - `a` can have only positive Numbers
    - `the sum` will always be the whole array
  - `a` can have negative numbers
    - `the sum` can be strictly on the left
    - `the sum` can be strictly on the right
    - `the sum` can be in the middle of the array
    - `the sum` can be twice in the array

### 4. Boundaries
There are two boundaries:
- `empty array`
- `one element array`

### 5. Test Cases
- T1 `a` is empty
- T2 `a` has one element
- T3 `a` has multiple elements
- T4 `a` contains negative elements
- T6 `a` contains negative elements and the highest sum is to the left
- T7 `a` contains negative elements and the highest sum is to the right
- T8 `a` contains negative elements and the highest sum in the middle
- T9 `a` contains two parts which will be the identical highest sum

### 6. Automate the test cases
See file MaximumSubarrayTest

### 7. Augment the test_suite
- T11 `a` contains a negative number which will be summed up into the sum
- T10 `a` contains only negative elements

### Code adaptation
The tests revealed a bug in the code: that was if an empty array was provided as input the method did not return 0 as was specified. This has been fixed by using a simple if condition check.

## Structural testing
- Instruction coverage: `92%` => missing line 3 since maxSubArray is a static method, therefore the Object is never instantiated => can write a test case for this `T11` => new instruction coverage `100%` 
- Branch coverage: `100%` => all branches are covered

## Mutation testing
- Mutation coverage of 100%
- 5/5 Mutations were killed
- no actions needed
