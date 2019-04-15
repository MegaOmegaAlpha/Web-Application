<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: bairamov-vladimir
  Date: 29.03.19
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/style/style.css" type="text/css">
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
                <h1>${artist.name}'s collection of tracks</h1>
            </div>
            <div class="col">

            </div>
        </div>
    </div>
    <hr>
    <div class="container-fluid text-center">
        <div class="row">
            <div class="col-sm-">
                <div class="btn-group-vertical mr-3">
                    <a href="/" class="btn btn-light mb-2">Home</a>
                    <a href="/artists" class="btn btn-light mb-2">Back</a>
                    <a href="/tracks" class="btn btn-light mb-2">Tracks</a>
                    <a href="/genres" class="btn btn-light mb-2">Genres</a>
                </div>
            </div>
            <div class="col">
                <table class="table text-center">
                    <thead class="thead-light">
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Album</th>
                        <th scope="col">Duration</th>
                        <th scope="col">Artist</th>
                        <th scope="col">Genre</th>
                        <th scope="col">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="track" items="${tracks}">
                        <tr>
                            <td>${track.name}</td>
                            <td>${track.album}</td>
                            <td>${track.duration}</td>
                            <td><a href="/tracks/trackArtists?id=${track.id}">Artists' collection</a></td>
                            <td><a href="/tracks/trackGenres?id=${track.id}">Genres' collection</a></td>
                            <td><a href="/updateTrack/${track.id}" class="btn btn-outline-warning mr-2">Edit</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</main>
</body>
</html>
