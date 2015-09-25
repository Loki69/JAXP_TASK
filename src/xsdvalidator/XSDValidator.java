package xsdvalidator;

import XmlTools.ListValidator;
import java.io.IOException;
import XmlTools.XmlParser;
import java.io.File;
import org.xml.sax.SAXException;

public class XSDValidator {

    public static void main(String[] args) throws SAXException, IOException {
        if (args.length > 0) {
            XmlParser xs = XmlParser.getControler();
            File xmlListValidateData = new File(args[0]);
            if (xmlListValidateData.exists()) {
                xs.getValidatorSchema(xmlListValidateData);
                ListValidator ld = new ListValidator();
                System.out.println(ld.getResult(xs.getDocument(xmlListValidateData)));
            } else {
                System.out.println(String.format("file not found", args[0]));
            }
        } else {
            System.out.println("Not param");
        }
    }
}
