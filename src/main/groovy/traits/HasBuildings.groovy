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
        
        List<Building> resolvedUniqueBuildings = []
        List<Building> resolvedCommonBuildings = []

        /** Resolve the common tree */
        List<Building> commonBuildings = buildingConfiguration.findAll { it.product == product && !it.race }

        /** Calculate the maximum production for this product tree */
        Integer maxValue = resolveMaximumProductionForProduct(product)
        
        /** Resolve the possible race specific buildings and sort them in ascending order */
        List<Building> uniqueBuildings = resolveUniqueBuildingsForTree(product, maxValue)
       
        /** Then start to subtract building from race specific buildings */
        uniqueBuildings.each { building ->

            /** How much production for this specific product + race path */
            Integer buildValue = buildingProduction.find { it.race == building.race && it.product == building.product }.value

            /** If enough build value, the building is finished*/
            if(building.resolveBuilt(maxValue, buildValue)){
                resolvedUniqueBuildings.add(building)
                maxValue -= building.value
            /** If not, then just subtract the buildValue from common building tree */
            } else {
                maxValue -= buildValue
            }
        }

        /** After unique buildings we now the exact production for the common tree */
        resolvedCommonBuildings = buildingConfiguration.findAll { 
            it.product == product && !it.race && it.value <= maxValue 
        }

        return resolvedCommonBuildings + resolvedUniqueBuildings

        // TODO Deal with production overflow (i.e. buildings under construction )
    }

    /** Resolve the possible race specific buildings and sort them in ascending order */
    public List<Building> resolveUniqueBuildingsForTree(Product product, Integer maxValue){
        return buildingConfiguration.findAll { b ->
            b.product == product && b.race && buildingProduction.find { p -> p.race == b.race && p.value >= maxValue }
        }.sort { -it.value } 
    }

    /** Calculate the maximum production for this product tree */
    public Integer resolveMaximumProductionForProduct(Product product){
        
        Integer maxValue = 0

        buildingProductions.findAll { 
            it.product == product 
        }.each { maxValue += it.value }

        return maxValue
    }
}