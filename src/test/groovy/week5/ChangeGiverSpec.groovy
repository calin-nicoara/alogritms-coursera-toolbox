package week5

import spock.lang.Specification
import spock.lang.Unroll


class ChangeGiverSpec extends Specification {

    @Unroll
    "Money change with dynamic programming"() {
        given:
        def changeGiver = new ChangeGiver()
        def denominations = [1, 3, 4]

        when:
        def result = changeGiver.numberOfCoins(amount, denominations)

        then:
        result == resultExpected

        where:
        amount | resultExpected
        0      | 0
        1      | 1
        2      | 2
        3      | 1
        4      | 1
        34     | 9
    }
}