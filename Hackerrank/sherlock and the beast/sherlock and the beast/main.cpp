//
//  main.cpp
//  sherlock and the beast
//
//  Created by Yanqiao Zhan on 12/10/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
using namespace std;
int main(int argc, const char * argv[]) {
    int t,n;
    cin>>t;
    for(int i=0;i<t;i++)
    {
        cin>>n;
        int time3=0,time5=0;
        while(n>0)
        {
            if(n%3==0){time5+=n/3;n=0;}
            else
            {
                n-=5;
                time3+=1;
            }
        }
        if(n!=0)cout<<-1<<endl;
        else
        {
            for(int p=0;p<time5;p++)
                cout<<555;
            for(int p=0;p<time3;p++)
                cout<<33333;
            cout<<endl;
        }
    }
    return 0;
}
