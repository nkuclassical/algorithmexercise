//
//  main.cpp
//  valid number
//
//  Created by Yanqiao Zhan on 1/7/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
using namespace std;
class Solution {
public:
    bool isNumber(const char *s) {
        int i=0;
        bool dot=false,e=false,digit=false;
        while(true)
        {
            if(s[i]>='0'&&s[i]<='9')
            {
                i++;
                digit=true;
            }
            else if(s[i]=='.')
            {
                if(dot==false)
                {
                    i++;
                    dot=true;
                }
                else return false;
            }
            else if(s[i]=='e')
            {
                if(e==false&&dot==false&&i!=0&&s[i+1]>='0'&&s[i+1]<='9')
                {
                    i++;
                    e=true;
                }
                else return false;
            }
            else if(digit==true&&s[i]=='\0')
                return true;
            else if(s[i]==' ')
                i++;
            else return false;
        }
        
        
    }
};
int main(int argc, const char * argv[]) {
    char *s=" . ";
    Solution c;
    cout<<c.isNumber(s)<<endl;
    return 0;
}
