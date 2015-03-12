//
//  main.cpp
//  balanced binary tree
//
//  Created by Yanqiao Zhan on 1/10/15.
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
    bool isBalanced(TreeNode *root) {
        int a=maxtraverse(root);
        int b=mintraverse(root);
        cout<<a<<" "<<b<<endl;
        return a-b<=1;
    }
    int mintraverse(TreeNode*root)
    {
        if(root==NULL)return 0;
        else if(root->left!=NULL&&root->right!=NULL)
        {
            return min(mintraverse(root->left),mintraverse(root->right))+1;
        }
        else return 1;
    }
    int maxtraverse(TreeNode*root)
    {
        if(root==NULL)return 0;
        else if(root->left!=NULL&&root->right!=NULL)
        {
            return max(maxtraverse(root->left),maxtraverse(root->right))+1;
        }
        else if(root->left!=NULL&&root->right==NULL)
        {
            return maxtraverse(root->left)+1;
        }
        else if(root->left==NULL&&root->right!=NULL)
        {
            return maxtraverse(root->right)+1;
        }
        else return 1;
    }
};
int main(int argc, const char * argv[]) {
    // insert code here...
    std::cout << "Hello, World!\n";
    return 0;
}
