<%@ page import="java.util.List" %>
<%@ page import="modelForTraining.Genre" %>
<%@ page import="modelForTraining.Song" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 12.03.2019
  Time: 0:20
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
        <input type="text" name="rating" placeholder="Rating"/>
        <button type="submit">Search</button>
    </form>
    <a href="/genres/newGenre">Add new genre</a>
    <table border="1">
        <thead>
        <tr>
            <th>Name</th>
            <th>Rating</th>
            <th>Songs</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <%
            /*List<Genre> will be handled*/
            List<Genre> genreList = (List<Genre>) request.getAttribute("genres");
            for (Genre genre : genreList) {
                out.print("<tr>");
                out.print("<td rowspan=\"2\">" + genre.getName() + "</td>");
                out.print("<td rowspan=\"2\">" + genre.getRating() + "</td>");
                out.print("<td rowspan=\"2\"><select>");
                for (Song song : genre.getSongList()) {
                    out.print("<option>" + song.getName() + "</option>");
                }
                out.print("</select></td>");
                out.print("<td rowspan=\"2\"><a href=\"/songs/song?id=" + genre.getId() + "\">" + "Edit" + "</a><br><a>Remove</a></td>");
                out.print("</tr>");
            }
        %>
        </tbody>
    </table>
</main>
</body>
</html>
