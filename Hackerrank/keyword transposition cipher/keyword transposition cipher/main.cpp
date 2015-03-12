//
//  main.cpp
//  keyword transposition cipher
//
//  Created by Yanqiao Zhan on 12/16/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <string>
#include <map>
#include <vector>
using namespace std;
string alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
map<char, int> substiution(string subkeyword)
{
    bool visit[26];
    for(int i=0;i<26;i++)
        visit[i]=false;
    string keyword;
    for(int i=0;i<subkeyword.length();i++)
    {
        if(visit[subkeyword[i]-'A']==false)
        {
            keyword+=subkeyword[i];
            visit[subkeyword[i]-'A']=true;
        }
    }
    map<char, int> result;
    int width=keyword.size();
    vector<vector<char>>v(width,vector<char>());

    
    for(int i=0;i<keyword.length();i++)
    {
        v[i].push_back(keyword[i]);
        visit[static_cast<int>(keyword[i]-'A')]=true;
    }

    int j=0;
    for(int i=0;i<26;i++)
    {
        if(visit[i]==false)
        {
            v[j%keyword.length()].push_back(char('A'+i));
            j++;
        }
    }
    for(int i=0;i<width;i++)
    {
        for(int j=i+1;j<width;j++)
        {
            if(v[j][0]<v[i][0])
            {
                vector<char> tem=v[j];
                v[j]=v[i];
                v[i]=tem;
            }
        }
    }
    int index=0;
    for(int i=0;i<width;i++)
    {
        for(int j=0;j<v[i].size();j++)
        {
            result[v[i][j]]=index;
            index++;
        }
    }
    return result;
}
int main(int argc, const char * argv[]) {
    int n;
    cin>>n;
    for(int p=0;p<n;p++){
        string keyword;

        getline(cin,keyword);
        cin.ignore();
        map<char,int> m=substiution(keyword);
        string ciphertext;
        getline(cin,ciphertext);
        for(int i=0;i<ciphertext.length();i++)
        {
            if(ciphertext[i]!=' ')
            {
                cout<<alpha[m[ciphertext[i]]];
            }
            else
                cout<<" ";
        }
        cout<<endl;
    }
    return 0;
}
