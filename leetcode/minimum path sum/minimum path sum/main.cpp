//
//  main.cpp
//  minimum path sum
//
//  Created by Yanqiao Zhan on 1/24/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <vector>
#include <string>
#include <map>
#include <unordered_map>
#include <stdio.h>
#include <queue>
#include <unordered_map>
#include <unordered_set>
#include <cmath>
#include <queue>
using namespace std;
/*
class Solution {
public:
    vector<int> spiralOrder(vector<vector<int> > &matrix) {
        vector<int>ans;
        if(matrix.size()==0)return ans;
        int row=matrix.size();
        int col=matrix[0].size();
        int level=min(row,col)/2;
        for(int i=0;i<level;i++)
        {
            
            for(int j=i;j<col-i;j++)
            {
                ans.push_back(matrix[i][j]);
            }
            for(int j=i+1;j<row-i;j++)
            {
                ans.push_back(matrix[j][col-i-1]);
            }
            for(int j=col-i-2;j>=i;j--)
            {
                ans.push_back(matrix[row-i-1][j]);
            }
            for(int j=row-i-2;j>i;j--)
            {
                ans.push_back(matrix[j][i]);
            }
        }

        if(col>row)
        {
            if(row!=level*2)
            {
                for(int i=level;i<col-level;i++)
                {
                    ans.push_back(matrix[level][i]);
                }
            }
        }
        else
        {
            if(col!=level*2)
            {
                for(int i=level;i<row-level;i++)
                {
                    ans.push_back(matrix[i][level]);
                }
            }
        }
        return ans;
    }
};*/
/*
class Solution {
public:
    vector<vector<int> > generateMatrix(int n) {
        vector<int>input(n);
        vector<vector<int>>ans(n,input);
        int level=n/2;
        int index=1;
        for(int i=0;i<level;i++)
        {
            for(int j=i;j<n-i;j++)
            {
                ans[i][j]=index;
                index++;
            }
            for(int j=i+1;j<n-i;j++)
            {
                ans[j][n-i-1]=index;
                index++;
            }
            for(int j=n-i-2;j>=i;j--)
            {
                ans[n-i-1][j]=index;
                index++;
            }
            for(int j=n-i-2;j>i;j--)
            {
                ans[j][i]=index;
                index++;
            }
        }
        if(level*2!=n)
            ans[level][level]=index;
        return ans;
    }
};*/
/*
class Solution {
public:
    unordered_map<char,int>map={{'I',1},{'V',5},{'X',10},{'L',50},{'C',100},{'D',500},{'M',1000}};
    int romanToInt(string s) {
        int ans=map[s.back()];
        cout<<ans<<endl;
        for(int i=s.length()-2;i>=0;i--)
        {
            if(map[s[i]]<map[s[i+1]])
            {
                
                ans-=map[s[i]];
                cout<<ans<<" "<<s[i]<<" "<<s[i+1]<<endl;
            }
            else
            {
                ans+=map[s[i]];
                cout<<ans<<endl;
            }
        }
        return ans;
    }
};
 */
/*
class Solution {
public:
    int strStr(char *haystack, char *needle) {
        string a,b;
        for(int i=0;haystack[i]!='\0';i++)
        {
            //a+=haystack[i];
            int j=0;
            while(needle[j]!='\0'&&haystack[j+i]!='\0'&&haystack[j+i]==needle[j])
            {
                j++;
            }
            if(needle[j]=='\0')
                return i;
            
        }
        return -1;
        
    }
};*/
/*
class Solution {
public:
    bool isInterleave(string s1, string s2, string s3) {
        if(s1.size()+s2.size()!=s3.size())return false;
        vector<bool>input(s2.size()+1,false);
        vector<vector<bool>>matrix(s1.size()+1,input);
        matrix[0][0]=true;
        for(int i=1;i<=s1.size();i++)
        {
            if(s1[i-1]==s3[i-1])
                matrix[i][0]=true;
            else
                break;
        }
        for(int i=1;i<=s2.size();i++)
        {
            if(s2[i-1]==s3[i-1])
                matrix[0][i]=true;
            else
                break;
        }
        for(int i=1;i<=s1.size();i++)
        {
            char c1=s1[i-1];
            for(int j=1;j<=s2.size();j++)
            {
                char c2=s2[j-1];
                char c3=s3[i+j-1];
                if(c1==c3)
                {
                    matrix[i][j]=matrix[i-1][j]||matrix[i][j];
                }
                if(c2==c3)
                {
                    matrix[i][j]=matrix[i][j-1]||matrix[i][j];
                }
            }
        }
        display(matrix);
        return matrix[s1.size()][s2.size()];
        
    }
    void display(vector<vector<bool>>&matrix)
    {
        for(int i=0;i<matrix.size();i++)
        {
            for(int j=0;j<matrix[i].size();j++)
                cout<<matrix[i][j]<<" ";
            cout<<endl;
        }
    }
};
 */
/*
class Solution {
public:
    int jump(int A[], int n) {
        int Max=INT_MIN,steps=0,index=0,end=0;
        while(index<n)
        {
            if(Max>=n-1)break;
            while(index<=end)
            {
                Max=max(Max,index+A[index]);
                index++;
            }
            steps++;
            end=Max;
        }
        return steps;
    }
};
 */
