package arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.size() == 0)
			return intervals;
		Interval[] intervalArray = intervals.toArray(new Interval[intervals
				.size()]);
		Arrays.sort(intervalArray, new Comparator<Interval>() {
			public int compare(Interval interval1, Interval interval2) {
				return interval1.start - interval2.start;
			}
		});
		ArrayList<Interval> ret = new ArrayList();
		Interval mover = intervalArray[0];
		for (int i = 1; i < intervals.size(); i++) {
			if (mover.end < intervalArray[i].start) {
				ret.add(mover);
				mover = intervalArray[i];
			} else {
				mover.end = Math.max(mover.end, intervalArray[i].end);
			}
		}

		intervals.sort(new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start - o2.start;

			}

		});
		ret.add(mover);
		return ret;
	}

	public List<Interval> merge2(List<Interval> intervals) {
		List<Interval> ret = new ArrayList();
		if (intervals.size() == 0)
			return ret;
		intervals.sort(new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start - o2.start;
			}
		});

		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		for (int i = 1; i < intervals.size(); i++) {
			if (end >= intervals.get(i).start) {
				end = Math.max(end, intervals.get(i).end);
			} else {
				ret.add(new Interval(start, end));
				start = intervals.get(i).start;
				end = intervals.get(i).end;
			}
		}
		ret.add(new Interval(start, end));
		return ret;
	}
}
