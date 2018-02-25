package week3

import spock.lang.Specification
import spock.lang.Unroll
import week3.points_segments.PointsCommonForSegments
import week3.points_segments.Segment

class PointsCommonForSegmentsSpec extends Specification {

    @Unroll
    "Calculate points for intersecting segments"() {
        when:
        def points = PointsCommonForSegments.listOfPoints(segments)

        then:
        points == intersectionPoints

        where:
        segments                                || intersectionPoints
        threeSegmentsWithOneIntersectionPoint() || [3]
        fourSegmentsWithTwoIntersectionPoints() || [3, 6]
    }

    def threeSegmentsWithOneIntersectionPoint() {
        [aSegment(leftPoint: 1, rightPoint: 3), aSegment(leftPoint: 2, rightPoint: 5), aSegment(leftPoint: 3, rightPoint: 6)]
    }

    def fourSegmentsWithTwoIntersectionPoints() {
        [aSegment(leftPoint: 4, rightPoint: 7), aSegment(leftPoint: 1, rightPoint: 3),
         aSegment(leftPoint: 2, rightPoint: 5), aSegment(leftPoint: 5, rightPoint: 6)]
    }

    def aSegment(overrides = [:]) {
        def values = [leftPoint: 1, rightPoint: 2]
        values << overrides
        Segment.newInstance(values)
    }
}