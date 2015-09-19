/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.File;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.xml.sax.SAXException;

/**
 *
 * @author Павел
 */
public class XmlControllerTest {

    @Test
    public void testGetDocument() throws Exception {
    }

    @Test
    public void testWF() throws Exception {
        XmlController xs = XmlController.getControler();
        System.out.println(new File("testData\\wf\\noHead.xml").getAbsolutePath());
        System.out.println(new File("testData\\wf\\noHead.xml").exists());
        try {
            xs.getDocument(new File("testData\\wf\\doubleRoot.xml"));
        } catch (SAXException ex) {
            System.err.println(ex.getException());
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

}
