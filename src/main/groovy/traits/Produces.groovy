package traits

import resources.common.Product
import resources.common.Race
import resources.common.Tile

/**
 * Created by Juri on 16.11.2015.
 */
trait Produces {

    Product product
    Integer productAmount = 0
    Integer harvestAmount = 0

    void produces(Race race, Tile tile){
        harvestAmount = productAmount.intValue()
    }
    
    Integer harvests(){
        Integer temp = harvestAmount.intValue()
		harvestAmount = 0
		return temp
    }

}