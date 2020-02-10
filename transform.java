/*
 ID: shelby.2
 TASK: transform
 LANG: JAVA
*/

// NAME             :   Shelby Alexander
// GROUP            :   AP CS
// LAST MODIFIED    :   9 February 2020
// PROBLEM ID       :   USACO Transformations
// DESCRIPTION      :   This program finds how many
//                      steps it takes to transform
//                      a given figure into another.
// SOURCES/HELP     :   USACO

import java.io.*;
import java.util.*;

public class transform
{
    // declares the variable for side length
    static int N;
    
    public static boolean equal(char[][] fig1, char[][] fig2)
    {   
        // determines if the arrays are the same
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < N; j++)
            {
                if(fig1[i][j] != fig2[i][j])
                {
                    return false;
                }
            }
        }
        return true;
    }
    public static char[][] rotate(char[][] fig)
    {
        // rotates the figure 90 degrees
        char[][] figNew = new char[N][N];
	for (int i = 0; i < N; i++) 
        {
            for (int j = 0; j < N; j++) 
            {
                figNew[j][N - i - 1] = fig[i][j];
            }
	}
        return figNew;
    }
    public static char[][] reflect(char[][] fig)
    {
        // reflects the figure horizontally
	char[][] figNew = new char[N][N];
	for (int i = 0; i < N; i++) 
        {
            int low = 0;
            int high = N - 1;
            while (low <= high) 
            {
                figNew[i][low] = fig[i][high];
                figNew[i][high] = fig[i][low];
                low++;
                high--;
            }
	}
        return figNew;
    }
    public static void main(String[] args) throws IOException
    {
        // open files for input and output
        Scanner scan = new Scanner(new File("transform.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
        
        // declares and read in the side length of the figure
        N = Integer.parseInt(scan.nextLine());
                
        // declare variables
        char[][] before = new char[N][N];
        char[][] after = new char[N][N];
        String currentLine;
        
        // reads in the two figures
        for(int i = 0; i < N; i++)
        {
            currentLine = scan.nextLine();
            for(int j = 0; j < N; j++)
            {
                before[i][j] = currentLine.charAt(j);
            }
        }
        for(int i = 0; i < N; i++)
        {
            currentLine = scan.nextLine();
            for(int j = 0; j < N; j++)
            {
                after[i][j] = currentLine.charAt(j);
            }
        }
        
        // determines the method and prints the answer
        if(equal(rotate(before), after))
        {
            out.println("1");
        }
        else if(equal(rotate(rotate(before)), after))
        {
            out.println("2");
        }
        else if(equal(rotate(rotate(rotate(before))), after))
        {
            out.println("3");
        }
        else if(equal(reflect(before), after))
        {
            out.println("4");
        }
        else if(equal(rotate(reflect(before)), after))
        {
            out.println("5");
        }
        else if(equal(rotate(rotate(reflect(before))), after))
        {
            out.println("5");
        }
        else if(equal(rotate(rotate(rotate(reflect(before)))), after))
        {
            out.println("5");
        }
        else if(equal(before, after))
        {
            out.println("6");
        }
        else
        {
            out.println("7");
        }
		
	// ensures that the program ends properly
	out.close();
	System.exit(0);
    }
}
