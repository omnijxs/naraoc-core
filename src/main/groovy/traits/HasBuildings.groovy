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

    // TODO deal with building upkeep
    // TODO deal with building architecture. BuildingOutput per turn which stores the buildings and overflow for every path.
    // TODO overflow stored in the building under construction?
    // TODO PopHub & Algorithm interface

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

    List<Building> buildingsForProduct(Product product, Integer value){
        
        List<Building> resolvedCommonBuildings = []
        List<Building> resolvedUniqueBuildings = []

        /** Calculate the maximum production for this product tree */
        Integer maxValue = resolveProductionForProduct(product)
        
        /** Resolve the possible race specific buildings and sort them in ascending order */
        List<Building> uniqueBuildings = resolvePossibleUniqueBuildings(product, maxValue)
       
        /** Resolve what buildings are fully built for the product and subtract max value accordingly */
        (maxValue, resolvedUniqueBuildings) = resolveBuiltUniqueBuildings(product, maxValue, uniqueBuildings)

        /** After resolving unique buildings we know the exact production for the common tree */
        resolvedCommonBuildings = resolveBuiltCommonBuildings(product, maxValue)

        return resolvedCommonBuildings + resolvedUniqueBuildings
    }

    /** Calculate the maximum production for this product tree */
    public Integer resolveProductionForProduct(Product product){
        
        Integer maxValue = 0

        buildingProductions.findAll {  it.product == product }.each { maxValue += it.value }

        return maxValue
    }

    /** Resolve the possible race specific buildings and sort them in ascending order */
    /** Note that we now assume that the value is higher as we traverse the bullding path */
    public List<Building> resolvePossibleUniqueBuildings(Product product, Integer maxValue){
        return buildingConfiguration.findAll { b ->
            b.product == product && b.race && buildingProductions.find { p -> p.race == b.race && p.value <= maxValue }
        }.sort { it.value } 
    }

    /** Resolve the actual race specific buildings */
    public Tuple resolveBuiltUniqueBuildings(Product product, Integer maxValue, List<Building> uniqueBuildings){

        List<Building> resolvedUniqueBuildings = []

        /** Then start to subtract buildings from race specific buildings */
        uniqueBuildings.each { building ->

            /** How much production for this specific product + race path */
            Integer buildValue = buildingProductions.find { it.race == building.race && it.product == building.product }.value

            /** If enough build value, the building is finished */
            if(building.resolveBuilt(maxValue, buildValue)){
                resolvedUniqueBuildings.add(building)
                maxValue -= building.value
            }
        }

        return new Tuple(maxValue, resolvedUniqueBuildings)
    }

    /** Resolve the actual common buildings */
    public List<Building> resolveBuiltCommonBuildings(Product product, Integer maxValue){
        return buildingConfiguration.findAll {
            it.product == product && !it.race && it.value <= maxValue 
        }
    }
}