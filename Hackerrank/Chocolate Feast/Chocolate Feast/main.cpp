//
//  main.cpp
//  Chocolate Feast
//
//  Created by Yanqiao Zhan on 11/30/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
using namespace std;

int main(int argc, const char * argv[]) {
    int T,N,C,M;
    cin>>T;
    for(int i=0;i<T;i++)
    {
        cin>>N>>C>>M;
        int have=N/C;
        int sum=have;
        
        while(have>=M)
        {
            sum+=have/M;
            have=have%M+have/M;
        }
            cout<<sum<<endl;
    }
    return 0;
}
