package team25.musiclibrary.entities;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Genre")
public class GenreTmp {

    @XStreamAlias("name")
    private String name;

    public GenreTmp(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
