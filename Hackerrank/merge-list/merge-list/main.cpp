//
//  main.cpp
//  merge-list
//
//  Created by Yanqiao Zhan on 12/13/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <cmath>
#include <map>
using namespace std;
map<pair<int, int>,long>M;
long solution(int n,int m)
{
    if(n>m)
    {
        n^=m;
        m^=n;
        n^=m;
    }

    if(n==0)
    {
        
        return 1;
    }
    else if(m==0)
    {
        return 1;
    }
    else
    {
        pair<int, int>tem(n,m);
        if(M.find(tem)!=M.end())return M[tem];
        else{
            M[pair<int, int>(n,m)]=(solution(n-1,m)+solution(n,m-1))%(1000000000+7);
            return M[pair<int, int>(n,m)];
        }
    }
}
int main()
{
    int t,n,m;
    cin>>t;
    for(int i=0;i<t;i++)
    {
        cin>>n>>m;
        cout<<solution(n,m)<<endl;
    }
}