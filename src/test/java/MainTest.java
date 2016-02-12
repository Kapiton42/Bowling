import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;

import static org.mockito.Mockito.*;

/**
 * Created by kapiton on 02.02.16.
 */
public class MainTest {

    @Test
    public void testReadFromBuffer() throws Exception {
        BufferedReader br = mock(BufferedReader.class);
        when(br.readLine()).thenReturn("12");
        String[] result = Main.readFromBuffer(br);
        Assert.assertEquals(result, new String[]{"12", "12", "12", "12", "12", "12", "12", "12", "12", "12"});
    }

    @Test
    public void testCheckFrame() throws Exception {
        Assert.assertEquals("23", true, Main.checkFrame("23"));
        Assert.assertEquals("x", true, Main.checkFrame("x"));
        Assert.assertEquals("2/", true, Main.checkFrame("2/"));

        Assert.assertEquals("65", false, Main.checkFrame("65"));
        Assert.assertEquals("", false, Main.checkFrame(""));
        Assert.assertEquals("652", false, Main.checkFrame("652"));
        Assert.assertEquals("65/", false, Main.checkFrame("65/"));
        Assert.assertEquals("x2", false, Main.checkFrame("x2"));
        Assert.assertEquals("/2", false, Main.checkFrame("/2"));
    }

    @Test
    public void testCheckLastFrame() throws Exception {
        Assert.assertEquals("23", true, Main.checkLastFrame("23"));
        Assert.assertEquals("x32", true, Main.checkLastFrame("x32"));
        Assert.assertEquals("2/4", true, Main.checkLastFrame("2/4"));

        Assert.assertEquals("265", false, Main.checkLastFrame("265"));
        Assert.assertEquals("", false, Main.checkLastFrame(""));
        Assert.assertEquals("56", false, Main.checkLastFrame("56"));
        Assert.assertEquals("65/", false, Main.checkLastFrame("65/"));
        Assert.assertEquals("x2", false, Main.checkLastFrame("x2"));
        Assert.assertEquals("/2", false, Main.checkLastFrame("/2"));
    }
}