/*
class Solution {
public:
    vector<string> findMissingRanges(int A[], int n, int lower, int upper) {
        vector<string>ans;
        if(n==0)
        {
            if(lower==upper)
                ans.push_back(to_string(lower));
            else
            {
                ans.push_back(to_string(lower)+"->"+to_string(upper));
            }
            return ans;
        }
        if(upper<A[0])
        {
            ans.push_back(to_string(lower)+"->"+to_string(upper));
            return ans;
        }

        if(lower<A[0]-1)
        {
            ans.push_back(to_string(lower)+"->"+to_string(A[0]-1));
        }
        else if(lower==A[0]-1)
        {
            ans.push_back(to_string(lower));
        }
        for(int i=0;i<n-1;i++)
        {
            if(A[i]>=upper)
                break;
            if((A[i]==A[i+1])||(A[i]+1==A[i+1]))
            {
                continue;
            }
            else if(A[i]+2==A[i+1])
            {
                ans.push_back(to_string(A[i]+1));
            }
            else if(A[i]+2<A[i+1])
            {
                if(A[i+1]<=upper)
                    ans.push_back(to_string(A[i]+1)+"->"+to_string(A[i+1]-1));
                else if(upper==A[i]+1)
                    ans.push_back(to_string(upper));
                else if(upper>A[i]+1)
                    ans.push_back(to_string(A[i]+1)+"->"+to_string(upper));
            }
        }
        if(A[n-1]<upper-1)
        {
            ans.push_back(to_string(A[n-1]+1)+"->"+to_string(upper));
        }
        else if(A[n-1]==upper-1)
        {
            ans.push_back(to_string(upper));
        }
        return ans;
    }
};
 */
/*
class Solution {
public:
    bool isOneEditDistance(string s, string t) {
        for(int i=0;i<min(s.size(),t.size());i++)
        {
            if(s[i]!=t[i])
            {
                if(s.size()==t.size())
                {
                    return s.substr(i+1).compare(t.substr(i+1))==0;
                }
                else if(s.size()<t.size())
                {
                    return s.substr(i).compare(t.substr(i+1))==0;
                }
                else return s.substr(i+1).compare(t.substr(i))==0;
            }
        }
        if(abs(static_cast<int>(s.size()-t.size()))==1)
            return true;
        else return false;
    }
};
 */
class Solution {
public:
    int lengthOfLongestSubstringTwoDistinct(string s) {
        if(s.size()<=2)return s.size();
        int fast=0,slow=0;
        unordered_map<char,queue<int>>record;
        int ans=0;
        for(fast=0;fast<s.size();)
        {
            cout<<s[fast]<<" "<<ans<<endl;
            if(record.size()<2||record.find(s[fast])!=record.end())
            {
                record[s[fast]].push(fast);
                fast++;
                ans=(fast-slow)>ans?(fast-slow):ans;
                cout<<fast<<" "<<slow<<" "<<fast-slow<<"!!"<<endl;
            }
            else
            {
                char slowchar=s[slow];
                char another;
                for(unordered_map<char,queue<int>>::iterator it=record.begin();it!=record.end();it++)
                {
                    if(it->first!=slowchar)
                    {
                        another=it->first;
                    }
                }

                int index1=record[slowchar].front();
                int index2=record[another].front();
                while(slow<fast)
                {
                    if(index1==slow)
                    {
                        record[slowchar].pop();
                        if(record.empty())
                        {
                            record.erase(slowchar);
                            record[s[fast]].push(fast);
                            break;
                        }
                        else
                        {
                            index1=record[slowchar].front();
                        }
                    }
                    else if(index2==slow)
                    {
                        record[another].pop();
                        if(record.empty())
                        {
                            record.erase(another);
                            record[s[fast]].push(fast);
                            break;
                        }
                        else
                        {
                            index2=record[another].front();
                        }
                    }
                    slow++;
                }
                ans=(fast-slow)>ans?(fast-slow):ans;
                cout<<"!!!"<<fast<<" "<<slow<<" "<<fast-slow<<"!!"<<endl;
                fast++;
            }
            
        }
        return ans;
    }
};
int main(int argc, const char * argv[]) {


    Solution s;
//
    cout<<s.lengthOfLongestSubstringTwoDistinct("eceba")<<endl;
   /* map<char, queue<int>>a;
    a['1'].push(10);
    a['1'].push(20);
    a['2'].push(2);
    cout<<a.size()<<endl;
    a.erase('1');
    cout<<a.size()<<endl;
  */
//    vector<vector<int>>v;
/*    vector<int>input;
    input.push_back(2);
    input.push_back(5);
//    input.push_back(3);
  //  input.push_back(4);
    v.push_back(input);
    input.clear();
    input.push_back(8);
    input.push_back(4);
  //  input.push_back(7);
   // input.push_back(8);
    v.push_back(input);
    input.clear();
    input.push_back(0);
    input.push_back(-1);
 //   input.push_back(11);
  //  input.push_back(12);
/*    v.push_back(input);
    input.clear();
    input.push_back(9);
    input.push_back(10);
 //   input.push_back(11);
  //  input.push_back(12);

    v.push_back(input);
    input.clear();*/
    /*
    v=s.generateMatrix(5);
    for(int i=0;i<v.size();i++)
    {
        for(int j=0;j<v[i].size();j++)
        {
            cout<<v[i][j]<<" ";
        }
        cout<<endl;
    }
     */

    return 0;
}
