package game

import resources.gameActor.GameActor
import resources.gameActor.GameActorOutput
import resources.popHub.PopHub
import resources.popHub.PopHubOutput
import resources.popUnit.PopUnit

/**
 * Created by jxs on 16.12.2015.
 */
class Algorithm {

    /**
     * All pop units check whether they multiply this turn.
     *
     * @param gd
     * @return
     */
    protected GameData popUnitsMultiply(GameData gameData){

        List<PopUnit> newPopUnits = []

        gameData.popUnits.each { popUnit ->
            def a = popUnit.multiply(gameData)
            if(a)
                newPopUnits.add(popUnit.multiply(gameData))
        }

        gameData.popUnits.addAll(newPopUnits)

        return gameData
    }

    /**
     * All pop units calculate their preferred hubs AND make them produce.
     * Farmers feed their tiles.
     *
     * @param gd
     * @return
     */
    protected GameData popUnitsProduce(GameData gameData){
        gameData.popUnits.each { popUnit ->

            /** All pop units calculate to which city they will produce to. */
            popUnit.prefer(gameData)

            /** Set production flags up in all popUnits.
             * TileFeeding popUnits feed their tiles and set the surplus as their this turns production. */
            popUnit.produce(gameData)
        }

        return gameData
    }

    /**
     * All pop hubs calculate their production from pop unit production.
     * Pop Hubs feed their pop Units.
     *
     * @param gd
     * @return
     */
    protected GameData popHubsRefine(GameData gameData){

        gameData.popHubs.each { PopHub popHub ->

            /** Calculate bonuses, deal with buildings etc. */
            PopHubOutput output = popHub.produce(gameData)

            /** Feed the hub population and calculate the surplus food. */
            Integer surplusFood = popHub.feedHub(gameData, output.getTotalFood())

            output.surplusFood = surplusFood

            popHub.setPopHubOutput(output)

        }

        return gameData
    }

    /** No tests. Multiple functions. */
    /**
     * All game actors feed their their armies not on pop hubs AND tax revenue is calculated.
     *
     * @param gd
     * @return
     */
    protected GameData gameActorsSetup(GameData gameData){
        gameData.gameActors.each { player ->
            /** Lets feed your roaming armies...*/

            /** Calculate how much extra food pob hubs loyal to you produce.
             *  And then feed them */
            Integer totalFood = player.resolveSurplusFood(gameData.popHubs, player)
            Integer surplusFood = player.feedArmy(gameData, totalFood)

            /** Lets tax those pesky pop units...*/

            /** Get total production of your loyal popHubs */
            GameActorOutput output = player.produce(gameData, player)

            output.surplusFood = surplusFood

            player.setGameActorOutput(output)

            /** Tax their asses! */
            player.tax(output)

        }

        return gameData
    }

    /** No tests. No full implementation. */
    /**
     * 1) Calculate pop hub demand.
     * 2) Deal with pop unit obedience .
     * 3) Set all pop units to starving for the next turn.
     *
     * @param gd
     * @return
     */
    protected GameData postProcess(GameData gameData){

        /** Calculate demand for pop hubs */
        gameData.popHubs.each { popHub ->
            popHub.setDemand(gameData)
        }

        /** Deal with pop unit obedience. Note that this MUST be done before we set them to starving. */
        gameData.popUnits.each { popUnit ->
            // popUnit.dealWithObedience()
        }

        /** Set all PopUnits to starving for next turn. Could be done in pre-process. */
        gameData.popUnits.each { popUnit ->
            popUnit.starving = true
        }

        return gameData

    }

    /** The actual player input */

    /** No tests. Multiple functions. */
    protected GameData gameActorInput(GameData gameData){
        gameData.gameActors.each { player ->
            gameData = yieldControl(gameData, player)
        }

        return gameData
    }

    /** No tests. No implementation. */
    protected GameData yieldControl(GameData gameData, GameActor gameActor){
        return gameData
        /** The actual player/AI input */
    }
}
