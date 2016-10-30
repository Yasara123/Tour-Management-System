/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import static com.sun.xml.bind.util.CalendarConv.formatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Yas
 */
public class DataValidateNGTest {
    
    public DataValidateNGTest() {
    }

    /**
     * Test of Validate method, of class DataValidate.
     */
    @Test
    public void testValidate() {
        System.out.println("Validate");
        String[] CustomerNIC = {"123456789v","12345678v","123456789"};
        String[] ContactNo = {"1102709887","1102709887","110270988"};
        String[] Email ={ "yasara101@gmail.com","yasara101gmail.com","yasara101@gmailcom"};
        Date StartDate=null; 
        Date Enter_Date=null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try {
            StartDate = (Date) formatter.parse("19-04-2015");
            Enter_Date = (Date)formatter.parse("18-04-2015");
        } catch (ParseException ex) {
            Logger.getLogger(DataValidateNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        DataValidate instance = new DataValidate();
        String[] expResult ={ null,"-customer NIC Invalid-email not valid","-contact number invalid-customer NIC Invalid-email not valid"};
        String[] result=new String[3];
        for(int i=0;i<3;i++){
            result[i] = instance.Validate(CustomerNIC[i], ContactNo[i], Email[i], StartDate, Enter_Date);}
        assertEquals(result[0], expResult[0]);
        assertEquals(result[1], expResult[1]);
        assertEquals(result[2], expResult[2]);
        
    }
    
}
