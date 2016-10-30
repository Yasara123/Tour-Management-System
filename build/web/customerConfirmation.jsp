<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : hotelConfirmation
    Created on : Apr 11, 2015, 4:48:07 PM
    Author     : Nathie
--%>


<c:set var="tourDetails" value="${tours}"/>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title> Customer Confirmation: ${tour_ID}</title>
    </head>
    <body>
        <h1>Customer: ${tour_ID}</h1>
        
 
<form method="post" action="Bill">
   <table cellpadding="2" cellspacing="0" border="1" width="500">
     
      <tr>
         <td width="250">Tour Reference Number:</td>
         <td colspan="3"><input class="left" type="text" name="tour_ID" value=${tour_ID} style="width: 150px;"></td>
      </tr>      
      <tr>
          <td>Tour Date:</td>
         <td colspan="3"><input class="left" type="text" name="tour_date" value=${tour_date} style="width: 150px;"></td>
      </tr>
      <tr>
          <td>Client Name:</td>
         <td colspan="3"><input class="left" type="text" name="client_name" value=${client_name} style="width: 150px;"></td>
      </tr>
  
        <tr>
          <td>Client Email:</td>
         <td colspan="3"><input class="left" type="text" name="cli_email" value=${cli_email} style="width: 150px;"></td>
      </tr>
       <tr>
          <td>No of individuals:</td>
          <td colspan="3"><input class="left" type="text" name="pas_no" value=${pas_no}  style="width: 150px;"></td>
      </tr>
      <tr>
          <td>Package No:</td>
          <td colspan="3"><input class="left" type="text" name="pack_no" value=${pack_no}  style="width: 150px;"></td>
      </tr>
      <tr>
          <td>Per person:</td>
          <td colspan="3"><input class="left" type="text" name="pack_price" value=${pack_price}  style="width: 150px;"></td>
      </tr>
      
         <tr>
          <td>Bill Amount:</td>
          <td colspan="3"><input class="left" type="text" name="bill" value=${bill}  style="width: 150px;"></td>
      </tr>
 
 
 
       <tr>
         <td valign="top">Message:</td>
         <td colspan="3"><textarea class="left" name="message" style="width: 200px; height: 200px;"></textarea></td>
      </tr>
        
     
  
      <tr>
          <td colspan="4" align="center"><input type="submit" value="Send Customer Confirmation Email" style="margin-left: 20px; width: 250px "></td>
    
        </td>
      </tr>
  
   </table>
</form>
</body>
</html>
