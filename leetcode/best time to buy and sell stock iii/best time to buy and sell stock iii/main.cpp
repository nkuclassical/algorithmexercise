//
//  main.cpp
//  best time to buy and sell stock iii
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
        int result=0,low=0,highest=0;
        vector<int>premax;
        for(int i=0;i<prices.size();i++)
        {
            if(prices[i]<prices[low])
            {
                low=i;
            }
            else if(prices[i]-prices[low]>highest)
            {
                highest=prices[i]-prices[low];
            }
            premax.push_back(highest);
        }
        int high=prices[prices.size()-1];
        highest=0;
        for(int i=prices.size()-2;i>=0;i--)
        {
            if(prices[i]>high)
            {
                high=prices[i];
                if(premax[i]>highest)
                {
                    highest=premax[i];
                }
            }
            else if(premax[i]+high-prices[i]>highest)
            {
                highest=premax[i]+high-prices[i];
            }
        }
        return highest;
    }
};
int main(int argc, const char * argv[]) {
    vector<int>temp;
    temp.push_back(2);
        temp.push_back(1);
        temp.push_back(2);
        temp.push_back(0);
        temp.push_back(1);
    Solution s;
    cout<<s.maxProfit(temp)<<endl;
    
    return 0;
}
