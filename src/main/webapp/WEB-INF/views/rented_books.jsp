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
    <script type="text/javascript">
        function submitform(id_input, book_id_input, user_id_input, return_date)
        {
            var xhr = new XMLHttpRequest();
            xhr.open("DELETE", "http://localhost:8080/books/rental", true);
            xhr.setRequestHeader('Content-Type', 'application/json');
            xhr.send(JSON.stringify({
                'id': id_input,
                'book_id': book_id_input,
                'user_id': user_id_input,
                'return_date': return_date
            }));
            window.alert("Rental deleted!");
            location.reload();
        }
    </script>
    <head>
        <title>List of books rental</title>
    </head>
    <body>
        <center>
        <ul>
            <li><a href="http://localhost:8080/authors">List of authors</a></li>
            <li><a href="http://localhost:8080/users">List of users</a></li>
            <li><a href="http://localhost:8080/books">List of books</a></li>
        </ul>
        <table>
            <tr>
                <th>User name</th>
                <th>Book title</th>
                <th>Book author</th>
                <th>Return date</th>
            </tr>
            <c:forEach var="rent_book" items="${rented_books}">
                <tr>
                    <td>${rent_book.user.name} ${rent_book.user.surname}</td>
                    <td>${rent_book.book.title}</td>
                    <td>${rent_book.book.author.names} ${rent_book.book.author.surname}</td>
                    <td>${rent_book.returnDate}</td>
                    <td><a href="javascript:submitform(${rent_book.id}, ${rent_book.book.id}, ${rent_book.user.id})"> Delete </a></td>
                </tr>
            </c:forEach>
        </table>
        <a href="http://localhost:8080/books/rental/new"> Rent a book </a>
        </center>
    </body>
</html>