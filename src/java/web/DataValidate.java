/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import java.util.Date;

/**
 *
 * @author Yas
 */
public class DataValidate {
  String  CustomerNIC, ContactNo,Email,StartDate;      
  public String Validate(String CustomerNIC,String ContactNo,String Email,Date StartDate,Date Enter_Date){
  String error =null;   
      if(ContactNo.length()!=10){
          if (error==null)
            error="-contact number invalid";
          else
             error+="-contact number invalid";
      }
      if((CustomerNIC.length()!=10)||(!CustomerNIC.contains("v"))){
           if (error==null)
             error="-customer NIC Invalid";
           else
             error+="-customer NIC Invalid";
      }
      if(!(Email.contains("@")&&Email.contains("."))){
         if (error==null) 
          error="-email not valid";
         else
          error+="-email not valid";   
      }
      if(Enter_Date.after(StartDate)){
          error+="-Date not valid";
      }
      return error; 
  }
}
