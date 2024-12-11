package org.example.laba22222222.lab2;



import org.example.laba22222222.Function;

import java.util.concurrent.Callable;
import java.util.function.DoubleUnaryOperator;

public class CallableIntegralCalculator implements Callable<Double> {

    private final Function function;

    public CallableIntegralCalculator(double start, double end, int nSteps, DoubleUnaryOperator f) {
        function = new Function(start, end, nSteps, f);
    }

    @Override
    public Double call() {
        return function.calculate();
    }
}
