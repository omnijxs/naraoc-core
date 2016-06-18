import resources.common.Tile
import resources.gameActor.GameActor
import resources.gameActor.Player
import resources.popHub.PopHub
import resources.popUnit.ArmyUnit
import resources.popUnit.MagicUnit
import resources.popUnit.PopUnit
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by jxs on 29.5.2016.
 */
class FeedsArmySpec extends Specification {

    @Shared
    GameActor player

    @Shared
    GameActor AI

    @Shared
    PopHub popHub

    @Shared
    Tile tile

    def setup(){

        player = new Player()

        tile = new Tile(x: 1, y: 1)

        popHub = new PopHub(owner: player, tile: tile)

        AI = new Player()
    }

    /* def "Feed army."(){

        when:
        def surplus = player.feedsArmy(popUnits, gameActor, food)

        then:
        surplus == expected

        where:
        popUnits  | gameActor | food | expected
        [a]       | player    | 1    | 0
    }*/

    def "Feed army."(){
        setup:
        PopUnit a = new ArmyUnit(owner: player, starving: true)

        when:
        def surplus = player.feedsArmy([a], player, 1)

        then:
        surplus == 0
        !a.starving
    }

    def "Do not feed army."(){
        setup:
        PopUnit a = new ArmyUnit(owner: AI, starving: true)

        when:
        def surplus = player.feedsArmy([a], player, 1)

        then:
        surplus == 1
        a.starving
    }

    def "Not enough food."(){
        setup:
        PopUnit a = new ArmyUnit(owner: player, starving: true)
        PopUnit b = new ArmyUnit(owner: player, starving: true)
        PopUnit c = new ArmyUnit(owner: player, starving: true)

        when:
        def surplus = player.feedsArmy([a, b, c], player, 2)

        then:
        surplus == 0
        !a.starving
        !b.starving
        c.starving
    }

    def "Do not feed non-starving army."(){
        setup:
        PopUnit a = new ArmyUnit(owner: AI, starving: false)

        when:
        def surplus = player.feedsArmy([a], player, 1)

        then:
        surplus == 1
        !a.starving
    }

    def "Do not feed non-army."(){
        setup:
        PopUnit a = new MagicUnit(owner: AI, starving: true)

        when:
        def surplus = player.feedsArmy([a], player, 1)

        then:
        surplus == 1
        a.starving
    }

}