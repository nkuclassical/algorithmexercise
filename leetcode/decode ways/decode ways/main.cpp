//
//  main.cpp
//  decode ways
//
//  Created by Yanqiao Zhan on 1/10/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <string>
using namespace std;
class Solution {
public:
    int stringtoint(string s)
    {
        int result=0;
        for(int i=0;i<s.size();i++)
        {
            result*=10;
            result+=s[i]-'0';
        }
        return result;
    }
    int numDecodings(string s) {
//        if(s.substr())
        return 0;
            
    }
};
int main(int argc, const char * argv[]) {

    
    return 0;
}
