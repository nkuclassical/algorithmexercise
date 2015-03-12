//
//  main.cpp
//  Halloween party
//
//  Created by Yanqiao Zhan on 11/30/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
using namespace std;
int main(int argc, const char * argv[]) {
    size_t T,K;
    cin>>T;
    for(size_t i=0;i<T;i++)
    {
        cin>>K;
        if(K%2==0)cout<<(K/2)*(K/2)<<endl;
        else cout<<(K/2)*(K/2+1)<<endl;
    }
    return 0;
}
