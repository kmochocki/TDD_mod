package com.kmochocki;

import org.junit.Test;
import org.junit.function.ThrowingRunnable;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertThrows;

public class MaxValueTest {

    @Test
    public void shouldReturnFourWhenPassedOneTwoThreeFour() {
        int[] list = {1, 2, 3, 4};

        int largest = MaxValue.largest(list);

        assertThat(largest, is(4));
    }

    @Test
    public void shouldReturnLargestWhenPassedUnorderedArray() {
        int[] list = {1, 6, 2, 3};

        int largest = MaxValue.largest(list);

        assertThat(largest, is(6));
    }

    @Test
    public void shouldReturnFourWhenPassedMultipleFours() {
        int[] list = {4, 4, 4, 4, 4};

        int largest = MaxValue.largest(list);

        assertThat(largest, is(4));
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenEmptyArray() {
        int[] list = {};

        MaxValue.largest(list);
    }

    @Test
    public void shouldThrowExceptionWithAppropriateMessageWhenEmptyArray() {
        int[] list = {};

        ThrowingRunnable action = () -> MaxValue.largest(list);

        Exception exception = assertThrows(RuntimeException.class, action);
        String expectedMessage = "Lista jest pusta";
        String actualMessage = exception.getMessage();
        assertThat(actualMessage, equalTo(expectedMessage));
    }
}