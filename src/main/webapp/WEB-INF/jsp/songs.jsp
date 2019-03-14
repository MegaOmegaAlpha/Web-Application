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
</head>
<body>
<main>
    <form>
        <input type="text" name="name" placeholder="Name"/>
        <input type="text" name="album" placeholder="Album"/>
        <input type="time" name="duration" placeholder="Duration"/>
        <input type="text" name="artistName" placeholder="Name of artist"/>
        <input type="text" name="genreName" placeholder="Name of genre"/>
        <button type="submit">Search</button>
    </form>
    <a href="/songs/newSong">Add new song</a>
    <table border="1">
        <thead>
        <tr>
            <th>Name</th>
            <th>Album</th>
            <th>Duration</th>
            <th>Artist</th>
            <th>Genre</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Song> songList = (List<Song>) request.getAttribute("songs");
            for (Song song : songList) {
                out.print("<tr>");
                out.print("<td rowspan=\"2\">" + song.getName() + "</td>");
                out.print("<td rowspan=\"2\">" + song.getAlbum() + "</td>");
                out.print("<td rowspan=\"2\">" + song.getDuration() + "</td>");
                out.print("<td rowspan=\"2\"><a>" + song.getArtist().getName() + "</a></td>");
                out.print("<td rowspan=\"2\"><a>" + song.getGenre().getName() + "</a></td>");
                out.print("<td rowspan=\"2\"><a href=\"/songs/song?id=" + song.getId() + "\">" + "Edit" + "</a><br><a>Remove</a></td>");
                out.print("</tr>");
            }
        %>
        </tbody>
    </table>
</main>
</body>
</html>
