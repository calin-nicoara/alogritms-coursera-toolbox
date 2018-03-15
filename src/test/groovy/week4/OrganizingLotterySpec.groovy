package week4

import spock.lang.Specification
import week4.lottery.OrganizingLottery
import week4.lottery.Segment


class OrganizingLotterySpec extends Specification {

    def "Get numbers of segments that contain the points"() {
        when:
        def result = OrganizingLottery.calculateNumberOfSegmentContainingThePoints(points, segmentList)

        then:
        result == numberContainingSegments

        where:
        points | segmentList  || numberContainingSegments
        []     | []           || []
        []     | [0, 1]       || []
        [1]    | [aSegment()] || [1]
    }

    static aSegment(Map overrides = [:]) {
        def values = [leftPoint: 0, rightPoint: 1]
        values << overrides
        Segment.newInstance(values)
    }
}