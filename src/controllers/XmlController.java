package controllers;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XmlController {

    private static final XmlController INIT = new XmlController();

    private static DocumentBuilder parser;
    private static Schema schema;
    private static Validator validator;
    private static SchemaFactory sf;

    private XmlController() {
        try {
            parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XmlController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static XmlController getControler() {
        return INIT;
    }

    public Document getDocument(String filePath) throws SAXException, IOException {
        return parser.parse(filePath);
    }

    public void setSchema(File xsdFile) throws SAXException {
        schema = sf.newSchema(xsdFile);
        validator = schema.newValidator();
    }

    public String isValid(String xmlFile) throws SAXException, IOException {
        Source xml = new StreamSource(new File(xmlFile));
        validator.validate(xml);
        return null;
    }
}
