// NAME            : S. Alexander
// GROUP           : APCS
// LAST MODIFIED   : 17 October 2019
// PROBLEM ID      : Ride FileIO
// DECRIPTION      : Program that takes the ASCII
//                   values of characters of two
//                   strings, calculates a value
//                   for each and verifies if they
//                   are equal. I used NetBeans and
//                   stored the text files in the
//                   NetBeans projects folder.
// SOURCES/HELP    : USACO, Mr. Houtrouw

import java.io.*;
import java.util.*;

public class Input_USACO
{
    public static void main (String[] args) throws IOException
    {
        // opening files for input and output
        File file = new File(System.getProperty("user.dir")+"/Ride.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Output.txt")));
        
        // signature
        out.println("Shelby Alexander\nAP CS\nRide FileIO\n");
        
        // declares two strings
        String cometName;
        String groupName;

        while ((cometName = br.readLine()) != null && (groupName = br.readLine()) != null)
        {
            // declares and initializes two integer variables for storing calculations
            int cometNum = 1, groupNum = 1;

            // declares and initializes two constant variables
            final int ASCII_OFFSET_UPPERCASE = 64, MOD_VALUE = 47;

            // translates letters to ASCII code
            for(int k = 0; k < cometName.length(); k++)
            {
                cometNum *= cometName.charAt(k) - ASCII_OFFSET_UPPERCASE;
                cometNum %= MOD_VALUE;
            }
            for(int k = 0; k < groupName.length(); k++)
            {
                groupNum *= groupName.charAt(k) - ASCII_OFFSET_UPPERCASE;
                groupNum %= MOD_VALUE;
            }

            // checks if group and comet numbers are equal
            if(groupNum == cometNum)
            {
                out.println("GO");
            }
            else
            {
                out.print("STAY\n");
            }
        }
        
        // ensures the program ends properly
        out.close();
        System.exit(0);
    }
}
        
