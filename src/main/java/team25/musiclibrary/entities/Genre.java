package team25.musiclibrary.entities;


import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "genre")
@Table(name = "genre", schema = "music_store", catalog = "")
@XStreamAlias("Genre")
public class Genre{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XStreamOmitField
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "rating")
    private int rating;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "genres")
    @XStreamOmitField
    private List<Track> tracks = new ArrayList<>();

    @Transient
    @XStreamAlias("Tracks")
    List<TrackTmp> trackTmps;

    public List<TrackTmp> getTrackTmps() {
        return trackTmps;
    }

    public Genre(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    public Genre() {
    }

    public void setTrackTmps(List<TrackTmp> trackTmps) {
        this.trackTmps = trackTmps;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void initToDownload(){
        trackTmps = new ArrayList<>();
        for (Track track : tracks) {
            TrackTmp trackTmp = new TrackTmp();
            trackTmp.setName(track.getName());
            trackTmp.setAlbum(track.getAlbum());
            trackTmps.add(trackTmp);
        }
    }
}
