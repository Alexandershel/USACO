/*
 ID: shelby.2
 TASK: dualpal
 LANG: JAVA
*/

// NAME             :   Shelby Alexander
// GROUP            :   AP CS
// LAST MODIFIED    :   8 February 2020
// PROBLEM ID       :   USACO Dual Palindromes
// DESCRIPTION      :   This program prints out a
//                      number of base 10 numbers
//                      that are palindromic in at
//                      least 2 bases from 2 to 10.
// SOURCES/HELP     :   USACO

import java.io.*;
import java.util.*;

public class dualpal
{
    // declare variables
    static char[] baseMaker = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J'};
    
    public static boolean isPalindrome(String s)
    {   
        // determines if the string is a palindrome
        if(s.length() == 0 || s.length() == 1)
        {
            return true; 
        }
        if(s.charAt(0) == s.charAt(s.length()-1))
        {
            return isPalindrome(s.substring(1, s.length()-1));
        }
        else
        {
            return false;
        }
    }
    public static String toBase(int num, int base)
    {
        String s = "";
        while(num > 0)
        {
            s += baseMaker[num % base];
            num /= base;
        }
        return s;
    }
    public static void main(String[] args) throws IOException
    {
        // open files for input and output
        Scanner scan = new Scanner(new File("dualpal.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
        
        // declares variables
        int N, S, count = 0, number, numFound = 0;
        
        // reads in the input
        N = scan.nextInt();
        S = scan.nextInt();
        
        // runs program
        number = S;
        while(numFound < N)
        {
            // re-initializes variables
            count = 0;
            number++;
            
            // converts to different bases
            for(int i = 2; i <= 10; i++)
            {
                if(isPalindrome(toBase(number, i)))
                {
                    count++;
                }
            }
            
            // prints output
            if(count >= 2)
            {
                out.println(number);
                numFound++;
            }
        }
		
	// ensures that the program ends properly
	out.close();
	System.exit(0);
    }
}
