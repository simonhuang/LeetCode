# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: List[Interval]
        """
        
        def cmp_intervals(itv1, itv2):
        	if itv1.start != itv2.start:
        		return itv1.start - itv2.start
        	return itv1.end - itv2.end

        intervals = sorted(intervals, cmp = cmp_intervals)

        merged = []

        for itv in intervals:
        	if not merged:
        		merged.append(itv)
        		continue

        	last_itv = merged[-1]

        	if itv.start > last_itv.end:
        		merged.append(itv)
        		continue

        	last_itv.end = max(itv.end, last_itv.end)
        return merged



