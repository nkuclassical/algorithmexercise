package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms {
	public boolean canAttendMeetings(Interval[] intervals) {
		Arrays.sort(intervals, new IntervalsComparator());
		for(int i=1;i<intervals.length;i++){
			if(intervals[i].start<intervals[i-1].end)return false;
		}
		return true;
	}
	
	class IntervalsComparator implements Comparator<Interval>{

		@Override
		public int compare(Interval o1, Interval o2) {
			// TODO Auto-generated method stub
//			if(o1.start<o2.start)return -1;
//			else if(o1.start==o2.start)return 0;
//			else return 1;
			return Integer.compare(o1.start, o2.start);
		}
		
	}
	
	public static void main(String[]args){
		MeetingRooms test=new MeetingRooms();
		Interval[]intervals=new Interval[2];
		intervals[0]=new Interval();
		intervals[1]=new Interval();
		intervals[0].start=7;
		intervals[0].end=10;
		intervals[1].start=2;
		intervals[1].end=4;
		System.out.println(test.canAttendMeetings(intervals));
		List<Integer>list=new ArrayList();
		list.sor
		
	}
}
