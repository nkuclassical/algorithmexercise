//
//  main.cpp
//  insertionsort1
//
//  Created by Yanqiao Zhan on 11/30/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
using namespace std;
int s,*ar;
void display()
{
    for(int i=0;i<s;i++)
        cout<<ar[i]<<" ";
    cout<<endl;
}
int main(int argc, const char * argv[]) {
    cin>>s;
    ar=new int[s];
    for(int i=0;i<s;i++)
        cin>>ar[i];
    for(int i=1;i<s;i++)
    {
        for(int j=i-1;j>=0;j--)
        {
            if(ar[j+1]<ar[j])
            {
                int tem=ar[j];
                ar[j]=ar[j+1];
                ar[j+1]=tem;

            }
            else
                break;
        }
        display();
    }
    return 0;
}
