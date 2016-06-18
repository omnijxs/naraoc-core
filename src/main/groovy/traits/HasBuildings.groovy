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

    List<Building> buildingsForProduct(Product product, Integer value){

        Integer maxValue = 0

        /** Resolve the common tree */
        List<Building> commonBuildings = buildingConfiguration.findAll { it.product == product && !it.race }

        /** Calculate the maximum production for this product tree */
        List<BuildingProduction> productProduction = buildingProduction.findAll { it.product == product }
        productProduction.each { maxValue += it.value }

        /** Resolve the possible race specific buildings */
        List<Building> uniqueBuildings = buildingConfiguration.findAll { b ->
            b.product == product && b.race && buildingProduction.find { p -> p.race == b.race && p.value >= maxValue }
        }

        /** Sort in ascending order */
        uniqueBuildings = uniqueBuildings.sort { -it.value }

        List<Building> resolvedUniqueBuildings = []

        /** Then start to subtract building from race specific buildings */
        uniqueBuildings.each { building ->
            if(maxValue > building.value){
                maxValue -= building.value
                resolvedUniqueBuildings.add(building)
            }
        }

        // TODO overflow

        List<Building> resolvedCommonBuildings = buildingConfiguration.findAll { 
            it.product == product && !it.race && it.value <= maxValue 
        }

        return resolvedCommonBuildings + resolvedUniqueBuildings
    }
}