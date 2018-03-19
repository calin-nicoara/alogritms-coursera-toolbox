package week4.lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class OrganizingLottery {

    public static List<Integer> calculateNumberOfSegmentContainingThePoints(
            final List<Integer> points, final List<Segment> segmentList) {


        return Collections.emptyList();
    }

    public static List<Integer> calculateNumberOfSegmentContainingThePointsInefficent(
            final List<Integer> points, final List<Segment> segmentList) {
        List<Integer> intersectionList = new ArrayList<>();
        for(int pointIndex = 0; pointIndex < points.size(); pointIndex++) {
            final int numberIntersections = getNumberIntersections(points, segmentList, pointIndex);
            intersectionList.add(numberIntersections);
        }

        return intersectionList;
    }

    private static int getNumberIntersections(final List<Integer> points, final List<Segment> segmentList, final int pointIndex) {
        AtomicInteger intersections = new AtomicInteger(0);
        for(int segmentIndex = 0; segmentIndex < segmentList.size(); segmentIndex++) {
            final Segment segment = segmentList.get(segmentIndex);
            if(segment.leftPoint <= points.get(pointIndex)
                    && segment.rightPoint >= points.get(pointIndex)) {
                intersections.incrementAndGet();
            }
        }

        return intersections.get();
    }
}
