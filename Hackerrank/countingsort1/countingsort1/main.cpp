//
//  main.cpp
//  countingsort1
//
//  Created by Yanqiao Zhan on 12/11/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <fstream>
#include <string>
#include <queue>
using namespace std;
int main(int argc, const char * argv[]) {
    int n,*ar,x[100];
    queue<string>q[100];
    string *s;
    cin>>n;
    ar=new int[n];
    s=new string[n];
    for(int i=0;i<100;i++)
        x[i]=0;
    for(int i=0;i<n;i++)
    {
        cin>>ar[i];
        cin>>s[i];
        x[ar[i]]++;
        if(i<n/2)
            q[ar[i]].push("-");
        else
            q[ar[i]].push(s[i]);
    }
    int sum=0;
    for(int i=0;i<100;i++)
    {
        for(int j=0;j<x[i];j++)
        {
            
            cout<<q[i].front()<<" ";
            q[i].pop();
            sum++;
        }
        
    }
    cout<<endl;
    
    return 0;
}
