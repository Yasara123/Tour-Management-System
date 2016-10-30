<%-- 
    Document   : index
    Created on : 04-Apr-2015, 22:55:54
    Author     : Yas
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<sql:query var="route" dataSource="jdbc/ABCD">
    SELECT route_ID FROM route
</sql:query>
    

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="style.css">
 
        <title>ReceptionPage</title>
    </head>
    <body>
        <h1>Reception</h1>
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
                        <form method="POST" action="ReceptionServelet">                  
                            <table border="0">
                                <thead>
                                    <tr>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><strong>Date(Ex:"18-04-2015"):</strong></td>
                                        <td><input type="text" name="Date" /></td>
                                        
                               
                                    </tr>
                                    <tr>
                                        <td><strong>Customer Name:</strong></td>
                                        <td><input type="text" name="name" /></td>
                                        
                               
                                    </tr>
                                    <tr>
                                        <td><strong>No.Of.Days:</strong></td>
                                        <td><input type="text" name="duration_days" /></td>
                                        
                               
                                    </tr>
                                    <tr>
                                        <td><strong>TourRef:</strong></td>
                                        <td><input type="text" name="TourRef" /></td>
                                    </tr>
                                    <tr>
                                        <td> <strong>CustomerNIC:</strong></td>
                                        <td><input type="text" name="CustomerNIC"  /></td>
                                    </tr>
                                    <tr>
                                        <td><strong>ContactNo:</strong></td>
                                        <td> <input type="text" name="ContactNo"  />  </td>
                                    </tr>
                                    <tr>
                                        <td><strong>Email:</strong></td>
                                        <td><input type="text" name="Email" /></td>
                                    </tr>
                                    <tr>
                                        <td><strong>Route:</strong></td>
                                        <td>
                                             <select name="Route">
                                             <c:forEach var="row" items="${route.rowsByIndex}">
                                            <c:forEach var="column" items="${row}">
                                            <option value="<c:out value="${column}"/>"><c:out value="${column}"/></option>
                                            </c:forEach>
                                            </c:forEach>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><strong>StartDate(Ex:"18-04-2015"):</strong></td>
                                        <td> <input type="text" name="StartDate"  /></td>
                                    </tr>
                                   
                                    <tr>
                                        <td> <strong>No.People:</strong></td>
                                        <td> <input type="text" name="No_People"  /></td>
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
                            SELECT route_ID,RouteName,Price FROM route
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
