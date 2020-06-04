// CODE TO BE REVIEWED

package com.numberrangesummarizer;

import java.util.*;

/**
 * @author Hishaam Nusterdien
 *
 */

public class NumberRangeSummarizerImpl implements NumberRangeSummarizer
{
    /**
     Function    :   Checks if last character of string equals a specific character.
     Arguments   :   String - words/numbers/etc, String - One character
     Returns     :   Boolean - true or false
     */
    protected boolean isLastCharOfStr(String str, String character)
    {
        if( (str.substring(str.length()-1)).equals(character) )
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     Function    :   Converts a String of comma separated values to a collection of Integers.
     Arguments   :   String - User's input
     Returns     :   Collection of Integers
     */
    @Override
    public Collection<Integer> collect(String input)
    {
        List<Integer> userNumList = new ArrayList<>();

        // Removes spaces
        input = input.replaceAll(" ", "");

        // Numbers are split up by a comma and are added to an Array
        String[] numListArray = input.split(",");

        // Checks if any / how many characters have been entered by the user
        int charCount = 0;

        // Loops over Arrays, converts Strings to Integers and add the Integers to an ArrayList
        for (String numStr : numListArray)
        {
           try
           {
               if(numStr.equals(""))
               {
                   continue;
               }
               userNumList.add(Integer.parseInt(numStr));
           }
           catch (NumberFormatException e)
           {
               charCount++;
           }
        }

        // Prints out a message if characters have been found
        if (charCount > 0)
        {
            System.out.println("\n" + "Note!" + "\n" +
                               "* " + charCount + " character/s have been found and removed" + "\n" +
                               "* " + "Only numbers should have been included" + "\n");
        }

        return userNumList;
    }

    /**
     Function    :   Sorts the collection of integers, removes all duplicate integers and then
                     converts it to a comma delimited list of numbers as a String.
     Arguments   :   Collection of Integers
     Returns     :   String - A comma delimited sequence of numbers
     */
    @Override
    public String summarizeCollection(Collection<Integer> input)
    {
        // Sort
        Collections.sort((List<Integer>)input);

        // Remove Duplicates
        Set<Integer> noDupList = new LinkedHashSet<>(input);
        List<Integer> newNumList = new ArrayList<>(noDupList);

        // String - Delimited Number List to be returned
        String str = "";

        int currentNum = 0;
        int previousNum = 0;

        // Loops through the Collection of Integers and forms a delimited number sequence as a String
        for (int i : newNumList)
        {
            currentNum = i;

            if(i == newNumList.get(0))
            {
                str += currentNum;
            }

            else if (currentNum == previousNum + 1)
            {
                if ( !(isLastCharOfStr(str,"-")) )
                {
                    str += "-";
                }
            }
            else
            {
                if ( isLastCharOfStr(str,"-") )
                {
                    str += previousNum + ", " + currentNum;
                }
                else
                {
                    str += ", " + currentNum;
                }
            }

            previousNum = i;
        }

        if ( isLastCharOfStr(str,"-") )
        {
            str += currentNum;
        }

        return str;
    }
}
