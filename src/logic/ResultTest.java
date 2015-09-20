/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.File;

/**
 *
 * @author Павел
 */
public class ResultTest {

    private final File xmlName;
    private String comments;
    private final boolean exeptValid;
    private boolean resultValid;

    public ResultTest(String xmlPath, boolean expectValid) {
        this.xmlName = new File(xmlPath);
        this.exeptValid = expectValid;
    }

    public File getXmlFile() {
        return xmlName;
    }

    @Override
    public String toString() {
        return String.format("ResultTest{ XML name: %s, Expected status: %s Comments: %s}", xmlName.getName(), comments);
    }

}
