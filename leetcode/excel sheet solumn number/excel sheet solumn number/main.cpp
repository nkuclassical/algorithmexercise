//
//  main.cpp
//  excel sheet solumn number
//
//  Created by Yanqiao Zhan on 1/5/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <string>
using namespace std;
class Solution
{
public:
    int titleToNumber(string s)
    {
        int value=0;
        for(int i=0;i<s.length();i++)
        {
            value*=26;
            value+=s[i]-'A'+1;
        }
        return value;
    }
};
int main(int argc, const char * argv[]) {
    Solution a;
    cout<<a.titleToNumber("Z")<<endl;
    return 0;
}
