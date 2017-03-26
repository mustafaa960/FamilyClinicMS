package com.modreniraq.cdms.validation;

import com.codingelab.validation.Regex;
import com.codingelab.validation.Validator;
import com.codingelab.validation.strategy.strings.StringValidation;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class Validation {

static StringValidation validation;
    public static boolean isLetter(String... text)  {
        
        try {
             validation = Validator.decorate(Regex.letters());
       
        for (String s : text) {
            
            validation.setInput(s);
            if (!validation.isValid()) {
               // JOptionPane.showMessageDialog(null, validation.getErrors());
                
               // System.err.println();
                return false;
            }
        }
         
       
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
         return true;
    }
    public static boolean isDigit(String... text)  {
        
        try {
             validation = Validator.decorate(Regex.numbers());
       
        for (String s : text) {
            
            validation.setInput(s);
            if (!validation.isValid()) {
                //JOptionPane.showMessageDialog(null, validation.getErrors());
               // System.err.println();
                return false;
            }
        }
         
       
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
         return true;
    }
    public static boolean isDigitAndLetterAndChar(String... text)  {
        
        try {
             validation = Validator.decorate(Regex.numbers(),Regex.letters(),Regex.specialCharacters());
       
        for (String s : text) {
            
            validation.setInput(s);
            if (!validation.isValid()) {
                //JOptionPane.showMessageDialog(null, validation.getErrors());
               // System.err.println();
                return false;
            }
        }
         
       
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
         return true;
    }

//    public static boolean isEmpty(int... value) {
//        for (int i : value) {
//            if (i < 0) {
//                return true;
//            }
//        }
//        return false;
//    }
    public static void resetTextField(TextField...text){
        
        for(TextField s:text){
            s.setText("");
        }
        
    }
    public static void resetCombo(ComboBox...text){
        
        for(ComboBox s:text){
            s.getSelectionModel().clearSelection();
        }
        
    }
    
//    public static boolean isDigit(String... text) {
//        for (String s : text) {
//            if (!s.matches("[0-9]+")) {
//                return false;
//            }
//        }
//        return true;
//    }
//    public static boolean isText(String... text) {
//        for (String s : text) {
//            if (!s.matches("[a-z]+")) {
//                return false;
//            }
//        }
//        return true;
//    }

}
