<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.List" %>
<%@ page import="team25.musiclibrary.entities.Artist" %>
<%@ page import="team25.musiclibrary.entities.Genre" %>
<%@ page import="team25.musiclibrary.entities.Track" %>
<%--Created by IntelliJ IDEA.--%>
  <%--User: User--%>
  <%--Date: 12.03.2019--%>
  <%--Time: 0:35--%>
  <%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
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
        Track track = (Track) request.getAttribute("track");
        List<Artist> artists = (List<Artist>) request.getAttribute("artistList");
        List<Genre> genres = (List<Genre>) request.getAttribute("genreList");
        String operation = (String) request.getAttribute("operation");
    %>
    <div class="container">
        <div class="row">
            <div class="col">

            </div>
            <div class="col text-center">
                <h1>${operation} track</h1>
            </div>
            <div class="col">

            </div>
        </div>
        <div class="col">

        </div>
    </div>
    <hr>
    <div class="container-fluid">
        <div class="row">
            <div class="col text-right">
                <div class="btn-group-vertical mr-3">
                    <a href="/tracks" class="btn btn-light mb-2">Back</a>
                    <a href="/" class="btn btn-light mb-2">Home</a>
                    <a href="/artists" class="btn btn-light mb-2">Artists</a>
                    <a href="/genres" class="btn btn-light mb-2">Genres</a>
                </div>
            </div>
            <div class="col text-center">
                <form method="post">
                    <div class="form-row">
                        <div class="form-group col">
                            <label for="trackNameId">Name</label>
                            <input type="text" name="name" id="trackNameId" required="required" class="form-control" value="<c:out value="${track.name}" default=""/>" placeholder="Name"/>
                        </div>
                        <div class="form-group col">
                            <label for="trackAlbumId">Album</label>
                            <input type="text" name="album" id="trackAlbumId" required="required" class="form-control" value="<c:out value="${track.album}" default=""/>" placeholder="Album"/>
                        </div>
                        <div class="form-group col">
                            <label for="trackDurationId">Duration</label>
                            <input type="time" step="1" name="duration" id="trackDurationId" class="form-control" value="<c:out value="${track.duration}" default=""/>"/>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col" id="artist-col-id">
                            <label for="trackArtistId">Artists</label>
                            <div class="selector" id="selector-id">
                                <%
                                    if (track.getArtists() != null) {
                                        for (Artist artistItem : track.getArtists()) {
                                            out.print("<select name=\"artistIdList\" id=\"trackArtistId\" class=\"form-control mb-2\"");
                                            for (Artist artist : artists) {
                                                String selected = track != null && artistItem.getId() == artist.getId() ? "selected" : "";
                                                out.print("<option " + selected + " value=\"" + artist.getId() + "\">");
                                                out.print(artist.getName() + ", " + artist.getAge());
                                                out.print("</option>");
                                            }
                                            out.print("</select>");
                                        }
                                    }
                                    if(operation.equals("Create")){
                                        out.print("<select name=\"artistIdList\" id=\"trackArtistId\" class=\"form-control mb-2\"");
                                        for (Artist artist : artists) {

                                            out.print("<option \"\" value=\"" + artist.getId() + "\">");
                                            out.print(artist.getName() + ", " + artist.getAge());
                                            out.print("</option>");
                                        }
                                        out.print("</select>");
                                    }
                                %>
                            </div>
                            <button type="button" class="btn btn-success" onclick="addField(this)" name="0">+</button>
                        </div>
                        <div class="form-group col">
                            <label for="trackGenreId">Genre</label>
                            <div class="selector">
                                <%
                                    if (track.getGenres() != null) {
                                        for (Genre genreItem : track.getGenres()) {
                                            out.print("<select type=\"text\" name=\"genreIdList\" id=\"trackGenreId\" class=\"form-control mb-2\">");
                                            for (Genre genre : genres) {
                                                String selected = track != null && genreItem.getId() == genre.getId() ? "selected" : "";
                                                out.print("<option " + selected + " value=\"" + genre.getId() + "\">");
                                                out.print(genre.getName() + "," + genre.getRating());
                                                out.print("</option>");
                                            }
                                            out.print("</select>");
                                        }
                                    }
                                    if(operation.equals("Create")){
                                        out.print("<select type=\"text\" name=\"genreIdList\" id=\"trackGenreId\" class=\"form-control mb-2\">");
                                        for (Genre genre : genres) {
                                            out.print("<option \"\" value=\"" + genre.getId() + "\">");
                                            out.print(genre.getName() + "," + genre.getRating());
                                            out.print("</option>");
                                        }
                                        out.print("</select>");
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
