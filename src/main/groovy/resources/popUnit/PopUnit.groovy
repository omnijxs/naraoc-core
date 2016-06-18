package resources.popUnit

import game.GameData
import groovy.transform.CompileStatic
import groovy.transform.TypeChecked
import resources.common.Priority
import resources.common.Race
import resources.common.Tile
import resources.gameActor.GameActor
import resources.popHub.PopHub
import traits.Consumes
import traits.Multiplies
import traits.PopUnitResolver
import traits.Prefers
import traits.Produces
import traits.Reallocates

/**
 * Created by Juri on 21.10.2015.
 */

@CompileStatic
@TypeChecked
class PopUnit implements Consumes,
                         Produces,
                         Prefers,
                         Reallocates,
                         Multiplies,
                         PopUnitResolver {

    @Delegate Race race
    @Delegate Tile tile

    Integer age = 0
    Priority priority
    GameActor owner

    Integer consume(Integer food){
        return consumes(food)
    }

    void produce(GameData gameData){
        if(canProduce(gameData.metadata, this.class.name)){
            produces(race, tile)
        }
    }

    Integer harvest(){
        return harvests()
    }

    PopHub prefer(GameData gameData){
        if(canProduce(gameData.metadata, this.class.name)){
            prefers(gameData.popHubs, tile, product)
        }
    }

    List<PopUnit> reallocate(GameData gameData, GameActor gameActor, def gameInput){
        if(canReallocate(gameData, gameActor)){
            return reallocates(gameData.popUnits, gameInput)
        }
    }

    PopUnit multiply(GameData gameData){
        if(canMultiply(gameData.metadata, this.class.name, race, starving)){
            return multiplies(multiplicationRate)
        }
    }

    Boolean tax(GameData gameData, GameActor gameActor){
        return canBeTaxed(gameData, gameActor)
    }

}
