//
//  main.cpp
//  game of thrones
//
//  Created by Yanqiao Zhan on 11/30/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <string>
#include <map>
using namespace std;
int main(int argc, const char * argv[]) {
    string s;
    cin>>s;
    map<char, int>m;
    int flag = 0;
    for(int i=0;i<s.length();i++)
    {
        if(m.find(s[i])!=m.end())
        {
            m[s[i]]++;
        }
        else
        {
            m[s[i]]=1;
        }
    }
    for(map<char, int>::iterator it=m.begin();it!=m.end();it++)
    {
        if(it->second%2!=0)
        {
            flag++;
            if(flag>1)break;
        }
    }
    
    if(flag>1)
        cout<<"NO"<<endl;
    else
        cout<<"YES"<<endl;
    return 0;
}
