/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XmlTools;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pavel_Garanin
 */
public class ListValidatorIT {

    public ListValidatorIT() {
    }

    /**
     * Test of getResult method, of class ListValidator.
     */
    @Test
    public void testGetResult() throws Exception {
        XmlParser xs = XmlParser.getControler();
        ListValidator ld = new ListValidator();
        System.out.println(ld.getResult(xs.getDocument("testData//data//test.xml")));
    }

}
