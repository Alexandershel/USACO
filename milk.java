/*
 ID: shelby.2
 TASK: milk
 LANG: JAVA
*/

// NAME             :   Shelby Alexander
// GROUP            :   AP CS
// LAST MODIFIED    :   6 November 2019
// PROBLEM ID       :   USACO Mixing Milk
// DESCRIPTION      :	This program 
// SOURCES/HELP     :   Mr. H, USACO

import java.io.*;
import java.util.*;

public class milk 
{  
    public static void main(String[] args) throws IOException
    {
        // opening files for input and output
        Scanner in = new Scanner(new File("milk.in"));
        PrintWriter out = new PrintWriter(new File("milk.out"));
        // declare variables
        int N, M, least = 0, unit = 0, currentP = 0, check = 0, price = 0;
        
        // reads in the variables
        N = in.nextInt();
        M = in.nextInt();
        int[] P = new int[M];
        int[] A = new int[M];
        for(int j = 0; j < M; j++)
        {
            int p1 = in.nextInt();
            int a1 = in.nextInt();
            P[j] = p1;
            A[j] = a1;
        }
        
        // determines the lowest price
        P[0] = least;
        for(int j = 1; j < M; j++)
        {
            if(P[j] < least)
            {
                least = P[j];
                unit = A[j];
            }
        }
        
        // repeats the program
        while(N != 0)
        {
            while(unit != 0)
            {
                N -= unit;
                price += least;
                unit--;
            }
            
            // determines the next lowest price
            currentP = least;
            check = least;
            while(currentP == least)
            {
                check++;
                for(int j = 0; j < M; j++)
                {
                    if(P[j] == check)
                    {
                        least = P[j];
                        unit = A[j];
                        break;
                    }
                }
            }
        }
        
        // prints answer
        out.print(price);
        
        // ensures that the program ends properly
        out.close();
        System.exit(0);
    }
}
