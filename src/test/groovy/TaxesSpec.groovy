import resources.gameActor.GameActorOutput
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll
import traits.Taxes


/**
 * Created by jxs on 29.5.2016.
 */
class TaxesSpec extends Specification {

    // TODO tests for gather

    private class Taxman implements Taxes { }

    @Shared
    Taxman taxman

    def setup(){
        taxman = new Taxman()
        taxman.foodTaxRate = 50
        taxman.workTaxRate = 50
        taxman.tradeTaxRate = 50
    }

    def "Test tax."() {
        setup:
        GameActorOutput gameActorOutput = new GameActorOutput(foodTotal: 10, workTotal: 10, tradeTotal: 10)

        when:
        def yield = taxman.tax(gameActorOutput)

        then:
        yield == 15
    }

    @Unroll
    def "Test tax product."() {
        setup:

        when:
        def yield = taxman.taxProduct(output, taxRate)

        then:
        yield == expected

        where:
        output | taxRate | expected
        1      |    100  | 1
        2      |    50   | 1
        100    |    10   | 10
        30     |    50   | 15
        25     |    50   | 12
    }


}