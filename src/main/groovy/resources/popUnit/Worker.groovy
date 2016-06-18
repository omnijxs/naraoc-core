package resources.popUnit

import resources.common.Priority
import resources.common.Product

/**
 * Created by Juri on 26.10.2015.
 */

class Worker extends PopUnit {
    
    public Worker(){
        this.product = Product.WORK
        this.productAmount = 1 /** Should be from a config file */
        this.priority = Priority.LOW
    }
}