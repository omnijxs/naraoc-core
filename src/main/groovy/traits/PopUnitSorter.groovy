package traits

import resources.popUnit.PopUnit

/**
 * Created by Juri on 23.10.2015.
 */
trait PopUnitSorter {
    
    /** *
     * Sort a popUnit list first by priority (the lower the better) AND then by age (the higher the better)     *
     * Priority is defined by the PopUnit class (ArmyUnit, MagicUnit, Farmer etc)
     *
     * @param popUnits Unsorted list of popUnits
     * @return Sorted list of popUnits
     */
    List<PopUnit> defaultSort(List<PopUnit> popUnits){
        return popUnits.sort {a, b -> a.priority.value <=> b.priority.value ?: -a.age <=> -b.age }
        /** First sort by priority in ascending order. If they are equal the spaceship evaluates to zero which
         *  Groovy thinks is null and then sort by age in descending order */
    }

    // TODO COMMENTARY
    List<PopUnit> senioritySort(List<PopUnit> popUnits){
        return popUnits.sort {a, b -> -a.age <=> -b.age }
    }

    // TODO COMMENTARY
    List<PopUnit> productionSort(List<PopUnit> popUnits){
        // return popUnits.sort {a, b -> a.priority <=> b.priority ?: -a.productAmount <=> -b.productAmount ?: -b.age <=> -b.age }

        /** Extra null check because not all popUnits produce and have a productAmount */
        return popUnits.sort {a, b -> a.priority <=> b.priority ?:
                                     (a.productAmount) ? -a.productAmount <=> -b.productAmount : null ?:
                                     -b.age <=> -b.age }        // TODO WTF?!?! Why does this work?
    }
    
    
}