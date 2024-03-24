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


# frac2dec
## Specification-based testing

### 0. Notes and comments

we added in the code [if (denominator == 0) return null;] as it was specifiec by documentation but not implemented in the original code

we assume the function is given 2 integers (and no NULL or other types), so we don't test the other types of input, as specified by documentation

We set up [if (res.length() > 103) return null;] as it's specified in the documentation that the output length should be less than 104

### 1. Understand the requirement, inputs, and outputs

The program converts a fraction into decimal numbers, repeating fractional part are enclosed in parenthesis
The inputs are 2 integers parameters, representing the the numerator and the denominator of the fraction.
The program returns the decimal of the fraction as a String (any solution if there are multiple)
it's return length will be less than 104 and it should return null in case of the denominator is 0


### 2. Explore the program
wrote some tests to see how the program behaves

### 3. Explore possible inputs and outputs, and identify partitions

Input parameters:
- `numerator` integer parameter
  - 0
  - positive integer
  - negative integer
  - integer with zeroes to the left


- `denominator` integer parameter
  - 0
  - positive integer
  - negative integer
  - integer with zeroes to the left

- combination of `numerator` and `denominator`
  - both positive
  - one positive and one negative
  - both negative

  - `numerator` and `denominator` such that we get a non-periodic decimal
  - `numerator` and `denominator` such that we get a periodic decimal


Output parameters:
-  String (periodic decimal)
-  String (noon-periodic decimal)
-  null

### 4. Analyze the boundaries

-  Denominator = 0
-  Numerator = 0
-  Output of length 104

### 5. Devise test cases


- T1: `numerator` is zero
- T2: `denominator` is zero

- T3: `numerator` and `denominator` both positive
- T4: `numerator` is positive and `denominator` is negative
- T5: `numerator` and `denominator` both negative

- T6: fraction is a normal integer without comma

- T7: fraction is non-periodic smaller than 1
- T8: fraction is non-periodic only after some digits

- T9: fraction is periodic smaller than 1
- T10: fraction is periodic only after some digits

- T11: fraction is non-periodic bigger than 1
- T12: fraction is periodic bigger than 1

- T13: fraction is periodic (multiple digit)
- T14: fraction is periodic (multiple digit and same number can reoccur)

- T15: Boundary of output (output length 103)

- T16: `numerator` has a leading zero
- T17: `denominator` has a leading zero



### 6. Automate the test cases
see: [Frac2DecTest.java](frac2dec/src/test/java/zest/Frac2DecTest.java)

### 7. Augment the test suite with creativity and experience

- T18: Boundary of output (output length 104)

## Structural testing

- line coverage: 100% (97% overall, because the method is static. Therefore, the class is never instantiated)
- branch coverage: 100% --> 0 out of 18 branches missed

no modification needed


## Mutation testing

- mutation coverage: 91% --> 21 out of 23 mutants were killed

both mutants concerns the same line
line 15: changed conditional boundary → SURVIVED

