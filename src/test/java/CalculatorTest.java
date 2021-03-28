import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    void testPlus() throws Exception{
        assertEquals(2, Calculator.calculate("1+1"));
        assertEquals(2, Calculator.calculate("1+ 1"));
        assertEquals(2, Calculator.calculate("1 +1"));
        assertEquals(2, Calculator.calculate("1 + 1"));
        assertEquals(2, Calculator.calculate(" 1 + 1 "));
        assertEquals(2, Calculator.calculate("(1 + 1)"));
        assertEquals(2, Calculator.calculate("( ( 1 + 1 ) )"));
        assertEquals(3, Calculator.calculate("1 + (1 + 1)"));
        assertEquals(2, Calculator.calculate("1 + (1)"));
        assertEquals(5, Calculator.calculate("(1 + (1)) + (1) + (1 + 1)"));
    }

    @Test
    void testMinus() throws Exception{
        assertEquals(0, Calculator.calculate("1-1"));
        assertEquals(0, Calculator.calculate("1- 1"));
        assertEquals(0, Calculator.calculate("1 -1"));
        assertEquals(0, Calculator.calculate("1 - 1"));
        assertEquals(0, Calculator.calculate(" 1 - 1 "));
        assertEquals(0, Calculator.calculate("(1 - 1)"));
        assertEquals(0, Calculator.calculate("( ( 1 - 1 ) )"));
        assertEquals(1, Calculator.calculate("1 - (1 - 1)"));
        assertEquals(0, Calculator.calculate("1 - (1)"));
        assertEquals(-1, Calculator.calculate("(1 - (1)) - (1) - (1 - 1)"));
        assertEquals(-2, Calculator.calculate("(-1) - 1"));
        assertEquals(-2, Calculator.calculate("-1 - 1"));
        assertEquals(-2, Calculator.calculate("0 - 1 - 1"));
    }

    @Test
    void testMultiplication() throws Exception{
        assertEquals(6, Calculator.calculate("2*3"));
        assertEquals(6, Calculator.calculate("2 *3"));
        assertEquals(6, Calculator.calculate("2* 3"));
        assertEquals(6, Calculator.calculate("2 * 3"));
        assertEquals(1, Calculator.calculate("2 * 0.5"));
        assertEquals(0, Calculator.calculate("2 * 0"));
        assertEquals(-6, Calculator.calculate("-2 * 3"));
        assertEquals(6, Calculator.calculate("-2 * (-3)"));
    }

    @Test
    void testDivision() throws Exception{
        assertEquals(2, Calculator.calculate("4/2"));
        assertEquals(2, Calculator.calculate("4 /2"));
        assertEquals(2, Calculator.calculate("4/ 2"));
        assertEquals(2, Calculator.calculate("4 / 2"));
        assertEquals(-2, Calculator.calculate("-4 / 2"));
        assertEquals(-2, Calculator.calculate("4 / (-2)"));
        assertEquals(2, Calculator.calculate("-4 / (-2)"));
        assertEquals(2, Calculator.calculate("(-4) / (-2)"));
        assertEquals(1, Calculator.calculate("(-4) / (-2) / 2"));
        assertEquals(4, Calculator.calculate("(-4) / ((-2) / 2)"));
        assertEquals(4, Calculator.calculate("(-4) / (((-2) / (2)))"));
    }

    @Test
    void testExponentiation() throws Exception{
        assertEquals(8, Calculator.calculate("2^3"));
        assertEquals(8, Calculator.calculate("2^ 3"));
        assertEquals(8, Calculator.calculate("2 ^3"));
        assertEquals(8, Calculator.calculate("2 ^ 3"));
        assertEquals(-8, Calculator.calculate("(-2) ^ 3"));
        assertEquals(4, Calculator.calculate("(-2) ^ 2"));
        assertEquals(0.25, Calculator.calculate("(-2) ^ (-2)"));
        assertEquals(-0.125, Calculator.calculate("(-2) ^ (-3)"));
        assertEquals(-2, Calculator.calculate("(-2) ^ (1)"));
        assertEquals(1, Calculator.calculate("(-2) ^ (0)"));
    }
}
