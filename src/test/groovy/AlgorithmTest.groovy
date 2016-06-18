import game.Algorithm
import org.junit.Before
import org.junit.Test
import resources.common.Product
import resources.common.Race
import resources.gameActor.GameActor
import resources.gameActor.Player
import resources.popHub.City
import resources.common.Tile
import resources.popHub.PopHubOutput
import resources.popHub.PopHub
import resources.popUnit.Farmer
import resources.popUnit.Merchant
import resources.popUnit.PopUnit

import resources.popUnit.Worker
import traits.HasObedience

/**
 * Created by Juri on 16.11.2015.
 */
class AlgorithmTest extends Algorithm {

    /**
     * These tests are technically redundant. All functionality is/should be tested in traitTests.
     * The purpose of these tests is to prototype the main algorithm.
     * */

  /*  protected GameData gameData
    protected PopHub city
    protected GameActor player
    protected PopUnit farmer
    protected PopUnit worker
    protected PopUnit merchant
    protected Tile cityTile

    @Before
    void setUp() {
        gameData = new GameData()

        player = new Player()

        cityTile = new Tile(x: 1, y: 1)

        city = new City(tile: cityTile, buildings: new Buildings(), owner: player)
        city.demand.put((Product.FOOD), 10)
        city.demand.put((Product.WORK), 10)
        city.demand.put((Product.TRADE), 10)

        gameData.popHubs = [city]
        gameData.gameActors = [player]

        farmer = new Farmer(tile: new Tile(x: 1, y: 2), race: new Race(), preferredHub: city, obedience: new HasObedience())
        worker = new Worker(tile: cityTile, race: new Race(), obedience: new HasObedience())
        merchant = new Merchant(tile: cityTile, race: new Race(), obedience: new HasObedience())

        gameData.popUnits = [farmer, worker, merchant]

    }

    @Test
    void testTurnAlgorithm() {

        *//** 1. DEAL WITH POP UNIT MULTIPLICATION. *//*
        gameData = popUnitsMultiply(gameData)           *//** gameData.popUnits = ...*//*

        *//** 2. DEAL WITH POP UNIT PRODUCTION *//*
        gameData = popUnitsProduce(gameData)            *//** gameData.popUnits = ...*//*

        *//** 3. DEAL WITH POP HUB PRODUCTION *//*
        gameData = popHubsRefine(gameData)

        *//** 4. DEAL WITH GAME ACTORS *//*
        gameData = gameActorsSetup(gameData)

        *//** 5. TURN-BASED ACTIONS... *//*
        gameData = gameActorInput(gameData)

        *//** 6. PREPARE GAME DATA FOR THE NEXT TURN *//*
        gameData = postProcess(gameData)

    }

    @Test
    void testPopUnitsMultiplyAlways() {

        PopUnit p = new Farmer(race: new Race(multiplicationRate: 100), starving: false)

        gameData.popUnits = [p]

        gameData = popUnitsMultiply(gameData)

        assert gameData.popUnits.size() == 2

    }

    @Test
    void testPopUnitsProduceBasicCase() {

        gameData = popUnitsProduce(gameData)

        assert farmer.harvest() == 1
        assert worker.harvest() == 1
        assert merchant.harvest() == 1
    }

    @Test
    void testPopHubsRefineBasicCase() {

        gameData = popUnitsProduce(gameData)
        gameData = popHubsRefine(gameData)

        PopHubOutput output = city.getTurnData()

        assert output.food.size() == 1
        assert output.work.size() == 1
        assert output.trade.size() == 1
    }*/


}