//
//  main.cpp
//  minesweeper
//
//  Created by Yanqiao Zhan on 1/30/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <string>
#include <queue>
#include <unordered_set>
#include <vector>
#include <unordered_map>
using namespace std;
class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        unordered_map<size_t,int>map;
        hash<string>fn;
        vector<string>ans;
        for(int i=9;i<s.size();i++)
        {
            string sub=s.substr(i-9,10);
            size_t hashvalue=fn(sub);
            if(map.find(hashvalue)!=map.end())
            {
                if(map[hashvalue]==1)ans.push_back(sub);
                map[hashvalue]++;
            }
            else map[hashvalue]=1;
        }

        return ans;
       /* unordered_map<size_t,int> MP;
        hash<string> hash_fn;
        vector<string> ret;
        
        for(int i = 0; i < int(s.size()) - 9; ++i)
            if(MP[hash_fn(s.substr(i,10))]++ == 1 )
                ret.push_back(s.substr(i,10));
        
        return ret;
        */
    }
};
int main(int argc, const char * argv[]) {

/*    Solution s;
    unordered_set<string>dict;
    dict.insert("leet");
        dict.insert("lee");
    dict.insert("code");
//    vector<string>ans=s.wordBreak("leetcode", dict);
    cout<<s.wordBreak("leetcode", dict)<<endl;
 */
    Solution s;
    vector<string>ans=s.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
    for(int i=0;i<ans.size();i++)
        cout<<ans[i]<<endl;

    
    return 0;
}
