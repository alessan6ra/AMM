<%-- 
    Document   : tabellaJson
    Created on : 31-ago-2016, 17.55.41
    Author     : Alessandra
--%>

<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@page contentType="application/json" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<json:array>
    <c:forEach var="oggetto" items="${listaOggetti}">
        <json:object>
            <json:property name="nome" value="${oggetto.getNome()}"/>
            <json:property name="url" value="${oggetto.getUrl()}"/>
            <json:property name="pezzi" value="${oggetto.getPezzi()}"/>
            <json:property name="prezzo" value="${oggetto.getPrezzo()}"/>
        </json:object>
    </c:forEach>
</json:array>