//
//  main.cpp
//  Archery
//
//  Created by Yanqiao Zhan on 12/6/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <cmath>
using namespace std;
bool in(double x1,double x2,double x3,double y1,double y2,double y3)
{
    double l1=sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    double l2=sqrt((x1-x3)*(x1-x3)+(y1-y3)*(y1-y3));
    double l3=sqrt((x3-x2)*(x3-x2)+(y3-y2)*(y3-y2));
    if(abs(l1+l2-l3)<0.001)return true;
    else return false;
}
int main(int argc, const char * argv[]) {
    long n,*r,m,sum=0;
    long *x1,*x2,*y1,*y2;
    cin>>n;
    r=new long[n];
    for(long i=0;i<n;i++)
        cin>>r[i];
    cin>>m;
    x1=new long[m];
    x2=new long[m];
    y1=new long[m];
    y2=new long[m];
    for(long i=0;i<m;i++)
    {
        cin>>x1[i]>>y1[i]>>x2[i]>>y2[i];
        double small=sqrt(x1[i]*x1[i]+y1[i]*y1[i]);
        double big=sqrt(x2[i]*x2[i]+y2[i]*y2[i]);

        long a=(y1[i]-y2[i]);
        long b=-(x1[i]-x2[i]);
        long c=-x1[i]*(y1[i]-y2[i])+y1[i]*(x1[i]-x2[i]);
        double d=abs(c)/sqrt(a*a+b*b);
        double rx=-a*c/(a*a+b*b);
        double ry=-b*c/(a*a+b*b);
        for(long j=0;j<n;j++)
        {
            
            if(d<r[j]&&small<r[j]&&big>r[j])sum+=1;
            else if(d<r[j]&&small>r[j]&&big<r[j])sum+=1;
            else if(in(x1[i],x2[i],y1[i],y2[i],rx,ry)&&d<r[j]&&small>r[j]&&big>r[j])sum+=2;
        }
        
    }
    cout<<sum<<endl;
    return 0;
}
