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
        for(int i=0;i<intervals.size();i++)
        {
           if(intervals[i].start>=newInterval.end)
           {
               if(i>0&&newInterval.start==intervals[i-1].end)
               {

                    intervals[i-1].end=newInterval.end;

               }
               else intervals.insert(intervals.begin()+i, newInterval);
                newInterval.start=newInterval.end;
               break;
           }
            else if(intervals[i].start>=newInterval.start&&intervals[i].start<newInterval.end&&intervals[i].end>newInterval.end)
            {
                intervals[i].start=newInterval.start;
                if(i>0)
                {
                    if(intervals[i-1].end==intervals[i].start)
                    {
                        intervals[i-1].end=intervals[i].end;
                        intervals[i].start=intervals[i].end;
                    }
                }
                newInterval.start=newInterval.end;
                break;
            }
            else if(intervals[i].start>newInterval.start&&intervals[i].end<newInterval.end)
            {
                intervals[i].start=newInterval.start;
                if(i>0)
                {
                    if(intervals[i-1].end==intervals[i].start)
                    {
                        intervals[i-1].end=intervals[i].end;
                        intervals[i].start=intervals[i].end;
                    }
                }
                newInterval.start=intervals[i].end;
            }
            else if(intervals[i].start<newInterval.start&&intervals[i].end>newInterval.end)
            {
                newInterval.start=newInterval.end;
                break;
            }
            else if(intervals[i].start<newInterval.start&&intervals[i].end>newInterval.start&&intervals[i].end<newInterval.end)
            {
                newInterval.start=intervals[i].end;
            }
        }
        if(newInterval.start!=newInterval.end)
            intervals.push_back(newInterval);
        for(int i=0;i<intervals.size();i++)
        {
            if(result.size()>0&&intervals[i].start==result[result.size()-1].end)
            {
                
                Interval temp=result[result.size()-1];
                result.pop_back();
                temp.end=intervals[i].end;
                result.push_back(temp);
            }
            else if(intervals[i].start!=intervals[i].end)
            {
                result.push_back(intervals[i]);
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
