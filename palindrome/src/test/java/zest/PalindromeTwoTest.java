package zest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

import static java.lang.Math.round;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.of;
import org.junit.jupiter.params.provider.MethodSource;
import zest.PalindromeTwo;

import java.util.stream.Stream;

class PalindromeTwoTest {
        @Test
        void xIsNegative(){
            assertFalse(PalindromeTwo.isPalindrome(-1));
        }

        @Test
        void xIsPositive(){
            assertFalse(PalindromeTwo.isPalindrome(10));
            assertTrue(PalindromeTwo.isPalindrome(11));
            assertFalse(PalindromeTwo.isPalindrome(1049401));
            assertTrue(PalindromeTwo.isPalindrome(1048401));
        }

        @Test
        void xSmaller100NoPalindrome(){
            assertFalse(PalindromeTwo.isPalindrome(21));
        }

        @Test
        void xSmaller1000Palindrome(){
            assertTrue(PalindromeTwo.isPalindrome(101));
        }

        @Test
        void xLarger1000(){
            assertFalse(PalindromeTwo.isPalindrome(1234));
            assertTrue(PalindromeTwo.isPalindrome(1001));
        }

        @Test
        void xIsZero(){
            assertTrue(PalindromeTwo.isPalindrome(0));
        }
}