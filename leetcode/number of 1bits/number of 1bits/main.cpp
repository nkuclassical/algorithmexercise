//
//  main.cpp
//  number of 1bits
//
//  Created by Yanqiao Zhan on 4/14/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
using namespace std;
class Solution {
public:
    int hammingWeight(uint32_t n) {
        int count=0;
        for(int i=0;i<32;i++)
        {
            
            if(n>=(1<<(31-i)))
            {
                cout<<(1<<(31-i))<<" "<<i<<endl;
                count++;
                n-=(1<<(31-i));
                cout<<n<<endl;
            }
            
        }
        
        return count;
    }
};
int main(int argc, const char * argv[]) {
    Solution s;
    cout<<s.hammingWeight(8)<<endl;

    return 0;
}
