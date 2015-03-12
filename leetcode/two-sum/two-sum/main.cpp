//
//  main.cpp
//  two-sum
//
//  Created by Yanqiao Zhan on 1/5/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <vector>
#include <algorithm>
#include <map>
using namespace std;
class Solution
{
public:
    void display(vector<int>&numbers)
    {
        for(int i=0;i<numbers.size();i++)
            cout<<numbers[i]<<" ";
        cout<<endl;
    }
    vector<int>twoSum(vector<int>&numbers,int target)
    {
        map<int, vector<int>>newnumbers;
        vector<int>result;
        for(int i=0;i<numbers.size();i++)
        {
        
            newnumbers[numbers[i]].push_back(i+1);
        }
        for(map<int, vector<int>>::iterator it=newnumbers.begin();it!=newnumbers.end();it++)
        {
            if(it->first*2==target&&it->second.size()>=2)
            {
                if(it->second[0]>it->second[1])
                    swap(it->second[0], it->second[1]);
                result.push_back(it->second[0]);
                result.push_back(it->second[1]);
                break;
            }
            if(newnumbers.find(target-it->first)!=newnumbers.end())
            {
                int value=newnumbers.find(target-it->first)->second[0];
                if(value<it->second[0])
                {
                    swap(value, it->second[0]);
                }
                result.push_back(it->second[0]);
                result.push_back(value);
            }
        }
        return result;
    }
};
int main(int argc, const char * argv[]) {
    vector<int>a;
    a.push_back(0);
    a.push_back(4);
    a.push_back(3);
    a.push_back(0);
    Solution b;
    vector<int>c=b.twoSum(a, 0);
    cout<<c[0]<<" "<<c[1]<<endl;
    return 0;
}
