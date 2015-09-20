package logic;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ListData{

    private String xsdPath;
    private List<ResultTest> listXml;

    ListData(){
        listXml = new ArrayList(40);
    }

    public void setListData(Document inputData){
        addXMLFile(inputData);
        addXSDFile(inputData);
    }

    private void addXMLFile(Document inputData){
        NodeList listXmlPath = inputData.getElementsByTagName("xmlPath");
        for(int i = 0; i < listXmlPath.getLength(); i++){
            Element nod = (Element)listXmlPath.item(i);
            listXml.add(new ResultTest(nod.getChildNodes().item(0).getNodeValue(), Boolean.getBoolean(nod.getAttribute("valid"))));
        }
    }

    private void addXSDFile(Document inputData){
        NodeList listXmlPath = inputData.getElementsByTagName("xsdPath");
        xsdPath = listXmlPath.item(0).getNodeValue();
    }
}
