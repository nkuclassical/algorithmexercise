//
//  main.cpp
//  web-shark-and-42
//
//  Created by Yanqiao Zhan on 12/13/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//each square that has a label divisible by 4 and/or 2 but not divisible by 42 contains a black glob of jelly, stepping on which his strength decreases by 1.

#include <iostream>
using namespace std;
int main(int argc, const char * argv[]) {
    int t;
    long s,tem;
    cin>>t;
    for(int i=0;i<t;i++)
    {
        cin>>s;
        tem=s;
        if(tem<=20)cout<<tem*2<<endl;
        else
        {
            tem-=20;
            tem/=41;
            tem*=84;
            s-=20;
            s%=41;
            if(s==0)cout<<(tem+40)%(1000000000+7)<<endl;
            else
            {
                s*=2;
                cout<<(tem+s+42)%(1000000000+7)<<endl;
            }
        }
    }
    return 0;
}
