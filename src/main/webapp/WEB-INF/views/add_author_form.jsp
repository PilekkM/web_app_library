<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding ="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C/DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <style>
        table, th, td {
            border: 1px solid black;
        }
        td {
            padding: 10px;
        }
    </style>
    <head>
        <title>List of authors</title>
    </head>

    <body>
        <ul>
            <li><a href="http://localhost:8080/demo/users">List of users</a></li>
            <li><a href="http://localhost:8080/demo/books">List of books</a></li>
            <li><a href="http://localhost:8080/demo/authors"> List of authors</a></li>
            <li><a href="http://localhost:8080/demo/books/rental"> List of rentals </a></li>
        </ul>
        <form action="new" method="post">
            <label>Names</label> <input type="text" name="names"/>
            <label>Surname</label> <input type="text" name="surname"/>
            <input type="submit" value="Add author">
        </form>
    </body>
</html>