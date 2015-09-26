package XmlTools;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import strungUtil.Regrex;
import static strungUtil.Regrex.match;

public class ListValidator {

    private ValidatorXMLSchema vs;
    private String absolutePath;
    private StringBuilder sb;
    private XmlParser xs;

    public ListValidator(File file)throws IOException, SAXException{
        xs = XmlParser.getControler();
        sb = new StringBuilder();
        absolutePath = file.getParent();
        validXML(xs.getDocument(file));
    }

    public String getResult()  {
        return sb.toString();
    }

    
    private String validXML(Document inputData) throws IOException {
        if (setXSDSchema(inputData)) {
            validetXmlList(inputData);
        }
        return sb.toString();
    }

    private void validetXmlList(Document inputData) {
        NodeList listXmlPath = inputData.getElementsByTagName("xmlPath");
        for (int i = 0; i < listXmlPath.getLength(); i++) {
            Element nod = (Element) listXmlPath.item(i);
            File fl = findeFile(nod.getChildNodes().item(0).getNodeValue());
            try {
                sb.append(fl.getName()).append(": ").append(vs.isValid(fl)).append("\n");
            } catch (IOException ex) {
                sb.append(String.format("xml file not exist %s", fl.getAbsolutePath())).append("\n");
            }
        }
    }

    private boolean setXSDSchema(Document inputData) {
        NodeList listXmlPath = inputData.getElementsByTagName("xsdPath");
        try {
            File xsdFile = findeFile(listXmlPath.item(0).getTextContent());
            if (xsdFile.exists()) {
                try {
                    vs = xs.getValidatorSchema(xsdFile);// вывести результат если файла нету
                } catch (SAXException ex) {
                    sb.append(String.format("xsd file %s:\n %s ", xsdFile.getName(), ex.getLocalizedMessage())).append("\n");
                    return false;
                }
            } else {
                sb.append(String.format("xsd file not exist %s", xsdFile.getAbsolutePath())).append("\n");
                return false;
            }
            sb.append("XML Shem: ").append(xsdFile.getName()).append("\n");
            return true;
        } catch (NullPointerException exp) {
            sb.append("xsd file not set");
            return false;
        }
    }

    private File findeFile(String path) {
        if (Regrex.isAbsolutPath(path)) {
            return new File(path);
        } else {
            if (Regrex.match("/^\\/", path)) {
                return new File(this.absolutePath + path);
            } else {
                return new File(new StringBuilder(this.absolutePath).append("\\").append(path).toString());
            }
        }
    }

}
