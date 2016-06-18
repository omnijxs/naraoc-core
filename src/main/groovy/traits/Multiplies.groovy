package traits

import resources.popUnit.PopUnit

/**
 * Created by jxs on 2.12.2015.
 */
trait Multiplies implements Probability {

    /** Assumptions: I am implemented by an object which implements PopUnit-interface.
      * I need it to for the state property which tells my probabilities to multiply. */
    
    PopUnit multiplies(Integer multiplicationRate){
        if(getProbability(multiplicationRate)){
            return breed()
        }

    }

    PopUnit breed(){
        return this.class.newInstance()
    }

}