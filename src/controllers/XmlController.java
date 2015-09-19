package controllers;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XmlController {

    private static DocumentBuilder parser;
    private static final XmlController INIT = new XmlController();

    private XmlController() {
        try {
            parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XmlController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static XmlController getControler() {
        return INIT;
    }

    public Document getDocument(File fl) throws SAXException, IOException {
        return parser.parse(fl);
    }

}
