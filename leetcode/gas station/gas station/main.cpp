//
//  main.cpp
//  gas station
//
//  Created by Yanqiao Zhan on 1/7/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    int canCompleteCircuit(vector<int> &gas, vector<int> &cost)
    {
        vector<int>diff(gas.size());
        for(int i=0;i<gas.size();i++)
        {
            diff[i]=gas[i]-cost[i];
        }
        int leftgas=0,sum=0,startnode=0;
        for(int i=0;i<gas.size();i++)
        {
            leftgas+=diff[i];
            sum+=diff[i];
            if(sum<0)
            {
                startnode=i+1;
                sum=0;
            }
        }
        if(leftgas<0)return -1;
        else return startnode;
    }
};
int main(int argc, const char * argv[]) {
    // insert code here...
    std::cout << "Hello, World!\n";
    return 0;
}
