package xsdvalidator;

import XmlTools.ListValidator;
import XmlTools.ValidatorXMLSchema;
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
                ValidatorXMLSchema vs = xs.getValidatorSchema(new File("./testData/xmlShema/shemaInputData/validInput.xsd"));
                if ("OK".equals(vs.isValid(xmlListValidateData))) {
                    ListValidator ld = new ListValidator(xmlListValidateData);
                    System.out.println(ld.getResult());
                } else {
                    System.out.println(vs.isValid(xmlListValidateData));
                }
            } else {
                System.out.println(String.format("file not found", args[0]));
            }
        } else {
            System.out.println("Not param");
        }
    }
}
