package traits

import game.GameData
import resources.common.Race
import resources.gameActor.GameActor

/**
 * Created by jxs on 27.5.2016.
 */
trait PopUnitResolver implements HasObedience {

    public Boolean canMultiply(def config, String className, Race race, Boolean starving){
        return resolveConfigurationItem(config, className, race) && !starving
    }

    public Boolean canReallocate(GameData gameData, GameActor gameActor){
        return isObedient(gameData, gameActor)
    }

    public Boolean canBeTaxed(GameData gameData, GameActor gameActor){
        return isObedient(gameData, gameActor)
    }

    public Boolean canProduce(def config, String className){
        return resolveConfigurationItem(config, className, null)
    }

    private Boolean isObedient(GameData gameData, GameActor gameActor){
        return resolveObedience(gameData, gameActor) > 0
    }

    private Boolean resolveConfigurationItem(def config, String className, Race race){
        // DO MAGIC
    }
}