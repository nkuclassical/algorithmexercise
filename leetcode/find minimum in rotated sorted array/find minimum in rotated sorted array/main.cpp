//
//  main.cpp
//  find minimum in rotated sorted array
//
//  Created by Yanqiao Zhan on 1/7/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    int findMin(vector<int> &num) {
        if(num.size()==0)return 0;
        int min=num[0];
        for(int i=0;i<num.size();i++)
            if(min>num[i])
                min=num[i];
        return min;
        
    }
};
int main(int argc, const char * argv[]) {
    // insert code here...
    std::cout << "Hello, World!\n";
    return 0;
}
