package team25.musiclibrary.entities;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

@XStreamAlias("Artist")
public class ArtistTmp implements Serializable {

    @XStreamAlias("name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
