<%@ page import="modelForTraining.Song" %>
<%@ page import="modelForTraining.Artist" %>
<%@ page import="java.util.List" %>
<%@ page import="modelForTraining.Genre" %><%--
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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<main class="m-3">
    <%
        Song song = (Song) request.getAttribute("song");
        List<Artist> artists = (List<Artist>) request.getAttribute("artists");
        List<Genre> genres = (List<Genre>) request.getAttribute("genres");
    %>
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
                <form method="post">
                    <div class="form-row">
                        <div class="form-group col">
                            <label for="songNameId">Title</label>
                            <input type="text" name="songName" id="songNameId" class="form-control" value="<%=song.getName()%>"/>
                        </div>
                        <div class="form-group col">
                            <label for="songAlbumId">Album</label>
                            <input type="text" name="songName" id="songAlbumId" class="form-control" value="<%=song.getAlbum()%>"/>
                        </div>
                        <div class="form-group col">
                            <label for="songDurationId">Duration</label>
                            <input type="time" name="songName" id="songDurationId" class="form-control" value="<%=song.getDuration()%>"/>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col">
                            <label for="songArtistId">Artist</label>
                            <select name="songName" id="songArtistId" class="form-control">
                                <%
                                    for (Artist artist : artists) {
                                        String selected = song.getArtist().getId() == artist.getId() ? "selected" : "";
                                        out.print("<option" + selected +" value=\"" + artist.getId() + "\">");
                                        out.print(artist.getName());
                                        out.print("</option>");
                                    }
                                %>
                            </select>
                        </div>
                        <div class="form-group col">
                            <label for="songGenreId">Genre</label>
                            <select type="text" name="songName" id="songGenreId" class="form-control">
                                <%
                                    for (Genre genre : genres) {
                                        String selected = song.getArtist().getId() == genre.getId() ? "selected" : "";
                                        out.print("<option" + selected +" value=\"" + genre.getId() + "\">");
                                        out.print(genre.getName());
                                        out.print("</option>");
                                    }
                                %>
                            </select>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-success">Confirm</button>
                </form>
            </div>
        </div>
    </div>
</main>
</body>
</html>
