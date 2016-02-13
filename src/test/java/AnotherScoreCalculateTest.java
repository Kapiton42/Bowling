import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kapiton on 13.02.16.
 */
public class AnotherScoreCalculateTest {
    @Test
    public void testAllZero() {
        String[] testHits = new String[]{"00","00","00","00","00","00","00","00","00","00"};
        assertEquals(0, AnotherScoreCalculate.calculateScore(testHits));
    }

    @Test
    public void testAllSimpleZero() {
        String[] testHits = new String[]{"12","42","15","72","12","32","12","15","00","23"};
        assertEquals(46, AnotherScoreCalculate.calculateScore(testHits));
    }

    @Test
    public void testAllStrike() {
        String[] testHits = new String[]{"x","x","x","x","x","x","x","x","x","xxx"};
        assertEquals(300, AnotherScoreCalculate.calculateScore(testHits));
    }

    @Test
    public void testAllSpair() {
        String[] testHits = new String[]{"1/","4/","1/","7/","1/","3/","1/","1/","0/","2/3"};
        assertEquals(123, AnotherScoreCalculate.calculateScore(testHits));
    }

    @Test
    public void testAll() {
        String[] testHits = new String[]{"x","13","12","1/","x","12","12","17","12","x3x"};
        assertEquals(94, AnotherScoreCalculate.calculateScore(testHits));
    }



}