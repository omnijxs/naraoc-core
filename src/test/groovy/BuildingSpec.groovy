import resources.popHub.Building
import spock.lang.Specification

/**
 * Created by jxs on 7.8.2016.
 */
class BuildingSpec extends Specification {

    def "Test for getTotalValue-method."(){
        setup:
        Building a = new Building(build: 10)
        Building b = new Building(ancestor: a, build: 30)
        Building c = new Building(ancestor: b, build: 20)

        when:
        Integer valueA = a.getTotalValue()
        Integer valueB = b.getTotalValue()
        Integer valueC = c.getTotalValue()

        then:
        valueA == 10
        valueB == 10 + 30
        valueC == 10 + 30 + 20
    }

    // TODO tests for resolveBuilt!!!
}
