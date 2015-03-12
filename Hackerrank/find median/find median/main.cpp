//
//  main.cpp
//  find median
//
//  Created by Yanqiao Zhan on 12/11/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
using namespace std;
int findmedian(int *ar,int first,int last,int n)
{
    int partition=first;
    for(int i=first;i<last;i++)
    {
        if(ar[i]<ar[last])
        {
            swap(ar[i],ar[partition]);
            partition++;
        }
    }
    
    swap(ar[partition], ar[last]);
    if(partition==n/2)return ar[partition];
    else if(partition>n/2)return findmedian(ar, first, partition-1, n);
    else return findmedian(ar, partition+1, last, n);
}
int main(int argc, const char * argv[]) {
    int n,*ar;
    cin>>n;
    ar=new int[n];
    for(int i=0;i<n;i++)
    {
        cin>>ar[i];
    }
    cout<<findmedian(ar, 0, n-1, n)<<endl;//the last index is n-1;
    return 0;
}
