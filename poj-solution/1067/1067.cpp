// 1067.cpp : 定义控制台应用程序的入口点。
//1.如果我方结束时某一边被取完了，则对方胜利
//2.如果我方结束时两边一样多，则对方胜利


#include "stdafx.h"

#include <iostream>
#include <cmath>
using namespace std;
int main()
{
	int a,b;
	while(cin>>a>>b)
	{
		if(a<b)
		{
			a^=b;
			b^=a;
			a^=b;
		}
		int k=a-b;		
		a=(int)(k*(1+sqrt(5))/2.0);		
		if(a==b)
			cout<<0<<endl;
		else
			cout<<1<<endl;
	}
		return 0;
}





