import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kapiton on 02.02.16.
 */
public class ScoreCalculatorTest {

    @Test
    public void testCalculateScore() throws Exception {
        String[] data = {"12","12","12","12","12","12","12","12","12","12"};
        assertEquals("1", 30, IScoreCalculator.calculateScore(data));
        data = new String[]{"x","x","x","00","x","12","00","00","00","00"};
        assertEquals("2", 76, IScoreCalculator.calculateScore(data));
        data = new String[]{"1/","1/","12","00","00","1/","12","00","00","00"};
        assertEquals("3", 39, IScoreCalculator.calculateScore(data));
        data = new String[]{"x","1/","12","1/","x","12","12","1/","12","1/x"};
        assertEquals("4", 107, IScoreCalculator.calculateScore(data));
        data = new String[]{"x","x","x","x","x","x","x","x","x","xxx"};
        assertEquals("4", 300, IScoreCalculator.calculateScore(data));
        data = new String[]{"10","10","10","10","10","10","10","10","10","100"};
        assertEquals("4", 10, IScoreCalculator.calculateScore(data));
    }
}