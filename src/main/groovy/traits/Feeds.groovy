package traits

import resources.popUnit.PopUnit

/**
 * Created by Juri on 29.10.2015.
 */
trait Feeds {

    /**
     *
     * Is ignorant of the Pop Unit class (i.e. ArmyUnit or Farmer) and is ignorant whether popUnits is an object or a list.
     *
     * @param popUnits
     * @param foodAmount
     * @return
     */
    Integer feed(List<PopUnit> popUnits, Integer foodAmount){

        popUnits.each {
            if(foodAmount)
                foodAmount = it.consume(foodAmount)
        }

        return foodAmount

    }

}