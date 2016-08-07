import resources.popHub.Building
import spock.lang.Specification
import resources.common.Product
import resources.common.Race

/**
 * Created by jxs on 7.8.2016.
 */
class BuildingSpec extends Specification {

        
    Building a
    Building b
    Building c
    Building d
    Building e

    Race orc

    def setup(){

        orc = new Race()

        a = new Building(race: orc, product: Product.TRADE, build: 10)
        b = new Building(race: orc, product: Product.TRADE, ancestor: a, build: 20)
        c = new Building(race: orc, product: Product.TRADE, ancestor: b, build: 30)
        d = new Building(race: orc, product: Product.TRADE, ancestor: c, build: 40)
        e = new Building(race: orc, product: Product.TRADE, ancestor: d, build: 50)
    }

    def "Test for getTotalValue-method."(){
        setup:

        when:
        Integer valueA = a.getTotalValue()
        Integer valueB = b.getTotalValue()
        Integer valueC = c.getTotalValue()
        Integer valueD = d.getTotalValue()
        Integer valueE = e.getTotalValue()

        then:
        valueA == 10
        valueB == 10 + 20
        valueC == 10 + 20 + 30
        valueD == 10 + 20 + 30 + 40
        valueE == 10 + 20 + 30 + 40 + 50
    }

    def "Test for resolveBuilt-method. Building a."(){
        setup:

        when:
        def built = a.resolveBuilt(10, 10)

        then:
        built
    }
    
}
