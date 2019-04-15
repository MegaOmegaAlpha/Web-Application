<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 16.04.2019
  Time: 2:47
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
<body class="m-3">
<main>
    <div class="container-fluid">
        <div class="row">
            <div class="col">

            </div>
            <div class="col text-center">
                <h1>Here you can find any track by genre's rating</h1>
            </div>
            <div class="col">

            </div>
        </div>
    </div>
    <hr>
    <div class="container-fluid">
        <div class="row">
            <div class="col">

            </div>
            <div class="col">

            </div>
            <div class="col">
                <form class="form-inline">
                    <input type="text" name="rating" placeholder="Rating" class="form-control mb-2 mr-sm-2" required/>
                    <button type="submit" class="btn btn-light mb-2 mr-sm-2">Search</button>
                </form>
            </div>
            <div class="col">

            </div>
            <div class="col">

            </div>
        </div>
    </div>
    <div class="container-fluid text-center">
        <div class="row">
            <div class="col-sm- text-right">
                <div class="btn-group-vertical mr-3">
                    <a href="/genres" class="btn btn-light mb-2">Back</a>
                    <a href="/" class="btn btn-light mb-2">Home</a>
                    <a href="/artists" class="btn btn-light mb-2">Artists</a>
                    <a href="/tracks" class="btn btn-light mb-2">Tracks</a>
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
                    <c:forEach var="track" items="${listOfTracks}">
                        <tr>
                            <td>${track.name}</td>
                            <td>${track.album}</td>
                            <td>${track.duration}</td>
                            <td><a href="/tracks/trackArtists?id=${track.id}">Artists' collection</a></td>
                            <td><a href="/tracks/trackGenres?id=${track.id}">Genres' collection</a></td>
                            <td>
                                <a class="btn btn-outline-warning mr-2" href="/updateTrack/${track.id}">Edit</a>
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
