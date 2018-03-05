package week4

import spock.lang.Specification
import spock.lang.Unroll


class NumberInversionsSpec extends Specification {

    @Unroll
    def "Number of inversion"() {

        when:
        def result = NumberInversions.numberOfInversions(numbers)

        then:
        result == numberInversions

        where:
        numbers         || numberInversions
        [2, 1]          || 1
        [2, 1, 3, 2, 1] || 5
        [2, 3, 9, 2, 9] || 2
    }
}