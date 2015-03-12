//
//  main.cpp
//  Sherlock and Squares
//
//  Created by Yanqiao Zhan on 11/30/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <cmath>
using namespace std;

int main(int argc, const char * argv[]) {
    size_t T,A,B;
    cin>>T;
    for(int i=0;i<T;i++)
    {
        cin>>A>>B;
        int sb=static_cast<int>(sqrt(B));
        double sa=sqrt(A);
        cout<<static_cast<int>(sb-sa+1)<<endl;
    }
    return 0;
}
