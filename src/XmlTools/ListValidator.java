package XmlTools;

import java.io.File;
import java.io.IOException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ListValidator{

    private ValidatorXMLSchema vs;
    private StringBuilder sb;
    private  XmlParser xs;
    
    public ListValidator() throws IOException{
        xs = XmlParser.getControler();
        sb = new StringBuilder();
    }
    
    public String getResult(Document inputListValidate) throws IOException{
        validXML(inputListValidate);
        return sb.toString();
    };
    
    private String validXML(Document inputData) throws IOException{
        if(setXSDSchema(inputData)){
            validetXmlList(inputData);
        }
        return sb.toString();
    }

    private void validetXmlList(Document inputData){
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

    private boolean setXSDSchema(Document inputData){
        NodeList listXmlPath = inputData.getElementsByTagName("xsdPath");
        try{
            File xsdFile = new File(listXmlPath.item(0).getTextContent());
            if(xsdFile.exists()){
                try{
                    vs = xs.getValidatorSchema(xsdFile);// вывести результат если файла нету
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
        }catch(NullPointerException exp){
            sb.append("xsd file not set");
            return false;
        }
    }

}
