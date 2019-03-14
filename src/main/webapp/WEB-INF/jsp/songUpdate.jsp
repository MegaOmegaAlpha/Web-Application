<%@ page import="modelForTraining.Song" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 12.03.2019
  Time: 0:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<main>
    <%
        Song song = (Song) request.getAttribute("song");
    %>
    <form method="post">
        <input type="text" name="songName" value=<%out.print("\"" + song.getName() + "\"");%> />
        <input type="text" name="songAlbum" value=<%out.print("\"" + song.getAlbum() + "\"");%> />
        <input type="number" name="songDuration" value=<%out.print("\"" + song.getDuration() + "\"");%> />
        <input type="text" name="songArtist" value=<%out.print("\"" + song.getArtist().getName() + "\"");%> />
        <input type="text" name="songGenre" value=<%out.print("\"" + song.getGenre().getName() + "\"");%> />
        <button type="submit" name=<%out.print("\"" + song.getId() + "\"");%>>Confirm</button>
        <%
            /*updating song with current id*/
        %>
    </form>
</main>
</body>
</html>
