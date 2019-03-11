<%@ page import="java.util.List" %><%--
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
            List<String> stringList = (List<String>) request.getAttribute("songs");
            for (String s : stringList) {
                out.print("<tr>");
                out.print("<td>" + s + "</td>");
                out.print("<td>" + 52 + "</td>");
                out.print("<td><a>" + "Any album" + "</a></td>");
                out.print("<td><a>" + "Any artist" + "</a></td>");
                out.print("<td><a>" + "Any genre" + "</a></td>");
                out.print("<td rowspan=\"2\"><a href=\"/songs/song?id=\">" + "Edit" + "</a><br><a>Remove</a></td>");
                out.print("<tr>");
            }
        %>
        </tbody>
    </table>
</main>
</body>
</html>
