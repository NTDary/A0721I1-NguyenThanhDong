package com.codegym.music.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Max(value = 800)
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "vui lòng không sử dụng ký tự đặc biệt")
    private String nameMusic;

    @NotBlank
    @Max(value = 300)
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "vui lòng không sử dụng ký tự đặc biệt")
    private String nameArtist;

    @NotBlank
    @Max(value = 1000)
    @Pattern(regexp = "^[a-zA-Z0-9-,]*$", message = "vui lòng không sử dụng ký tự đặc biệt")
    private String kindOfMusic;

    public Music() {
    }

    public Music(Long id, String nameMusic, String nameArtist, String kindOfMusic) {
        this.id = id;
        this.nameMusic = nameMusic;
        this.nameArtist = nameArtist;
        this.kindOfMusic = kindOfMusic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameMusic() {
        return nameMusic;
    }

    public void setNameMusic(String nameMusic) {
        this.nameMusic = nameMusic;
    }

    public String getNameArtist() {
        return nameArtist;
    }

    public void setNameArtist(String nameArtist) {
        this.nameArtist = nameArtist;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }
}
