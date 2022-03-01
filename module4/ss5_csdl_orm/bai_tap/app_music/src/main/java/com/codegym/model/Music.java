package com.codegym.model;

import javax.persistence.*;

@Entity
@Table
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String singer;
    private String type;
    private String link;

    public Music() {
    }

    public Music(String name, String singer, String type, String link) {
        this.name = name;
        this.singer = singer;
        this.type = type;
        this.link = link;
    }

    public Music(long id, String name, String singer, String type, String link) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.type = type;
        this.link = link;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
