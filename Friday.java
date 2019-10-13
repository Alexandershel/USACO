/*
 ID: shelby.2
 TASK: friday
 LANG: JAVA
*/

// NAME             :   Shelby Alexander
// GROUP            :   AP CS
// LAST MODIFIED    :   13 October 2019
// PROBLEM ID       :   USACO Friday the 13th
// DESCRIPTION      :	This program finds the
//			amount of times that the 
//			13th lands on a Friday over
//			certain span of time.
// SOURCES/HELP     :   Mr. H, USACO

import java.io.*;
import java.lang.*;
import java.text.*;
import java.util.*;

public class friday
{
    public static void main(String[] args) throws IOException
    {
        // opening files for input and output
        RandomAccessFile in = new RandomAccessFile ("friday.in", "r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        
        // declare variables
	final int START_YEAR = 1900, WEEK_LENGTH = 7;
	int numYears, date, dayThirteenth;
	int[] monthLength = new int[] {31,28,31,30,31,30,31,31,30,31,30,31};
        int[] dayTotals = new int[WEEK_LENGTH];
        int[] extraDays = new int[13];

	// reads in the number of years
        numYears = Integer.parseInt(in.readLine());
    
	// initializes variables
        for(int j = 0; j < 7; j++)
        {
            dayTotals[j] = 0;
        }
        date = 13;

        // finds the amount of days greater than 28 in a month
        for(int j = 0; j < 12; j++)
        {
            extraDays[j] = 0;
        }

        // runs the program as long as the year is in our timeline
        for(int currentYear = START_YEAR; currentYear < START_YEAR + numYears; currentYear++)
        {
            // finds if it is a leap year
            if(currentYear % 400 == 0 || currentYear % 4 == 0 && currentYear % 100 != 0)
            {
                monthLength[1] = 29;
            }
            else
            {
                monthLength[1] = 28;
            }

            // repeats process every month
            for(int i = 0; i < 12; i++)
            {
                // finds the day of the month that the 13th falls on
                date += extraDays[i];
                dayThirteenth = date % WEEK_LENGTH;

                // adds a tally to the weekday that the 13th landed on
                dayTotals[dayThirteenth]++;

                // calculates the next offset
                if(i == 11)
                {
                    extraDays[0] = monthLength[i] - 28;
                }
                else
                {
                    extraDays[i+1] = monthLength[i] - 28;
                }
            }
        }

        // prints the output
        out.print(dayTotals[6] + " ");
        for(int j = 0; j < 5; j++)
        {
            out.print(dayTotals[j] + " ");
        }
        out.println(dayTotals[5]);

        // ensures the program ends properly
        out.close();
        System.exit(0);
    }
}
