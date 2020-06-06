package com.kmochocki;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FirstTest {

    @Test
    public void shouldReturnOneTwoWhenPassedOneTwo() {
        String first = "one";
        String second = "two";

        String result = First.concatString(first, second);

        assertThat(result, equalTo("onetwo"));
    }

    @Test
    public void shouldReturnWordNullWhenPassedNull() {
        String first = null;
        String second = "two";

        String result = First.concatString(first, second);

        assertThat(result, equalTo("nulltwo"));
    }

    @Test
    public void shouldReturnEmptyStringWhenPassedEmptyStringAsFirstArgument() {
        String first = "";
        String second = "two";

        String result = First.concatString(first, second);

        assertThat(result, equalTo("two"));
    }

    @Test
    public void shouldReturnEmptyStringWhenPassedEmptyStringAsSecondArgument() {
        String first = "one";
        String second = "";

        String result = First.concatString(first, second);

        assertThat(result, equalTo("one"));
    }

    @Test
    public void shouldReturnTwelveWhenMultiplyingThreeAndFour() {
        int result = First.multiply(3, 4);

        assertThat(result, is(12));
    }

    @Test
    public void shouldReturnZeroWhenMultiplyingZeroAndFour() {
        int result = First.multiply(0, 4);

        assertThat(result, is(0));
    }

    @Test
    public void shouldReturnZeroWhenMultiplyingThreeAndZero() {
        int result = First.multiply(3, 0);

        assertThat(result, is(0));
    }
}