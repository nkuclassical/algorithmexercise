//
//  main.cpp
//  Filling Jars
//
//  Created by Yanqiao Zhan on 11/30/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
using namespace std;
int main(int argc, const char * argv[]) {

    size_t N,M,a,b,k,sum=0;
    cin>>N>>M;
    for(int i=0;i<M;i++)
    {
        cin>>a>>b>>k;
        sum+=(b-a+1)*k;
    }
    cout<<sum/N<<endl;
    return 0;
}
