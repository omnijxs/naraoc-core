package resources.common

/**
 * Created by jxs on 2.12.2015.
 */
enum Priority {

    HIGH("High", 0),
    MEDIUM("Medium", 5),
    LOW("Low", 10)

    final String label
    final Integer value

    private Priority(String label, Integer value){
        this.label = label
        this.value = value

    }

}