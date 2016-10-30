<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : booking
    Created on : Apr 3, 2015, 1:20:24 AM
    Author     : Dulan
--%>
<sql:query var="newentryforschedulig" dataSource="jdbc/ABCD">
    SELECT tour_ID FROM newentryforschedulig 
</sql:query>

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
            <div class="amanda">
                <form action="DriverSelection" method="POST" > 
        <strong>Select Tour:</strong>
            <select name="tourCode">
               <c:forEach var="row" items="${newentryforschedulig.rows}">
               <option value="${row.tour_ID}">${row.tour_ID}</option>
               </c:forEach>    
            <input type="submit" value="submit" name="submit" />
         </select>
        <p></p>
         <p></p>
        <sql:query var="result" dataSource="jdbc/ABCD">
            SELECT tour_ID,Enter_Date,individualNIC FROM tourentry where tour_ID in (SELECT tour_ID FROM newentryforbooking)
        </sql:query>
    
        <table border="1">
            <!-- column headers -->
            <tr>
                <c:forEach var="columnName" items="${result.columnNames}">
                    <th><c:out value="${columnName}"/></th>
                    </c:forEach>
            </tr>
            <!-- column data -->
            <c:forEach var="row" items="${result.rowsByIndex}">
                <tr>
                    <c:forEach var="column" items="${row}">
                        <td><c:out value="${column}"/></td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>
        </form> 
            </div>    
 </div>
        <div id="data2">
        <a href="index.jsp"><img src="images/download.jpg" ></a>  
        </div>
</div>      
</body>
</html>
