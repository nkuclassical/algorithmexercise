//
//  main.cpp
//  excel sheet column title
//
//  Created by Yanqiao Zhan on 1/5/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
using namespace std;
class Solution
{
public:
    string alpha[26]={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    string convertToTitle(int n)
    {
        string result,tem;
        while(n>0)
        {
            if(n%26>0)
                result+=alpha[n%26-1];
            else if(n%26==0)
                result+="Z";
            n=(n-1)/26;
        }
        for(int i=result.length()-1;i>=0;i--)
            tem+=result[i];
        return tem;
    }
};
int main(int argc, const char * argv[]) {
    Solution a;
    cout<<a.convertToTitle(1)<<endl;
    return 0;
}
