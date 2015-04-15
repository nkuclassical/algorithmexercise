class Solution {
public:
    vector<int> rightSideView(TreeNode *root) {
        sub(root,0);
        return ret;
    }
    void sub(TreeNode*root,int depth)
    {
        if(root==NULL)return;
        if(depth==ret.size())
            ret.push_back(root->val);
        if(root->right)sub(root->right,depth+1);
        if(root->left)sub(root->left,depth+1);
    }
    vector<int>ret;
};
