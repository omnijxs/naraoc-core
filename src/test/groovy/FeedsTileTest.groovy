

import resources.game.GameData
import org.junit.Before
import org.junit.Test
import resources.common.Priority
import resources.popUnit.ArmyUnit
import resources.popUnit.PopUnit
import resources.common.Tile

import traits.Consumes
import traits.FeedsTile

/**
 * Created by Juri on 22.10.2015.
 */
class FeedsTileTest {
/*
    private class TileFeeder extends PopUnit implements FeedsTile, Consumes {

    }
    
    protected GameData gameData
    protected Tile emptyTile
    protected Tile filledTile
    protected PopUnit army
    protected PopUnit feeder
    protected PopUnit extra

    @Before
    void setUp(){
        gameData = new GameData()

        emptyTile = new Tile()
        filledTile = new Tile()
        army = new ArmyUnit()
        feeder = new TileFeeder(priority: Priority.LOW)

        gameData.mapTiles = [emptyTile, filledTile]

        gameData.popUnits = [army, feeder]

    }

    @Test
    void testFeedSelfAndFriend() {

        army.tile = filledTile
        feeder.tile = filledTile

        assert feeder.feedTile(gameData, 2) == 0
        assert !feeder.starving
        assert !army.starving
    }

    @Test
    void testFeedSelfNoOneElseToFeed() {

        army.tile = emptyTile
        feeder.tile = filledTile

        assert feeder.feedTile(gameData, 2) == 1
        assert !feeder.starving
        assert army.starving
    }


    @Test
    void testFeedArmyUnitsBeforeSelf() {

        extra = new ArmyUnit()

        gameData.popUnits.add(extra)

        army.tile = filledTile
        extra.tile = filledTile
        feeder.tile = filledTile

        assert feeder.feedTile(gameData, 2) == 0
        assert feeder.starving
        assert !army.starving
        assert !extra.starving
    }

    @Test
    void testDoNotFeedNonStarving() {

        army.tile = filledTile
        feeder.tile = filledTile

        army.starving = false

        assert feeder.feedTile(gameData, 2) == 1
        assert !feeder.starving
        assert !army.starving
    }*/

}
