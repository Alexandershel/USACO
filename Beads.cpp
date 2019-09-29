/*
 ID: shelby.2
 TASK: beads
 LANG: C++
*/

// NAME             :   Shelby Alexander
// GROUP            :   AP CS
// LAST MODIFIED    :   26 September 2019
// PROBLEM ID       :   USACO Broken Necklace
// DESCRIPTION      :   This program finds the
//						maximum number of beads
//						collected after breaking a
//						necklace.
// SOURCES/HELP     :   Mr. H, USACO

#include<iostream>
#include<fstream>
#include<string>

using namespace std;

int main()
{
    // open files for input and output
    ofstream fout ("beads.out");
    ifstream fin ("beads.in");
    
    // declares variables
    int numBeads, max = 0, tally, pos;
	char initial;
    string necklace, currentBead;
    
	// reads in the inputs
	fin >> numBeads >> necklace;
	
	// repeats program
	for(int j = 0; j < numBeads; j++)
	{
		// initializes the variables
		currentBead = necklace.substr(j) + necklace.substr(0, j);
		tally = 0;
		pos = 0;
		initial = '\0';
		
		// starts the process from the left side
		for(int k = 0; k < numBeads; k++)
		{
			// determines what the bead is in the sequence
			if(currentBead[k] == 'w')
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
					initial = currentBead[k];
				}
				else
				{
					if(initial == currentBead[k])
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
			if(currentBead[k] == 'w')
			{
				tally++;
			}
			else
			{
				if(initial == '\0')
				{
					tally++;
					initial = currentBead[k];
				}
				else
				{
					if(initial == currentBead[k])
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
	fout << max << endl;
	
    // exits program
    return 0;
}
