package calculator.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static calculator.service.CalculatorServiceTestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CalculatorServiceTest {

    private final CalculatorService out = new CalculatorService();

    @Test
    void checkSum() {
        String resultFromTestedMethod = out.sum(1, 1);
        assertTrue(resultFromTestedMethod.contains(ONEPLUSONE_RESULT_INCL));
        assertEquals(ONEPLUSONE_RESULT, resultFromTestedMethod);

        resultFromTestedMethod = out.sum(-1, -1);
        assertTrue(resultFromTestedMethod.contains(MINUSONEPLUSMINUSONE_RESULT_INCL));
        assertEquals(MINUSONEPLUSMINUSONE_RESULT, resultFromTestedMethod);
    }

    @Test
    void checkSubstract() {
        String result = out.substract(1, 1);
        assertTrue(result.contains(ONEMINUSONE_RESULT_INCL));
        assertEquals(ONEMINUSONE_RESULT, result);

        result = out.substract(-1, -1);
        assertTrue(result.contains(MINUSONEMUNUSMINUSONE_RESULT_INCL));
        assertEquals(MINUSONEMINUSMINUSONE_RESULT, result);
    }

    @Test
    void checkMultiply() {
        String result = out.multiply(1, 1);
        assertTrue(result.contains(ONEMULTIPLYONE_RESULT_INCL));
        assertEquals(ONEMULTIPLYONE_RESULT, result);

        result = out.multiply(-1, -1);
        assertTrue(result.contains(MINUSONEMULTIPLYMINUSONE_RESULT_INCL));
        assertEquals(MINUSONEMULTIPLYMINUSONE_RESULT, result);
    }

    @Test
    void checkDivide() {
        String result = out.divide(1, 1);
        assertTrue(result.contains(ONEDIVIDEONE_RESULT_INCL));
        assertEquals(ONEDIVIDEONE_RESULT, result);

        result = out.divide(-1, -1);
        assertTrue(result.contains(MINUSONEDIVIDEMINUSONE_RESULT_INCL));
        assertEquals(MINUSONEDIVIDEMINUSONE_RESULT, result);
    }

    @Test
    void checkDivideException() {
        String result = out.divide(1, 0);
        assertEquals(ONEDIVIDEONE_EXCEPTION_RESULT, result);
    }

    public static Stream<Arguments> provideParamsForTestSum() {
        return Stream.of(
                Arguments.of(1, 1, ONEPLUSONE_RESULT_INCL, ONEPLUSONE_RESULT),
                Arguments.of(-1, -1, MINUSONEPLUSMINUSONE_RESULT_INCL, MINUSONEPLUSMINUSONE_RESULT)
        );
    }

    public static Stream<Arguments> provideParamsForTestSub() {
        return Stream.of(
                Arguments.of(1, 1, ONEMINUSONE_RESULT_INCL, ONEMINUSONE_RESULT),
                Arguments.of(-1, -1, MINUSONEMUNUSMINUSONE_RESULT_INCL, MINUSONEMINUSMINUSONE_RESULT)
        );
    }

    public static Stream<Arguments> provideParamsForTestMul() {
        return Stream.of(
                Arguments.of(1, 1, ONEMULTIPLYONE_RESULT_INCL, ONEMULTIPLYONE_RESULT),
                Arguments.of(-1, -1, MINUSONEMULTIPLYMINUSONE_RESULT_INCL, MINUSONEMULTIPLYMINUSONE_RESULT)
        );
    }

    public static Stream<Arguments> provideParamsForTestDiv() {
        return Stream.of(
                Arguments.of(1, 1, ONEDIVIDEONE_RESULT_INCL, ONEDIVIDEONE_RESULT),
                Arguments.of(-1, -1, MINUSONEDIVIDEMINUSONE_RESULT_INCL, MINUSONEDIVIDEMINUSONE_RESULT)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTestSum")
    public void testSumOnAllParams(Integer firstParam, Integer secondParam, String expectResultIncl, String expectResult) {
        String resultFromTestedMethod = out.sum(firstParam, secondParam);
        assertTrue(resultFromTestedMethod.contains(expectResultIncl));
        assertEquals(expectResult, resultFromTestedMethod);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTestSub")
    public void testSubOnAllParams(Integer firstParam, Integer secondParam, String expectResultIncl, String expectResult) {
        String resultFromTestedMethod = out.substract(firstParam, secondParam);
        assertTrue(resultFromTestedMethod.contains(expectResultIncl));
        assertEquals(expectResult, resultFromTestedMethod);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTestMul")
    public void testMulOnAllParams(Integer firstParam, Integer secondParam, String expectResultIncl, String expectResult) {
        String resultFromTestedMethod = out.multiply(firstParam, secondParam);
        assertTrue(resultFromTestedMethod.contains(expectResultIncl));
        assertEquals(expectResult, resultFromTestedMethod);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTestDiv")
    public void testDivOnAllParams(Integer firstParam, Integer secondParam, String expectResultIncl, String expectResult) {
        String resultFromTestedMethod = out.divide(firstParam, secondParam);
        assertTrue(resultFromTestedMethod.contains(expectResultIncl));
        assertEquals(expectResult, resultFromTestedMethod);
    }
}