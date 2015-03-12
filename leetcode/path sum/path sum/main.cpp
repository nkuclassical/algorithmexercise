//
//  main.cpp
//  path sum
//
//  Created by Yanqiao Zhan on 1/6/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    bool hasPathSum(TreeNode *root, int sum) {
        if(root==NULL&&sum>0)return false;
        if(sum<root->val)return false;
        else{
            if(root->left==NULL&&root->right==NULL)
            {
                if(sum==root->val)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else if(root->left!=NULL&&root->right!=NULL)
            {
                return hasPathSum(root->left,sum-root->val)||hasPathSum(root->right, sum-root->val);
            }
            else if(root->left!=NULL&&root->right==NULL)
            {
                return hasPathSum(root->left, sum-root->val);
            }
            else //if(root->left==NULL&&root->right!=NULL)
            {
                return hasPathSum(root->right, sum-root->val);
            }
        }
    }
};
int main(int argc, const char * argv[]) {
    // insert code here...
    std::cout << "Hello, World!\n";
    return 0;
}
