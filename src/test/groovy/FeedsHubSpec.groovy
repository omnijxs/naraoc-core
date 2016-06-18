import resources.common.Tile
import resources.popHub.PopHub
import resources.popUnit.ArmyUnit
import resources.popUnit.Farmer
import resources.popUnit.Merchant
import resources.popUnit.PopUnit
import spock.lang.Shared
import spock.lang.Specification

/**
 * Created by jxs on 28.5.2016.
 */
class FeedsHubSpec extends Specification {

    @Shared
    PopHub popHub

    @Shared
    PopUnit army

    @Shared
    PopUnit farmer

    @Shared
    PopUnit merchant

    @Shared
    Tile inTile

    @Shared
    Tile outTile

    void setup(){

        inTile = new Tile()
        outTile = new Tile()

        popHub = new PopHub(tile: inTile)

        army = new ArmyUnit()
        merchant = new Merchant()
        farmer = new Farmer()
    }

    def "Feed two. Surplus zero."(){
        setup:
        army.tile = inTile
        merchant.tile = inTile
        farmer.tile = outTile

        when:
        def surplus = popHub.feedsHub([army, merchant, farmer], popHub, 2)

        then:
        surplus == 0
        !army.starving
        !merchant.starving
        farmer.starving
    }

    def "Feed one. Surplus zero. Prefer army unit. "(){
        setup:
        army.tile = inTile
        merchant.tile = inTile
        farmer.tile = outTile

        when:
        def surplus = popHub.feedsHub([army, merchant, farmer], popHub, 1)

        then:
        surplus == 0
        !army.starving
        merchant.starving
        farmer.starving
    }

    def "Feed one. Surplus zero. Army unit not on city. "(){
        setup:
        army.tile = outTile
        merchant.tile = inTile
        farmer.tile = outTile

        when:
        def surplus = popHub.feedsHub([army, merchant, farmer], popHub, 1)

        then:
        surplus == 0
        army.starving
        !merchant.starving
        farmer.starving
    }

    def "Feed three. Surplus zero. Farmer outside city but prefers. "(){
        setup:
        army.tile = inTile
        merchant.tile = inTile
        farmer.tile = outTile
        farmer.preferredHub = popHub

        when:
        def surplus = popHub.feedsHub([army, merchant, farmer], popHub, 3)

        then:
        surplus == 0
        !army.starving
        !merchant.starving
        !farmer.starving
    }

    def "Feed three. Surplus one. Farmer prefers another hub. "(){
        setup:
        army.tile = inTile
        merchant.tile = inTile
        farmer.tile = outTile
        farmer.preferredHub = new PopHub()

        when:
        def surplus = popHub.feedsHub([army, merchant, farmer], popHub, 3)

        then:
        surplus == 1
        !army.starving
        !merchant.starving
        farmer.starving
    }

    def "Feed three. Surplus zero. "(){
        setup:
        army.tile = inTile
        merchant.tile = inTile
        farmer.tile = inTile

        when:
        def surplus = popHub.feedsHub([army, merchant, farmer], popHub, 3)

        then:
        surplus == 0
        !army.starving
        !merchant.starving
        !farmer.starving
    }

    def "Feed three. Surplus three. "(){
        setup:
        army.tile = inTile
        merchant.tile = inTile
        farmer.tile = inTile

        when:
        def surplus = popHub.feedsHub([army, merchant, farmer], popHub, 6)

        then:
        surplus == 3
        !army.starving
        !merchant.starving
        !farmer.starving
    }
}