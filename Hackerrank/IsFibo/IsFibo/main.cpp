//
//  main.cpp
//  IsFibo
//
//  Created by Yanqiao Zhan on 11/29/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
using namespace std;
int fibonacci(size_t target)
{
    if(target==1||target==2)return true;
    size_t a1=1,a2=2;
    while(target>a2)
    {
        size_t tem=a2;
        a2+=a1;
        a1=tem;
    }
    if(target==a2)return true;
    else return false;
}
int main(int argc, const char * argv[]) {

    size_t T,N;
    cout<<INT32_MAX<<endl;
    cin>>T;
    for(size_t i=0;i<T;i++)
    {
        cin>>N;
        if(fibonacci(N))cout<<"IsFibo"<<endl;
        else cout<<"IsNotFibo"<<endl;
    }
    
    return 0;
}
