package zest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;
import org.junit.jupiter.params.provider.MethodSource;
import zest.PalindromeOne;

import java.util.stream.Stream;

class PalindromeOneTest {
    @ParameterizedTest
    @MethodSource("generator")
    void test (int x, boolean expectedBool){
        assertEquals(PalindromeOne.isPalindrome(x), expectedBool);
    }

    static Stream<Arguments> generator() {
        return Stream.of(
                of(-1, false),
                of(1048576, false),
                of(0, true),
                of(1048401, true)
        );
    }


}