package com.kmochocki;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class SimpleSampleTest {

    @Before
    public void setUp() {
        System.out.println("before");
    }

    @After
    public void tearDown() {
        System.out.println("after");
    }

    @BeforeClass
    public static void setUpAll() {
        System.out.println("before class");
    }

    @AfterClass
    public static void tearDownAll() {
        System.out.println("after class");
    }

    @Test
    public void cos() {
        System.out.println("cos");
        SimpleSample.cos();
        assertEquals(2, 1);
    }

    @Test
    public void name() {
        SimpleSample.cosEx();
        System.out.println("name");
    }
}