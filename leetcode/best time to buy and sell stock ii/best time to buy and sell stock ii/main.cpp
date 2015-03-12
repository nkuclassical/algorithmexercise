//
//  main.cpp
//  best time to buy and sell stock ii
//
//  Created by Yanqiao Zhan on 1/5/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <vector>
using namespace std;
class Solution{
public:
    int maxProfit(vector<int>&prices)
    {
        
        int result=0;
        for(int i=1;i<prices.size();i++)
        {
            if(prices[i]>prices[i-1])
                result+=prices[i]-prices[i-1];
        }
        return result;
    }
};
int main(int argc, const char * argv[]) {
    // insert code here...
    vector<int>p;

    Solution a;
    cout<<a.maxProfit(p)<<endl;
    return 0;
}
