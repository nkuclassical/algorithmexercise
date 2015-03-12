//
//  main.cpp
//  2mi
//
//  Created by Yanqiao Zhan on 2/11/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <string>
#include <vector>
using namespace std;
class Solution {
public:
    void reverseWords(string &s) {
        vector<string>ans;
        string ansult;
        string temp;
        for(int i=0;i<s.size();i++)
        {
            if(s[i]==' ')
            {
                if(temp.size()>0)
                {
                    ans.push_back(temp);
                    temp.clear();
                }
            }
            else
                temp+=s[i];
        }
        if(temp.size()>0)ans.push_back(temp);
        s.clear();
        if(ans.size()>0){
            for(int i=ans.size()-1;i>0;i--)
                s+=ans[i]+' ';
            s+=ans[0];
        }
        
        
    }
};
int main(int argc, const char * argv[]) {
    Solution s;
    string input="the sky is blue";
    s.reverseWords(input);
    cout<<input<<endl;
    return 0;
}
