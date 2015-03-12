//
//  main.cpp
//  text justification
//
//  Created by Yanqiao Zhan on 1/22/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <vector>
#include <string>
#include <unordered_map>
using namespace std;

int main(int argc, const char * argv[]) {
    // insert code here...
    int num;
    cin>>num;
    vector<string> input(num);
    unordered_map<char, vector<int>>map;
    for(int i=0;i<num;i++)
    {
        cin>>input[i];
        for(int j=0;j<input[i].size();j++)
        {
            if(map.find(input[i][j])!=map.end())
            {
                if(map[input[i][j]].back()<i)map[input[i][j]].push_back(i);
            }
            else
            {
                map[input[i][j]].push_back(i);
            }
        }
    }
    int ans=0;
    for(unordered_map<char, vector<int>>::iterator it=map.begin();it!=map.end();it++)
    {
        if(it->second.size()==num)ans++;
    }
    cout<<ans<<endl;
    return 0;
}
