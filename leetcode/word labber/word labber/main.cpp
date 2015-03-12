//
//  main.cpp
//  word labber
//
//  Created by Yanqiao Zhan on 1/5/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <vector>
#include <string>
#include <unordered_set>
#include <map>
using namespace std;
class Solution
{
public:
    bool different(string a,string b)
    {
        int result=0;
        if(a.length()==b.length())
        {
            for(int i=0;i<a.length();i++)
            {
                if(a[i]!=b[i])
                    result++;
                if(result>1)
                    break;
            }
        }
        if(result==1)return true;
        else return false;
    }
 /*   vector<string> visit(string start,string end,map<string,bool>dic,vector<string> result)
    {
        if(different(start, end))
        {
            result.push_back(end);
            return result;
        }
        else
        {
            for(map<string, bool>::iterator it=dic.begin();it!=dic.end();it++)
            {
                if(it->second==false&&different(start, it->first))
                {
                    it->second=true;
                    result.push_back(it->first);
                    visit(it->first, end, dic,result);
                    result.pop_back();
                }
            }
            return result;
        }
    }*/
    vector<vector<string>>result;
    vector<vector<string>> findLadders(string start, string end, unordered_set<string> &dict)
    {
        map<string,bool>dic;
        for(unordered_set<string>::iterator it=dict.begin();it!=dict.end();it++)
        {
            dic[*it]=false;//never be visited
        }
        
        return result;
    }

};
int main(int argc, const char * argv[]) {
    string start="hit";
    string end="cog";
    unordered_set<string>dict;
    dict.insert("hot");
    dict.insert("dot");
    dict.insert("dog");
    dict.insert("lot");
    dict.insert("log");
    Solution m;

    return 0;
}
