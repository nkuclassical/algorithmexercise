//
//  main.cpp
//  The love letter mystery
//
//  Created by Yanqiao Zhan on 11/30/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <string>
#include <algorithm>
using namespace std;
int task(string input)
{
    size_t head=0,end=input.length()-1;
    int sum=0;
    while(head<end)
    {
        sum+=abs(input[head]-input[end]);
        head++;
        end--;
    }
    return sum;
}
int main(int argc, const char * argv[]) {
    int T;
    string input;
    cin>>T;
    for(int i=0;i<T;i++)
    {
        cin>>input;
        cout<<task(input)<<endl;
    }
    return 0;
}
