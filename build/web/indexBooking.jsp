<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : index
    Created on : Apr 8, 2015, 6:19:02 AM
    Author     : Nathie
--%>

<h1>Tours to be booked</h1>
<table border="0.5">
    <!-- column headers -->
    <tr>
        <th>Tour Reference No</th>
        <th>Tour Date</th>
    </tr>
    <!-- column data -->
    
    <c:forEach var="row" items="${tours}">
        <tr>

            <td><c:out value="${row}"/></td>
            

        </tr>
    </c:forEach>
</table>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Hotel Bookings</title>
    </head>
    <body>
        <h1> Select a tour reference number</h1>
        <table border="0">
            <thead>
                <tr>
                    <th>select a tour to book the hotels</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td> <form method="POST" action="SelectedTour">
                            <strong>Tour Reference Number:</strong>
                            <select name="ToursSelect">
                                <c:forEach var="row" items="${tours}">
                                    <option><c:out value="${row}"/></option>
                                </c:forEach>
                            </select>
                            <input type="submit" value="submit" name="submit" />
                        </form>
                    </td>
                </tr>

            </tbody>
        </table>


    </body>
</html>
