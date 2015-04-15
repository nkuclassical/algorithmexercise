// 1050.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"


#include <iostream>
using namespace std;
int main()
{
	int N;
	cin>>N;
	int **a;
	a=new int*[N];
	int *tem;
	tem=new int[N];
	int *middlevalue;
	middlevalue=new int[N];
	int Max;
	int temMax;
	for(int i=0;i<N;i++)
	{
		a[i]=new int[N];
		for(int j=0;j<N;j++)
		{
			cin>>a[i][j];
		}
	}
	Max=a[0][0];
	for(int i=0;i<N;i++)
	{
		for(int j=i+1;j<N;j++)
		{
			for(int k=0;k<N;k++)
			{
				tem[k]=0;
				for(int t=i;t<=j;t++)
				{
					tem[k]+=a[k][t];//新的一行数组形成;
				}
			}
			middlevalue[0]=tem[0];
			temMax=middlevalue[0];
			for(int s=1;s<N;s++)
			{
				if((middlevalue[s-1]+tem[s])>tem[s])
				{
					middlevalue[s]=middlevalue[s-1]+tem[s];
				}
				else
				{
					middlevalue[s]=tem[s];
				}
				if(middlevalue[s]>temMax)temMax=middlevalue[s];

			}
			if(temMax>Max)Max=temMax;

		}
	}
	cout<<Max<<endl;
	return 0;
}

