//
//  main.cpp
//  longest valid parentheses
//
//  Created by Yanqiao Zhan on 1/12/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <stack>
#include <string>
#include <vector>

using namespace std;
class Solution {
public:
    void rotate(vector<vector<int> > &matrix) {
        int n=matrix.size();
        for(int i=0;i<matrix.size();i++)
        {
            for(int j=0;j<matrix.size()-i;j++)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[n-1-j][n-1-i];
                matrix[n-1-j][n-1-i]=temp;
            }
        }

        for(int i=0;i<matrix.size()/2;i++)
        {
            for(int j=0;j<matrix.size();j++)
            {

                int temp=matrix[i][j];
                matrix[i][j]=matrix[n-1-i][j];
                matrix[n-1-i][j]=temp;
            }
        }
    }
};
int main(int argc, const char * argv[]) {
    vector<int>temp;
    vector<vector<int>>v;
    temp.push_back(1);
    temp.push_back(2);
    v.push_back(temp);
    temp.clear();
    temp.push_back(3);
    temp.push_back(4);
    v.push_back(temp);
    Solution s;
    s.rotate(v);
    return 0;
}
