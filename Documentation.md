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
- `s` parameter: The string can be any string.
    - null string
    - empty string
    - non-empty string
    - leading whitespaces
    - leading zeroes

- no combination of input parameters possible, as only1 input parameter exists

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
- line coverage: 100% (96% overall, because the method is static. Therefore, the class is never instantiated)
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
