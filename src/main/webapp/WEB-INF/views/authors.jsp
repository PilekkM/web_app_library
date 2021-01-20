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
        function submitform(id_input,names_input,surname_input)
        {
            var xhr = new XMLHttpRequest();
            xhr.open("DELETE", "http://localhost:8080/authors", true);
            xhr.setRequestHeader('Content-Type', 'application/json');
            xhr.send(JSON.stringify({
                'id': id_input,
                'names': names_input,
                'surname': surname_input
            }));
            window.alert(names_input + " deleted!");
            location.reload();
        }
    </script>
    <head>
        <title>List of authors</title>
    </head>

    <body>
        <center>
        <ul>
            <li><a href="http://localhost:8080/users">List of users</a></li>
            <li><a href="http://localhost:8080/books">List of books</a></li>
            <li><a href="http://localhost:8080/books/rental"> List of rentals </a></li>
        </ul>
        <table>
            <tr>
                <th>Names</th>
                <th>Surname</th>
            </tr>
            <c:forEach var="author" items="${authors}">
                <tr>
                    <td>${author.names}</td>
                    <td>${author.surname}</td>
                    <td><a href="javascript: submitform(${author.id}, '${author.names}', '${author.surname}')"> Delete </a></td>
                    <td><a href="http://localhost:8080/authors/update/${author.id}"> Update </a></td>
                </tr>
            </c:forEach>
        </table>
        <a href="http://localhost:8080/authors/new">Add new author</a>
        </center>
    </body>
</html>