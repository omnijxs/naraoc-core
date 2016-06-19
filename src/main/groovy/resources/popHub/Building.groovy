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

    // TDDO deal with upkeeå
    public Integer getValue(){
        return build
    }

    // TODO calculate the total build cost of my path's previous buildings.
    public Integer getLowerLimit(){
    	return build
    }

	// TODO calculate the total build cost of my path's previous buildings + my build cost.
    public Integer getHigherLimit(){
    	return build
    }

}