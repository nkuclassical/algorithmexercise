// 1067.cpp : �������̨Ӧ�ó������ڵ㡣
//1.����ҷ�����ʱĳһ�߱�ȡ���ˣ���Է�ʤ��
//2.����ҷ�����ʱ����һ���࣬��Է�ʤ��


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





