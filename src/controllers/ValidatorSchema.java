/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;

/**
 *
 * @author Павел
 */
public class ValidatorSchema{

    private final Schema schema;
    private final Validator validator;

    private ValidatorSchema(Schema schema){
        this.schema = schema;
        this.validator = schema.newValidator();
    }

    protected static ValidatorSchema getValidator(Schema schema){
        return new ValidatorSchema(schema);
    }

    public String isValid(File xmlFile) throws IOException{
        Source xml = new StreamSource(xmlFile);
        try{
            validator.validate(xml);
        }catch(SAXException ex){
            return ex.getLocalizedMessage();
        }
        return "Valid";
    }

}
