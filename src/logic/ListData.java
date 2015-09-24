package logic;

import controllers.ValidatorSchema;
import controllers.XmlParser;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ListData{

    private ValidatorSchema vs;
    private StringBuilder sb;

    public String validXML(Document inputData) throws IOException{
        sb = new StringBuilder();
        XmlParser xs = XmlParser.getControler();

        if(getXSDFile(inputData, xs)){
            validetData(inputData);
        }
        return sb.toString();
    }

    private void validetData(Document inputData){
        NodeList listXmlPath = inputData.getElementsByTagName("xmlPath");
        for(int i = 0; i < listXmlPath.getLength(); i++){
            Element nod = (Element)listXmlPath.item(i);
            File fl = new File(nod.getChildNodes().item(0).getNodeValue());
            try{
                sb.append(fl.getName()).append(": ").append(vs.isValid(fl)).append("\n");
            }catch(IOException ex){
                sb.append(String.format("xml file not exist %s", fl.getAbsolutePath()));
            }
        }
    }

    private boolean getXSDFile(Document inputData, XmlParser xs){
        NodeList listXmlPath = inputData.getElementsByTagName("xsdPath");
//        System.out.println(listXmlPath.item(0).getTextContent());
        File xsdFile = new File(listXmlPath.item(0).getTextContent());
        if(xsdFile != null && xsdFile.exists()){
            try{
                vs = xs.getVAlidatorSchema(xsdFile);// вывести результат если файла нету
            }catch(SAXException ex){
                sb.append(String.format("xsd file %s:\n %s ", xsdFile.getName(), ex.getLocalizedMessage()));
                return false;
            }
        }else{
            sb.append(String.format("xsd file not exist %s", xsdFile.getAbsolutePath()));
            return false;
        }
        sb.append("XML Shem: ").append(xsdFile.getName()).append("\n");
        return true;
    }
}
