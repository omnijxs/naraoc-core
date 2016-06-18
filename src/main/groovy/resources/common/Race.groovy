package resources.common

/**
 * Created by jxs on 2.12.2015.
 */
class Race {

    /** Everything here will come from a config */
    String label = ""
    Integer multiplicationRate = 0
    Integer foodProductionBonus = 0
    Integer workProductionBonus = 0
    Integer tradeProductionBonus = 0
    
    /**
     * Could be List noReallocationPenalty = ["ArmyUnit"]   
     */    
    Boolean noReallocationPenaltyForArmyUnit = false        
    Boolean noReallocationPenaltyForMagicUnit = false
    
}
