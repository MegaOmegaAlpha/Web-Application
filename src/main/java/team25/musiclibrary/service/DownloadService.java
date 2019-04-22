package team25.musiclibrary.service;

import com.thoughtworks.xstream.XStream;
import team25.musiclibrary.entities.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DownloadService {

    public static String downloadTrack(Track track) {
        List<Artist> artistList = track.getArtists();
        List<Genre> genreList = track.getGenres();
        List<GenreTmp> genreTmps = new ArrayList<>();
        List<ArtistTmp> artistTmps = new ArrayList<>();
        for (Artist artist : artistList) {
            ArtistTmp artistTmp = new ArtistTmp();
            artistTmp.setName(artist.getName());
            artistTmps.add(artistTmp);
        }
        for (Genre genre : genreList) {
            GenreTmp  genreTmp = new GenreTmp(genre.getName());
            genreTmps.add(genreTmp);
        }
        track.setArtistTmps(artistTmps);
        track.setGenreTmps(genreTmps);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(track.getName()).append(" ").append(track.getAlbum()).append(".xml");
        File file = new File(stringBuilder.toString());
        XStream stream = new XStream();
        stream.autodetectAnnotations(true);
        try {
            stream.toXML(track, new FileWriter(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static String downloadArtist(Artist artist) {
        return  null;
    }

    public static String downloadGenre(Genre genre) {
        return null;
    }

}
