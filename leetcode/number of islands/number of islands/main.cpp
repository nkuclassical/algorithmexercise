//
//  main.cpp
//  number of islands
//
//  Created by Yanqiao Zhan on 4/14/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    int numIslands(vector<vector<char>> &grid) {
        int ret=0;
        for(int i=0;i<grid.size();i++)
        {
            for(int j=0;j<grid[i].size();j++)
            {
                if(grid[i][j]=='1')
                {
                    ret++;
                    grid[i][j]='2';
                    sub(grid,i,j);
                }
            }
        }
        return ret;
    }
    void sub(vector<vector<char>>&grid,int row,int column)
    {
        if(row+1<grid.size()&&grid[row+1][column]=='1')
        {
            grid[row+1][column]='2';
            sub(grid,row+1,column);
        }
        if(row-1>=0&&grid[row-1][column]=='1')
        {
            grid[row-1][column]='2';
            sub(grid,row-1,column);
        }
        if(column+1<grid[row].size()&&grid[row][column+1]=='1')
        {
            grid[row][column+1]='2';
            sub(grid,row,column+1);
        }
        if(column-1>=0&&grid[row][column-1]=='1')
        {
            grid[row][column-1]='2';
            sub(grid,row,column-1);
        }
    }
};
int main(int argc, const char * argv[]) {
    vector<vector<char>>grid={{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
    Solution s;
    cout<<s.numIslands(grid)<<endl;
    return 0;
}
