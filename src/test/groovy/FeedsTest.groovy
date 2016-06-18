

import org.junit.Test
import resources.popUnit.PopUnit
import traits.Consumes
import traits.Feeds

/**
 * Created by Juri on 29.10.2015.
 */
class FeedsTest implements Feeds {
/*
    private class MockUnit extends PopUnit implements Consumes {}

    @Test
    void testFeedWithObject() {

        *//** Feed method is ignorant of PopUnit type. They all behave the same way from it's perspective. *//*
        PopUnit a = new MockUnit()

        def surplusFood = feed(a, 1)

        assert !a.starving
        assert surplusFood == 0
    }

    @Test
    void testFeedAllSurplus() {

        PopUnit a = new MockUnit()
        PopUnit b = new MockUnit()

        def surplusFood = feed([a, b], 3)

        assert !a.starving
        assert !b.starving
        assert surplusFood == 1
    }

    @Test
    void testFeedAllNoSurplus() {

        PopUnit a = new MockUnit()
        PopUnit b = new MockUnit()

        def surplusFood = feed([a, b], 2)

        assert !a.starving
        assert !b.starving
        assert surplusFood == 0
    }

    @Test
    void testCannotFeedAll() {

        PopUnit a = new MockUnit()
        PopUnit b = new MockUnit()

        def surplusFood = feed([a, b], 1)

        assert !a.starving
        assert b.starving
        assert surplusFood == 0
    }*/

}
