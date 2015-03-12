//
//  main.cpp
//  linked list cycle ii
//
//  Created by Yanqiao Zhan on 1/22/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <string>
#include <vector>
#include <cmath>
#include <unordered_map>
using namespace std;
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    int divide(int dividend, int divisor) {
        return sub(dividend,divisor);
        
    }
    int sub(long dividend,long divisor)
    {

        bool negative=false;
        if((dividend<0&&divisor>0)||(dividend>0&&divisor<0))negative=true;
        dividend=abs(dividend);
        divisor=abs(divisor);
        long ret=0;
        long sum=divisor;
        long c=1;
        while(dividend>=divisor)
        {
            if(dividend>=sum)
            {
                dividend-=sum;
                ret+=c;
                sum=(sum<<1);
                c=(c<<1);
            }
            else
            {
                sum=(sum>>1);
                c=(c>>1);
            }
        }
        if(negative)
            ret=-ret;
        if(ret<INT_MIN||ret>INT_MAX)return INT_MAX;
        else return ret;
//        return min(max(INT_MIN,ret),INT_MAX);
    }
};
int main(int argc, const char * argv[]) {
    // insert code here...
    Solution s;
//    cout<<s.simplifyPath("/a/./b/../../c/")<<endl;
    cout<<s.sub(-2147483648, -1)<<endl;
    
    return 0;
}
