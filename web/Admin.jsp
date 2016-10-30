<%-- 
    Document   : Admin
    Created on : 16-Jun-2015, 03:03:02
    Author     : Yas
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <link rel="stylesheet" type="text/css" href="style.css">
        
        <title>Admin Page</title>
    </head>
    <body>
        <div id="data">
        <div id="data6">
         <thead>
                <tr>
                    <h1>System Administration</h1>
                    

         
      <table border="0">
            
            <tbody>
                <tr>
                    <td>
                       <form method="POST" action="AdminServlet">                
                            <table border="0">
                                
                                <tbody>
                                    <tr>
                                        <td><label for="NewItem"> Register new item: </label></td>
                                        <td>
                                        <select name="item">
                                         <option>workers</option>
                                         <option>Route</option>
                                         <option>Change Password</option>
                                        </select></td>    
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
      <div id="data7">      
<div id="data3">
                 <a href="index.jsp"><img src="images/download.jpg" ></a>
 </div>  
          </div>
  </div>
    </body>
</html>
