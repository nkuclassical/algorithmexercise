// 1002.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"

#include <iostream>
#include <string>
#include <map>
#include <vector>
using namespace std;
int main()
{
	int num;
	const int maxn = 100100;	
	map<char, string> mmap;
	string *input, *mid,output;
	map<int,int>count;	
	map<string, int>dic;
	mmap['A'] = "2";
	mmap['B'] = "2";
	mmap['C'] = "2";
	mmap['D'] = "3";
	mmap['E'] = "3";
	mmap['F'] = "3";
	mmap['G'] = "4";
	mmap['H'] = "4";
	mmap['I'] = "4";
	mmap['J'] = "5";
	mmap['K'] = "5";
	mmap['L'] = "5";
	mmap['M'] = "6";
	mmap['N'] = "6";
	mmap['O'] = "6";
	mmap['P'] = "7";
	mmap['R'] = "7";
	mmap['S'] = "7";
	mmap['T'] = "8";
	mmap['U'] = "8";
	mmap['V'] = "8";
	mmap['W'] = "9";
	mmap['X'] = "9";
	mmap['Y'] = "9";
	cin >> num;
	
	
		for (int i = 0; i < num; i++)
		{
			string s, st;
			cin >> s;
			for (int j = 0; j < s.size(); j++)
			{
				if (s[j] != '-')
				{
					if (s[j] >= '0'&&s[j] <= '9')
						st += s[j];
					else st += mmap[s[j]];
				}
				if (st.size() == 3)st += '-';
			}
			dic[st]++;
		}
		int ok = 1;
		for (map<string, int>::iterator it = dic.begin(); it != dic.end(); it++)
		{
			if ((*it).second > 1)
			{
				cout << it->first << " " << it->second << endl;
				ok = 0;
			}
		}
		if (ok)
			cout << "No duplicates." << endl;
	

	return 0;
}

