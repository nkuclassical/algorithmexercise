//
//  main.cpp
//  binary tree maximum path sum
//
//  Created by Yanqiao Zhan on 1/11/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <algorithm>
#include <stack>
using namespace std;
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    int maxPathSum(TreeNode *root)
    {
        maxvalue=0;
        sub(root);
        return maxvalue;
    }
    int sub(TreeNode*root)
    {
        if(root==NULL)return 0;
        if(root->left==NULL&&root->right==NULL)
        {
            return root->val;
        }
        int left=sub(root->left);
        int right=sub(root->right);
        if(left+right+root->val>maxvalue)
        {
            maxvalue=left+right+root->val;
        }
        return max(left,right)+root->val;

    }
private:
    int maxvalue;
};
int main(int argc, const char * argv[]) {
    // insert code here...
    stack<int>s;
    s.top();
    
    return 0;
}
