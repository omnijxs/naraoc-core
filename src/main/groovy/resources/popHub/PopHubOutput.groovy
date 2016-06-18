package resources.popHub

import resources.popUnit.PopUnit

/**
 * Created by Juri on 17.11.2015.
 */
class PopHubOutput {

    Map<PopUnit, Integer> food = [:]
    Map<PopUnit, Integer> work = [:]
    Map<PopUnit, Integer> trade = [:]

    Integer surplusFood = 0
    Boolean closed = false

    Integer getTotalFood(){
        Integer temp = 0

        food.values().each {
            temp += it
        }

        return temp
    }

    Integer getTotalWork(){
        Integer temp = 0

        work.values().each {
            temp += it
        }

        return temp
    }

    Integer getTotalTrade(){
        Integer temp = 0

        trade.values().each {
            temp += it
        }

        return temp
    }

    Map<PopUnit, Integer> getAllPopUnits(){
        return food + work + trade
    }

}
