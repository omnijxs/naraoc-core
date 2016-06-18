import resources.common.Tile
import resources.popHub.City
import resources.popHub.PopHubDemand
import resources.popUnit.PopUnit
import spock.lang.Shared
import spock.lang.Specification
import traits.Prefers


/**
 * Created by jxs on 26.5.2016.
 */
class DemandSpec extends Specification {

    @Shared
    protected City city

    @Shared
    protected Tile cityTile

    private class MockUnit extends PopUnit implements Prefers {
        Tile tile
    }

    void setup(){
        cityTile = new Tile()
        city = new City(tile: cityTile)
    }

    def "No popUnit. No demand."(){

        when:
        PopHubDemand demand = city.setDemands(null, city)

        then:
        demand.foodDemand == 0
        demand.workDemand == 0
        demand.tradeDemand == 0
    }

    def "PopUnits in city proper."(){
        setup:
        PopUnit a = new MockUnit(tile: cityTile, preferredHub: null)

        when:
        PopHubDemand demand = city.setDemands([a], city)

        then:
        demand.foodDemand == 1
        demand.workDemand == 1
        demand.tradeDemand == 1
    }

    def "PopUnits outside city proper but prefers."() {
        setup:
        PopUnit a = new MockUnit(tile: null, preferredHub: city)

        when:
        PopHubDemand demand = city.setDemands([a], city)

        then:
        demand.foodDemand == 1
        demand.workDemand == 1
        demand.tradeDemand == 1
    }

    def "PopUnits in and outside city proper."() {
        setup:
        PopUnit a = new MockUnit(tile: null, preferredHub: city)
        PopUnit b = new MockUnit(tile: cityTile, preferredHub: null)

        when:
        PopHubDemand demand = city.setDemands([a, b], city)

        then:
        demand.foodDemand == 2
        demand.workDemand == 2
        demand.tradeDemand == 2
    }

    def "PopUnits outside city proper. No demand."() {
        setup:
        PopUnit a = new MockUnit(tile: new Tile(), preferredHub: new City())

        when:
        PopHubDemand demand = city.setDemands([a], city)

        then:
        demand.foodDemand == 0
        demand.workDemand == 0
        demand.tradeDemand == 0
    }
}