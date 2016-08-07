import resources.common.Product
import resources.common.Race
import resources.popHub.BuildingProduction
import resources.popHub.Building
import resources.popUnit.Farmer
import resources.popUnit.Merchant
import resources.popUnit.PopUnit
import resources.popUnit.Worker
import spock.lang.IgnoreRest
import spock.lang.Unroll
import spock.lang.Shared
import spock.lang.Specification
import traits.HasBuildings


/**
 * Created by jxs on 16.6.2016.
 */
class HasBuildingsSpec extends Specification implements HasBuildings {

    @Shared
    PopUnit farmer

    @Shared
    PopUnit worker

    @Shared
    PopUnit merchant

    @Shared
    Race orc

    @Shared
    Race highMen

    @Shared
    Building a

    @Shared
    Building b

    @Shared
    Building c

    def setup(){

        farmer = new Farmer()
        worker = new Worker()
        merchant = new Merchant()

        orc = new Race()
        highMen = new Race()

        buildingProductions = []

        a = new Building(race: orc, product: Product.TRADE, build: 10)
        b = new Building(race: orc, product: Product.TRADE, ancestor: a, build: 20)
        c = new Building(race: orc, product: Product.TRADE, ancestor: b, build: 30)

        buildingConfiguration = [a, b, c]
    }

    def "Test for resolveBuildingProduction-method: Add new building production. "() {
        setup:
        farmer.race = orc

        when:
        def production = resolveBuildingProduction(farmer)

        then:
        production.race == orc
        production.product == farmer.product
        production.value == 0
        buildingProductions.size() == 1
    }

    def "Test for resolveBuildingProduction-method: Don't add if already exists."() {
        setup:
        farmer.race = orc
        BuildingProduction p = new BuildingProduction(race: farmer.race, product: farmer.product, value: 0)
        buildingProductions.add(p)

        when:
        def production = resolveBuildingProduction(farmer)

        then:
        production.race == orc
        production.product == farmer.product
        production.value == 0
        buildingProductions.size() == 1
    }

    def "Test for resolveBuildingProduction-method: Add if different."() {
        setup:
        BuildingProduction p = new BuildingProduction(race: orc, product: Product.FOOD, value: 0)
        buildingProductions.add(p)

        farmer.race = highMen

        when:
        def production = resolveBuildingProduction(farmer)

        then:
        production.race == highMen
        production.product == farmer.product
        production.value == 0
        buildingProductions.size() == 2
    }

    def "Test for build-method: Add new building production. "() {
        setup:
        farmer.race = orc

        when:
        def production = build(farmer, 2)

        then:
        production.race == orc
        production.product == farmer.product
        production.value == 2
        buildingProductions.size() == 1
    }

    def "Test for build-method: Add to existing building production. "() {
        setup:
        farmer.race = orc
        BuildingProduction p = new BuildingProduction(race: orc, product: Product.FOOD, value: 2)
        buildingProductions.add(p)

        when:
        def production = build(farmer, 2)

        then:
        production.race == orc
        production.product == farmer.product
        production.value == 4
        buildingProductions.size() == 1
    }

    def "Test for resolveProductionForProduct-method. One race and one product."(){
        setup:
        buildingProductions.add(new BuildingProduction(race: orc, product: Product.FOOD, value: 2))
        buildingProductions.add(new BuildingProduction(race: orc, product: Product.FOOD, value: 2))

        when:
        Integer value = resolveProductionForProduct(Product.FOOD)

        then:
        value == 4
    }

    def "Test for resolveProductionForProduct-method. One race and two products."(){
        setup:
        buildingProductions.add(new BuildingProduction(race: orc, product: Product.FOOD, value: 2))
        buildingProductions.add(new BuildingProduction(race: orc, product: Product.WORK, value: 2))

        when:
        Integer value = resolveProductionForProduct(Product.FOOD)

        then:
        value == 2
    }

    def "Test for resolveProductionForProduct-method. Two races and one products."(){
        setup:
        buildingProductions.add(new BuildingProduction(race: orc, product: Product.FOOD, value: 2))
        buildingProductions.add(new BuildingProduction(race: highMen, product: Product.FOOD, value: 2))

        when:
        Integer value = resolveProductionForProduct(Product.FOOD)

        then:
        value == 4
    }

    def "Test for getTotalValue-method."(){
        setup:
        Building a = new Building(build: 10)
        Building b = new Building(ancestor: a, build: 30)
        Building c = new Building(ancestor: b, build: 20)

        when:
        Integer valueA = a.getTotalValue()
        Integer valueB = b.getTotalValue()
        Integer valueC = c.getTotalValue()

        then:
        valueA == 10
        valueB == 10 + 30
        valueC == 10 + 30 + 20

    }
    
    def "Test for resolvePossibleUniqueBuildings-method. No unique buildings. "(){
        setup:
        buildingProductions.add(new BuildingProduction(race: orc, product: Product.TRADE, value: 60))       

        when:
        def buildings = resolvePossibleUniqueBuildings(Product.FOOD, 60)

        then:
        buildings == []
    }

    def "Test for resolvePossibleUniqueBuildings-method. Unique buildings. "(){
        setup:
        buildingProductions.add(new BuildingProduction(race: orc, product: Product.TRADE, value: 60))       

        when:
        def buildings = resolvePossibleUniqueBuildings(Product.TRADE, 60)

        then:
        buildings == [a, b, c]
    }
}