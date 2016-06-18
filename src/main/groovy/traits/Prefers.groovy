package traits

import resources.common.Product
import resources.common.Tile
import resources.popHub.PopHub

/**
 * Created by Juri on 23.10.2015.
 */
trait Prefers {

    PopHub preferredHub = null

    PopHub prefers(List<PopHub> popHubs, Tile tile, Product product){

        /** If there is no city with a preferredValue higher than zero, the Pop Unit does not produce for any city */
        preferredHub = null
        Integer preferredValue = 0

        popHubs.each { c ->

            /** Resolve how far the city is from the Pop Unit*/
            Integer distance = resolveDistance(tile.x, tile.y, c.x, c.y)

            /** The preferredValue is city's demand for the Pop Units' product minus distance to the city */
            Integer tempPreferredValue =  c.resolveDemandForProduct(product) - distance

            if(tempPreferredValue > preferredValue ) {
                preferredHub = c
                preferredValue = tempPreferredValue
            }
                
        }

        return preferredHub

    }

    /**
     *  Exponential progession (0, 1, 2, 4, 8, 16, 32...) */
    // TODO requires information about map to calculate river bonuses etc.
    // TODO make into an own trait
    Integer resolveDistance(px, py, cx, cy){
        return (Math.abs(cx - px) * Math.abs(cx - px)) + (Math.abs(cy - py) * Math.abs(cy - py))

    }
}