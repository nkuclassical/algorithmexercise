//
//  main.cpp
//  same tree
//
//  Created by Yanqiao Zhan on 1/5/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
using namespace std;
struct TreeNode
{
    int val;
    TreeNode*left;
    TreeNode*right;
    TreeNode(int x):val(x),left(NULL),right(NULL){}
};
class Solution
{
public:
    bool isSameTree(TreeNode*p,TreeNode*q)
    {
        if(p==NULL&&q==NULL)return true;
        if(p!=NULL&&q!=NULL&&p->val==q->val){
            if(p->left!=NULL&&q->left!=NULL&&p->right!=NULL&&q->right!=NULL)
                return isSameTree(p->left, q->left)&&isSameTree(p->right, q->right);
            else if(p->left!=NULL&&q->left!=NULL&&p->right==NULL&&q->right==NULL)
                return isSameTree(p->left, q->left);
            else if(p->left==NULL&&q->left==NULL&&p->right!=NULL&&q->right!=NULL)
                return isSameTree(p->right, q->right);
            else if(p->left==NULL&&q->left==NULL&&p->right==NULL&&q->right==NULL)
                return true;
            else return false;
        }
        else return false;
    }
};
int main(int argc, const char * argv[]) {

    return 0;
}
