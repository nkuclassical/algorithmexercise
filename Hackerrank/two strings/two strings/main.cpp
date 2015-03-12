//
//  main.cpp
//  two strings
//
//  Created by Yanqiao Zhan on 11/30/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <map>
#include <string>
using namespace std;
bool task(string a,string b)
{
    map<char, bool>ra,rb;
    map<char, bool>::iterator it;
    for(int i=0;i<a.length();i++)
    {
        if(ra.find(a[i])==ra.end())
        {
            ra[a[i]]=true;
        }
    }
    for(int i=0;i<b.length();i++)
    {
        if(rb.find(b[i])==rb.end())
        {
            rb[b[i]]=true;
        }
    }
    for(it=ra.begin();it!=ra.end();it++)
    {
        if(rb.find(it->first)!=rb.end())
        {
            return true;
        }
    }
    return false;
}
int main(int argc, const char * argv[]) {
    int T;
    string A,B;
    cin>>T;
    for(int i=0;i<T;i++)
    {
        cin>>A>>B;
        if(task(A,B))
        {
            cout<<"YES"<<endl;
        }
        else
        {
            cout<<"NO"<<endl;
        }
    }
    return 0;
}
