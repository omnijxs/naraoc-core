import game.GameData
import resources.common.Race
import resources.common.Tile
import resources.gameActor.GameActor
import resources.gameActor.Player
import resources.popHub.City
import resources.popHub.PopHub
import resources.popUnit.Farmer
import resources.popUnit.Merchant
import resources.popUnit.PopUnit
import resources.popUnit.Worker
import spock.lang.IgnoreRest
import spock.lang.Shared
import spock.lang.Specification


/**
 * Created by jxs on 29.5.2016.
 */
class RefinesSpec extends Specification {

    @Shared
    GameData gameData

    @Shared
    PopHub popHub

    @Shared
    GameActor player

    @Shared
    PopUnit farmer

    @Shared
    PopUnit worker

    @Shared
    PopUnit merchant

    @Shared
    Tile tile

    def setup(){

        gameData = new GameData()

        player = new Player()

        tile = new Tile(x: 1, y: 1)

        popHub = new City(tile: tile, owner: player)

        gameData.popHubs = [popHub]
        gameData.gameActors = [player]

        farmer = new Farmer(tile: new Tile(), race: new Race(), preferredHub: popHub)
        worker = new Worker(tile: tile, race: new Race(), preferredHub: popHub)
        merchant = new Merchant(tile: tile, race: new Race(), preferredHub: popHub)

        gameData.popUnits = [farmer, worker, merchant]
    }

    def "Basic output."() {
        setup:
        gameData.popUnits.each { it.produces(it.race, it.tile) }

        when:

        def output = popHub.refines(gameData.popUnits, popHub)

        then:
        output.totalFood == 2
        output.totalWork == 1
        output.totalTrade == 1
    }

    def "Basic output. Farmer has no preferred hub."() {
        setup:
        gameData.popUnits.each { it.produces(it.race, it.tile) }

        when:
        farmer.preferredHub = null
        def output = popHub.refines(gameData.popUnits, popHub)

        then:
        output.totalFood == 0
        output.totalWork == 1
        output.totalTrade == 1
    }
}