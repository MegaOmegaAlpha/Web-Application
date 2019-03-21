<%@ page import="java.util.List" %>
<%@ page import="modelForTraining.Song" %><%--
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
    <link rel="stylesheet" href="../jsp/style/style.css" type="text/css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body class="m-3">
<main>
    <div>
        <form class="form-inline">
            <input type="text" name="name" placeholder="Name" class="form-control mb-2 mr-sm-2"/>
            <input type="text" name="album" placeholder="Album" class="form-control mb-2 mr-sm-2"/>
            <input type="time" name="duration" placeholder="Duration" class="form-control mb-2 mr-sm-2"/>
            <input type="text" name="artistName" placeholder="Name of artist" class="form-control mb-2 mr-sm-2"/>
            <input type="text" name="genreName" placeholder="Name of genre" class="form-control mb-2 mr-sm-2"/>
            <button type="submit" class="btn btn-light mb-2 mr-sm-2">Search</button>
        </form>
    </div>
    <div class="container-fluid">
        <div class="row">
            <div class="column">
                <div class="btn-group-vertical mr-3">
                    <a href="/songs" class="btn btn-light mb-2">Songs</a>
                    <a href="/artists" class="btn btn-light mb-2">Artists</a>
                    <a href="/genres" class="btn btn-light mb-2">Genres</a>
                </div>
            </div>
            <div class="column">
                <table class="table" style="text-align: center">
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
                        List<Song> songList = (List<Song>) request.getAttribute("songs");
                        if (songList != null) {
                            for (Song song : songList) {
                                out.print("<tr>");
                                out.print("<td rowspan=\"\">" + song.getName() + "</td>");
                                out.print("<td rowspan=\"\">" + song.getAlbum() + "</td>");
                                out.print("<td rowspan=\"\">" + song.getDuration() + "</td>");
                                out.print("<td rowspan=\"\"><a>" + song.getArtist().getName() + "</a></td>");
                                out.print("<td rowspan=\"\"><a>" + song.getGenre().getName() + "</a></td>");
                                out.print("<td rowspan=\"\"><a href=\"/songs/song?id=" + song.getId() + "\" class=\"btn btn-outline-warning mr-2\">" + "Edit" + "</a><a class=\"btn btn-outline-danger\">Remove</a></td>");
                                out.print("</tr>");
                            }
                        }
                    %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</main>
</body>
</html>
