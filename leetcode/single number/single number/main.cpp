//
//  main.cpp
//  single number
//
//  Created by Yanqiao Zhan on 1/5/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
using namespace std;
class Solution
{
public:
    int singleNumber(int A[],int n)
    {
        int result=0;
        for(int i=0;i<n;i++)
        {
            result^=A[i];
        }
        return result;
    }
};
int main(int argc, const char * argv[]) {
    Solution a;
    int b[]={4};
    int n=1;
    cout<<a.singleNumber(b, n)<<endl;;
    return 0;
}
