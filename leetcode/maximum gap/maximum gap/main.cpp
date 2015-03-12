//
//  main.cpp
//  maximum gap
//
//  Created by Yanqiao Zhan on 1/23/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <vector>
#include <string>
using namespace std;
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    string addBinary(string a, string b) {
        string ans;
        int add=0;
        int i=0;
        if(a.size()<b.size())
        {
            string tem=b;
            b=a;
            a=tem;
        }
        string tem(a.size()-b.size(),'0');
        b=tem+b;
        for(int i=a.size()-1;i>=0;i--)
        {
            int value=a[i]-'0'+b[i]-'0'+add;
            if(value>=2)
            {
                value-=2;
                add=1;
            }
            else
                add=0;
            if(value==0)
                a[i]='0';
            else if(value==1)a[i]='1';
        }
        if(add==1)
            ans='1'+a;
        else ans=a;
        return ans;
    }
};
int main(int argc, const char * argv[]) {
    // insert code here...
    string a("11");
    string b("11");
    Solution s;
    cout<<s.addBinary(a,b)<<endl;
    
    return 0;
}
