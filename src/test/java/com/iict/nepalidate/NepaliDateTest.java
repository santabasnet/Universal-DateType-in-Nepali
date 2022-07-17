package com.iict.nepalidate;

import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * This class is a part of the package com.iict.nepalidate and the package
 * is a part of the project NepaliDate.
 * <p>
 * Integrated ICT Pvt. Ltd. Lalitpur, Nepal.
 * https://www.iict.com.np/
 * <p>
 * Created by Santa on 2015-07-17.
 */
public class NepaliDateTest {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of IsValid method, of class NewsDate.
     */
    @Test
    public void testIsValid() {
        System.out.println("Test : IsValid");
        NepaliDate instance = new NepaliDate("२०७१ फाल्गुन १० मवार");
        boolean result = instance.IsValid();
        Assert.assertNotSame(result, true);
    }

    /**
     * Test of toString method, of class NewsDate.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        NepaliDate instance = new NepaliDate("२०७१ फाल्गुन १०, सोमवार");
        String expResult = "२०७१ फाल्गुन १० सोमवार";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
