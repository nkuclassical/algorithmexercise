//
//  main.cpp
//  minimum path
//
//  Created by Yanqiao Zhan on 1/26/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <unordered_map>
#include <vector>
#include <stack>
using namespace std;
class Solution {
public:
    int evalRPN(vector<string> &tokens) {
        stack<string>s;
        for(int i=0;i<tokens.size();i++)
        {
            if(tokens[i]=="+"||tokens[i]=="-"||tokens[i]=="*"||tokens[i]=="/")
            {

                int b=stringtoint(s.top());
                s.pop();
                int a=stringtoint(s.top());
                s.pop();
                if(tokens[i]=="+")
                {
                    s.push(to_string(a+b));
                }
                else if(tokens[i]=="-")
                {
                    s.push(to_string(a-b));
                }
                else if(tokens[i]=="*")
                {
                    s.push(to_string(a*b));
                }
                else if(tokens[i]=="/")
                {
                    s.push(to_string(a/b));
                }
            }
            else
            {
                s.push(tokens[i]);
            }
        }
        return stringtoint(s.top());
    }
    int stringtoint(string s)
    {
        int ans=0;
        int i=0;
        if(s[0]=='-')
            i=1;
        for(;i<s.size();i++)
        {
            ans*=10;
            ans+=s[i]-'0';
        }
        return s[0]=='-'?-ans:ans;
    }
};
int main(int argc, const char * argv[]) {
    // insert code here...
    Solution s;
    vector<string>v;
    v.push_back("3");
        v.push_back("-4");
        v.push_back("+");

    cout<<s.evalRPN(v)<<endl;
//    cout<<s.lengthOfLongestSubstringTwoDistinct("123321123321")<<endl;
    
/*    vector<int>c;
    c.push_back(12);
    c.push_back(15);
    c.push_back(19);
    c.push_back(8);
    c.push_back(20);
    c.push_back(51);
    c.push_back(8);
        c.push_back(8);
    c.push_back(732);
//    c.erase(c.begin()+4, c.end());

    for(vector<int>::iterator it=c.begin();it!=c.end();it++)
    {
        if(*it==8)
        {
            c.insert(it, 7);
            it++;
        }
    }
    c.res
    for(int i=0;i<c.size();i++)
        cout<<c[i]<<" ";
    cout<<endl;
//    remove(c.begin(), c.end(), 8);
*/

    return 0;
}
