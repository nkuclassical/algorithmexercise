//
//  main.cpp
//  manasa and stones
//
//  Created by Yanqiao Zhan on 11/30/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
using namespace std;
int main(int argc, const char * argv[]) {
    int T,n,a,b;
    cin>>T;
    for(int i=0;i<T;i++)
    {
        cin>>n>>a>>b;
        if(a>b)
        {
            a=a^b;
            b=a^b;
            a=a^b;
        }
        if(a!=b){
            for(int i=0;i<n;i++)
            {
                cout<<a*(n-i-1)+b*i<<" ";
            }
        }
        else
        {
            cout<<b*(n-1);
        }
        cout<<endl;
    }
    return 0;
}
