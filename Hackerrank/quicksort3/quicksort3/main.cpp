//
//  main.cpp
//  quicksort3
//
//  Created by Yanqiao Zhan on 12/10/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
using namespace std;
int qnumber,inumber;
void display(int*ar,int n)
{
    for(int i=0;i<n;i++)
        cout<<ar[i]<<" ";
    cout<<endl;
}
void sort(int *ar,int first,int last,int n)
{
    int partition=first;
    for(int i=first;i<=last;i++)
    {
        if(ar[i]<ar[last])
        {
            swap(ar[i], ar[partition]);
            qnumber++;
            partition++;
        }
    }
    swap(ar[last], ar[partition]);
    qnumber++;
   // display(ar,n);
    if(first<partition-1)
    {
        sort(ar,first,partition-1,n);
    }
    if(partition+1<last)
    {
        sort(ar,partition+1,last,n);
    }
}
void insertsort(int *ar,int n)
{
    for(int i=1;i<n;i++)
    {
        for(int j=i-1;j>=0;j--)
        {
            if(ar[j]>ar[j+1])
            {
                swap(ar[j], ar[j+1]);
                inumber++;
            }
        }
    }
}
int main(int argc, const char * argv[]) {
    int n,*ar,*iar;
    cin>>n;
    ar=new int[n];
    iar=new int[n];
    for(int i=0;i<n;i++)
    {
        cin>>ar[i];
        iar[i]=ar[i];
    }
    qnumber=0,inumber=0;
    sort(ar,0,n-1,n);
    insertsort(iar,n);
    cout<<inumber-qnumber<<endl;
    
    return 0;
}
