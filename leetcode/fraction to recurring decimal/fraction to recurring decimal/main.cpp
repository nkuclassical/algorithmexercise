//
//  main.cpp
//  fraction to recurring decimal
//
//  Created by Yanqiao Zhan on 1/5/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <string>
#include <map>
using namespace std;
class Solution
{
public:
    string fractionToDecimal(int numerator,int denominator)
    {
        string result;
        map<int, int>facotr;
        result=numerator/denominator;
        
        while(true)
        {
            int divisor=numerator/denominator;
            
        }
        return result;
    }
};
int main(int argc, const char * argv[]) {
    string a;
    a.push_back(char(2));
    cout<<a<<endl;
    return 0;
}
