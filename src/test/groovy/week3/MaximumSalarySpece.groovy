package week3

import spock.lang.Specification
import spock.lang.Unroll


class MaximumSalarySpece extends Specification {

    @Unroll
    "Calculate maximum salary from numbers"() {
        when:
        def result = MaximumSalary.calculateMaximumSalary(numbers)

        then:
        result == maxSalary

        where:
        numbers         || maxSalary
        [21, 2]         || "221"
        [9, 4, 6, 1, 9] || "99641"
        [23, 39, 92]    || "923923"
        [9399, 93,]     || "939993"
    }

}