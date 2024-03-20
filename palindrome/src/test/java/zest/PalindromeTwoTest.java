package zest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.of;
import org.junit.jupiter.params.provider.MethodSource;
import zest.PalindromeTwo;

import java.util.stream.Stream;

class PalindromeTwoTest {
        @Test
        void xIsNegative(){
            assertFalse(PalindromeOne.isPalindrome(-1));
        }

        @Test
        void xIsPositive(){
            assertFalse(PalindromeOne.isPalindrome(10));
            assertTrue(PalindromeOne.isPalindrome(11));
            assertFalse(PalindromeOne.isPalindrome(1049401));
            assertTrue(PalindromeOne.isPalindrome(1048401));
        }

        @Test
        void xIsZero(){
            assertTrue(PalindromeOne.isPalindrome(0));
        }

    @Test
    void instantiateClassAndCheckIfWorks(){
        int[] a = {1};
        PalindromeTwo p = new PalindromeTwo();
        assertTrue(p.isPalindrome(0));
    }
}