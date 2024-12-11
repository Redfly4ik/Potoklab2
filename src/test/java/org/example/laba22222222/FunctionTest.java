package org.example.laba22222222;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class FunctionTest {

    @Test
    void functionTest1(){
        Function function = new Function(Math.PI/6, Math.PI/4, 100000 ,t -> 1 / Math.pow(Math.sin(2 * t), 2)  );
        double expected = 0.2886751389581343;
        double result = function.calculate();
        assertEquals(expected, result, 1e-6);
    }
  
}