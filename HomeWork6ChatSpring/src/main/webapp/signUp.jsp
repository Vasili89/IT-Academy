<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*" %>

<html>
 <head>
   <title>TheBestChat</title>
   <meta charset="utf-8">
 </head>
 <body>
    <h1>The Best Chat Registration</h1>
    <form action="regchat" method="POST">
        Full Name: <input type="text" name="FIO" />
        Date of birth: <input type="date" name="birthDate" />
        Login: <input type="text" name="login" />
        Password: <input type="password" name="password" />
        <input type="submit" value="Registration" />
        </form>

    <br/>

    <form action="signIn" method="GET">
            <input type="submit" value="Entry">
            </form>
    <br>
    <img height="300" width="300" src="https://www.it-academy.by/local/images/logo.svg">
 </body>
</html>