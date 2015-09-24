package xsdvalidator;

import XmlTools.XmlParser;
import java.io.IOException;
import java.util.logging.Logger;
import XmlTools.ListValidator;
import org.xml.sax.SAXException;

public class XSDValidator{

    public static void main(String[] args) throws SAXException, IOException{
        XmlParser xs = XmlParser.getControler();
        ListValidator ld = new ListValidator();
        System.out.println(ld.validXML(xs.getDocument("C:\\GitHub\\testxmv.xml")));
    }
}
