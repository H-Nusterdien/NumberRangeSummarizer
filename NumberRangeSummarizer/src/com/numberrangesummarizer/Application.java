// CODE TO BE REVIEWED

package com.numberrangesummarizer;

import java.io.BufferedReader;
import java.util.*;

/**
 * @author Hishaam Nusterdien
 *
 */

public class Application
{
    public static void main(String[] args)
    {
        // Header
        System.out.println("=======================================================" + "\n" +
                           "\t\t\t\tNUMBER RANGE SUMMARIZER" + "\n"+
                           "=======================================================" + "\n");

        // Instances
        NumberRangeSummarizerImpl myMethods = new NumberRangeSummarizerImpl();
        Scanner userInput = new Scanner(System.in);

        // Ask user to enter a string of numbers, each separated by a comma
        System.out.print("Enter a sequence of numbers, each separated by a comma" + "\n\n" +
                         "Enter Here\t: ");
        String userNumbers = userInput.nextLine();

        // Calls "collect" method
        List<Integer> collectionOfIntegers = (ArrayList<Integer>) myMethods.collect(userNumbers);

        // Prints out the returned String of "summarizeCollection" method
        System.out.println("Summarized\t: " + myMethods.summarizeCollection(collectionOfIntegers));
    }
}
