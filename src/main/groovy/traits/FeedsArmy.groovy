package traits

import resources.gameActor.GameActor
import resources.popHub.PopHub
import resources.popUnit.ArmyUnit
import resources.popUnit.PopUnit

/**
 * Created by Juri on 03.11.2015.
 */
trait FeedsArmy implements PopUnitSorter, Feeds {

    Integer feedsArmy(List<PopUnit> popUnits, GameActor gameActor, Integer foodAmount){

        /** Find armyUnits to feed. Currently we also feed starving armyUnits on cityTile. */
        def armyUnitsToFeed = popUnits.findAll { it?.owner == gameActor && it?.starving && it?.class == ArmyUnit }

        /** Sort by Pop Unit age. Perhaps some day also by distance. But how to calculate diestance? From what city? */
        def sortedPopUnits = senioritySort(armyUnitsToFeed)

        return feed(sortedPopUnits, foodAmount)
    }

    /** An own trait, perhaps? */
    Integer getSurplusFood(List<PopHub> popHubs, GameActor gameActor){

        Integer foodForArmies = 0

        /** Find cities which produce for me... */
        def loyalHubs = popHubs.findAll { it?.owner == gameActor }

        /** Calculate total surplus food. */
        loyalHubs.each { popHub ->
            def turnData = popHub.getPopHubOutput()
            foodForArmies += turnData.surplusFood
        }

        return foodForArmies
    }


}