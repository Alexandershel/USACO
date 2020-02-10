/*
 ID: shelby.2
 TASK: namenum
 LANG: JAVA
*/

// NAME             :   Shelby Alexander
// GROUP            :   AP CS
// LAST MODIFIED    :   4 December 2019
// PROBLEM ID       :   USACO Name That Number
// DESCRIPTION      :   This program finds the
//                      proper name for a cow.
// SOURCES/HELP     :   Mr. H, USACO

import java.io.*;
import java.util.*;
import java.lang.*;
import java.text.*;

public class namenum
{
    public static void main(String[] args) throws IOException
    {
        // opening files for input and output
        Scanner in = new Scanner(new File("namenum.in"));
        BufferedReader br = new BufferedReader(new FileReader("dict.txt"));
        PrintWriter out = new PrintWriter(new File("namenum.out"));
        
        // declare variables
        int code, nameNum;
        int j = 0;
        final int ASCII = 64, MOD_VAL = 47;
        String name;
        
        // reads in the serial code
        code = Integer.parseInt(in.next());
        
        // converts the names to numbers
        while((name = br.readLine()) != null)
        {
            // initializes variables
            nameNum = 1;
            
            // translates letters to numbers
            if(name.contains("A") || name.contains("B") || name.contains("C"))
            {
                name = name.replace("A", "2");
                name = name.replace("B", "2");
                name = name.replace("C", "2");
            }
            if(name.contains("D") || name.contains("E") || name.contains("F"))
            {
                name = name.replace("D", "3");
                name = name.replace("E", "3");
                name = name.replace("F", "3");
            }
            if(name.contains("G") || name.contains("H") || name.contains("I"))
            {
                name = name.replace("G", "4");
                name = name.replace("H", "4");
                name = name.replace("I", "4");
            }
            if(name.contains("J") || name.contains("K") || name.contains("L"))
            {
                name = name.replace("J", "5");
                name = name.replace("K", "5");
                name = name.replace("L", "5");
            }
            if(name.contains("M") || name.contains("N") || name.contains("O"))
            {
                name = name.replace("M", "6");
                name = name.replace("N", "6");
                name = name.replace("O", "6");
            }
            if(name.contains("P") || name.contains("R") || name.contains("S"))
            {
                name = name.replace("P", "7");
                name = name.replace("R", "7");
                name = name.replace("S", "7");
            }
            if(name.contains("T") || name.contains("U") || name.contains("V"))
            {
                name = name.replace("T", "8");
                name = name.replace("U", "8");
                name = name.replace("V", "8");
            }
            if(name.contains("W") || name.contains("X") || name.contains("Y"))
            {
                name = name.replace("W", "9");
                name = name.replace("X", "9");
                name = name.replace("Y", "9");
            }
            nameNum = Integer.valueOf(name);
            
            // compares the serial code to the number
            if(nameNum == code)
            {
                out.println(name);
            
                // counter
                j++;
            }
        }
        if(j == 0)
        {
            out.println("NONE");
        }
        
        
        // ensures the program ends properly
        out.close();
        System.exit(0);
    }
}
