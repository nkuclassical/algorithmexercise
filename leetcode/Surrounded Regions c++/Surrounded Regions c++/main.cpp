//
//  main.cpp
//  Surrounded Regions c++
//
//  Created by Yanqiao Zhan on 1/15/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <queue>
#include <vector>

using namespace std;
class Solution
{
public:
    void dfs(vector<vector<char>>&board,int row,int col)
    {
        board[row][col]='B';
        int width=board.size();
        int length=board[0].size();
        queue<pair<int, int>>q;
        q.push(make_pair(row, col));
        while(!q.empty())
        {
            pair<int, int>cur=q.front();
            q.pop();
            pair<int, int>direction[4]=
            {
                {cur.first-1,cur.second},
                {cur.first,cur.second-1},
                {cur.first,cur.second+1},
                {cur.first+1,cur.second}
            };
            for(int i=0;i<4;i++)
            {
                int adjw=direction[i].first;
                int adjc=direction[i].second;
                if((adjw>=0)&&(adjw<width)&&(adjc>=0)&&(adjc<length)&&(board[adjw][adjc]=='O'))
                {
                    board[adjw][adjc]='B';
                    q.push(make_pair(adjw, adjc));
                }
                   
            }
        }
    }
    void solve(vector<vector<char>>&board)
    {
        if(board.size()==0)return;
        if(board[0].size()==0)return;
        for(int i=0;i<board.size();i++)
        {
            if(board[i][0]=='O')
            {
                dfs(board, i, 0);
            }
            if(board[i][board[0].size()-1]=='O')
            {
                dfs(board, i, board[0].size()-1);
            }
        }
        for(int i=0;i<board[0].size();i++)
        {
            if(board[0][i]=='O')
            {
                dfs(board, 0, i);
            }
            if(board[board.size()-1][i]=='O')
            {
                dfs(board, board.size()-1, i);
            }
        }
        for(int i=0;i<board.size();i++)
        {
            for(int j=0;j<board[0].size();j++)
            {
                if(board[i][j]=='O')
                    board[i][j]='X';
                else if(board[i][j]=='B')
                    board[i][j]='O';
            }
        }

    }
};
int main(int argc, const char * argv[]) {
    // insert code here...
    std::cout << "Hello, World!\n";
    return 0;
}
