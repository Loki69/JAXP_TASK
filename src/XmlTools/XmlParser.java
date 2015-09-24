package XmlTools;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.SchemaFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XmlParser{

    private static final XmlParser INIT = new XmlParser();

    private static DocumentBuilder parser;
    private static SchemaFactory sf;

    private XmlParser(){
        try{
            parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        }catch(ParserConfigurationException ex){
            Logger.getLogger(XmlParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static XmlParser getControler(){
        return INIT;
    }

    public Document getDocument(String filePath) throws SAXException, IOException{
        return parser.parse(filePath);
    }

    public  ValidatorXMLSchema getVAlidatorSchema(File xsdFile) throws SAXException{
        return ValidatorXMLSchema.getValidator(sf.newSchema(xsdFile));
    }

}
