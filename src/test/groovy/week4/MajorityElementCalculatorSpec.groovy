package week4

import spock.lang.Specification
import spock.lang.Unroll

class MajorityElementCalculatorSpec extends Specification {

    @Unroll
    def "Get majority element from list of numbers"() {
        when:
        def result = MajorityElementCalculator.calculateMajorityElement(numbers)

        then:
        result == majorityElement

        where:
        numbers               || majorityElement
        []                    || -1
        [1, 2, 3, 4]          || -1
        [1, 2, 4, 4]          || -1
        [2, 1, 2]             || 2
        [3, 3, 7, 8, 9, 3, 3] || 3
    }
}