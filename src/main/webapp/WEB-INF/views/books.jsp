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
        <title>List of books</title>
    </head>
    <script type="text/javascript">
                function submitform(id_input, title_input)
                {
                    var xhr = new XMLHttpRequest();
                    xhr.open("DELETE", "http://localhost:8080/demo/books", true);
                    xhr.setRequestHeader('Content-Type', 'application/json');
                    xhr.send(JSON.stringify({
                        'id': id_input
                    }));
                    window.alert(title_input + " deleted!");
                    location.reload();
                }
    </script>
    <body>
        <ul>
            <li><a href="http://localhost:8080/demo/authors">List of authors</a></li>
            <li><a href="http://localhost:8080/demo/users">List of users</a></li>
            <li><a href="http://localhost:8080/demo/books/rental"> List of rentals </a></li>
        </ul>
        <table>
            <tr>
                <th>Title</th>
                <th>Author</th>
                <th>Quantity</th>
                <th>In rental</th>
            </tr>
            <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.title}</td>
                    <td>${book.author.names} ${book.author.surname}</td>
                    <td>${book.quantity}</td>
                    <td>${book.inRental}</td>
                    <td><a href="javascript:submitform(${book.id}, '${book.title}')"> Delete </a></td>
                    <td><a href="http://localhost:8080/demo/books/update/${book.id}"> Update </a></td>
                </tr>
            </c:forEach>
        </table>
        <a href="http://localhost:8080/demo/books/new"> Add new book </a>
    </body>
</html>