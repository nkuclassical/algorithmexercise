//
//  main.cpp
//  schedule
//
//  Created by Yanqiao Zhan on 12/6/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <iomanip>
using namespace std;
struct s
{
    int t;
    double p;
};
bool Sort(s s1,s s2)
{
 //   if(s1.t+s1.p*(s1.t+s2.t)<s2.t+s2.p*(s2.t+s1.t))return true;
   if(s1.t+s1.p*s2.t<s2.t+s2.p*s1.t)return true;
    else return false;
}
int main(int argc, const char * argv[]) {
    int n;
    s *sch;
    cout.setf(ios::showpoint); //设置为始终输出小数点后的数字，就是说 a = 3，它也输出 3.00000 这样
    cout.precision(9);
    cout.setf(ios::fixed);
    cin>>n;
    sch=new s[n];
    for(int i=0;i<n;i++)
    {
        cin>>sch[i].t>>sch[i].p;
    }
    for(int i=0;i<n;i++)
    {
        for(int j=i+1;j<n;j++)
        {
            if(!Sort(sch[i],sch[j]))
            {
                s tem=sch[i];
                sch[i]=sch[j];
                sch[j]=tem;
            }
        }
    }
    double sum=sch[0].t;
    for(int i=1;i<n;i++)
    {
//        cout<<sch[i].t<<endl;
        double tem=1;
        for(int j=0;j<i;j++)
        {
            tem*=sch[j].p;
        }
        sum+=tem*sch[i].t;
    }
    cout<<sum<<endl;
    return 0;
}
