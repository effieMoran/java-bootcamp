import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

public class TestFileList {
    @Test
    public void testAddWhenFull() {
        Program program1 = new Program();
        for (int i = 1; i < 7; i++) {
            program1.add("pic" + Integer.toString(i) + ".jpg");

        }
        ArrayList<String> actual = new ArrayList<String>();
        actual.add("pic3.jpg");
        actual.add("pic4.jpg");
        actual.add("pic5.jpg");
        actual.add("pic6.jpg");
        assertEquals(actual.toString(), program1.getListOfFiles().toString());
    }

    @Test
    public void testAddWhenFileExist() {

        Program program1 = new Program();

        for (int i = 1; i < 7; i++) {
            program1.add("pic" + Integer.toString(i) + ".jpg");
        }

        program1.add("pic5.jpg");

        ArrayList<String> actual = new ArrayList<String>();

        actual.add("pic5.jpg");
        actual.add("pic3.jpg");
        actual.add("pic4.jpg");
        actual.add("pic6.jpg");

        assertEquals(actual.toString(), program1.getListOfFiles().toString());

    }

}
