package arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval>ret=new ArrayList();
		
		for(int i=0;i<intervals.size();i++){
			if(newInterval.end<intervals.get(i).start){
				ret.add(new Interval(newInterval.start,newInterval.end));
				newInterval = intervals.get(i);
			}else if(newInterval.start>intervals.get(i).end){
				ret.add(new Interval(intervals.get(i).start,intervals.get(i).end));
			}else{
				newInterval.start=Math.min(newInterval.start, intervals.get(i).start);
				newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
			}
		}
		ret.add(newInterval);
		return ret;
	}
}
