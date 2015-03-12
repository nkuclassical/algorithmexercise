//
//  main.cpp
//  easy-sum
//
//  Created by Yanqiao Zhan on 12/14/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
using namespace std;
int main(int argc, const char * argv[]) {
    long t,n,m;
    cin>>t;
    for(int i=0;i<t;i++)
    {
        long sum=0;
        cin>>n>>m;
        sum=(m-1)*m/2*(n/m)+(1+n%m)*(n%m)/2;
        cout<<sum<<endl;
    }
    
    return 0;
}