[   res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");    ]

Even with changed conditinal boundary > to ≥, it still work as intented as we numerator or the denominator are still both non-negative.
Case also tested with T1 and T2


# generateParentheses
## Specification-based testing

### 0. Notes and comments

We change the code to also return an empty array when `n` is bigger than 8 to respect the constraint.

[   if (n<=0  || n >=9) return combinations;   ]

### 1. Understand the requirement, inputs, and outputs

We give the program an integer `n` as pairs of parentheses, the function generate all combinations of well-formed parentheses.
if `n` is zero or negative, we return an empty array

As the constraint only limits `n` ≤ 8, we return also an empty array if `n` is higher.

we assume the input are only integers and no other types


### 2. Explore the program
wrote some tests to see how the program behaves

### 3. Explore possible inputs and outputs, and identify partitions

  Input parameters:
  `n` integer parameter
  - positive integer
  - negative integer
  - integer leading with zeroes

  Output parameters:
-  Empty array of string
-  Array of string

### 4. Analyze the boundaries

-  lower bound: n = 1
-  upper bound: n = 8

we test also n = 0 and n = 9

### 5. Devise test cases


- T1: `n` is negative
- T2: `n` is out of constraint (n=0)
- T3: `n` is out of constraint (n=9)

- T4: `n` is valid interger with leading zero

- T5: `n` from 1 to 8 (we brute force all values)


### 6. Automate the test cases
see: [GenerateParenthesesTest.java](generate_parentheses/src/test/java/zest/GenerateParenthesesTest.java)


## Structural testing

- line coverage: 100% (96% overall, because the method is static. Therefore, the class is never instantiated)
- branch coverage: 100% --> 0 out of 16 branches missed

no modification needed


## Mutation testing


- mutation coverage: 95% --> 21 out of 22 mutants were killed

concerning line 10:
replaced return value with Collections.emptyList for zest/GenerateParentheses::generateParentheses → SURVIVED

original:
[   if (n<=0  || n >=9) return combinations;    ]

on line 9:
List<String> combinations = new ArrayList();

in this mutation, we replace the `combinations` with `Collections.emptyList`, both element are empty, as it is the outer boundary case, thus resulting in the same result, hence why the mutation survived.
We can safely ignore this case


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

The Output is an `integer` sum which can take any integer value

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
see: [MaximumSubarrayTest](maximum_subarray/src/test/java/zest/MaximumSubarrayTest.java)

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


# Median of arrays
## Specification based Testing

### 1. Requirements
The Method `findMedianSortedArrays(int[] nums1, int[] nums2)` takes two sorted integer arrays as input and returns the median of the two. If either of the arrays is null or not sorted the returned value will be 0

### 2. Exploring
While exploring the program with some inputs it seems to be working for ordered arrays with multiple elements. However if two empty arrays are given the program returns `-1.0`. This behaviour is not specified in the readme, means the needed behaviour would need to be clarified with the stakeholders. Also the program seems to return `-1.0` for input arrays with a single elements.

### 3. Input/Output domains

possible input for `nums1` respectively `nums2`
- `input arrays` can be null
- `input arrays` can be empty
- `input arrays` can have one element
- `input arrays` can have multiple elements
- `input arrays` can have even amount of elements
- `input arrays` can have odd amount of elements
- `input arrays` can have only positive elements
- `input arrays` can have negative elements

combination of input parameters
- `nums1` is null `nums2` is null
- `nums1` is null `nums2` is empty
- `nums1` is null `nums2` has 1 element
- `nums1` is null `nums2` has multiple elements total size is even
- `nums1` is null `nums2` has multiple elements total size is odd
- `nums1` is null `nums2` has multiple elements the arrays can contain negative elements
- `nums1` is empty `nums2` is empty
- `nums1` is empty `nums2` has 1 element
- `nums1` is empty `nums2` has multiple elements total size is even
- `nums1` is empty `nums2` has multiple elements total size is odd
- `nums1` is empty `nums2` has multiple elements the arrays can contain negative elements
- `nums1` has one element `nums2` has 1 element
- `nums1` has one element `nums2` has multiple elements total size is even
- `nums1` has one element `nums2` has multiple elements total size is odd
- `nums1` has one element `nums2` has multiple elements the arrays can contain negative elements
- `nums1` multiple elements `nums2` has multiple elements total size is even
- `nums1` multiple elements `nums2` has multiple elements total size is odd
- `nums1` multiple elements `nums2` has multiple elements the arrays can contain negative elements

The output is a double which is the median of the two arrays

### 4. Boundaries
- `nums1` `nums2` is null
- `nums1` or `nums2` is empty
- `nums1` or `nums2` has one element
- `nums1` or `nums2` have multiple elements
- `nums1` and `nums2` have a combined length of 0
- `nums1` and `nums2` have a combined length of 1
- `nums1` and `nums2` have a combined length of 2

### 5. Test Cases
- `nums1` is null, `nums2` will contain multiple ordered elements
- `nums1` is not ordered, `nums2` will contain multiple ordered elements

#### `nums1` is empty
- `nums2` is empty => will not be tested since behaviour not specified (see reasoning in 2)
- `nums2` has one element
- `nums2` has multiple elements (even number)
- `nums2` has multiple elements (odd number)

#### `nums1` has one element
- `nums2` has one element
- `nums2` has multiple elements (even number)
- `nums2` has multiple elements (odd number and can contain negative elements)

#### `nums1` has multiple elements (even amount)
- `nums2` has multiple elements (even amount)

### 6. Automate the test cases
see: [MedianOfArrayTest](median_of_arrays/src/test/java/zest/MedianOfArraysTest.java)

### 7. Augment the test suite
- `nums1` has multiple elements (even amount) `nums2` has multiple elements (odd number) - check that with both arrays having elements and total size being odd still works
- test instantiation of class in a test in case it fails - provides clear information

### Code adaptation
The tests revealed no bug in the code

## Structural testing
- Instruction coverage 93%
- Branch coverage 82%
- 
Upon inspecting the code it becomes apparent that a case is missing with two empty lists. In the code it is easy to see that if there are two empty lists it should return -1. Let's verify it with a test (it works)

new coverage
- Instruction coverage 93%
- Branch coverage 82%

it is not needed to get to a 100% code coverage since the remaining uncovered branches/instructions are the same thing just for the other array. If it works for one of the arrays and the code is the same with just the variable replaced it should also work for the other.

## Mutation testing
- Mutation coverage 91%
- 40/46 Mutants killed

reasons to test or not:
- changed conditional boundary on line 19 survived. This is since there is no test which checks if the array is presumed to be sorted if there are 2 times the same number, let's write a test case for this. Indeed for this the test case and since the Readme does not specify that it is not allowed to have two times the same value we consider this a bug -> adapt the code (line 19 >= to >).
- replaced integer addition with subtraction on line 32 survived. This is since the line checks if there is an even number of elements in the array by adding the lengths and evaluating `sum(lengths) % 2 == 0` however this returns true if we either add the lengths or subtract them. Therefore all tests are still expected to pass. Therefore the mutant should survive and no new tests are required.
- replaced int return with 0 on line 10 survived. This is because it is not covered, however it is visible that line 12 which does the same for the other array is covered and kills the equivalent mutant

-new mutation coverage at 93%
- 41/46 mutants killedl

# needle_in_hay
## Specification based Testing

### 1.Requirements
Method `find(String haystack, String needl)` takes two strings needle and haystack and returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
If any string is null, return -1. If both strings are empty, return 0.

### 2. Exploring
Test various inputs

### 3. Input/Output domains
The Input are the two Strings `haystack` and `needle`
- `haystack` can be null
- `haystack` can be an empty string
- `haystack` can be a non-empty String
- `needle` can be null
- `needle` can be an empty string
- `needle` can be a non-empty String
- `needle` is in `haystack`
- `needle` is not in`haystack`

### 4. Boundaries
There are three boundaries:
- `haystack` having length 1
- `needle` having length 1
- `needle` is in `haystack` exactly once

### 5. Test Cases
- T1 `haystack` and `needle` are null
- T2 `haystack` is null
- T3 `needle` is null
- T4 `haystack` is empty
- T5 `needle` is empty
- T6 `needle` and `haystack` are empty
##### `haystack` has length 1:
- T7 `needle` is not in `haystack`
- T8 `needle` is in haystack
- T8 `needle` has length > 1
##### `needle` has length 1:
- T9 `needle` is in `haystack`
- T10 `needle` is not in `haystack`
- T11 `needle` is in `haystack` more than once
##### `haystack` and `needle` have length > 1:
- T12 `needle` is in `haystack`
- T13 `needle` is in `haystack` more than once
- T14 `needle` is not in `haystack` 

### 6. Automate the test cases
See file NeedleInHayTest

### 7. Augment the test_suite
- T15 `needle` is in `haystack` and `haystack` is a sentence
- T16 Test instantiation of class

### Code adaptation
No bugs revealed

## Structural testing
- Instruction coverage: `95%` => missing lines since NeedleInHay is a static method, therefore the Object is never instantiated => can write a test case for this `T16` => new instruction coverage `100%`
- Branch coverage: `100%` => all branches are covered

## Mutation testing
- Mutation coverage of 100%
- 19/19 Mutations were killed
- no actions needed

# palindrome
## Specification based Testing

### 1.Requirements
Given an integer `x`, return `true` if `x` is palindrome integer.
Only integers >= 0 can be palindromes. Further constraints are: `-2^20 <= x <= 2^20 - 1`

### 2. Exploring
Test various inputs

### 3. Input/Output domains
The Input is the integer x
- `x` is positive
- `x` is negative
- `x` is smaller than the minimum 
- `x` is larger than the maximum

### 4. Boundaries
There are three boundaries:
- `x` is equal to the minimum
- `x` is equal to the maximum
- `x` is 0

### 5. Test Cases
- T1 `x` is negative
- T2 `x` is positive and not a palindrome
- T3 `x` is a palindrome
- T4 `x` is larger than the maximum and a palindrome (1049401)
- T5 `x` is 0
- T6 `x` is largest possible palindrome that is smaller than maximum (1048401)

### 6. Automate the test cases
See file PalindromeOneTest and PalindromeTwoTest

### 7. Augment the test_suite
- T7 Test instantiation of class

### Code adaptation
In the test `xIsPositive` the assertion ` assertFalse(PalindromeOne.isPalindrome(1049401))` fails meaning PalindromeOne fails for a Palindrome that is larger than the maximum integer.
The same goes for PalindromeTwo.

So need to add a condition to make sure `isPalindrome` returns false if `x` > 2^20 -1.

Additionally, PalindromeTwo does not return true for `x` = 0 in the test `xIsZero` -> add a if statement that returns true if `x` = 0.

## Structural testing
#### PalindromeOne
- Instruction coverage: `100%`
- Branch coverage: `100%`
#### PalindromeTwo
- Instruction coverage: `83%`
- Branch coverage: `72%`

Missed lined 17, 18 and 26 -> added tests `xSmaller100NoPalindrome`, `xSmaller1000Palindrome` and `xLarger1000`
=> Branch and Instruction Coverage: `100%`

## Mutation testing
- PalindromeOne: Mutation Coverage: 75% -> 9 out of 12 mutants were killed

  -> line 6: Replaced double subtraction with addition → SURVIVED -> does not matter if `-1` or `+1`, there is no palindrome within this range

  -> line 6: changed conditional boundary → SURVIVED -> covered with `T4`

  -> line 13: changed conditional boundary → SURVIVED -> doesn't make sense to cover with test, start can never be greater than end.
- PalindromeTwo: Mutation Coverage: 70% -> 28 out of 40 mutants were killed

  -> line 10: Replaced double subtraction with addition → SURVIVED -> same reasoning as above

  -> line 10: changed conditional boundary → SURVIVED -> same reasoning as above

  -> line 17: negated conditional → SURVIVED -> covered with `T4`
