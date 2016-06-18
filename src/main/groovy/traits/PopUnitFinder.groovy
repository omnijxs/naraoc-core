package traits

import resources.popHub.PopHub
import resources.popUnit.PopUnit

/**
 * Created by Juri on 18.11.2015.
 */
trait PopUnitFinder {

    /**
     * The definition of popHubs population
     *
     * @param gd
     * @param popHub
     * @return
     */
    List<PopUnit> popHubPopulation(List<PopUnit> popUnits, PopHub popHub){
        return popUnits.findAll { it?.preferredHub == popHub || it?.tile == popHub?.tile }
    }
    
    /**
     * The pop units which produce for this pop hub.
     *
     * @param gd
     * @param popHub
     * @return
     */
    List<PopUnit> popHubPopulationProducing(List<PopUnit> popUnits, PopHub popHub){
        return popUnits.findAll { it?.preferredHub == popHub }
    }

    /**
     * Finds those populationUnits which are to be fed by the popHub:
     * Find all non-starving population units of the popHub
     *
     * @param popUnits
     * @param popHub
     * @return
     */
    List<PopUnit> popHubPopulationStarving(List<PopUnit> popUnits, PopHub popHub){
        return popUnits.findAll { (it?.preferredHub == popHub || it?.tile == popHub.tile) && it?.starving }
    }

}