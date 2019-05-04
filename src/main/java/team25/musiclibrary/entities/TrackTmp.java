package team25.musiclibrary.entities;

import com.thoughtworks.xstream.annotations.XStreamAlias;


@XStreamAlias("Track")
public class TrackTmp {

    @XStreamAlias("name")
    private String name;
    @XStreamAlias("album")
    private String album;

//    @XStreamAlias("duration")
//    private Time duration;

//    public TrackTmp(String name, String album, Time duration) {
//        this.name = name;
//        this.album = album;
//        this.duration = duration;
//    }

    public TrackTmp(){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
//
//    public Time getDuration() {
//        return duration;
//    }
//
//    public void setDuration(Time duration) {
//        this.duration = duration;
//    }
}
