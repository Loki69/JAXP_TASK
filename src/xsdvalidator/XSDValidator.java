package xsdvalidator;

import controllers.XmlController;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.SAXException;

public class XSDValidator {

    public static void main(String[] args) {
        if (checkInputData(args)) {
            XmlController xs = XmlController.getControler();
            try {
                xs.getDocument(new File("C:\\Project\\Java\\Test\\build.xml"));
            } catch (SAXException ex) {
                System.err.println(ex.getException());
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }

    private static boolean checkInputData(String[] arvg) {
        return arvg.length > 1;
    }
}
