package resources.popHub

import game.GameData
import groovy.transform.CompileStatic
import groovy.transform.TypeChecked
import resources.common.Product
import resources.common.Tile
import resources.gameActor.GameActor
import traits.Demands
import traits.FeedsHub
import traits.HasBuildings
import traits.Refines

/**
 * Created by Juri on 17.11.2015.
 */
@CompileStatic
@TypeChecked
class PopHub implements Demands,
                        Refines,
                        FeedsHub,
                        HasBuildings {

    @Delegate Tile tile
    GameActor owner

    PopHubDemand setDemand(GameData gameData){
        setDemands(gameData.popUnits, this)
    }

    PopHubOutput produce(GameData gameData){
        return refines(gameData.popUnits, this)
    }

    Integer feedHub(GameData gameData, Integer foodAmount){
        return feedsHub(gameData.popUnits, this, foodAmount)
    }

    Integer resolveDemandForProduct(Product product){
        return demandForProduct(product)
    }

    PopHubOutput getPopHubOutput(){
        return getOutputData()
    }

    Boolean setPopHubOutput(PopHubOutput data){
        return setOutputData(data)
    }

    List<BuildingProduction> buildBuildings(PopHubOutput output){
        return builds(output)
    }

    List<Building> resolveBuildings(){
        return buildingsForPaths()
    }


}
