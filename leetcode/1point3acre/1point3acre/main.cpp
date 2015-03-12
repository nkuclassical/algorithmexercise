//
//  main.cpp
//  1point3acre
//
//  Created by Yanqiao Zhan on 1/8/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <vector>
#include <string>
using namespace std;
class Solution{
public:
    int subclimb(int n)
    {
        if(n==1)
        {
            step[0]=1;
            return 1;
        }
        else if(n==2)
        {
            step[1]=2;
            return 2;
        }
        else
        {
            if(step[n-1]<=0)
                step[n-1]=subclimb(n-1)+subclimb(n-2);
            return step[n-1];
        }
    }
    int climbStairs(int n)
    {
        step=new int[n];
        for(int i=0;i<n;i++)
            step[i]=0;
        return subclimb(n);
    }
private:
    int *step;
};
int main()
{
    Solution s;
    cout<<s.climbStairs(30)<<endl;

    return 0;
}