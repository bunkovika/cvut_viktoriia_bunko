package lab03;

import org.junit.jupiter.api.*;
import hm2.Calculator;
public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void addTest(){
        Assertions.assertEquals(0, calculator.add(15,-15));
        Assertions.assertEquals(3588630, calculator.add(16352355,-12763725));}
    @Test
    public void subtractTest(){
        Assertions.assertEquals(0, calculator.subtract(5,5));
        Assertions.assertEquals(29116080, calculator.subtract(16352355,-12763725));
    }
    @Test
    public void multiplyTest(){
        Assertions.assertEquals(0, calculator.multiply(12, 0));
        Assertions.assertEquals(0, calculator.multiply(0, -88885));
    }
    @Test
    public void divideTest(){
        Assertions.assertEquals(0, calculator.divide(0, 5));
        Assertions.assertEquals(-4, calculator.divide(-12, 3));
        Assertions.assertEquals(4, calculator.divide(9,2));
    }
    @Test
    public void divideByNuleTest(){
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.divide(-2, 0));
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.divide(4, 0));
    }

}
