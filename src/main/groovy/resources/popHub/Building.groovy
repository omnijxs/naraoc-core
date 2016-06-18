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

    public getValue(){
        return build + upkeep
    }

}