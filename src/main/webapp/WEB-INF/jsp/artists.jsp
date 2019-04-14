<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 12.03.2019
  Time: 0:13
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
            <div class="col-5">
                <form class="form-inline">
                    <input type="text" name="name" placeholder="Name" class="form-control mb-2 mr-sm-2"/>
                    <input type="text" name="age" placeholder="Age" class="form-control mb-2 mr-sm-2"/>
                    <button type="submit" class="btn btn-light mb-2 mr-sm-2">Search</button>
                </form>
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
                    <a href="/tracks" class="btn btn-light mb-2">Tracks</a>
                    <a href="/genres" class="btn btn-light mb-2">Genres</a>
                </div>
            </div>
            <div class="col-5">
                <table class="table text-center">
                    <thead class="thead-light">
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Age</th>
                        <th scope="col">Tracks' collection</th>
                        <th scope="col">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="artist" items="${listOfArtists}">
                        <tr>
                            <td><c:out value="${artist.name}"/></td>
                            <td><c:out value="${artist.age}"/></td>
                            <td><a href="/ad?id=${artist.id}">Tracks' collection</a></td>
                            <td><a class="btn btn-outline-warning mr-2" href="<c:url value="/artist/${artist.id}"/>">Edit</a><a href="/deleteArtist?id=${artist.id}" class="btn btn-outline-danger">Remove</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <a href="/addArtist" class="btn btn-success mb-2">Add new artist</a>
            </div>
            <div class="col">

            </div>
        </div>
    </div>
</main>
</body>
</html>
