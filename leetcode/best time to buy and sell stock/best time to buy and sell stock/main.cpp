//
//  main.cpp
//  best time to buy and sell stock
//
//  Created by Yanqiao Zhan on 1/7/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <vector>
using namespace std;
class Solution
{
public:
    int maxProfit(vector<int>&prices)
    {
        int best=0,low=0;
        for(int i=0;i<prices.size();i++)
        {
            if(prices[i]<prices[low])
                low=i;
            else if(prices[i]-prices[low]>best)
            {
                best=prices[i]-prices[low];
            }
        }
        return best;
    }
};
int main(int argc, const char * argv[]) {
    Solution s;
    vector<int>v;
    v.push_back(4);
        v.push_back(1);
        v.push_back(3);
    cout<<s.maxProfit(v)<<endl;
    return 0;
}
