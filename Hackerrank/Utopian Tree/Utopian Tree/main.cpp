//
//  main.cpp
//  Utopian Tree
//
//  Created by Yanqiao Zhan on 11/29/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
using namespace std;
int height(int n)
{
    int height=1;
    for(int i=1;i<=n;i++)
    {
        if(i%2==0)
        {
            height+=1;
        }
        else
        {
            height*=2;
        }
    }
    return height;
}
int main(int argc, const char * argv[]) {

    int T;
    cin >> T;
    while (T--) {
        int n;
        cin >> n;
        cout << height(n) << endl;
    }
    return 0;
}
