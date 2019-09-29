/*
 ID: shelby.2
 TASK: gift1
 LANG: C++
*/

// NAME             :   Shelby Alexander
// GROUP            :   Hex
// LAST MODIFIED    :   5 February 2019
// PROBLEM ID       :   USACO Greedy Gift Givers
// DESCRIPTION      :   This program finds the balances
//						of bank accounts after a number
//						of rounds of gift giving.
// SOURCES/HELP     :   Mr. H, USACO, Ava Apolo, Sawyer
//                      Barton, Charlie Hinkley

#include<iostream>
#include<fstream>
#include<string>

using namespace std;

int main()
{
    // opens files for input and output
    ofstream fout ("gift1.out");
	ifstream fin ("gift1.in");
    
	// declares NP
	int NP;
	
	// reads in the number of people
	fin >> NP;
	
	// declare variables
	int NG, moneyGive, account[NP];
	string name[NP], receiver, giver;
		
	// initializes the bank accounts
	// reads in names of people
	for(int j = 0; j < NP; j++)
	{
		account[j] = 0;
		fin >> name[j];
    }
	
    // repeats process of gift giving and receiving
	for(int j = 0; j < NP; j++)
	{
		// inputs giver, number of receivers, and the
		// amount of money to give
		fin >> giver;
		fin >> moneyGive;
		fin >> NG;
		
		// finds amount of money in the giver's account
		for(int i = 0; i < NP; i++)
		{
           if(name[i] == giver)
           {
                account[i] -= moneyGive;
               
                // determines if the giver matches the account
                if(NG != 0)
                {
                    // finds the new giver account balance
                    account[i] += moneyGive % NG;
                }
           }
		}
		
		// finds amount of money in the receiver's account
		for(int i = 0; i < NG; i++)
		{
			// reads in the receiver
			fin >> receiver;
			
            for(int k = 0; k < NP; k++)
            {
                // determines if the receiver matches the account
                if(name[k] == receiver and NG != 0)
                {
                    // finds the new receiver account balance
                    account[k] += moneyGive / NG;
                }
            }
		}
    }
	
	// outputs account balances and associated names
	for(int j = 0; j < NP; j++)
	{
		fout << name[j] << " " << account[j] << endl;
	}
		
    // exit program
    return 0;
}

