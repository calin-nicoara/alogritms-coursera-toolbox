package week3.points_segments;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PointsCommonForSegments {

    public static List<Integer> listOfPoints(List<Segment> segments) {
        segments.sort(Comparator.comparing(Segment::getRightPoint));

        List<Integer> points = new ArrayList<>();
        Integer lastPoint = null;

        for(Segment segment: segments) {
            if(lastPoint == null || !segment.containsPoint(lastPoint)) {
                points.add(segment.getRightPoint());
                lastPoint = segment.getRightPoint();
            }
        }

        return points;
    }
}
