import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theory;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeThat;
import static org.mockito.Mockito.*;

/**
 * Created by kapiton on 02.02.16.
 */
public class MainTest {

    public static final Map<String, Boolean> testData = new HashMap<String, Boolean>();
    public static final Map<String, Boolean> testDataForCheckFrame = new HashMap<String, Boolean>();
    public static final Map<String, Boolean> testDataForCheckLastFrame = new HashMap<String, Boolean>();

    @Before
    public void setUp() {
        testData.put("23", true);
        testData.put("65", false );
        testData.put("265", false );
        testData.put("", false );
        testData.put("65/", false );
        testData.put("x2", false );
        testData.put("/2", false );

        testDataForCheckFrame.put("x", true);
        testDataForCheckFrame.put("2/", true);

        testDataForCheckLastFrame.put("x32", true);
        testDataForCheckLastFrame.put("2/4", true);
    }

    @Test
    public void testReadFromBuffer() throws Exception {
        BufferedReader br = mock(BufferedReader.class);
        when(br.readLine()).thenReturn("12");
        String[] result = Main.readFromBuffer(br);
        Assert.assertEquals(result, new String[]{"12", "12", "12", "12", "12", "12", "12", "12", "12", "12"});
    }

    @Test
    public void testCheckFrame() throws Exception {
        for( HashMap.Entry<String, Boolean> entry: testData.entrySet())
            assertEquals(entry.getKey(), entry.getValue(), Main.checkFrame(entry.getKey()));

        for( HashMap.Entry<String, Boolean> entry: testDataForCheckFrame.entrySet())
            assertEquals(entry.getKey(), entry.getValue(), Main.checkFrame(entry.getKey()));

    }

    @Test
    public void testCheckLastFrame() throws Exception {
        for( HashMap.Entry<String, Boolean> entry: testData.entrySet())
            assertEquals(entry.getKey(), entry.getValue(), Main.checkLastFrame(entry.getKey()));

        for( HashMap.Entry<String, Boolean> entry: testDataForCheckLastFrame.entrySet())
            assertEquals(entry.getKey(), entry.getValue(), Main.checkLastFrame(entry.getKey()));
    }
}