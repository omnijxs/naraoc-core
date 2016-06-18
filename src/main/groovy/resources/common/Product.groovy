package resources.common

/**
 * Created by Juri on 26.10.2015.
 */

enum Product {
    
    FOOD("Food"),
    WORK("Work"),
    TRADE("Trade"),
    MAGIC("Magic"),
    WAR("War")

    final String label
    
    private Product(String label){
        this.label = label
        
    }
  
}