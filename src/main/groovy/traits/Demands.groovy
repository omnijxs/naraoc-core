package traits

import resources.common.Product
import resources.popHub.PopHub
import resources.popHub.PopHubDemand
import resources.popUnit.PopUnit

/**
 * Created by Juri on 7.11.2015.
 */
trait Demands implements PopUnitFinder {

    private List<PopHubDemand> demandData = []

    public PopHubDemand setDemands(List<PopUnit> popUnits, PopHub popHub){

        /** Search for all pop units in the city proper and pop units outside city proper producing for the city. Currently the only strategy. */
        def basicDemand = resolveBasicDemand(popUnits, popHub)

        PopHubDemand demand = new PopHubDemand(foodDemand: basicDemand, workDemand: basicDemand, tradeDemand: basicDemand)

        setDemandData(demand)

        return demand
    }

    Boolean setDemandData(PopHubDemand demand){
        demandData.add(demand)
    }

    PopHubDemand getDemandData(){
        return demandData.last()
    }

    public Integer demandForProduct(Product product){

        def demand = getDemandData()

        switch (product){
            case Product.FOOD:
                return demand.foodDemand
            case Product.WORK:
                return demand.workDemand
            case Product.TRADE:
                return demand.tradeDemand
            default:
                return 0
        }
    }

    private Integer resolveBasicDemand(List<PopUnit> popUnits, PopHub popHub){
        return popHubPopulation(popUnits, popHub).size()
    }

}