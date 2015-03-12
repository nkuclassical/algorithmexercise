//
//  main.cpp
//  factorial trailing zeroes
//
//  Created by Yanqiao Zhan on 1/10/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <math.h>
class Solution {
public:
    int trailingZeroes(int n) {
        int sum=0;
        int ex=log(n)/log(5);
        
        /*while(n/5>0)
         {
         sum+=n/5;
         n=n/5;
         }*/
        
        return n/5*(pow(5,ex)-1)/4;
    }
};
int main(int argc, const char * argv[]) {
    // insert code here...
    std::cout << "Hello, World!\n";
    return 0;
}
