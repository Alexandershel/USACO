/*
 ID: shelby.2
 TASK: gift1
 LANG: JAVA
*/

// NAME             :   Shelby Alexander
// GROUP            :   AP CS
// LAST MODIFIED    :   2 October 2019
// PROBLEM ID       :   USACO Greedy Gift Givers
// DESCRIPTION      :   This program finds the balances
//			            bank accounts after a number
//		                of rounds of gift giving.
// SOURCES/HELP     :   Mr. H, USACO, Anna Buck,
//                      Aiden Eichman

import java.io.*;
import java.lang.*;
import java.text.*;
import java.util.*;

public class gift1
{
    public static void main(String[] args) throws IOException
    {
        // opening files for input and output
        RandomAccessFile in = new RandomAccessFile ("gift1.in", "r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));

        // declares an integer and reads it in from file
        int numPeople = Integer.parseInt(in.readLine());

        // declare and initiate variables
        String giver, receiver;
        int money, numGive;
        int[] account = new int[numPeople];
        String[] people = new String[numPeople];
        for(int j = 0; j < numPeople; j++)
        {
            account[j] = 0;
            people[j] = in.readLine();
        }

        // repeats gift giving
        for(int j = 0; j < numPeople; j++)
        {
            // reads in these variables from the input file
            giver = in.readLine();
            StringTokenizer st = new StringTokenizer(in.readLine());
            money = Integer.parseInt(st.nextToken());
            numGive = Integer.parseInt(st.nextToken());

            // finds the amount of money in the giver's account
            for(int k = 0; k < numPeople; k++)
            {
                if(giver.equals(people[k]))
                {
                    account[k] -= money;

                    // determines if the giver matches the account
                    if(numGive != 0)
                    {
                        //finds the new giver account balance
                        account[k] += money % numGive;
                    }
                }
            }

            // finds amount of money in the receiver's account
            for(int i = 0; i < numGive; i++)
            {
                // reads in the receiver
                receiver = in.readLine();

                for(int k = 0; k < numPeople; k++)
                {
                    // determines if the receiver matches the account
                    if(receiver.equals(people[k]) && numPeople != 0)
                    {
                        // finds the new receiver account balance
                        account[k] += money / numGive;
                    }
                }
            }
        }

        // outputs account balances and associated names
        for(int j = 0; j < numPeople; j++)
        {
            out.println(people[j] + " " + account[j]);
        }

		// ensures the program ends properly
		out.close();
		System.exit(0);
    }
}
