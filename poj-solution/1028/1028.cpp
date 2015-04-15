// 1028.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"


#include <iostream>
#include <stack>
#include <string>
using namespace std;
int main()
{
	stack<string>Forward;
	stack<string>Backward;
	string current="http://www.acm.org/";
	string action;
	string website;
	while(cin>>action)
	{
		if(action!="QUIT")
		{
			
			if(action=="BACK")
			{
				if(Backward.empty())
				{
					cout<<"Ignored"<<endl;
				}
				else
				{
					Forward.push(current);
					current=Backward.top();
					Backward.pop();
					cout<<current<<endl;
				}
			}
			else if(action=="FORWARD")
			{
				if(Forward.empty())
				{
					cout<<"Ignored"<<endl;
				}
				else
				{
					Backward.push(current);
					current=Forward.top();
					Forward.pop();
					cout<<current<<endl;
				}
			}
			else if(action=="VISIT")
			{
				cin>>website;
				Backward.push(current);
				current=website;
				cout<<current<<endl;
				while(!Forward.empty())
				{
					Forward.pop();
				
				}
			}
			}
		else
		{
				break;
			
		}
	}
	
	return 0;
}

