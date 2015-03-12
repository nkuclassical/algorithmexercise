//
//  main.cpp
//  difference and product
//
//  Created by Yanqiao Zhan on 12/13/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <cmath>
using namespace std;
int compute(long d,long p)
{
    if(d<0)return 0;
    if(d==0&&p>0)return 2;
    if(d==0&&p==0)return 1;
    if(d==0&&p<0)return 0;
    if(d>0&&d*d+4*p<0)return 0;
    if(d>0&&d*d+4*p==0)return 2;
    if(d>0&&d*d+4*p>0)return 4;
    return 4;
}
int main(int argc, const char * argv[]) {
    
    long t,d,p;
    cin>>t;
    for(int i=0;i<t;i++)
    {
        cin>>d>>p;
        cout<<d*d+4*p<<endl;
//        cout<<compute(d, p)<<endl;
    }
    return 0;
}
