package resources.popUnit

import resources.common.Priority
import resources.common.Product
import resources.game.GameData
import traits.FeedsTile

/**
 * Created by Juri on 21.10.2015.
 */
class Farmer extends PopUnit implements FeedsTile  {
    
    public Farmer(){
        this.product = Product.FOOD
        this.productAmount = 2 /** Should be from a config file */ 
        this.priority = Priority.LOW
    }
    
    @Override
    void produce(GameData gd){
        harvestAmount = feedTile(gd, productAmount)
    }

}