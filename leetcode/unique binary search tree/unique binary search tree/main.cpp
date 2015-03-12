//
//  main.cpp
//  unique binary search tree
//
//  Created by Yanqiao Zhan on 1/6/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <vector>
using namespace std;
class Solution
{
public:
    int numTrees(int n)
    {
        vector<int>count;
        count.push_back(1);
        count.push_back(1);
        for(int i=2;i<=n;i++)
        {
            int sum=0;
            for(int j=0;j<i;j++)
            {
                sum+=count[j]*count[i-j-1];
            }
            count.push_back(sum);
        }
        return count[n];
    }
};
int main(int argc, const char * argv[]) {
    Solution s;
    cout<<s.numTrees(3)<<endl;
    return 0;
}
