package org.example.test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class FunctionTest {

    @Test
    void functionTest1(){
        Function function = new Function(1, 9, 100000 ,  t -> 3 * Math.sqrt(t));;
        double expected = 51.999759999466676;
        double result = function.calculate();
        assertEquals(expected, result, 1e-6);
    }
}