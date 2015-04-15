//
//  main.cpp
//  Infinite Houser of Pancakes
//
//  Created by Yanqiao Zhan on 4/11/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <fstream>
#include <cmath>
using namespace std;
int main(int argc, const char * argv[]) {
    int T;
    ifstream in("/Users/yanqiaozhan/Code/algorithmexercise/2015googlecodejam/B/B-small-attempt0.in");
    ofstream out("/Users/yanqiaozhan/Code/algorithmexercise/2015googlecodejam/B/out");
    //  ifstream in("A-small-attempt3.in");
    // ofstream out("out");
    //in>>T;
    in>>T;
    for(int i=0;i<T;i++)
    {
        int D;
        in>>D;
        int m=0,temp;
        for(int j=0;j<D;j++)
        {
            in>>temp;
            if(temp>m)
                m=temp;
        }

        out<<"Case #"<<i+1<<": "<<ceil(sqrt(m)/sqrt(2))+1<<endl;


    }
    return 0;
}
