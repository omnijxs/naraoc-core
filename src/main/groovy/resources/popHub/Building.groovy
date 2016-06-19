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
    // List<Perk> buildingPerks

    // TDDO deal with upkeep
    public Integer getValue(){
        return build
    }

    // TODO resolve the build cost of all buildings preceding me in my path.
    public Integer getTotalValue(){
    	return build
    }

    public Boolean resolveBuilt(Integer maxValue, Integer buildValue){
    	return maxValue >= getTotalValue() && buildValue >= getValue()
    }

}