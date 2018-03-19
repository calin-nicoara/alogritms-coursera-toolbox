package week4

import spock.lang.Specification
import spock.lang.Unroll
import week4.lottery.OrganizingLottery
import week4.lottery.Segment


class OrganizingLotterySpec extends Specification {

    @Unroll
    "Get numbers of segments that contain the points"() {
        when:
        def result = OrganizingLottery.calculateNumberOfSegmentContainingThePointsInefficent(points, segmentList)

        then:
        result == numberContainingSegments

        where:
        points         | segmentList                                                                                                             || numberContainingSegments
        []             | []                                                                                                                      || []
        []             | [0, 1]                                                                                                                  || []
        [1]            | [aSegment()]                                                                                                            || [1]
        [1, 6, 11]     | [aSegment(leftPoint: 0, rightPoint: 5), aSegment(leftPoint: 7, rightPoint: 10)]                                         || [1, 0, 0]
        [-100, 100, 0] | [aSegment(leftPoint: -10, rightPoint: 10)]                                                                              || [0, 0, 1]
        [1, 6]         | [aSegment(leftPoint: 0, rightPoint: 5), aSegment(leftPoint: -3, rightPoint: 2), aSegment(leftPoint: 7, rightPoint: 10)] || [2, 0]
    }

    @Unroll
    "Get numbers of segments that contain the points efficient"() {
        when:
        def result = OrganizingLottery.calculateNumberOfSegmentContainingThePoints(points, segmentList)

        then:
        result == numberContainingSegments

        where:
        points         | segmentList                                                                                                             || numberContainingSegments
        []             | []                                                                                                                      || []
        []             | [0, 1]                                                                                                                  || []
        [1]            | [aSegment()]                                                                                                            || [1]
        [1, 6, 11]     | [aSegment(leftPoint: 0, rightPoint: 5), aSegment(leftPoint: 7, rightPoint: 10)]                                         || [1, 0, 0]
        [-100, 100, 0] | [aSegment(leftPoint: -10, rightPoint: 10)]                                                                              || [0, 0, 1]
        [1, 6]         | [aSegment(leftPoint: 0, rightPoint: 5), aSegment(leftPoint: -3, rightPoint: 2), aSegment(leftPoint: 7, rightPoint: 10)] || [2, 0]
    }

    static aSegment(Map overrides = [:]) {
        def values = [leftPoint: 0, rightPoint: 1]
        values << overrides
        Segment.newInstance(values)
    }
}