// 1011.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"

/*
#include <iostream>
#include <algorithm>
using namespace std;
struct stick
{
	int len;
	bool calcute;
};
bool cmp(const stick &a,const stick &b)
{
	return a.len > b.len;
}
void dfs(int len,int left,int n,int t)
{
	
}
int main()
{	
	int num;
	while (cin >> num&&num != 0)
	{
		stick *sticks;
		int sum = 0;
		sticks = new stick[num];
		for (int i = 0; i < num; i++)
		{
			cin >> sticks[i].len;
			sum += sticks[i].len;
		}
		
		sort(sticks,&sticks[num-1]+1,cmp);
		for (int i = sticks[0].len; i <= sum; i++)
		{
			dfs(len,sticks[i])
		}

	}
	return 0;
}

*/
#include<iostream>
#include<cstring>
#include<algorithm>
using namespace std;
int a[70], sign[70];
int cmp(const void *a, const void *b)
{
	return *(int *)b - *(int *)a;
}
int dfs(int len, int others, int n, int t)//��Ҫ��ԭ���ĳ��ȣ�ƴ��һ��������Ҫ�ģ�����ĳ��ȣ���ʣ��ƴ�İ��ĳ��� 
{
	int i;
	if (others == 0 && t == 0)//���û��С��ʣ�ಢ���Ѿ�ƥ����ͷ��� 
		return len;
	if (others == 0) //һ��ԭ��ƥ���꣬����ƥ����һ�� 
		others = len;
	for (i = 0; i<n; i++)
	{
		if (sign[i] == 1)//С���Ѿ��ù��������� 
			continue;
		if (a[i] <= others)
		{
			sign[i] = 1;
			if (dfs(len, others - a[i], n, t - 1))//ƴ�ӳɹ��˷��ص� 
				return len;
			sign[i] = 0;
			if (others == a[i] || len == others)
				break;//�������겻�ɣ�����϶��겻��
			while (a[i] == a[i + 1])
				i++;

		}
	}
	return 0;
}
int main()
{
	int n, i, len, sum, k;
	while (cin >> n)
	{
		if (n == 0)
			break;
		sum = 0;
		for (i = 0; i<n; i++)
		{
			cin >> a[i];
			sum += a[i];
		}
		qsort(a, n, sizeof(int), cmp);//���������������      
		for (len = a[0]; len <= sum; len++)
		{
			memset(sign, 0, sizeof(sign));
			if (sum%len == 0)
			{
				k = dfs(len, len, n, n);
				if (k != 0)
					break;
			}
		}
		cout << k << endl;
	}
	return 0;
}