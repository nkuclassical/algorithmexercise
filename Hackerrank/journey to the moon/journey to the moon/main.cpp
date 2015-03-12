//
//  main.cpp
//  journey to the moon
//
//  Created by Yanqiao Zhan on 12/16/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <map>
#include <vector>
#include <algorithm>
using namespace std;
struct treestructre
{
    vector<int>element;
};
int visited[100001];
treestructre astr[1000001];
void insert(int astronaut1,int astronaut2)
{
    if(find(astr[astronaut1].element.begin(), astr[astronaut1].element.end(), astronaut2)==astr[astronaut1].element.end())
    {
        astr[astronaut1].element.push_back(astronaut2);
        astr[astronaut2].element.push_back(astronaut1);
    }
}
int stastics(int index)
{
    int sum=0;
    for(vector<int>::iterator it=astr[index].element.begin();it!=astr[index].element.end();it++)
    {
        if(!visited[*it])
        {
            sum++;
            visited[*it]=true;
            sum+=stastics(*it);
        }
    }
    return sum;
}
long compute(int N)
{
    vector<int>multiply;
    int s=0;
    for(int i=0;i<N;i++)
    {
        if(!visited[i])
        {
            visited[i]=true;
            int tem=1+stastics(i);
            if(tem>1)
                multiply.push_back(tem);
        }
    }
    long result=0;
    for(int i=0;i<multiply.size();i++)
    {
        s+=multiply[i];
        for(int j=i+1;j<multiply.size();j++)
        {
            result+=multiply[i]*multiply[j];
        }
    }
    long one=N-s;
    result+=(s*one)+one*(one-1)/2;
    return result;
}
int main(int argc, const char * argv[]) {
    int N,I;
    cin>>N>>I;
    for(int i=0;i<N;i++)
        visited[i]=false;
    int person1,person2;
    for(int i=0;i<I;i++)
    {
        cin>>person1>>person2;
        insert(person1, person2);
    }
    cout<<compute(N)<<endl;
    return 0;
}
