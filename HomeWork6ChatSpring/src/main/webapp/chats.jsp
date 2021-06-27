<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*, java.text.*, by.it_academy.jd2.core.*" %>

<html>
 <head>
   <title>TheBestChat</title>
   <meta charset="utf-8">
 </head>
 <body>
    <h3>The Best chat!</h3>

    <%= "Messages for " + session.getAttribute("login") + ":" %>

    <br>
    <br>

    <table border="1">
                <tbody>
                            <td width="20%">From user: </td>
                            <td width="20%">Date and time: </td>
                            <td width="20%">Message: </td>
                    <c:forEach items="${requestScope.messages}"
                               var="message">
                        <tr>
                            <td width="20%">${message.userFrom}</td>
                            <td width="20%">${message.messageTime}</td>
                            <td width="20%">${message.message}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

    <br/>

    <form action="message" method="GET">
                <input type="submit" value="Back to Chat">
            </form>

    <form action="exitChat" method="GET">
                <input type="submit" value="Exit">
            </form>
 </body>
</html>