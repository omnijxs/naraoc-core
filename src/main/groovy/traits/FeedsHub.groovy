package traits

import resources.popHub.PopHub
import resources.popUnit.PopUnit

/**
 * Created by Juri on 22.10.2015.
 */
trait FeedsHub implements PopUnitSorter, PopUnitFinder, Feeds {

    Integer feedsHub(List<PopUnit> popUnits, PopHub popHub, Integer foodAmount){

        /** Get the pop units to feed. */
        def starvingPopUnits = popHubPopulationStarving(popUnits, popHub)

        /** Sort by Pop Unit type, production value and age. */
        def sortedPopUnits = productionSort(starvingPopUnits)

        /** Feed and return surplus. */
        return feed(sortedPopUnits, foodAmount)

    }

}