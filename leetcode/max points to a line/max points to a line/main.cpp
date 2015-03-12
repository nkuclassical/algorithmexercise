//
//  main.cpp
//  max points to a line
//
//  Created by Yanqiao Zhan on 1/5/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <map>
#include <vector>
using namespace std;

struct Point {
  int x;
  int y;
  Point() : x(0), y(0) {}
  Point(int a, int b) : x(a), y(b) {}
};

class Solution {
public:
    int maxPoints(vector<Point> &points) {
        int max=0;
        for(int i=0;i<points.size();i++)
        {
            int duplicate=1;
            map<double, int> result;
            result[INT_MIN]=0;
            for(int j=0;j<points.size();j++)
            {
                if(i!=j)
                {
                    if(points[i].x==points[j].x&&points[i].y==points[j].y)duplicate++;
                    double ratio=(points[i].x==points[j].x)?INT_MAX:static_cast<double>(points[i].y-points[j].y)/(points[i].x-points[i].x);
                    if(result.find(ratio)==result.end())
                    {
                        result[ratio]=1;
                    }
                    else
                        result[ratio]++;
                }
            }
            for(map<double, int>::iterator it=result.begin();it!=result.end();it++)
            {
                if(it->second+duplicate>max)
                {
                    max=it->second+duplicate;
                }
            }
        }
        return max;
    }
};
int main(int argc, const char * argv[]) {


    return 0;
}
