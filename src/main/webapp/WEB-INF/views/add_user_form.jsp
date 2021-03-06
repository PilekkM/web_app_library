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
        <center>
        <ul>
            <li><a href="http://localhost:8080/users">List of users</a></li>
            <li><a href="http://localhost:8080/books">List of books</a></li>
            <li><a href="http://localhost:8080/authors"> List of authors</a></li>
            <li><a href="http://localhost:8080/books/rental"> List of rentals </a></li>
        </ul>
        <form action="new" method="post">
            <label>Name</label> <input type="text" name="name"/>
            <label>Surname</label> <input type="text" name="surname"/>
            <label>Personal id</label> <input type="text" name="personal_id"/>
            <label>Age</label> <input type="number" name="age"/>
            <input type="submit" value="Add user">
        </form>
        </center>
    </body>
</html>