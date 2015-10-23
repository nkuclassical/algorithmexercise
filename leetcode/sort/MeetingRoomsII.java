package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MeetingRoomsII {
	public int minMeetingRooms(Interval[] intervals) {
		Arrays.sort(intervals, new IntervalComparator());
		List<Integer> ret = new ArrayList();
		for (int i = 0; i < intervals.length; i++) {
			boolean finished = false;
			for (int j = 0; j < ret.size(); j++) {
				if (ret.get(j) <= intervals[i].start) {
					ret.set(j, intervals[i].end);
					finished = true;
					break;
				}
			}
			if (finished == false) {
				ret.add(intervals[i].end);
			}
		}
		return ret.size();
	}

	class IntervalComparator implements Comparator<Interval> {
		public int compare(Interval o1, Interval o2) {
			return Integer.compare(o1.start, o2.start);
		}
	}

	public static void main(String[] args) {
		Interval[] newinterval = new Interval[6];
		newinterval[0] = new Interval();
		newinterval[1] = new Interval();
		newinterval[2] = new Interval();
		newinterval[3] = new Interval();
		newinterval[4] = new Interval();
		newinterval[5] = new Interval();
		newinterval[0].start = 1293;
		newinterval[0].end = 2986;
		newinterval[1].start = 848;
		newinterval[1].end = 3846;
		newinterval[2].start = 4284;
		newinterval[2].end = 5907;
		newinterval[3].start = 4466;
		newinterval[3].end = 4781;
		newinterval[4].start = 518;
		newinterval[4].end = 2918;
		newinterval[5].start = 300;
		newinterval[5].end = 5870;
		MeetingRoomsII test = new MeetingRoomsII();
		System.out.println(test.minMeetingRooms(newinterval));
	}
}
