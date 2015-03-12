//
//  main.cpp
//  permutation sequence
//
//  Created by Yanqiao Zhan on 1/6/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <string>
#include <map>
using namespace std;
class Solution {
public:
    int factorial(int n)
    {
        int m=1;
        for(int i=2;i<=n;i++)
        {
            m*=i;
        }
        return m;
    }
    string getPermutation(int n, int k) {
        string result;
        map<char,bool>list;
        char ch[9]={'1','2','3','4','5','6','7','8','9'};
        for(int i=0;i<n;i++)
        {
            list.insert(pair<char, bool>(ch[i],true));
        }
        for(int i=n-1;i>=0;i--)
        {
            if(k!=0){
            int tem=(k-1)/factorial(i);
            k=k%factorial(i);
            int r=0;
            for(map<char, bool>::iterator it=list.begin();it!=list.end();it++)
            {
                if(r==tem&&it->second==true)
                {
                    it->second=false;
                    result+=it->first;
                    break;
                }
                else if(it->second==true)
                {
                    r++;
                }
            }
            }
            else
            {
                for(map<char,bool>::reverse_iterator it=list.rbegin();it!=list.rend();it++)
                {
                    if(it->second==true)
                    {
                        result+=it->first;
                        it->second=false;
                        break;
                    }
                }
            }
        }
        return result;
    }
};
int main(int argc, const char * argv[]) {
    Solution s;
    cout<<s.getPermutation(0,0)<<endl;
    return 0;
}
