//
//  main.cpp
//  valid sudoku
//
//  Created by Yanqiao Zhan on 1/8/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <vector>
#include <map>
using namespace std;
class Solution {
public:
    bool isValidSudoku(vector<vector<char> > &board) {
        map<char, bool>visit;
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
             //   if(board[i][j]!='.'&&visit.find(board[i][j])==visit.end())
               // {
                 //   visit[board[i][j]]=true;
                //}
                //else if(board[i][j]!='.'&&visit.find(board[i][j])!=visit.end())
                  //  return false;
            }
            visit.clear();
        }
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                for(int p=0;p<3;p++)
                {
                    for(int q=0;q<3;q++)
                    {
                        if(board[i*3+p][j*3+q]!='.'&&visit.find(board[i*3+p][j*3+q])==visit.end())
                        {
                            visit[board[i*3+p][j*3+q]]=true;
                        }
                        else if(board[i*3+p][j*3+q]!='.'&&visit.find(board[i*3+p][j*3+q])!=visit.end())
                            return false;
                    }
                }
                visit.clear();
            }
        }
        return true;
    }
};
int main(int argc, const char * argv[]) {
    vector<vector<char>>board;
    vector<char> tem;
    tem.push_back('.');
    tem.push_back('8');
    tem.push_back('7');
    tem.push_back('6');
    tem.push_back('5');
    tem.push_back('4');
    tem.push_back('3');
    tem.push_back('2');
    tem.push_back('1');
    board.push_back(tem);
    tem.clear();
    tem.push_back('2');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    board.push_back(tem);
    tem.clear();
    tem.push_back('3');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');

    board.push_back(tem);
    tem.clear();
    tem.push_back('4');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    board.push_back(tem);
    tem.clear();
    tem.push_back('5');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    board.push_back(tem);
    tem.clear();
    tem.push_back('6');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    board.push_back(tem);
    tem.clear();
    tem.push_back('7');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    board.push_back(tem);
    tem.clear();
    tem.push_back('8');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    board.push_back(tem);
    tem.clear();
    tem.push_back('9');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    tem.push_back('.');
    Solution s;
    cout<<s.isValidSudoku(board)<<endl;
return 0;
}
