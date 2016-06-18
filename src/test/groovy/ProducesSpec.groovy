import game.GameData
import resources.common.Race
import resources.common.Tile
import spock.lang.Shared
import spock.lang.Specification
import traits.Produces


/**
 * Created by jxs on 27.5.2016.
 */
class ProducesSpec extends Specification implements Produces {

    @Shared
    GameData gameData

    @Shared
    Tile tile

    @Shared
    Race race

    void setup() {
        gameData = new GameData()
        race = new Race()
        tile = new Tile()
    }

    def "Test produces-method. No production."(){

        when:
        productAmount = 2

        then:
        harvestAmount == 0
    }

    def "Test produces-method. Production. "(){
        setup:
        productAmount = 2

        when:
        produces(race, tile)

        then:
        harvestAmount == 2
    }

    def "Test harvest-method. "(){
        setup:
        harvestAmount = 2

        when:
        def harvest = harvests()

        then:
        harvest == 2
        harvestAmount == 0
    }

}