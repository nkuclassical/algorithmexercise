//
//  main.cpp
//  acm icpc team
//
//  Created by Yanqiao Zhan on 11/30/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
using namespace std;
int binto10(string a,string b)
{
    int sum=0;
    for(int i=0;i<a.length();i++)
    {
        if(a[i]=='1'||b[i]=='1')
            sum++;
    }
    return sum;
}
int main(int argc, const char * argv[]) {
    int N,M;
    vector<string> sm;
    cin>>N>>M;
    string tem;
    int max=0,maxteam=0;
    for(int i=0;i<N;i++)
    {
        cin>>tem;
        sm.push_back(tem);
    }
    for(int i=0;i<sm.size()-1;i++)
    {
        for(int j=i+1;j<sm.size();j++)
        {
            int temsum=binto10(sm[i], sm[j]);
            if(temsum>max)
            {
                max=temsum;
                maxteam=1;
            }
            else if(temsum==max)
            {
                maxteam++;
            }
        }
    }
    cout<<max<<endl<<maxteam<<endl;
    return 0;
}
