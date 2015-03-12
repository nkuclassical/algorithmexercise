//
//  main.cpp
//  triangle
//
//  Created by Yanqiao Zhan on 1/9/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    int minimumTotal(vector<vector<int> > &triangle) {
        if(triangle.size()==0)return 0;
        for(int i=1;i<triangle.size();i++)
        {
            for(int j=0;j<triangle[i].size();j++)
            {
                triangle[i][j]+=min(triangle[i-1][j-1],triangle[i-1][j]);
            }
        }
        int minvalue=INT_MAX;
        
        int index=triangle.size()-1;
  //      cout<<index<<"!!"<<endl;
        for(int i=0;i<triangle[triangle.size()-1].size();i++)
        {
//            cout<<triangle[index][i]<<endl;
            if(triangle[index][i]<minvalue)minvalue=triangle[index][i];
        }
        return minvalue;
    }
};
int main(int argc, const char * argv[]) {
    vector<vector<int>>s;
    vector<int>temp;
    temp.push_back(-10);
    s.push_back(temp);
    cout<<s[0][0]<<endl;
    Solution c;
    cout<<c.minimumTotal(s)<<endl;
    return 0;
}
