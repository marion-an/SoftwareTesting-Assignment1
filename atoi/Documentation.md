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

## Explore possible inputs and outputs, and identify partitions


# Structural testing

-> maximizing condition and branch coverage

# Mutation testing