import static org.junit.Assert.*;

import org.junit.Test;

public class TestConverter {
    @Test
    public void testConverMMXVTo2015() {
        assertEquals(new RomanNum("MMXV").toInt(), 2015);
    }

    @Test
    public void testConvertCXTo60() {
        assertEquals(new RomanNum("v").toInt(), 5);

    }

    @Test
    public void testConvertcdxlivTo444() {
        assertEquals(new RomanNum("CDXLIV").toInt(), 444);
    }

    @Test
    public void testConvert444toCMXCIX() {
        assertEquals(new IntNum(444).toRoman(), "CDXLIV");
    }

    @Test
    public void testConvert5ToV() {
        assertEquals(new IntNum(5).toRoman(), "V");
    }

    @Test
    public void testConvert2015ToMMXV() {
        assertEquals(new IntNum(444).toRoman(), "CDXLIV");
    }

}
