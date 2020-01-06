/*
 ID: shelby.2
 TASK: wormhole
 LANG: JAVA
*/

// NAME             :   Shelby Alexander
// GROUP            :   AP CS
// LAST MODIFIED    :   6 November 2019
// PROBLEM ID       :   USACO Wormholes
// DESCRIPTION      :	This program determines the
//                      number of wormhole loops that
//                      the cow could get trapped in.
// SOURCES/HELP     :   Mr. H, USACO, Anna Buck

import java.io.*;
import java.util.Scanner;

public class wormhole 
{
    // declare variables
    final static int MAX_N = 12;
    static int N = 0;
    static int[] partner = new int[MAX_N + 1];
    static int[] x = new int[MAX_N + 1];
    static int[] y = new int[MAX_N + 1];
    static int[] next_right = new int[MAX_N + 1];
    
    // determines if a cycle exists
    public static boolean cycle_exists()
    {
        for(int j = 1; j <= N; j++)
        {
            int pos = j;
            for(int k = 0; k < N; k++)
            {
                pos = next_right[partner[pos]];
            }
            if(pos != 0)
            {
                return true;
            }
        }
        return false;
    }
    
    // counts all solutions
    private static int solve()
    {
        // declare variables
        int i = 0, total = 0;
        
        // finds first unpaired wormhole
        for(i = 1; i <= N; i++)
        {
            if(partner[i] == 0)
            {
                break;
            }
        }
        
        // checks if everyone is paired
        if(i > N)
        {
            if(cycle_exists())
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
        
        // try to pairing i and j
        for(int j = i + 1; j <= N; j++)
        {
            if(partner[j] == 0)
            {
                partner[i] = j;
                partner[j] = i;
                total += solve();
                partner[i] = partner[j] = 0;
            }
        }
        
        return total;
    }
    
    public static void main(String[] args) throws IOException
    {
        // opening files for input and output
        Scanner in = new Scanner(new File("wormhole.in"));
        PrintWriter out = new PrintWriter(new File("wormhole.out"));
        
        // reads in variables
        N = in.nextInt();
        for(int i = 1; i <= N; i++)
        {
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            
            x[i] = x1;
            y[i] = y1;
        }
        
        // checks if the case is a loop
        for(int m = 1; m <= N; m++)
        {
            for(int n = 1; n <= N; n++)
            {
                if(x[n] > x[m] && y[m] == y[n])
                {
                    if(next_right[m] == 0 || (x[n] - x[m]) < (x[next_right[m]] - x[m]))
                    {
                        next_right[m] = n;
                    }
                }
            }
        }
        
        // prints answer
        out.println(solve());
        
        // ensures that the program ends properly
        out.close();
        System.exit(0);
    }
}
