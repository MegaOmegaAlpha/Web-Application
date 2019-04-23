package team25.musiclibrary.entities;


import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "artist")
@Table(name = "artist", schema = "music_store", catalog = "")
@XStreamAlias("Artist")
public class Artist{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @XStreamOmitField
    private int id;
    @Column(name = "name")
    @XStreamAlias("name")
    private String name;
    @Column(name = "age")
    @XStreamAlias("age")
    private int age;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "artists")
    @XStreamOmitField
    private List<Track> tracks = new ArrayList<>();

    @Transient
    @XStreamAlias("Tracks")
    List<TrackTmp> trackTmps;

    public void setTrackTmps(List<TrackTmp> trackTmps) {
        this.trackTmps = trackTmps;
    }

    public List<TrackTmp> getTrackTmps() {
        return trackTmps;
    }

    public Artist(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Artist() {
    }

    public List<Track> getTracks() {
        return tracks;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
