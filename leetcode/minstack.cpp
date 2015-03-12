//
//  main.cpp
//  minstack
//
//  Created by Yanqiao Zhan on 11/12/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <stack>
using namespace std;
class MinStack{
    
public:
    void push(int x)
    {
        if(Min.size()==0)
            Min.push(x);
        else if(x<=Min.top())Min.push(x);
        a.push(x);
    }
    int top()
    {
        return a.top();
    }
    void pop()
    {
        if(Min.size()>0&&a.top()==Min.top())Min.pop();
        a.pop();
    }
    int getMin()
    {
        if (Min.size()>0)
            return Min.top();
        else return a.top();
    }
private:
    stack<int>a;
    stack<int>Min;
};
