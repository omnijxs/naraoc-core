/*
 * This Spock specification was auto generated by running the Gradle 'init' task
 * by 'jxs' at '6/18/16 2:14 PM' with Gradle 2.14
 *
 * @author jxs, @date 6/18/16 2:14 PM
 */

import spock.lang.Specification

class LibraryTest extends Specification{
    def "someLibraryMethod returns true"() {
        setup:
        Library lib = new Library()
        when:
        def result = lib.someLibraryMethod()
        then:
        result == true
    }
}