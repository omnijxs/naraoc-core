package traits

import resources.common.Product
import resources.popHub.PopHub
import resources.popHub.PopHubOutput
import resources.popUnit.PopUnit

/**
 * Created by Juri on 20.11.2015.
 */
trait Refines implements PopUnitFinder {

    private List<PopHubOutput> outputData = []

    /** Assumptions: I am implemented by an object which implements PopHub-interface.
     * I need it for access to buildings. And for my population. */

    PopHubOutput refines(List<PopUnit> popUnits, PopHub popHub){

        PopHubOutput output = new PopHubOutput()

        /** Get all my popUnits. */
        def population = popHubPopulationProducing(popUnits, popHub)

        /** Split them according to their product */
        def foodProducers = population.findAll { it.product == Product.FOOD }
        def workProducers = population.findAll { it.product == Product.WORK }
        def tradeProducers = population.findAll { it.product == Product.TRADE }

        /** Harvest their production */
        foodProducers.each { p ->
            output.food.put(p, (p.harvest()))
        }

        workProducers.each { p ->
            output.work.put(p, (p.harvest()))
        }

        tradeProducers.each { p ->
            output.trade.put(p, (p.harvest()))
        }

        // TODO deal with production for buildings
        // TODO deal with building bonuses for production

        return output
    }

    void setOutputData(PopHubOutput data){
        outputData.add(data)
    }

    PopHubOutput getOutputData(){
        return outputData.last()
    }
}