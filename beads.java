/*
 ID: shelby.2
 TASK: beads
 LANG: JAVA
*/

// NAME             :   Shelby Alexander
// GROUP            :   AP CS
// LAST MODIFIED    :   19 December 2019
// PROBLEM ID       :   USACO Broken Necklace
// DESCRIPTION      :   This program finds the
//						maximum number of beads
//						collected after breaking a
//						necklace.
// SOURCES/HELP     :   Mr. H, USACO

import java.io.*;
import java.util.*;

public class beads
{
	public static void main(String[] args) throws IOException
	{
		// open files for input and output
		RandomAccessFile in = new RandomAccessFile ("beads.in", "r");
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
		
		// declares variables
		int numBeads, max = 0, tally, pos;
		char initial;
		String necklace, currentBead;
		
		// reads in the inputs
		numBeads = Integer.parseInt(in.readLine());
		necklace = in.readLine();
		
		// repeats program
		for(int j = 0; j < numBeads; j++)
		{
			// initializes the variables
			currentBead = necklace.substring(j) + necklace.substring(0, j);
			tally = 0;
			pos = 0;
			initial = '\0';
			
			// starts the process from the left side
			for(int k = 0; k < numBeads; k++)
			{
				// determines what the bead is in the sequence
				if(currentBead.charAt(k) == 'w')
				{
					tally++;
					pos++;
				}
				else
				{
					if(initial == '\0')
					{
						tally++;
						pos++;
						initial = currentBead.charAt(k);
					}
					else
					{
						if(initial == currentBead.charAt(k))
						{
							tally++;
							pos++;
						}
						else
						{
							break;
						}
					}
				}
			}
			
			// starts the process over from the right side
			initial = '\0';
			for(int k = numBeads - 1; k >= pos; k--)
			{
				// determines what the bead is in the sequence
				if(currentBead.charAt(k) == 'w')
				{
					tally++;
				}
				else
				{
					if(initial == '\0')
					{
						tally++;
						initial = currentBead.charAt(k);
					}
					else
					{
						if(initial == currentBead.charAt(k))
						{
							tally++;
						}
						else
						{
							break;
						}
					}
				}
			}
			
			// determines the maximum number of beads
			if(tally > max)
			{
				max = tally;
			}
		}
		
		// prints the output
		out.println(max);
		
		// ensures that the program ends properly
		out.close();
		System.exit(0);
	}
}