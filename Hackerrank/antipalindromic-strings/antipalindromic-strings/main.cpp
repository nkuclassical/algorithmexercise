//
//  main.cpp
//  antipalindromic-strings
//
//  Created by Yanqiao Zhan on 12/17/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <cmath>
using namespace std;
int main(int argc, const char * argv[]) {
    int t;
    int modn=1000000000+7;
    cin>>t;
    for(int i=0;i<t;i++)
    {
        int n,m;
        cin>>n>>m;
        int mn2=1;
        for(int i=0;i<n/2;i++)
        {
            mn2*=m;
            mn2%=(modn);
        }
        int mn21=(mn2*m)%(modn);
        int mn;
        mn=(mn2*mn2)%(modn);
        cout<<(mn-mn*m%modn-m+mn21)%modn/(1-m)<<endl;
    }
    return 0;
}
