package game

import resources.common.Tile
import resources.gameActor.GameActor
import resources.popHub.PopHub
import resources.popHub.PopHubOutput
import resources.popUnit.PopUnit

/**
 * Created by Juri on 21.10.2015.
 */
class GameData {

    Metadata metadata

    List<PopUnit> popUnits
    List<PopHub> popHubs
    List<GameActor> gameActors
    List<Tile> mapTiles

    Integer currentTurn
}
