//
//  main.cpp
//  upvotes
//
//  Created by Yanqiao Zhan on 12/6/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <queue>
using namespace std;
int main(int argc, const char * argv[]) {
    int n,k;
    cin>>n>>k;
//    size_t *nu=new size_t[n];
    size_t nu[100020];
    for(int i=0;i<n;i++)
        cin>>nu[i];
    int nifast=0,nislow=0,ndfast=0,ndslow=0;
    queue<int>snifast,snislow,sndfast,sndslow;
    int nonincrease=0,nondecrease=0;
    snislow.push(0);
    sndslow.push(0);
    for(int i=0;i<k-1;i++)
    {
        if(nu[ndfast]>=nu[ndfast+1])
        {
            ndfast+=1;
        }
        else
        {
            nondecrease+=(ndfast-ndslow)*(ndfast-ndslow-1)/2;
            sndfast.push(ndfast);
            ndslow=i;
            ndfast=i;
        }
        if(nu[nifast]>=nu[nifast+1])
        {
            nifast+=1;
        }
        else
        {
            nonincrease+=(nifast-nislow)*(nifast-nislow-1)/2;
            nislow=i;
            nifast=i;
        }
    }
    cout<<nondecrease+(ndfast-ndslow)*(ndfast-ndslow-1)/2-nonincrease-(nifast-nislow)*(nifast-nislow-1)/2<<endl;
    for(int i=k-1;i<n;i++)
    {
        if(nu[ndfast]>=nu[ndfast+1])
        {
            ndfast+=1;
        }
        else
        {
            nondecrease+=(ndfast-ndslow)*(ndfast-ndslow-1)/2-(ndfast-ndslow-1)*(ndfast-ndslow-2)/2;
            ndslow=i;
            ndfast=i;
        }
        if(ndslow1==i)
        {
            nondecrease=nondecrease-(ndfast1-ndslow1)*(ndfast1-ndslow1-1)/2+(ndfast1-ndslow1-1)*(ndfast1-ndslow1-2)/2;
        }
        
        
        
        for(int j=i+1;j<i+k;j++)
        {
            if(nu[j]<=nu[j-1])
            {
                nir++;
            }
            else
            {
                nonincrease+=nir*(nir-1)/2;
                nir=1;
            }
            if(nu[j]>=nu[j-1])
            {
                ndr++;
            }
            else
            {
                nondecrease+=ndr*(ndr-1)/2;
                ndr=1;
            }
        }
        cout<<nondecrease+ndr*(ndr-1)/2-nonincrease-nir*(nir-1)/2<<endl;
    }
    return 0;
}
