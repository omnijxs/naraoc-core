package traits

/**
 * Created by jxs on 2.12.2015.
 */
trait Probability {

    final int max = 100

    Boolean getProbability(Integer probability){
        return getComparison(probability, getRandom())
    }

    Boolean getComparison(Integer a, Integer b){
        return a >= b
    }

    Integer getRandom(){
        return Math.random() * max
    }

}