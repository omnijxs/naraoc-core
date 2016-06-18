

import org.junit.Test
import resources.popUnit.ArmyUnit
import resources.popUnit.Farmer
import resources.popUnit.Merchant
import resources.popUnit.PopUnit
import resources.popUnit.Worker
import traits.PopUnitSorter

/**
 * Created by Juri on 23.10.2015.
 */
class PopUnitSorterTest implements PopUnitSorter {

    /**
     * Tests for default sort 1) Pop Unit class (priority) 2) Pop Unit age
     */
    /*@Test
    void testDefaultSortByPriority() {

        PopUnit a = new ArmyUnit()
        PopUnit b = new Farmer()
        PopUnit c = new ArmyUnit()

        List<PopUnit> popUnits = [a, b, c]

        assert defaultSort(popUnits) == [a, c, b]
    }

    @Test
    void testDefaultSortByPriorityAndAge() {

        PopUnit a = new ArmyUnit(age: 5)
        PopUnit b = new Farmer(age: 15)
        PopUnit c = new ArmyUnit(age: 10)

        List<PopUnit> popUnits = [a, b, c]

        assert defaultSort(popUnits) == [c, a, b]
    }

    @Test
    void testDefaultSortByPriorityAndAgeMultipleTypes() {

        PopUnit a = new Farmer(age: 5)
        PopUnit b = new Farmer(age: 15)
        PopUnit c = new Farmer(age: 10)
        PopUnit d = new ArmyUnit(age: 20)
        PopUnit e = new ArmyUnit(age: 10)

        List<PopUnit> popUnits = [a, b, c, d, e]

        assert defaultSort(popUnits) == [d, e, b, c, a]
    }

    @Test
    void testDefaultSortByPriorityAndAgeAllTypes() {

        PopUnit a = new Farmer(age: 5)
        PopUnit b = new Merchant(age: 15)
        PopUnit c = new Worker(age: 10)
        PopUnit d = new Worker(age: 20)

        PopUnit e = new ArmyUnit(age: 20)
        PopUnit f = new ArmyUnit(age: 10)

        List<PopUnit> popUnits = [a, b, c, d, e, f]

        assert defaultSort(popUnits) == [e, f, d, b, c, a]
    }

    *//**
     * Tests for default sort 1) Pop Unit class (priority) 2) Pop Unit age
     *//*
    @Test
    void testSenioritySort() {

        PopUnit a = new ArmyUnit(age: 5)
        PopUnit b = new Farmer(age: 6)
        PopUnit c = new ArmyUnit(age: 7)

        List<PopUnit> popUnits = [a, b, c]

        assert senioritySort(popUnits) == [c, b, a]
    }

    *//**
     * Tests for production sort 1) Pop Unit class (priority) 2) Pop Unit productivity 3) Pop Unit age
     *//*
    @Test
    void testProductionSort() {

        PopUnit a = new ArmyUnit(age: 5)
        PopUnit b = new Farmer(age: 6, productAmount: 3)
        PopUnit c = new Farmer(age: 10, productAmount: 2)
        PopUnit d = new ArmyUnit(age: 7)

        List<PopUnit> popUnits = [a, b, c, d]

        assert productionSort(popUnits) == [a, d, b, c]
    }

    @Test
    void testProductionSortMultipleTypes() {

        PopUnit a = new Farmer(age: 10, productAmount: 4)
        PopUnit b = new Farmer(age: 30, productAmount: 2)
        PopUnit c = new Merchant(age: 10, productAmount: 3)

        PopUnit d = new ArmyUnit(age: 20)
        PopUnit e = new ArmyUnit(age: 10)

        List<PopUnit> popUnits = [a, b, c, d, e]

        assert productionSort(popUnits) == [d, e, a, c, b]
    }*/

}
