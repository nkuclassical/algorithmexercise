//
//  main.cpp
//  sqrt
//
//  Created by Yanqiao Zhan on 1/10/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <math.h>
using namespace std;
class Solution {
public:
    int sqrt(int x) {
        if(x==0)return 0;
        test(x,2);
    }
    double test(double x,double g)
    {
        if(close(x,g))
            return g;
        else
            return test(x,(g+x/g)/2);
    }
    bool close(double a,double b)
    {
        return abs(b*b-a)<0.001;
    }
    
};
int main(int argc, const char * argv[]) {
    // insert code here...
    std::cout << "Hello, World!\n";
    return 0;
}
