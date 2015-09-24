package xsdvalidator;

import controllers.ValidatorSchema;
import controllers.XmlParser;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.ListData;
import org.xml.sax.SAXException;

public class XSDValidator{

    public static void main(String[] args) throws SAXException, IOException{
        XmlParser xs = XmlParser.getControler();
        ListData ld = new ListData();
        System.out.println(ld.validXML(xs.getDocument("C:\\GitHub\\testxmv.xml")));
    }
}
