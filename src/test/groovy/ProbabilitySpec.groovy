import spock.lang.Specification
import spock.lang.Unroll
import traits.Probability


/**
 * Created by jxs on 16.6.2016.
 */
class ProbabilitySpec extends Specification implements Probability {

    @Unroll
    def "Test getComparison-method"(){

        when:
        def hit = getComparison(a, b)

        then:
        hit == expected

        where:
        a   | b  | expected
        29  | 30 | false
        30  | 30 | true
        31  | 30 | true
    }

}