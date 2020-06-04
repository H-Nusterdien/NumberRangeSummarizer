// CODE TO BE REVIEWED

package com.numberrangesummarizer;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Hishaam Nusterdien
 *
 */

class NumberRangeSummarizerImplTest {

    NumberRangeSummarizerImpl test = new NumberRangeSummarizerImpl();

    @Test
    void testIsLastCharOfStr()
    {
        // Argument/s
        String str = "Impact";
        String chr = "t";

        // Expected Output
        boolean expectedOutput = true;

        // Actual Output
        boolean actualOutput = test.isLastCharOfStr(str,chr);

        // Checks if the Expected Output equals the Actual Output
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testCollect()
    {
        // Argument
        String strOfInts = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";

        // Expected Output
        Collection<Integer> expectedOutput = Arrays.asList(1,3,6,7,8,12,13,14,15,21,22,23,24,31);

        // Actual Output
        Collection<Integer> actualOutput = test.collect(strOfInts);

        // Checks if the Expected Output equals the Actual Output
        assertEquals(expectedOutput,actualOutput);
    }

    @Test
    void testSummarizeCollection()
    {
        // Argument
        Collection<Integer> collectionOfInts = Arrays.asList(1,3,6,7,8,12,13,14,15,21,22,23,24,31);

        // Expected Output
        String expectedOutput = "1, 3, 6-8, 12-15, 21-24, 31";

        // Actual Output
        String actualOutput = test.summarizeCollection(collectionOfInts);

        // Checks if the Expected Output equals the Actual Output
        assertEquals(expectedOutput, actualOutput);
    }
}
