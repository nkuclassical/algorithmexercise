//
//  main.cpp
//  edit distance
//
//  Created by Yanqiao Zhan on 1/8/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;
class Solution {
public:
    int minDistance(string word1,string word2){
        int result=0;
        if(word1.size()==0&&word2.size()>0)
            return static_cast<int>(word2.size());
        else if(word1.size()>0&&word2.size()==0)
            return static_cast<int>(word1.size());
        else if(word1.size()==0&&word2.size()==0)
            return 0;
        else
        {
            if(word1[word1.size()-1]==word2[word2.size()-1])
            {
                return minDistance(word1.substr(0,word1.size()-1), word2.substr(0,word2.size()-1));
            }
            else
            {
                return 1+min(minDistance(word1.substr(0,word1.size()-1),word2),minDistance(word1,word2.substr(0,word2.size()-1)),minDistance(word1.substr(0,word1.size()-1), word2.substr(0,word2.size()-1)));
            }
        }
        return result;
    }
private:
    int min(int a,int b,int c)
    {
        if(a<=b&&a<=c)return a;
        else if(b<=a&&b<=c)return b;
        else return c;
    }
    
};
int main(int argc, const char * argv[]) {
    string a="dinitrophenylhydrazine",b="benzalphenylhydrazone";
   // Solution c;
//    cout<<c.minDistance(a,b)<<endl;
  //  char str[]="abc";
    string str="abc";
    cout<<sizeof(str)<<endl;
    return 0;
}
