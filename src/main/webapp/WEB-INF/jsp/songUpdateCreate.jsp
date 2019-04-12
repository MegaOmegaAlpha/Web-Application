<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.List" %>
<%@ page import="team25.musiclibrary.entities.Artist" %>
<%@ page import="team25.musiclibrary.entities.Genre" %>
<%@ page import="team25.musiclibrary.entities.Track" %>
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
    <%
        Track song = (Track) request.getAttribute("song");
        List<Artist> artists = (List<Artist>) request.getAttribute("artistList");
        List<Genre> genres = (List<Genre>) request.getAttribute("genreList");
    %>
    <div class="container-fluid">
        <div class="row">
            <div class="col text-right">
                <div class="btn-group-vertical mr-3">
                    <a href="/songs" class="btn btn-light mb-2">Back</a>
                    <a href="/" class="btn btn-light mb-2">Home</a>
                    <a href="/artists" class="btn btn-light mb-2">Artists</a>
                    <a href="/genres" class="btn btn-light mb-2">Genres</a>
                </div>
            </div>
            <div class="col text-center">
                <form method="post" action="/saveTrack">
                    <div class="form-row">
                        <div class="form-group col">
                            <label for="songNameId">Title</label>
                            <input type="text" name="songName" id="songNameId" class="form-control" value="<%=(song == null ? "" : song.getName())%>"/>
                        </div>
                        <div class="form-group col">
                            <label for="songAlbumId">Album</label>
                            <input type="text" name="songAlbum" id="songAlbumId" class="form-control" value="<%=(song == null ? "" : song.getAlbum())%>"/>
                        </div>
                        <div class="form-group col">
                            <label for="songDurationId">Duration</label>
                            <input type="time" name="songDuration" id="songDurationId" class="form-control" value="<%=(song == null ? "" : song.getDuration())%>"/>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col" id="artist-col-id">
                            <label for="songArtistId">Artists</label>
                            <div class="selector" id="selector-id">
                                <%
                                    if (song.getArtists() != null) {
                                        for (Artist artistItem : song.getArtists()) {
                                            out.print("<select name=\"songArtistIdList\" id=\"songArtistId\" class=\"form-control mb-2\"");
                                            for (Artist artist : artists) {
                                                String selected = song != null && artistItem.getId() == artist.getId() ? "selected" : "";
                                                out.print("<option " + selected + " value=\"" + artist.getId() + "\">");
                                                out.print(artist.getName() + ", " + artist.getAge());
                                                out.print("</option>");
                                            }
                                            out.print("</select>");
                                        }
                                    }
                                %>
                            </div>
                            <button type="button" class="btn btn-success" onclick="addField(this)" name="0">+</button>
                        </div>
                        <div class="form-group col">
                            <label for="songGenreId">Genre</label>
                            <div class="selector">
                                <%
                                    if (song.getGenres() != null) {
                                        for (Genre genreItem : song.getGenres()) {
                                            out.print("<select type=\"text\" name=\"songGenreIdList\" id=\"songGenreId\" class=\"form-control mb-2\">");
                                            for (Genre genre : genres) {
                                                String selected = song != null && genreItem.getId() == genre.getId() ? "selected" : "";
                                                out.print("<option " + selected + " value=\"" + genre.getId() + "\">");
                                                out.print(genre.getName());
                                                out.print("</option>");
                                            }
                                            out.print("</select>");
                                        }
                                    }
                                %>
                            </div>
                            <button type="button" class="btn btn-success" onclick="addField(this)" name="0">+</button>
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
<script type="text/javascript">
    function addField(btn) {
        /*
        var select = document.getElementById('songArtistId');
        var clone = select.cloneNode(true);
        document.getElementsByClassName('selector')[0].appendChild(clone);
         */
        var parentOfSelect = btn.previousElementSibling;
        var select = parentOfSelect.children[0];
        var clone = select.cloneNode(true);
        parentOfSelect.appendChild(clone);
    }
</script>
</body>
</html>
