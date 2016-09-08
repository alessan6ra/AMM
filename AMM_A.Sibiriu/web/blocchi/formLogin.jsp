<%-- 
    Document   : formLogin
    Created on : 5-set-2016, 18.57.25
    Author     : Alessandra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<form method="post" action="Login"> <!--Inizia form di login-->
            
    <div>
        <label for="username"> Username: </label>
        <input type="text" name="Username" id="username" />
        <label for="password"> Password: </label>
        <input type="password" name="Password" id="password" />
    </div>
            
    <div class="padding">
        <input class="submitlog" type="submit" value="Login" name="Submit" />
    </div>

</form><!--Finisce form di login-->
