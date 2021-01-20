<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding ="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C/DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <script>
        function update(){
            let xhr = new XMLHttpRequest();
            xhr.open("PUT", "http://localhost:8080/demo/authors/",true);
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.send(JSON.stringify({
                "names":document.getElementById("names").value,
                "authorId":document.getElementById("author_id").value,
                "surname":document.getElementById("surname").value,
            }));
            xhr.onload=function(){
                window.location.href = "http://localhost:8080/demo/authors";
            };
        }
    </script>
    <head>
        <title>Update author</title>
    </head>

    <body>
        <ul>
            <li><a href="http://localhost:8080/demo/users">List of users</a></li>
            <li><a href="http://localhost:8080/demo/books">List of books</a></li>
            <li><a href="http://localhost:8080/demo/authors">List of authors</a></li>
            <li><a href="http://localhost:8080/demo/books/rental"> List of rentals </a></li>
        </ul>
            <label> Names </label> <input id="names" type="text" value = "${author.names}" />
            <label> Surname </label> <input id="surname" type="text" value="${author.surname}" />
            <input id="author_id" type="hidden" value=${author.id} />
            <button onclick="update()"> Update author </button>


    </body>
</html>