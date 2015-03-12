//
//  main.cpp
//  reverse words in a string
//
//  Created by Yanqiao Zhan on 1/7/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <vector>
#include <string>
using namespace std;
class Solution {
public:
    void reverseWords(string &s) {
        vector<string>temp;
        string subs;
        for(int i=0;i<s.length();i++)
        {
            if(s[i]!=' ')subs+=s[i];
            else
            {
                if(subs!="")
                {
                    temp.push_back(subs);
                    subs.clear();
                }
            }
        }
        if(subs!="")temp.push_back(subs);
        subs.clear();
        s.clear();
        if(temp.size()>0){
        for(int i=temp.size()-1;i>0;i--)
            s+=temp[i]+" ";
        s+=temp[0];
        }
    }
};
int main(int argc, const char * argv[]) {
    string s="the  dfa";
    Solution ss;
    ss.reverseWords(s);
    cout<<s<<endl;
    return 0;
}
