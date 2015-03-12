//
//  main.cpp
//  find-digits
//
//  Created by Yanqiao Zhan on 11/29/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
using namespace std;
int digit(int num)
{
    int tem=num;
    int sum=0;
    while(tem>0)
    {
        if((tem%10!=0)&&num%(tem%10)==0)sum++;
        tem/=10;
    }
    return sum;
}
int main(int argc, const char * argv[]) {
    int T;
    cin>>T;
    for(int i=0;i<T;i++)
    {
        int tem;
        cin>>tem;
        cout<<digit(tem)<<endl;
    }
    return 0;
}
