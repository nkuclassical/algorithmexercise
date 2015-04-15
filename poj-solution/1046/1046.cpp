// 1046.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"


#include <iostream>
using namespace std;
struct color
{
	int red;
	int green;
	int blue;
};
int main()
{
	color map[16];
	for(int i=0;i<16;i++)
	{
		cin>>map[i].red>>map[i].green>>map[i].blue;
	}
	color input,target;
	int min,temmin,minnum;
	while (cin>>input.red>>input.green>>input.blue&&input.red!=-1)
	{
		min=(input.red-map[0].red)*(input.red-map[0].red)+(input.green-map[0].green)*(input.green-map[0].green)+(input.blue-map[0].blue)*(input.blue-map[0].blue);
		minnum=0;
		int i;
		for(i=1;i<16;i++)
		{
			temmin=(input.red-map[i].red)*(input.red-map[i].red)+(input.green-map[i].green)*(input.green-map[i].green)+(input.blue-map[i].blue)*(input.blue-map[i].blue);
			if(temmin<min)
			{
				min=temmin;
				minnum=i;
			}
		}
		
		cout<<"("<<input.red<<","<<input.green<<","<<input.blue<<") maps to ("<<map[minnum].red<<","<<map[minnum].green<<","<<map[minnum].blue<<")"<<endl;
	}
	
	return 0;
}
