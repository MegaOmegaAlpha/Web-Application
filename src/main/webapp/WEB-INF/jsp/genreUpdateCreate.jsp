<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 12.03.2019
  Time: 0:46
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
    </style>
</head>
<body>
<main class="m-3">
    <div class="container-fluid">
        <div class="row">
            <div class="col text-right">
                <div class="btn-group-vertical mr-3">
                    <a href="/getAllGenres" class="btn btn-light mb-2">Back</a>
                    <a href="/" class="btn btn-light mb-2">Home</a>
                    <a href="/getAllArtists" class="btn btn-light mb-2">Artists</a>
                    <a href="/getAllTracks" class="btn btn-light mb-2">Songs</a>
                </div>
            </div>
            <div class="col text-center">
                <form method="post">
                    <div class="form-row">
                        <div class="form-group col">
                            <label for="songNameId">Name</label>
                            <input type="text" placeholder="Name" name="name" id="songNameId" class="form-control" value="<c:out value="${genre.name}" default=""/>"/>
                        </div>
                        <div class="form-group col">
                            <label for="songAlbumId">Rating</label>
                            <input type="text" placeholder="Rating" name="rating" id="songAlbumId" class="form-control" value="<c:out value="${genre.rating}" default=""/>"/>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-success">Confirm</button>
                </form>
            </div>
            <div class="col">

            </div>
        </div>
    </div>
</main>
</body>
</html>
