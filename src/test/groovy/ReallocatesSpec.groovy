import resources.popUnit.Farmer
import resources.popUnit.Merchant
import resources.popUnit.PopUnit
import resources.popUnit.Worker
import spock.lang.Shared
import spock.lang.Specification

/**
 * Created by jxs on 27.5.2016.
 */
class ReallocatesSpec extends Specification {

    @Shared
    def gameInput

    void setup(){
        gameInput = [popUnitClass: '', popUnitType: '', reallocator: '', gameActor: null]
    }

    void "Test reallocate."(){
        setup:
        PopUnit a = new Farmer()
        gameInput.popUnitClass = "resources.popUnit.Worker"

        when:
        def popUnits = a.reallocates([a], gameInput)

        then:
        popUnits.size() == 1
        popUnits.first() != a
        popUnits.first().class == Worker.class
    }

    void "Test createNewPopUnit."(){
        setup:
        PopUnit a = new Worker()

        when:
        def b = a.createNewPopUnit(className)

        then:
        b.class == expected

        where:
        className                     | expected
        "resources.popUnit.Farmer"    | Farmer
        "resources.popUnit.Worker"    | Worker
        "resources.popUnit.Merchant"  | Merchant
    }

    void "Test updatePopUnits."(){
        setup:
        PopUnit a = new Worker()
        PopUnit b = new Worker()

        when:
        def popUnits = a.updatePopUnits([a], b)

        then:
        popUnits.size() == 1
        popUnits.first() == b

    }

    // TODO tests for resolve state when implemented

}