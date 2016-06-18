package resources.gameActor

import game.GameData
import groovy.transform.CompileStatic
import groovy.transform.TypeChecked
import resources.popHub.PopHub
import traits.FeedsArmy
import traits.Taxes

/**
 * Created by Juri on 1.12.2015.
 */
@CompileStatic
@TypeChecked
class GameActor implements FeedsArmy,
                           Taxes {

    Integer feedArmy(GameData gameData, Integer foodAmount){
        return feedsArmy(gameData.popUnits, this, foodAmount)
    }

    GameActorOutput produce(GameData gameData, GameActor gameActor){
        return gather(gameData, gameActor)
    }

    Integer resolveSurplusFood(List<PopHub> popHubs, GameActor gameActor){
        return getSurplusFood(popHubs, gameActor)
    }

    GameActorOutput getGameActorOutput(){
        return getOutPutData()
    }

    Boolean setGameActorOutput(GameActorOutput data){
        return setOutPutData(data)
    }

}
