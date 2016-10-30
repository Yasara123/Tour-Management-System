

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Login Page</title>
    </head>
    <body>

        <h1>Tour Management System</h1>
        <div id="data">
        <div id="data5">
        <table border="0">
            <thead>
                <tr>
                    <th><p>System Login</p></th>
    </tr>
</thead>
<tbody>
    <tr>
        <td> <form method="POST" action="AdminServlet">
                <input type="submit"  value="admin" name="submit1" style="height:45px; width:200px" />
                <p></p>
                <p></p>
            </form>
             <form method="POST" action="LoginServlet1">
                <input type="submit"  value="Reception" name="submit1" style="height:45px; width:200px" />
                <p></p>
                <p></p>
            </form>
            <form method="POST" action="LoginServlet2">
                <input type="submit"  value="Driver and Coach Reservation" name="submit2" style="height:45px; width:200px" />
                <p></p>
                <p></p>
            </form>
            <form  method="POST" action="LoginServlet">
                <input type="submit"  value="Hotel Booking and Reservations" name="submit2" style="height:45px; width:200px" />
                
 </form>
       
       
            


        </td>
    </tr>
</tbody>
</table>
<div id="data3">
                 <a href="index.jsp"><img src="images/download.jpg" ></a>
 </div> 
 </div>
             
  </div>

</body>
</html>
