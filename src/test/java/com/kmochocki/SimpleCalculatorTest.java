package com.kmochocki;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleCalculatorTest {

    @Test
    public void shouldAddTwoPositiveNumbersUsingAddMethod() {
        int a = 3;
        int b = 4;

        int result = new SimpleCalculator().add(a, b);

        assertThat(result, equalTo(7));
    }

    @Test
    public void shouldAddTwoNegativeNumbersUsingAddMethod() {
        int a = -3;
        int b = -4;

        int result = new SimpleCalculator().add(a, b);

        assertThat(result, equalTo(-7));
    }

    @Test
    public void shouldReturnMIN_VALUEWhenIncrementMAX_VALUEUsingAddMethod() {
        int result = new SimpleCalculator().add(Integer.MAX_VALUE, 1);

        assertThat(result, equalTo(Integer.MIN_VALUE));
    }

    @Test
    public void shouldAddTwoPositiveNumbersUsingAddPositiveMethod() {
        int a = 3;
        int b = 4;

        int result = new SimpleCalculator().addPositve(a, b);

        assertThat(result, equalTo(7));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldAddTwoNegativeNumbersUsingAddPositiveMethod() {
        new SimpleCalculator().addPositve(-3, -4);
    }

    @Test
    public void shouldReturnMIN_VALUEWhenIncrementMAX_VALUEUsingAddPositiveMethod() {
        int result = new SimpleCalculator().addPositve(Integer.MAX_VALUE, 1);

        assertThat(result, equalTo(Integer.MIN_VALUE));
    }

}