import spock.lang.Specification
import spock.lang.Unroll
import traits.Consumes


/**
 * Created by jxs on 26.5.2016.
 */
class ConsumesSpec extends Specification implements Consumes {

    @Unroll
    def "Test consumes-method surplus behaviour."(){

        when:
        def surplus = consumes(value)

        then:
        surplus == expected

        where:
        value     | expected
        null      | 0
        0         | 0
        1         | 0
        2         | 1
        3         | 2
    }

    @Unroll
    def "Test consumes-method starving behaviour."(){

        when:
        def surplus = consumes(value)
        def starvation = this.starving

        then:
        starvation == expected

        where:
        value     | expected
        null      | true
        0         | true
        1         | false
        2         | false
        3         | false
    }

    @Unroll
    def "Test that consumes-method works as stateless."(){

        when:
        def surplus_a = consumes(0)
        def surplus_b = consumes(1)
        def surplus_c = consumes(2)
        def surplus_d = consumes(2)
        def surplus_e = consumes(3)

        then:
        surplus_a == 0
        surplus_b == 0
        surplus_c == 1
        surplus_d == 1
        surplus_e == 2
    }
}