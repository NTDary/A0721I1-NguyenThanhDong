package com.codegym.service;

import com.codegym.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> showAll();
    void save(Music product);
    Music findById(int id);
    void delete(int id);
    List<Music> findByName(String name);
}
