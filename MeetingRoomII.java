/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class IntervalComparator implements Comparator<Interval>
{
    public int compare(Interval a, Interval b)
    {
        return Integer.compare(a.start, b.start);
    }
}

public class MeetingRoomII {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length==0) return 0;

        Arrays.sort(intervals, new IntervalComparator());

        ArrayList<Interval> list = new ArrayList<Interval>();   //list if for overlapped time slots
        list.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            boolean notOverlap=false;

            for(int j=0;j<list.size();j++){
                Interval currentRange = list.get(j);
                //System.out.println(currentRange.start+","+currentRange.end);
                //System.out.println("intervals[i] is : "+intervals[i].start+","+intervals[i].end);
                if(intervals[i].start >= currentRange.end){//||(intervals[i].end <= range.start)){   //no overlap
                    currentRange.end=intervals[i].end;
                    list.set(j,currentRange);
                    notOverlap=true;
                    break;
                }
            }
            if(!notOverlap){
                list.add(intervals[i]);
            }
        }
        return list.size();
    }
}