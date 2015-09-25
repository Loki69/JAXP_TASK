package XmlTools;

import java.io.File;
import org.junit.Test;
import static org.junit.Assert.*;

public class ListValidatorIT {

    public ListValidatorIT() {
    }

    @Test
    public void testGetResult() throws Exception {
        XmlParser xs = XmlParser.getControler();
        ListValidator ld = new ListValidator();
        System.out.println(ld.getResult(new File("testData//data//test.xml")));
    }

}
