//
//  main.cpp
//  median of two sorted arrays
//
//  Created by Yanqiao Zhan on 1/6/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
using namespace std;
class Solution {
public:
    double findMedianSortedArrays(int A[], int m, int B[], int n)
    {
        if(m+n==0)return 0;
        int Apace=0,Bpace=0,tem,tem1=tem;
        for(int i=0;i<=(m+n)/2;i++)
            {
                tem1=tem;
                if(Apace<m&&Bpace<n)
                {
                    if(A[Apace]<B[Bpace])
                    {

                        tem=A[Apace];
                        Apace++;
                    }
                    else
                    {
                        tem=B[Bpace];
                        Bpace++;
                    }
                }
                else if(Apace>=m&&Bpace<n)
                {
                    tem=B[Bpace];
                    Bpace++;
                }
                else
                {
                    tem=A[Apace];
                    Apace++;
                }
            }
        if((m+n)%2==1)
            return tem;
        else return static_cast<double>(tem+tem1)/2;
    }
};
int main(int argc, const char * argv[]) {

    Solution s;
    int a[]={};
    int b[]={};
    
    cout<<s.findMedianSortedArrays(a, 0, b, 0)<<endl;
    return 0;
}
