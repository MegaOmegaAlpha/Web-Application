<%@ page import="java.util.List" %>
<%@ page import="modelForTraining.Artist" %>
<%@ page import="modelForTraining.Song" %><%--
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
</head>
<body>
<main>
    <form>
        <input type="text" name="name" placeholder="Name"/>
        <input type="number" name="age" placeholder="Age"/>
        <button type="submit">Search</button>
    </form>
    <a href="/artists/newArtist">Add new artist</a>
    <table border="1">
        <thead>
        <tr>
            <th>Name</th>
            <th>Age</th>
            <th>Songs</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <%
            /*List<Artist> will be handled*/
            List<Artist> artists = (List<Artist>) request.getAttribute("artists");
            for (Artist artist : artists) {
                out.print("<tr>");
                out.print("<td rowspan=\"\">" + artist.getName() + "</td>");
                out.print("<td rowspan=\"\">" + artist.getAge() + "</td>");
                out.print("<td rowspan=\"\"><a href=\"/songs/search?name=&album=&duration=&artistName=" + artist.getName() + "&genreName=\">Song's collection</a></td>");
                out.print("<td rowspan=\"\"><a href=\"/artists/artist?id=" + artist.getId() + "\">" + "Edit" + "</a><br><a>Remove</a></td>");
                out.print("</tr>");
            }
        %>
        </tbody>
    </table>
</main>
</body>
</html>
