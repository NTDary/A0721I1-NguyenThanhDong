package com.codegym.service;

import com.codegym.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> showAll();
    void save(Music product);
    Music findById(Long id);
    void delete(Long id);
    List<Music> findByName(String name);
}
