<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : response
    Created on : Apr 8, 2015, 6:25:28 AM
    Author     : Nathie
--%>
<c:set var="tourDetails" value="${passengers}"/>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title> Hotel Bookings </title>
    </head>
    <body>
        <h1>Hotel Bookings</h1>
        
           
       
 
<form  action="checkAvailability">
   <table cellpadding="2" cellspacing="0" border="1" width="500">
     
      <tr>
         <td width="300">Tour Reference Number::</td>
         <td colspan="3"><input class="left" type="text" name="tour_ID" value=${tours} style="width: 150px;"></td>
      </tr>
      <tr>
          <td>Tour Date:</td>
         <td colspan="3"><input class="left" type="text" name="date" value=${tours_date} style="width: 150px;"></td>
      </tr>
        <tr>
          <td>Hotel Name:</td>
         <td colspan="3"><input class="left" type="text" name="hotname" value=${hotel_name} style="width: 150px;"></td>
      </tr>
        <tr>
          <td>Hotel Contact Number:</td>
         <td colspan="3"><input class="left" type="text" name="hotnum"  style="width: 150px;" value=${hotel_num}></td>
      </tr>
      <tr>
          <td>No of passengers:</td>
         <td colspan="3"><input class="left" type="text" name="numPas" style="width: 150px;" value=${numPas} ></td>
      </tr>
       <tr>
          <td>No of rooms:</td>
          <td colspan="3"><input class="left" type="text" name="roomNo" value=""  style="width: 150px;"></td>
      </tr>
      <tr>
         <td>Room Type:</td>
         <td>Single: <input type="checkbox" name="single" style="border: 0px"></td>
         <td>Double: <input type="checkbox" name="double" style="border: 0px"></td>
         <td>Triple: <input type="checkbox" name="triple" style="border: 0px"></td>
      </tr>
        
      <tr>
          <td colspan="4" align="center"><input type="submit" value="Check Availability" style="margin-left: 20px; width: 160px "></td>
    
        </td>
      </tr>
  
   </table>
</form>
</body>
</html>
