//
//  main.cpp
//  pangrams
//
//  Created by Yanqiao Zhan on 2/16/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <string>
#include <unordered_map>
using namespace std;

int main(int argc, const char * argv[]) {
    string s;
    getline(cin,s);
    unordered_map<char, int>map;
    for(int i=0;i<s.size();i++)
    {
        char tem=s[i];
        if(s[i]>='A'&&s[i]<='Z')
            tem=s[i]-'A'+'a';
        if(tem>='a'&&tem<='z')
        {
            if(map.find(tem)==map.end())
            {
                map[tem]=1;
            }
        }
    }
    int count=0;
    for(unordered_map<char, int>::iterator it=map.begin();it!=map.end();it++)
    {
        count++;
    }
    if(count==26)cout<<"pangram"<<endl;
    else cout<<"not pangram"<<endl;
    return 0;
}
