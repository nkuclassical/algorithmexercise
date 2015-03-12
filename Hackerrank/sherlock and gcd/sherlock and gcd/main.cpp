//
//  main.cpp
//  sherlock and gcd
//
//  Created by Yanqiao Zhan on 11/30/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
using namespace std;
bool gcd(int a,int b)//true means gcd
{
    if(a<b)
    {
        a^=b;
        b^=a;
        a^=b;
    }
    if(a==b&&b>1)return true;
    else if(b<=1)return false;
    else return gcd(b,a-b);
}
int main(int argc, const char * argv[]) {

    int t,n,*a;
    cin>>t;
    for(int i=0;i<t;i++)
    {
        cin>>n;
        a=new int[n];
        for(int j=0;j<n;j++)
        {
            cin>>a[j];
        }
        bool b=false;
        for(int p=0;p<n-1;p++)
        {
            for(int q=p+1;q<n;q++)
            {
                if(!gcd(a[p], a[q]))
                {
                    cout<<"YES"<<endl;
                    b=true;
                    break;
                }
            }
            if(b==true)break;
        }
        if(b==false)cout<<"NO"<<endl;
    }
    return 0;
}
