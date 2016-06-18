package traits

import game.GameData
import resources.gameActor.GameActor
import resources.popUnit.obedience.ViolationRule

/**
 * Created by jxs on 2.12.2015.
 */
trait HasObedience {

    Integer value = 100
    List<ViolationRule> violations = []

    Integer resolveObedience(GameData gd, GameActor ga){
        Integer temp = 0

        violations.each { it ->
            temp += it.resolve(gd, ga)
        }

        return value - temp

    }

    def violate(ViolationRule violation){
        violations.push(violation)
    }

    /*
    def removeObsolete(){

    }
    */

}
