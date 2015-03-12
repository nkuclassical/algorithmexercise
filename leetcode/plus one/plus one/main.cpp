//
//  main.cpp
//  plus one
//
//  Created by Yanqiao Zhan on 1/12/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <vector>
using namespace std;
int main(int argc, const char * argv[]) {
    vector<int>a;
    a.push_back(1);
    a.push_back(2);
    a.push_back(3);
    a.insert(a.begin(), 4);
    a[3]=5;
    for(int i=0;i<a.size();i++)
        cout<<a[i]<<" ";
    cout<<endl;
    return 0;
}
