import spock.lang.Shared
import spock.lang.Specification

/**
 * Created by popy on 7/29/17.
 */
class RestTest extends Specification {


    List<Integer> list = new ArrayList<>()

    def setupSpec() {
//        list = new ArrayList<>()
//        list.add(2);
    }

    def setup() {
        list = new ArrayList<>()
        list.add(2);
    }

    def "inital state"(){

        when :
        list.add(2);

        then :
        list.size() ==2

    }

    def "should return test"(){

        when :
            list.add(2);

        then :
            list.size() ==2
    }
}
