//
//  main.cpp
//  insertionsort2
//
//  Created by Yanqiao Zhan on 12/1/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
using namespace std;
void display(int s,int *ar)
{
    for(int i=0;i<s;i++)
        cout<<ar[i]<<" ";
    cout<<endl;
}
int main(int argc, const char * argv[]) {
    int s,*ar;
    bool change=false;
    cin>>s;
    ar=new int[s];
    for(int i=0;i<s;i++)
        cin>>ar[i];
    for(int i=0;i<s;i++)
    {
        int t=ar[i];
        for(int j=i-1;j>=0;j--)
        {
            if(t<ar[j])
            {
                ar[j+1]=ar[j];
                display(s,ar);
                change=true;
            }
            else if(change)
            {
                ar[j+1]=t;
                display(s, ar);
                change=false;
                break;
            }
        }

        if(t<ar[0])
        {
            ar[0]=t;
            display(s, ar);
        }
    }
    return 0;
}
