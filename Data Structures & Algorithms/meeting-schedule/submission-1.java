/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */


// cant assume that input is sorted.
// naive uses 2 pointers, one start and one end, always comparing the end time with start-time (not its original start.-pair)
// initial sol'n:
// 1. Sort intervals based on start times.
// 2. Check the end and start times of curr with next.

// OR insert the pair into a map, key the start time, and the value becomes the 
class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        // sort:
        intervals.sort((s1, s2) -> s1.start - s2.start);

        // check
        for(int i = 0; i < intervals.size() - 1; i ++) {
            if (intervals.get(i).end > intervals.get(i + 1).start) {
                return false;
            }
        }
        return true;
    }
}
