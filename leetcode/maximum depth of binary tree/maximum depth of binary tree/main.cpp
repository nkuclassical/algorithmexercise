//
//  main.cpp
//  maximum depth of binary tree
//
//  Created by Yanqiao Zhan on 1/5/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    int maxDepth(TreeNode *root) {
        if(root==NULL)return 0;
        else
        {
            if(root->left!=NULL&&root->right!=NULL)
                return max(maxDepth(root->left)+1,maxDepth(root->right)+1);
            else if(root->left!=NULL&&root->right==NULL)
                return maxDepth(root->left)+1;
            else if(root->left==NULL&&root->right!=NULL)
                return maxDepth(root->right)+1;
            else return 1;
        }
    }
};
int main(int argc, const char * argv[]) {
    // insert code here...
    std::cout << "Hello, World!\n";
    return 0;
}
