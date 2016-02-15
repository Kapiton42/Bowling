import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by kapiton on 02.02.16.
 */
public class MainTest {

    public static final Map<String, Boolean> testData = new HashMap<String, Boolean>();

    @Before
    public void setUp() {
        testData.put("23", true);
        testData.put("65", false );
        testData.put("265", false );
        testData.put("", false );
        testData.put("65/", false );
        testData.put("x2", false );
        testData.put("/2", false );
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

        Assert.assertEquals("x", true, Main.checkFrame("x"));
        Assert.assertEquals("2/", true, Main.checkFrame("2/"));

    }

    @Test
    public void testCheckLastFrame() throws Exception {
        for( HashMap.Entry<String, Boolean> entry: testData.entrySet())
            assertEquals(entry.getKey(), entry.getValue(), Main.checkFrame(entry.getKey()));

        Assert.assertEquals("x32", true, Main.checkLastFrame("x32"));
        Assert.assertEquals("2/4", true, Main.checkLastFrame("2/4"));
    }
}