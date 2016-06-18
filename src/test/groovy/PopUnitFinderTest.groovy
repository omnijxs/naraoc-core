

import traits.PopUnitFinder

/**
 * Created by Juri on 18.11.2015.
 */
class PopUnitFinderTest implements PopUnitFinder {

    /*protected GameData gameData
    protected PopHub city
    protected Tile cityTile

    private class MockUnit extends PopUnit implements Preferres, Consumes {
        Tile tile
    }

    @Before
    void setUp(){
        gameData = new GameData()

        cityTile = new Tile()

        city = new City(tile: cityTile)

        gameData.popHubs = [city]

    }

    @Test
    void testPopHubPopulation() {

        PopUnit a = new MockUnit(tile: cityTile, preferredHub: city)
        PopUnit b = new MockUnit(tile: cityTile, preferredHub: new PopHub())
        PopUnit c = new MockUnit(tile: new Tile(), preferredHub: null)
        PopUnit d = new MockUnit(tile: new Tile(), preferredHub: new PopHub())
        PopUnit e = new MockUnit(tile: new Tile(), preferredHub: city)

        gameData.popUnits = [a, b, c, d, e]

        assert popHubPopulation(gameData, city) == [a, b, e]
    }

    @Test
    void testPopHubPopulationProducing() {

        PopUnit a = new MockUnit(tile: cityTile, preferredHub: city)
        PopUnit b = new MockUnit(tile: cityTile, preferredHub: new PopHub())        
        PopUnit c = new MockUnit(tile: new Tile(), preferredHub: null)
        PopUnit d = new MockUnit(tile: new Tile(), preferredHub: new PopHub())
        PopUnit e = new MockUnit(tile: new Tile(), preferredHub: city)

        gameData.popUnits = [a, b, c, d, e]

        assert popHubPopulationProducing(gameData, city) == [a, e]
    }

    @Test
    void testPopHubPopulationStarving() {

        PopUnit a = new MockUnit(tile: cityTile, starving: true)
        PopUnit b = new MockUnit(tile: cityTile, starving: false)
        PopUnit c = new MockUnit(preferredHub: city, starving: true)
        PopUnit d = new MockUnit(preferredHub: city, starving: false)

        gameData.popUnits = [a, b, c, d]

        assert popHubPopulationStarving(gameData, city) == [a, c]
    }*/
}
