package resources.popHub

import resources.common.Product
import resources.common.Race

/**
 * Created by jxs on 10.12.2015.
 */
class Building {

    Race race
    Product product /** Army, Magic, Food, Work, Trade */
    Integer upkeep
    Integer build
    Building ancestor

    // List<Perk> buildingPerks

    // TDDO deal with upkeep
    public Integer getValue(){
        return build
    }

    public Integer getTotalValue(){
    	return ancestor ? build + ancestor.getTotalValue() : build
    }

    public Boolean resolveBuilt(Integer maxValue, Integer buildValue){
    	return maxValue >= getTotalValue() && buildValue >= getValue()
    }

}