package xsdvalidator;

import controllers.XmlController;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XSDValidator{

    public static void main(String[] args) throws IOException{
        XmlController xs = XmlController.getControler();

        try{
            xs.setSchema(new File("C:\\GitHub\\test.xsd"));
            xs.isValid(new File("C:\\GitHub\\testxm.xml"));
            xs.isValid(new File("C:\\GitHub\\testxmv.xml"));
        }catch(SAXException ex){
            System.out.println(ex.getLocalizedMessage());
        }
        System.out.println("Document validates fine.");
    }

    private static boolean checkInputData(String[] arvg){
        return arvg.length > 1;
    }
}
