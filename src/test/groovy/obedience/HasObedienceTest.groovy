package obedience

import org.junit.Before
import org.junit.Test
import resources.common.Tile
import resources.gameActor.GameActor
import resources.popUnit.PopUnit

import traits.HasObedience
import resources.popUnit.obedience.ViolationRule

/**
 * Created by jxs on 21.12.2015.
 */
class HasObedienceTest {

/*    GameData gameData
    GameActor gameActor
    PopUnit popUnit

    private class MockViolationRule extends ViolationRule {
        @Override
        Integer resolve(GameData gd, GameActor ga) {
            return power
        }
    }

    @Before
    void setUp() {
        gameData = new GameData()
        gameActor = new GameActor()
        // popUnit = new PopUnit(obedience: new HasObedience(), tile: new Tile())
    }

    @Test
    void testAddViolation() {

        assert !popUnit.obedience.violations

        ViolationRule violation = new MockViolationRule(power: 0, duration: 0, turn: 0, violator: null)

        popUnit.violate(violation)

        assert popUnit.violations.size() == 1
    }

    @Test
    void testCalculateViolation() {

        ViolationRule violation = new MockViolationRule(power: 10, duration: 0, turn: 0, violator: null)

        popUnit.violate(violation)

        assert popUnit.resolveObedience(gameData, gameActor) == 90 *//** 100 - 10 *//*
    }

    @Test
    void testCalculateMultipleViolations() {

        ViolationRule violation_a = new MockViolationRule(power: 10, duration: 0, turn: 0, violator: null)
        popUnit.violate(violation_a)

        ViolationRule violation_b = new MockViolationRule(power: 25, duration: 0, turn: 0, violator: null)
        popUnit.violate(violation_b)

        assert popUnit.resolveObedience(gameData, gameActor) == 65 *//** 100 - 35 *//*
    }*/
}
