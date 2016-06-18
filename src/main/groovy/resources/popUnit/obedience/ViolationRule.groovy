package resources.popUnit.obedience

import game.GameData
import resources.gameActor.GameActor

/**
 * Created by jxs on 21.12.2015.
 */
abstract class ViolationRule {

    Integer power = 0
    Integer turn = 0
    Integer duration = 0
    GameActor violator = null

    abstract Integer resolve(GameData gd, GameActor ga)

}
