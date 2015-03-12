//
//  main.cpp
//  restore ip address
//
//  Created by Yanqiao Zhan on 1/6/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <vector>
#include <string>
using namespace std;
class Solution{
public:
    int stringtoint(string s)
    {
        int result=0;
        for(int i=0;i<s.length();i++)
        {
            result*=10;
            result+=s[i]-'0';
        }
        return result;
    }
    string subrestore(string s,int existpart,bool e)
    {
        string result;
        if(s.length()>existpart*3||s.length()<existpart)
        {
            e=false;
            return "";
        }
        else
        {
            for(int i=1;i<=3;i++)
            {
                string tem=subrestore(s.substr(i,s.length()), existpart-1, true);
                if(tem!="")
                    result+="."+tem;
            }
            
            
        }
        return result;
    }
    vector<string>restoreIpAddresses(string s)
    {
        vector<string>result;
        
        return result;
    }
};
int main(int argc, const char * argv[]) {
    // insert code here...
    std::cout << "Hello, World!\n";
    return 0;
}
