<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11.03.2019
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        body {
            background-color: #fdeeff;
        }
        .card {
            margin-top: 15%;
        }
    </style>
</head>
<body>
<main>
    <div class="container">
        <div class="card text-center">
            <div class="card-header">
                <h1>Welcome!</h1>
            </div>
            <div class="card-body">
                <h2 class="card-title">This is our simple web application</h2>
                <p class="card-text">Here you can do what you want</p>
                <div class="btn-group-vertical">
                    <a href="/tracks" class="btn btn-light">Tracks</a>
                    <a href="/artists" class="btn btn-light">Artists</a>
                    <a href="/genres" class="btn btn-light">Genres</a>
                    <a href="/findByArtistAge?ageMin=0&ageMax=0" class="btn btn-light">Hard query #1 (by artist age)</a>
                    <a href="/findAllByGenres_RatingLike?rating=0" class="btn btn-light">Hard query #2 (by genre rating)</a>
                </div>
            </div>
            <div class="card-footer text-muted">
                By Vladimir and Pavel
            </div>
        </div>
    </div>
</main>
</body>
</html>
