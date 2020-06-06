package com.kmochocki;

import org.junit.Test;

import javax.script.ScriptException;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void evaluatesExpression() throws ScriptException {
        Calculator calculator = new Calculator();
        int sum = calculator.eval("1+2+3");
        assertEquals(6, sum);
    }

    @Test
    public void evaluatesExpression1() throws ScriptException {
        Calculator calculator = new Calculator();
        int sum = calculator.eval1("1+2+3");
        assertEquals(6, sum);
    }
}