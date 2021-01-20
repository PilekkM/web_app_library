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
            xhr.open("PUT", "http://localhost:8080/books/",true);
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.send(JSON.stringify({
                "title":document.getElementById("title").value,
                "authorId":document.getElementById("author_select").value,
                "quantity":document.getElementById("quantity").value,
                "bookId":document.getElementById("book_id").value,
                "inRental":document.getElementById("in_rental").value
            }));
            xhr.onload=function(){
                window.location.href = "http://localhost:8080/books";
            };
        }
    </script>
    <head>
        <title>Update book</title>
    </head>

    <body>
        <center>
        <ul>
            <li><a href="http://localhost:8080/users">List of users</a></li>
            <li><a href="http://localhost:8080/books">List of books</a></li>
            <li><a href="http://localhost:8080/authors">List of authors</a></li>
            <li><a href="http://localhost:8080/books/rental"> List of rentals </a></li>
        </ul>
        <label>Title</label> <input id="title" type="text" value = "${book.title}"/>
        <label> Author </label>
        <select id="author_select">
            <c:forEach items="${authors}" var="iter_author">
                <option value="${iter_author.id}" ${book.author.id == iter_author.id ? 'selected' : ''}>${iter_author.names} ${iter_author.surname}</option>
            </c:forEach>
        </select>
        <label> Quantity </label> <input id="quantity" type="number" value="${book.quantity}"/>
        <label> In rental </label> <input id="in_rental" type="number" value="${book.inRental}"/>
        <input id="book_id" type="hidden" value=${book.id} />
        <button onclick="update()"> Update book </button>
        </center>
    </body>
</html>