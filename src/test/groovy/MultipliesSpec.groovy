import resources.popUnit.PopUnit
import spock.lang.Specification
import traits.Multiplies


/**
 * Created by jxs on 27.5.2016.
 */
class MultipliesSpec extends Specification {

    private class MockUnit extends PopUnit implements Multiplies {

    }

    def "Test breed-method."(){
        setup:
        MockUnit a = new MockUnit()

        when:
        def b = a.breed()

        then:
        b.class == MockUnit
        a != b
    }

    def "Test multiply always."(){
        setup:
        MockUnit a = new MockUnit()

        when:
        def b = a.multiplies(100)

        then:
        b.class == MockUnit
        a != b
    }

    def "Test multiply never."(){
        setup:
        MockUnit a = new MockUnit()

        when:
        def b = a.multiplies(0)

        then:
        !b
    }

}