//
//  main.cpp
//  LongestSubstringwithoutRepeatingCharacters
//
//  Created by Yanqiao Zhan on 11/19/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
using namespace std;
class Solution{
public:
    int max(int a,int b)
    {
        return a>b?a:b;
    }
    int lengthOfLongestSubstring(string s) {
        if(s.length()==0)return 0;
        int maxlength=0,fast=0,slow=0;
        char exist[256]={false};
        for(int i=0;i<s.length();i++)
        {
            fast=i;
            if(exist[s[i]])
            {
                maxlength=max(maxlength,fast-slow);
                for(int j=slow;j<fast;j++)
                {
                    if(s[i]==s[j])
                    {
                        slow=j+1;
                        break;
                    }
                    else
                    {
                        exist[s[j]]=false;
                    }
                }
            }
            else
            {
                exist[s[i]]=true;
            }
        }
        return max(maxlength,fast-slow+1);
    }
};
