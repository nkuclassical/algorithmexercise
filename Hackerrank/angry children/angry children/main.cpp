//
//  main.cpp
//  angry children
//
//  Created by Yanqiao Zhan on 11/30/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int main(int argc, const char * argv[]) {
    int N,K,unfairness=INT32_MAX;
    int tem;
    cin>>N>>K;
    vector<int>c;
    for(int i=0;i<N;i++)
    {
        cin>>tem;
        c.push_back(tem);
    }
    sort(c.begin(),c.end());//can't sort array, since sort function need how to traverse from the first element to the last element.
    for(int i=0;i<N-K;i++)
    {
        if(c[i+K-1]-c[i]<unfairness)
        {
            unfairness=c[i+K-1]-c[i];
        }
    }
    cout<<unfairness<<endl;
    return 0;
}
