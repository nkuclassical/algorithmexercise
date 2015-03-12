//
//  main.cpp
//  tutorial intro
//
//  Created by Yanqiao Zhan on 11/30/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
using namespace std;
int main(int argc, const char * argv[]) {

    int V,n,tem;
    cin>>V;
    cin>>n;
    for(int j=0;j<n;j++)
    {
        cin>>tem;
        if(tem==V)
        {
            cout<<j<<endl;
            break;
        }
    }
    return 0;
}
