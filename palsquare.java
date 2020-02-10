/*
 ID: shelby.2
 TASK: palsquare
 LANG: JAVA
*/

// NAME             :   Shelby Alexander
// GROUP            :   AP CS
// LAST MODIFIED    :   3 February 2020
// PROBLEM ID       :   USACO Palindromic Squares
// DESCRIPTION      :   This program prints out the
//                      palindromes when a number is 
//                      squared in base B.
// SOURCES/HELP     :   USACO

import java.io.*;
import java.util.*;

public class palsquare 
{
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
    public static void main(String[] args) throws IOException
    {
        // open files for input and output
        Scanner scan = new Scanner(new File("palsquare.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
        
        // declares variables
        int B;
        
        // reads in the input
        B = scan.nextInt();
        
        // prints the output
        for(int num = 1; num <= 299; num += 2)
        {
            int squared = num * num;
            
            // converts the numbers to base B
            String str1 = Integer.toString(num, B).toUpperCase();
            String str2 = Integer.toString(squared, B).toUpperCase();
            
            // prints the output
            if(isPalindrome(String.valueOf(str2)))
            {
                out.println(str1 + " " + str2);
            } 
        }
		
	// ensures that the program ends properly
	out.close();
	System.exit(0);
    }
}
