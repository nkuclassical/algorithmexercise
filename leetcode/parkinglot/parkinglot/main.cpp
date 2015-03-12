//
//  main.cpp
//  parkinglot
//
//  Created by Yanqiao Zhan on 3/5/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

int main(int argc, const char * argv[]) {
    //priority_queue<int>q;
    int a[]={4,5,123,4,6,321,1,3,9,10,21,8};
    vector<int>b;
//    sort(b);
    //sort(a);
    sort(a,a+10);
    for(int i=0;i<10;i++)
        cout<<a[i]<<" ";
    cout<<endl;
    queue<int >d;
    d.front()
    return 0;
}
