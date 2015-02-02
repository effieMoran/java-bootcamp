import static org.junit.Assert.*;

import org.junit.Test;

public class TestAmountToText {

    @Test
    public void testAmounToText() {

        assertEquals(new Amount(1523.138).toText(),
                "one thousand five hundred twenty three and 13/100 Dollars");
    }
    
    @Test
    public void testAmounToText1() {

        assertEquals(new Amount(2523).toText(),
                "two thousand five hundred twenty three and 0/100 Dollars");
    }
    
    
    @Test
    public void testAmounToText3() {

        assertEquals(new Amount(1.003).toText(),
                "one and 0/100 Dollars");
    }

    

}
