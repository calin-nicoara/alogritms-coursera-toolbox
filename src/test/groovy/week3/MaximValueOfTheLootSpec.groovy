package week3

import spock.lang.Specification
import spock.lang.Unroll
import week3.loot.Loot
import week3.loot.MaximValueOfTheLoot


class MaximValueOfTheLootSpec extends Specification {

    @Unroll
    "Maximum value of loot"() {
        when:
        def result = MaximValueOfTheLoot.maximumValue(sackCapacity, valueWeightMap)

        then:
        result == maximumValueExpected

        where:
        sackCapacity | valueWeightMap                                                                   || maximumValueExpected
        0            | []                                                                               || 0.0000
        10           | [aLoot(totalValue: 20, totalWeight: 10)]                                         || 20.0000
        20           | [aLoot(totalValue: 20, totalWeight: 10), aLoot(totalValue: 30, totalWeight: 10)] || 50.0000
        15           | [aLoot(totalValue: 20, totalWeight: 10), aLoot(totalValue: 30, totalWeight: 10)] || 40.0000
        50           | threeLootItems()                                                                 || 180.0000
        10           | [aLoot(totalValue: 500, totalWeight: 30)]                                        || 166.6667
    }

    def aLoot(overrides = [:]) {
        def values = [totalValue: 10, totalWeight: 10]
        values << overrides
        Loot.newInstance(values)
    }

    def threeLootItems() {
        [aLoot(totalValue: 60, totalWeight: 20), aLoot(totalValue: 100, totalWeight: 50), aLoot(totalValue: 120, totalWeight: 30)]
    }
}