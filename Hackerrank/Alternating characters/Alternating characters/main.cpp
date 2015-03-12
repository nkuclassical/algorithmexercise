//
//  main.cpp
//  Alternating characters
//
//  Created by Yanqiao Zhan on 11/29/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <string>
using namespace std;
int main(int argc, const char * argv[]) {
    int T;
    string S;
    string tem;
    cin>>T;
    for(int i=0;i<T;i++)
    {
        cin>>S;
        tem="";
        int fast=0,slow=0;

            for(fast=0;fast<S.length();)
            {
                if (S[slow]==S[fast])
                {
                    fast++;
                }
                else
                {
                    slow++;
                    S[slow]=S[fast];
                    fast++;
                }
            }
        cout<<S.length()-slow-1<<endl;
    }
    return 0;
}
