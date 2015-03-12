//
//  main.cpp
//  insert interval
//
//  Created by Yanqiao Zhan on 1/7/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <vector>
using namespace std;
struct Interval {
    int start;
    int end;
    Interval() : start(0), end(0) {}
    Interval(int s, int e) : start(s), end(e) {}
};

class Solution {
public:
    vector<Interval> insert(vector<Interval> &intervals, Interval newInterval) {
        vector<Interval>result;
        result.push_back(newInterval);
        for(int i=0;i<intervals.size();i++)
        {
            Interval newInt=result.back();
            result.pop_back();
            Interval*cur=&intervals[i];
            if(cur->end<newInt.start)
            {
                result.push_back(*cur);
                result.push_back(newInt);
            }
            else if(cur->start>newInt.end)
            {
                result.push_back(newInt);
                result.push_back(*cur);
            }
            else
            {
                newInt.start=min(cur->start,newInt.start);
                newInt.end=max(cur->end,newInt.end);
                result.push_back(newInt);
            }
        }
        return result;
    }
};
int main(int argc, const char * argv[]) {
    vector<Interval>t;
    t.push_back(Interval(1,2));
    t.push_back(Interval(3,5));
    Solution s;
    t=s.insert(t, Interval(4, 9));
    
    for(int i=0;i<t.size();i++)
    {
        cout<<t[i].start<<" "<<t[i].end<<endl;
    }
    return 0;
}
