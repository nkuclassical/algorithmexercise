//
//  main.cpp
//  line
//
//  Created by Yanqiao Zhan on 12/6/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <cmath>
using namespace std;
bool in(double x1,double x2,double y1,double y2,double rx,double ry)
{
    double l1=sqrt(pow(x1-rx,2)+pow(y1-ry,2));
    double l2=sqrt(pow(x2-rx,2)+pow(y2-ry,2));
    double l3=sqrt(pow(x1-x2,2)+pow(y1-y2,2));
    if(abs(l1+l2-l3)<0.001)return true;
    else return false;
}
int main(int argc, const char * argv[]) {
    int x1,y1,x2,y2,r;
    cin>>r>>x1>>y1>>x2>>y2;
    double a=(y1-y2);
    double b=(-x1+x2);
    double c=-x1*(y1-y2)+y1*(x1-x2);
    double d=abs(c)/sqrt((pow(a,2)+pow(b,2)));
    double rx=-a*c/(pow(a,2)+pow(b,2));
    double ry=-b*c/(pow(a,2)+pow(b,2));
    double d1=sqrt(pow(x1, 2)+pow(y1,2));
    double d2=sqrt(pow(x2, 2)+pow(y2,2));
    if(in(x1,x2,y1,y2,rx,ry)&&d<r&&d1>r&&d2>r){cout<<"2"<<endl;}
    else if(d<r&&d1<r&&d2>r)cout<<"1"<<endl;
    else if(d<r&&d1>r&&d2<r)cout<<"1"<<endl;
    else cout<<"0"<<endl;
    return 0;
}
