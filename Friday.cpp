/*
 ID: shelby.2
 TASK: friday
 LANG: C++
*/

// NAME             :   Shelby Alexander
// GROUP            :   Hexadecimal
// LAST MODIFIED    :   7 February 2019
// PROBLEM ID       :   USACO Friday the 13th
// DESCRIPTION      :	This program finds the
//						amount of times that the 
//						13th lands on a Friday over
//						certain span of time.
// SOURCES/HELP     :   Mr. H, USACO, Ava Apolo,
//						Sawyer Barton, Alex Kish,
//						Sam Rabick, Charlie Hinkley

#include<iostream>
#include<fstream>

using namespace std;

int main()
{
    // open files for input and output
    ofstream fout ("friday.out");
    ifstream fin ("friday.in");
    
    // declare variables
	const int START_YEAR = 1900, WEEK_LENGTH = 7;
	int numYears, dayTotals[WEEK_LENGTH], extraDays[13], date, dayThirteenth;
	int monthLength[12] = {31,28,31,30,31,30,31,31,30,31,30,31};

	// reads in the number of years
    fin >> numYears;
    
	// initializes variables
    for(int j = 0; j < 7; j++)
    {
        dayTotals[j] = 0;
    }
    date = 13;
	
	// finds the amount of days greater than 28 in a month
	for(int j = 0; j < 12; j++)
	{
		extraDays[j] = 0;
	}
	
	// runs the program as long as the year is in our timeline
	for(int currentYear = START_YEAR; currentYear < START_YEAR + numYears; currentYear++)
	{
		// finds if it is a leap year
		if(currentYear % 400 == 0 or currentYear % 4 == 0 and currentYear % 100 != 0)
		{
			monthLength[1] = 29;
		}
		else
		{
			monthLength[1] = 28;
		}
		
		// repeats process every month
		for(int i = 0; i < 12; i++)
		{
			// finds the day of the month that the 13th falls on
			date += extraDays[i];
			dayThirteenth = date % WEEK_LENGTH;
			
			// adds a tally to the weekday that the 13th landed on
			dayTotals[dayThirteenth]++;
			
			// calculates the next offset
			if(i == 11)
			{
				extraDays[0] = monthLength[i] - 28;
			}
			else
			{
				extraDays[i+1] = monthLength[i] - 28;
			}
		}
	}
	
	// prints the output
	fout << dayTotals[6] << " ";
	for(int j = 0; j < 5; j++)
	{
		fout << dayTotals[j] << " ";
	}
	fout << dayTotals[5] << endl;
	
    // exit program
    return 0;
}
