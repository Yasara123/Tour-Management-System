<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : driver
    Created on : Apr 3, 2015, 12:26:33 PM
    Author     : Yas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tour Scheduling</h1>
         <div id="data">
        <div id="data1">    
            <div class="amanda2">   
         <table border="0">     
            <form action="TourConfirm" method="POST">
                <tr>
        <td>Select Driver:</td>
        <td>
            <select name="driverCode">
                <c:forEach var="row" items="${drivers}">
                    <option value="${row}">${row}</option>
                    </c:forEach>
            </select>
            </td>
            </tr>  
        <tr> 
         <td>Select Coach:</td>
         <td>
            <select name="coach">
                <c:forEach var="row" items="${Reg}">
                    <option value="${row}">${row}</option>
                    </c:forEach>
            </select>
              
         </td>
        </tr>
        <tr>
            
            <td>
               <input type="submit" value="submit" name="submit" />   
            </td>
        </tr>
    </form>
         </table>         
            </div>
 </div>
        <div id="data2">
        <a href="index.jsp"><img src="images/download.jpg" ></a>  
        </div>
</div> 
    
    </body>
</html>
