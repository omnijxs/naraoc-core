package traits

import resources.popUnit.PopUnit

/**
 * Created by Juri on 04.12.2015.
 */
trait Reallocates {

    /** Assumptions: I am implemented by an object which implements PopUnit-interface.
      * I need it to remove myself from popUnits-list. */
    
    /** gameInput.reallocator   /** Who reallocated me? Usually a popHub. Needed for tile info and possible bonuses. */
    /** gameInput.popUnitClass  /** The class of the new PopUnit */
    /** gameInput.popUnitType   /** For armyUnit and magicUnit type identification */
    /** gameInput.gameActor     /** Which gameActor reallocated me. Needed for obedience calculations. */

    List<PopUnit> reallocates(List<PopUnit> popUnits, def gameInput){

        /** Create the new pop unit */
        PopUnit popUnit = createNewPopUnit(gameInput.popUnitClass)

        /** Resolve its properties */
        popUnit = resolvePopUnitState(popUnit)

        /** Remove the old pop unit from the resources.game data */
        return updatePopUnits(popUnits, popUnit)
    }

    /**
     * Create the new PopUnit
     *
     * @param gameInput
     * @return
     */
    PopUnit createNewPopUnit(String popUnitClass){
        GroovyClassLoader c = new GroovyClassLoader()
        def newClass = c.loadClass(popUnitClass)
        return newClass.newInstance()

    }

    // TODO
    PopUnit resolvePopUnitState(PopUnit popUnit){
        /** Deal with obedience */
        /** Calculate new tile */
        return popUnit
    }

    /** Is the resources.game data manipulation done on this level? or higher? */
    /** Put into correct place after architectural and data flow decisions */
    List<PopUnit> updatePopUnits(List<PopUnit> popUnits, PopUnit popUnit){
        popUnits.add(popUnit)
        popUnits.remove(this)
        return popUnits
    }

}