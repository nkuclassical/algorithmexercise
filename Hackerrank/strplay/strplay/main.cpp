//
//  main.cpp
//  strplay
//
//  Created by Yanqiao Zhan on 12/18/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <string>
#include <map>
using namespace std;
int main(int argc, const char * argv[]) {
    string s;
    
    cin>>s;
    for(int i=1;i<s.length()-1;i++)
    {
        if(s[i+1]==s[i-1]){
            int j=1;
            while(i+j<s.length()-1&&i-j>=0&&s[i+j]==s[i-j])
            {
                j++;
            }
        }
        if(s[i+1]==s[i]){
            int p=1;
            while(i+p<s.length()&&i-p+1>=0&&s[i+p]==s[i-p+1])
            {
                p++;
            }
        }
    }
    return 0;
}
