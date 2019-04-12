<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: bairamov-vladimir
  Date: 29.03.19
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
    <div class="container-fluid text-center">
        <div class="row">
            <div class="col-sm-">
                <div class="btn-group-vertical mr-3">
                    <a href="/" class="btn btn-light mb-2">Home</a>
                    <a href="/getAllGenres" class="btn btn-light mb-2">Back</a>
                    <a href="/getAllTracks" class="btn btn-light mb-2">Songs</a>
                    <a href="/getAllTracks" class="btn btn-light mb-2">Artists</a>
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
                    <c:forEach var="song" items="${songs}">
                        <tr>
                            <td>${song.name}</td>
                            <td>${song.album}</td>
                            <td>${song.duration}</td>
                            <td><a href="/trackArtists?id=${song.id}">Artists' collection</a></td>
                            <td><a href="/trackGenres?id=${song.id}">Genres' collection</a></td>
                            <td>
                                <a href="/updateTrack/${song.id}" class="btn btn-outline-warning mr-2">Edit</a>
                            </td>
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
