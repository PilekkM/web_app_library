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
    <script>
        function update(){
            let xhr = new XMLHttpRequest();
            xhr.open("PUT", "http://localhost:8080/users/",true);
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.send(JSON.stringify({
                "userId":document.getElementById("user_id").value,
                "name":document.getElementById("name").value,
                "surname":document.getElementById("surname").value,
                "age":document.getElementById("age").value,
                "personalId":document.getElementById("personal_id").value
            }));
            xhr.onload=function(){
                window.location.href = "http://localhost:8080/users";
            };
        }
    </script>
    <head>
        <title>Update user</title>
    </head>

    <body>
        <center>
        <ul>
            <li><a href="http://localhost:8080/users">List of users</a></li>
            <li><a href="http://localhost:8080/books">List of books</a></li>
            <li><a href="http://localhost:8080/authors">List of authors</a></li>
            <li><a href="http://localhost:8080/books/rental"> List of rentals </a></li>
        </ul>
        <label>Name </label> <input id="name" type="text" value = "${user.name}"/>
        <label>Surname </label> <input id="surname" type="text" value = "${user.surname}"/>
        <label>Personal ID </label> <input id="personal_id" type="text" value = "${user.personalId}"/>
        <label>Age </label> <input id="age" type="number" value="${user.age}"/>
        <input id="user_id" type="hidden" value=${user.id} />
        <button onclick="update()"> Update user </button>
        </center>
    </body>
</html>