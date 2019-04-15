<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: bairamov-vladimir
  Date: 29.03.19
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="style/style.css" type="text/css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        body {
            background-color: #fdeeff;
        }
        table {
            background-color: white;
        }
    </style>
</head>
<body>
<main class="m-3">
    <div class="container-fluid">
        <div class="row">
            <div class="col">

            </div>
            <div class="col text-center">
                <h1>"${track.name}"'s collection of genres</h1>
            </div>
            <div class="col">

            </div>
        </div>
    </div>
    <div class="container-fluid text-center">
        <div class="row">
            <div class="col text-right">
                <div class="btn-group-vertical mr-3">
                    <a href="/" class="btn btn-light mb-2">Home</a>
                    <a href="/artists" class="btn btn-light mb-2">Artists</a>
                    <a href="/tracks" class="btn btn-light mb-2">Songs</a>
                </div>
            </div>
            <div class="col-5">
                <table class="table text-center">
                    <thead class="thead-light">
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Rating</th>
                        <th scope="col">Tracks' collection</th>
                        <th scope="col">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="genre" items="${genres}">
                        <tr>
                            <td><c:out value="${genre.name}"/></td>
                            <td><c:out value="${genre.rating}"/></td>
                            <td><a href="/genreTracks?id=${genre.id}">Tracks' collection</a></td>
                            <td><a class="btn btn-outline-warning mr-2" href="/updateGenre/${genre.id}">Edit</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col">

            </div>
        </div>
    </div>
</main>
</body>
</html>
