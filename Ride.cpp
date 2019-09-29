/*
 ID: shelby.2
 TASK: ride
 LANG: C++
*/

// NAME             :   Shelby Alexander
// GROUP            :   Argon
// LAST MODIFIED    :   24 October 2018
// PROBLEM ID       :   USACO Your Ride is Here
// DESCRIPTION      :   This program reads the the name of
//                      comet and group and concludes whether the
//                      names match after a series of calculations
//                      by either printing "GO" or "STAY."
// SOURCES/HELP     :   Mr. H, USACO, Ava Apolo, Sawyer
//                      Barton, Kohler Briggs, Charlie Hinkley

#include<iostream>
#include<fstream>
#include<string>

using namespace std;

int main()
{
    // open files for input and output
    ofstream fout ("ride.out");
    ifstream fin ("ride.in");
    
    // declare variables
    const int ASCII_Offset = 64, modNum = 47;
    int cometNum = 1, groupNum = 1;
    string cometName, groupName;
    
    // reads in characters from the input file
    fin >> cometName >> groupName;
    
    // calculates the comet number
    for (int j = 0; j < cometName.length(); j++)
    {
        cometNum *= cometName[j] - ASCII_Offset;
        cometNum %= modNum;
    }
    
    // calculates the group number
    for (int j = 0; j < groupName.length(); j++)
    {
        groupNum *= groupName[j] - ASCII_Offset;
        groupNum %= modNum;
    }
    
    // decides if the output is "Go" or "Stay"
    if (cometNum == groupNum)
    {
        fout << "GO\n";
    }
    else
    {
        fout << "STAY\n";
    }
    
    // exit program
    return 0;
}
