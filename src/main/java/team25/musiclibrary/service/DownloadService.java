package team25.musiclibrary.service;

import com.thoughtworks.xstream.XStream;
import team25.musiclibrary.entities.Artist;
import team25.musiclibrary.entities.Genre;
import team25.musiclibrary.entities.Track;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DownloadService {

    public static String downloadTrack(Track track) {
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
