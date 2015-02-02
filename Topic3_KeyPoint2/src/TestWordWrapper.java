import static org.junit.Assert.*;

import org.junit.Test;


public class TestWordWrapper {

    @Test
    public void testWrapper1() {
        assertEquals(new Wrapper("Excelent",8).split(),
                "Excelent");
    }
    
   
    @Test
    public void testWrapper2() {
        assertEquals(new Wrapper("Excelent",5).split(),
                "Excel,ent");
    }
    
    
    @Test
    public void testWrapper3() {
        assertEquals(new Wrapper("rrffgghh",2).split(),
                "rr,ff,gg,hh");
    }
    
    
    
    
    

}
