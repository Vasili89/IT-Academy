<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*" %>

<html>
 <head>
   <title>TheBestChat</title>
   <meta charset="utf-8">
 </head>
 <body>
    <h3><%= "Hello " + session.getAttribute("login") + "! " %> This is The Best chat!</h3>
    <form action="mess" method="POST">
        Send to: <input type="text" name="loginto" />
        <br>
        Message: <input type="textarea" name="message" />
        <input type="submit" value="Send" />
    </form>
        <br>
        <br>
    <form action="chats" method="GET">
        <input type="submit" value="My messages">
    </form>
    <br>
    <form action="exitChat" method="GET">
            <input type="submit" value="Exit">
        </form>
 </body>
</html>