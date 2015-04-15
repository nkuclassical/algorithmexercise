// 1088.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"

#include <iostream>
using namespace std;
int **matric,**len,C,R;
int dir[4][2]={{-1,0},{0,1},{1,0},{0,-1}};
int dp(int i,int j)
{
	int maxx=0,s;
	if(len[i][j]!=0)return len[i][j];
	else
	{
		for(int t=0;t<4;t++)
		{
			int temx=i+dir[t][0],temy=j+dir[t][1];
			if(temx>=0&&temx<C&&temy>=0&&temy<R&&matric[temx][temy]<matric[i][j])
			{
				s=dp(temx,temy);
				if(s>maxx)maxx=s;
			}
		}
		len[i][j]=maxx+1;
	}
	
	return maxx+1;
}
int main()
{
	int max=-1;
	cin>>C>>R;
	matric=new int*[C];
	len=new int*[C];
	for(int i=0;i<C;i++)
	{
		matric[i]=new int[R];
		len[i]=new int[R];
	}
	for(int i=0;i<C;i++)
	{
		for(int j=0;j<R;j++)
		{
			cin>>matric[i][j];
			len[i][j]=0;
		}
	}
	for(int i=0;i<C;i++)
	{
		for(int j=0;j<R;j++)
		{
			len[i][j]=dp(i,j);
			if(len[i][j]>max)max=len[i][j];
		}
	}
	cout<<max<<endl;
	return 0;
}

