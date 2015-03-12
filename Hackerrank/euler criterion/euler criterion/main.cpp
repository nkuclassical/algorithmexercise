//
//  main.cpp
//  merge-list
//
//  Created by Yanqiao Zhan on 12/13/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <cmath>
using namespace std;
bool judge(long a,long m)
 {
 if(m==2)return true;
 else{
 long tem=a;
 for(long i=1;i<(m-1)/2;i++)
 {
 tem*=a;
 tem%=m;
 }
 if(tem==1)return true;
 else return false;
 }
 }
 int main(int argc, const char * argv[]) {
 int t,m,a;
 cin>>t;
 for(int i=0;i<t;i++)
 {
 cin>>a>>m;
 if(judge(a,m))cout<<"YES"<<endl;
 else cout<<"NO"<<endl;
 }
 return 0;
}
 
 
 
 
 
 
