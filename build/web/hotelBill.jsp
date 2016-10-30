<%-- 
    Document   : index
    Created on : 04-Apr-2015, 22:55:54
    Author     : Yas
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<sql:query var="hotel" dataSource="jdbc/ABCD">
    SELECT town_ID FROM hotel
</sql:query>
    


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="style2.css">
 
        <title>HotelBill</title>
    </head>
    <body>
        <h1>Welcome To Dream Tours</h1>
         <div id="data">
        <div id="data1">
        <table border="0">
            <thead>
                <tr>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <form method="POST" action="finals">                  
                            <table border="0">
                                <thead>
                                    <tr>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><strong>billDate(Ex:"18-04-2015"):</strong></td>
                                        <td><input type="text" name="billDate" /></td>
                                        
                               
                                    </tr>
                                    <tr>
                                        <td><strong>billRef:</strong></td>
                                        <td><input type="text" name="billRef" /></td>
                                        
                               
                                    </tr>
                                    <tr>
                                        <td><strong>email:</strong></td>
                                        <td><input type="text" name="email" /></td>
                                        
                               
                                    </tr>
                                    <tr>
                                        <td><strong>no of DatesUsed:</strong></td>
                                        <td><input type="text" name="no_of_DatesUsed" /></td>
                                    </tr>
                                    <tr>
                                        <td> <strong>noOfpersons:</strong></td>
                                        <td><input type="text" name="noOfpersons"  /></td>
                                    </tr>
                
                                    <tr>
                                        <td><strong>Hotel town ID:</strong></td>
                                        <td>
                                             <select name="hotel">
                                             <c:forEach var="row" items="${hotel.rowsByIndex}">
                                            <c:forEach var="column" items="${row}">
                                            <option value="<c:out value="${column}"/>"><c:out value="${column}"/></option>
                                            </c:forEach>
                                            </c:forEach>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><strong>Amount:</strong></td>
                                        <td> <input type="text" name="StartDate"  /></td>
                                    </tr>
                                   
                                    
                                </tbody>
                            </table>
                         
                             <input type="submit" value="submit"  />
                            
                            
                        </form>
                       
                    </td>
                </tr>
               
            </tbody>
        </table>
</div>
        <div id="data2">
         <sql:query var="list" dataSource="jdbc/ABCD">
                            SELECT town_ID,hotel_name FROM hotel
                        </sql:query>
    
                        <table border="0">
                            <!-- column headers -->
                            <tr>
                                <c:forEach var="columnName" items="${list.columnNames}">
                                    <th><h4><c:out value="${columnName}"/></h4></th>
                                    </c:forEach>
                                    
                            </tr>
                            <!-- column data -->
                            <c:forEach var="row" items="${list.rowsByIndex}">
                                <tr>
                                    <c:forEach var="column" items="${row}">
                                        <td><c:out value="${column}"/></td>
                                    </c:forEach>
                                </tr>
                            </c:forEach>
                        </table> 
        </div>
             <div id="data3">
                 <a href="index.jsp"><img src="images/download.jpg" ></a>
             </div> 
</div>
    </body>
</html>
