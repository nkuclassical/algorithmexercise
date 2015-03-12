//
//  main.cpp
//  majority element
//
//  Created by Yanqiao Zhan on 1/7/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
class Solution {
public:
    int majorityElement(vector<int> &num) {
        sort(num.begin(),num.end());
        return num[num.size()/2];
    }
};
int main(int argc, const char * argv[]) {
    vector<int>a;
    a.push_back(2);
        a.push_back(1);
        a.push_back(2);
        a.push_back(2);
        a.push_back(0);
        a.push_back(3);
    Solution s;
    cout<<s.majorityElement(a)<<endl;
    return 0;
}
