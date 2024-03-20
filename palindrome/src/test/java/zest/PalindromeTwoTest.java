package zest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;
import org.junit.jupiter.params.provider.MethodSource;
import zest.PalindromeTwo;

import java.util.stream.Stream;

class PalindromeTwoTest {

    @ParameterizedTest
    @MethodSource("generator")
    void test (int x, boolean expectedBool){
        assertEquals(PalindromeTwo.isPalindrome(x), expectedBool);
    }

    static Stream<Arguments> generator() {
        return Stream.of(
                of(-1, false),
                of(1048576, false),
                of(0, true),
                of(100, false),
                of(22, true),
                of(21, false),
                of(202, true),
                of(1001, true),
                of(1048401, true)
        );
    }


}