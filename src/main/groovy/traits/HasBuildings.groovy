package traits

import resources.common.Product
import resources.common.Race
import resources.popHub.Building
import resources.popHub.BuildingProduction
import resources.popHub.PopHubOutput
import resources.popUnit.PopUnit

/**
 * Created by jxs on 15.6.2016.
 */
trait HasBuildings {

    List<BuildingProduction> buildingProductions = []
    List<Building> buildingConfiguration = [] /** Comes from an external config */

    List<BuildingProduction> builds(PopHubOutput output){

        output.getAllPopUnits().each { popUnit, value ->
            build(popUnit, value)
        }

        return buildingProductions
    }

    BuildingProduction build(PopUnit popUnit, Integer value){

        BuildingProduction buildingProduction = resolveBuildingProduction(popUnit)

        buildingProduction.value += value

        return buildingProduction
    }

    BuildingProduction resolveBuildingProduction(PopUnit popUnit){

        BuildingProduction buildingProduction = buildingProductions.find { it.race == popUnit.race && it.product == popUnit.product }

        if(!buildingProduction){
            buildingProduction = new BuildingProduction(race: popUnit.race, product: popUnit.product, value: 0)
            buildingProductions.add(buildingProduction)
        }

        return buildingProduction

    }

    List<Building> buildingsForPath(Race race, Product product, Integer value){

        List<Building> buildings = buildingConfiguration.findAll { it.race == race && it.product == product && it.value <= value }

        return buildings
    }

    List<Building> buildingsForPaths(){

        List<Building> buildings = []

        buildingProductions.each { it ->
            buildings.addAll(buildingsForPath(it.race, it.product, it.value))
        }

        // TODO combine production values for same buildings within different trees!!!

        return buildings.unique()
    }
}