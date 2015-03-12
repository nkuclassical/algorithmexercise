//
//  main.cpp
//  maximizing xor
//
//  Created by Yanqiao Zhan on 11/29/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
using namespace std;
int maxXor(int l, int r) {
    int sum=0;
    for(int i=l;i<=r;i++)
    {
        for(int j=i;j<=r;j++)
        {
            if((i^j)>sum)sum=(i^j);
        }
        
    }
    return sum;
    
}

int main() {
    int res;
    int _l;
    cin >> _l;
    
    int _r;
    cin >> _r;
    
    res = maxXor(_l, _r);
    cout << res;
    
    return 0;
}
