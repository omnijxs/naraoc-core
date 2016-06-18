package traits

/**
 * Created by Juri on 16.11.2015.
 */
trait Consumes {
    
    Boolean starving = true 
    
    Integer consumes(Integer food){
        Integer consumed = 0

        if(food) {
            starving = false
            consumed = food - 1
        }

        return consumed
    }

}