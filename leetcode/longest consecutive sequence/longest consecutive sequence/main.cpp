//
//  main.cpp
//  longest consecutive sequence
//
//  Created by Yanqiao Zhan on 1/11/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;
/*
class Solution {
public:
    int longestConsecutive(vector<int> &num) {
        unordered_map<int,int>hashmap;
        vector<int>length(num.size(),0);
        int max=INT_MIN;
        for(int i=0;i<num.size();i++)
        {
            hashmap[num[i]]=i;
        }
        for(int i=0;i<num.size();i++)
        {
            if(length[i]>0)continue;
            length[i]=consecutive(num[i],hashmap,length);
            if(length[i]>max)max=length[i];
        }
        return max;
    }
    int consecutive(int value,unordered_map<int,int>hashmap,vector<int>length)
    {
        if(hashmap.find(value)==hashmap.end())return 0;
        int index=hashmap[value];
        if(length[index]>0)return length[index];
        else
        {
            length[index]=consecutive(value-1,hashmap,length)+1;
            return length[index];
        }
    }
};
 */
class Solution {
public:
    int longestConsecutive(vector<int> &num) {
        unordered_map<int, int> hashmap;
        vector<int> length(num.size(),0);
        for(int i =0; i< num.size(); i++)
        {
            hashmap[num[i]]=i;
        }
        for(int i =0; i< num.size(); i++)
        {
            // skip the node, which already calculate the length
            if(length[i] > 0) continue;
            length[i] = consecutiveLength(num[i], hashmap, length);
        }
        int maxV = INT_MIN;
        for(int i =0; i< num.size(); i++)
        {
            maxV = length[i]>maxV?length[i]:maxV;
        }
        return maxV;
    }
    int consecutiveLength(int num, unordered_map<int, int>& hashmap, vector<int>& length)
    {
        if(hashmap.find(num) == hashmap.end()) return 0;
        int index = hashmap[num];
        // skip the node, which already calculate the length
        if(length[index] > 0) return length[index];
        else
        {
            // hit each fresh node only once
            length[index] = consecutiveLength(num - 1, hashmap, length) + 1;
            return length[index];
        }
    }
};
int main(int argc, const char * argv[]) {
    vector<int>input;
    input.push_back(100);
        input.push_back(4);
        input.push_back(200);
        input.push_back(1);
        input.push_back(2);
        input.push_back(3);
    Solution s;
    cout<<s.longestConsecutive(input)<<endl;
    return 0;
}
