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
        function submitform(id_input,name_input,surname_input, age_input, personal_id_input)
        {
            var xhr = new XMLHttpRequest();
            xhr.open("DELETE", "http://localhost:8080/demo/users", true);
            xhr.setRequestHeader('Content-Type', 'application/json');
            xhr.send(JSON.stringify({
                'id': id_input,
                'name': name_input,
                'surname': surname_input,
                'age': age_input,
                'personal_id': personal_id_input
            }));
            window.alert(name_input + " deleted!");
            location.reload();
        }
    </script>
    <head>
        <title>List of users</title>
    </head>

    <body>
        <ul>
            <li><a href="http://localhost:8080/demo/authors">List of authors</a></li>
            <li><a href="http://localhost:8080/demo/books">List of books</a></li>
            <li><a href="http://localhost:8080/demo/books/rental"> List of rentals </a></li>
        </ul>
        <table>
            <tr>
                <th>Name</th>
                <th>Surname</th>
                <th>Personal ID</th>
                <th>Age</th>
            </tr>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.name}</td>
                    <td>${user.surname}</td>
                    <td>${user.personalId}</td>
                    <td>${user.age}</td>
                    <td><a href="javascript:submitform(${user.id}, '${user.name}', '${user.surname}', ${user.age}, '${user.personalId}')"> Delete </a></td>
                    <td><a href="http://localhost:8080/demo/users/update/${user.id}"> Update </a></td>
                </tr>
            </c:forEach>
        </table>
        <a href="http://localhost:8080/demo/users/new"> Add new user </a>
    </body>
</html>