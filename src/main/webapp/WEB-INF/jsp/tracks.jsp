<%@ page import="java.util.List" %>
<%@ page import="team25.musiclibrary.entities.Track" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11.03.2019
  Time: 23:38
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
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body class="m-3">
<main>
    <div class="container">
        <div class="row">
            <div class="col">

            </div>
            <div class="col text-center">
                <h1>Tracks data</h1>
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
            <div class="col- text-center">
                <form class="form-inline">
                    <input type="text" name="name" placeholder="Name" class="form-control mb-2 mr-sm-2"/>
                    <input type="text" name="album" placeholder="Album" class="form-control mb-2 mr-sm-2"/>
                    <input type="time" name="duration" placeholder="Duration" class="form-control mb-2 mr-sm-2"/>
                    <button type="submit" class="btn btn-light mb-2 mr-sm-2">Search</button>
                </form>
            </div>
            <div class="col">

            </div>
        </div>
    </div>
    <div class="container-fluid text-center">
        <div class="row">
            <div class="col-sm-">
                <div class="btn-group-vertical mr-3">
                    <a href="/" class="btn btn-light mb-2">Home</a>
                    <a href="/artists" class="btn btn-light mb-2">Artists</a>
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
                    <%
                        List<Track> trackList = (List<Track>) request.getAttribute("listOfTracks");
                        if (trackList != null) {
                            for (Track track : trackList) {
                                out.print("<tr>");
                                out.print("<td rowspan=\"\">" + track.getName() + "</td>");
                                out.print("<td rowspan=\"\">" + track.getAlbum() + "</td>");
                                out.print("<td rowspan=\"\">" + track.getDuration() + "</td>");
                                out.print("<td rowspan=\"\"><a href=\"/tracks/trackArtists?id=" + track.getId() + "\">" + "Artists' collection" + "</a></td>");
                                out.print("<td rowspan=\"\"><a href=\"/tracks/trackGenres?id=" + track.getId() + "\">" + "Genres' collection" + "</a></td>");
                                out.print("<td rowspan=\"\"><a href=\"/updateTrack/" + track.getId() + "\" class=\"btn btn-outline-warning mr-2\">" + "Edit" + "</a><a href=\"/deleteTrack?id=" + track.getId() + "\" class=\"btn btn-outline-danger\">Remove</a></td>");
                                out.print("</tr>");
                            }
                        }
                    %>
                    </tbody>
                </table>
                <a href="/addTrack" class="btn btn-success mb-2">Add new track</a>
            </div>
        </div>
    </div>
</main>
</body>
</html>
