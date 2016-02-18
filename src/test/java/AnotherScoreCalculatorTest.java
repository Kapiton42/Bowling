import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theory;
import sun.util.locale.LocaleUtils;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by kapiton on 13.02.16.
 */
public class AnotherScoreCalculatorTest {

    public static final Map<String[], Integer> testData = new HashMap<String[], Integer>();

    @Before
    public void setUp() {
        testData.put(new String[]{"00","00","00","00","00","00","00","00","00","00"}, 0);
        testData.put(new String[]{"12","42","15","72","12","32","12","15","00","23"}, 46 );
        testData.put(new String[]{"x","x","x","x","x","x","x","x","x","xxx"}, 300 );
        testData.put(new String[]{"1/","4/","1/","7/","1/","3/","1/","1/","0/","2/3"}, 123 );
        testData.put(new String[]{"x","13","12","1/","x","12","12","17","12","x3x"}, 94 );
    }

    @Test
    public void testCalculate() {
        for( Map.Entry<String[], Integer> entry: testData.entrySet())
            assertEquals(entry.getValue().intValue(), AnotherScoreCalculator.calculateScore(entry.getKey()));
    }



}