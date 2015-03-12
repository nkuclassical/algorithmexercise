//
//  main.cpp
//  samesubstring
//
//  Created by Yanqiao Zhan on 12/13/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <map>
#include <string>
using namespace std;
int main(int argc, const char * argv[]) {
    map<char,int>ma,mb;
    int t;
    string a,b;
    bool find=false;
    cin>>t;
    for(int i=0;i<t;i++)
    {
        find=false;
        ma.clear();
        mb.clear();
        cin>>a>>b;
        for(auto d:a)
        {
            if(ma.find(d)!=ma.end())
            {
                ma[d]++;
            }
            else
                ma[d]=1;
        }
        for(auto d:b)
        {
            if(ma.find(d)!=ma.end())
            {
                cout<<"YES"<<endl;
                find=true;
                break;
            }
        }
        if(!find)cout<<"NO"<<endl;
    }
    return 0;
}
