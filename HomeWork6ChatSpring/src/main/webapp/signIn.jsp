<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*" %>

<html>
 <head>
   <title>TheBestChat</title>
   <meta charset="utf-8">
 </head>
 <body>
    <h1>The Best Chat ENTER</h1>
    <form action="inchat" method="POST">
        Login: <input type="text" name="login" />
        Password: <input type="password" name="password" />
        <input type="submit" value="OK" />
        </form>

    <br/>

    <form action="signUp" method="GET">
        <input type="submit" value="Registration">
        </form>
 </body>
</html>