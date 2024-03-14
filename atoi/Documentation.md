# Specification-based testing

## 1. Understand the requirement, inputs, and outputs

Method: `myAtoi(string s)`
converts a string to a 32-bit signed integer

- `s`: String to be converted.
    - if `s` is null, return 0
    - if `s` doesn't contain any digits to convert, return 0
      return converted integer, or 0 if the input is null or if there are no digits to be converted

## 2. Explore the program

```
@Test
void inputNull() {
assertEquals(0, MyAtoi.myAtoi(null));
}

@Test
void inputNoInteger() {
    assertEquals(0, MyAtoi.myAtoi("abc"));
}

@Test
void inputLeadingWhiteSpaces() {
    assertEquals(-1, MyAtoi.myAtoi("              -1"));
}

@Test
void charactersInFrontOfString() {
    assertEquals(0, MyAtoi.myAtoi("avc123"));
}

@Test
void gapInBetween() {
    assertEquals(45, MyAtoi.myAtoi("   +45 78"));
}
```

## 3. Explore possible inputs and outputs, and identify partitions
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

## 4. Analyze the boundaries
- `s` having length 1
- 2^31 - 1 integer
- -2^31 integer

## 5. Devise test cases
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

## 6. Automate the test cases
see: [MyAtoiTest.java](src/test/java/zest/MyAtoiTest.java)

## 7. Augment the test suite with creativity and experience
- T14: `s` contains an integer which is split by a whitespace




# Structural testing

-> maximizing condition and branch coverage

# Mutation testing