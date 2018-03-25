package week4.lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

public class OrganizingLottery {

    public static Map<Integer, Integer> calculateNumberOfSegmentContainingThePoints(
            final List<Integer> initialPoints, final List<Segment> segmentList) {

        if(initialPoints.isEmpty()) {
            return Collections.emptyMap();
        }

        Set<Point> pointsSorted = new TreeSet<>();

        initialPoints.forEach(i -> pointsSorted.add(new Point(i, Point.Type.INITIAL)));
        segmentList.forEach(segment -> {
            pointsSorted.add(new Point(segment.leftPoint, Point.Type.LEFT));
            pointsSorted.add(new Point(segment.rightPoint, Point.Type.RIGHT));
        });


        Map<Integer, Integer> pointIntersections = new HashMap<>();
        AtomicInteger segmentsOpened = new AtomicInteger();

        pointsSorted.forEach(point -> {
            if(point.type.equals(Point.Type.LEFT)) {
                segmentsOpened.incrementAndGet();
            } else if(point.type.equals(Point.Type.RIGHT)) {
                segmentsOpened.decrementAndGet();
            } else {
                pointIntersections.put(point.value, segmentsOpened.get());
            }
        });

        return pointIntersections;
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
