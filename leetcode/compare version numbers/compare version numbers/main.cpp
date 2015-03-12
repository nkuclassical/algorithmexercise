//
//  main.cpp
//  compare version numbers
//
//  Created by Yanqiao Zhan on 1/9/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <string>
#include <algorithm>
using namespace std;
class Solution {
public:
    int stringtoint(string s)
    {
        int n=0;
        for(int i=0;i<s.size();i++)
        {
            n*=10;
            n+=s[i]-'0';
        }
//        cout<<n<<endl;
        return n;
    }
    int compareVersion(string version1, string version2) {
        int i1=0,i2=0;
        string temp1,temp2;
        while(version1.find('.')<version1.size()||version2.find('.')<version2.size())
        {
            cout<<version1<<" "<<version2<<" version"<<endl;
            temp1=version1.substr(0,min(version1.find('.'),version1.size()));
            temp2=version2.substr(0,min(version2.find('.'),version2.size()));
            cout<<temp1<<" "<<temp2<<endl;
            if(stringtoint(temp1)==stringtoint(temp2))
            {
                if(temp1=="")return 0;
                i1=static_cast<int>(min(version1.size()-1,version1.find('.')));
                i2=static_cast<int>(min(version2.size()-1,version2.find('.')));
                i1++;
                i2++;
                version1=version1.substr(i1);
                version2=version2.substr(i2);
            }
            else
            {
                if(stringtoint(temp1)>stringtoint(temp2))return 1;
                else if(stringtoint(temp1)<stringtoint(temp2))return -1;
            }
        }
        cout<<version1<<" "<<version2<<endl;
        if(stringtoint(version1)>stringtoint(version2))return 1;
        else if(stringtoint(version1)==stringtoint(version2))return 0;
        else return -1;
        
    }
};
int main(int argc, const char * argv[]) {
    string a="010.1.1";
    string b="10.1.1";
   // a=a.substr(a.find('.')+1);
   // cout<<a.find('.')+1<<endl;
//    cout<<a.substr(min(a.size(),a.find('.')+1))<<endl;
//    cout<<a.substr(a.size())<<endl;
   // cout<<(a.substr(0,a.find('.')-1)==b.substr(0,b.find('.')-1))<<endl;
    Solution s;
    cout<<s.compareVersion(a, b)<<endl;
    
    return 0;
}
