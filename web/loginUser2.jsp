
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <link rel="stylesheet" type="text/css" href="style.css">
        
        <title>System Login Page</title>
    </head>
    <body>
        <div id="data">
        <div id="data6">
         <thead>
                <tr>
                    <h2>System Login</h2>
                    

         
      <table border="0">
            
            <tbody>
                <tr>
                    <td>
                       <form method="POST" action="LoginServlet2">                
                            <table border="0">
                                
                                <tbody>
                                    <tr>
                                        <td><label for="userName"> User Name: </label></td>
                                        <td><input id="userName" name="userName" type="text" style="height:45px; width:200px"/><br/></td>
                                        
                               
                                    </tr>
                                    <tr>
                                        <td> <label for="pass"> Password:  </label></td>
                                        <td><input id="pass" name="pass" type="text"style="height:45px; width:200px"/><br/></td>
                                        
                               
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
