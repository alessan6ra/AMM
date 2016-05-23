<%-- 
    Document   : tabella_oggetti
    Created on : 22-mag-2016, 19.06.01
    Author     : alessandra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <table>
<tr class="titolotab">
<th>Nome </th>
<th> Foto</th>
<th> Quantità</th>  
<th>Prezzo</th>
<th>Compra</th>
</tr>


 <c:forEach items="${ListaOggetti}" var="Oggetto">
 <tr>
                    <td>${Oggetto.getNomeOgg()}</td>
                    <td>${Oggetto.nomeogg}</td>
                    <td>${Oggetto.NomeOgg}</td>
</tr>
                </c:forEach>
        </table>
    </body>
</html>
