package com.codegym.music.service;

import com.codegym.music.model.Music;
import com.codegym.music.repository.IMusicRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface IMusicService {
    Page<Music> findAll(Pageable pageable);
    Optional<Music> findById(Long id);
    void save(Music customer);
    void remove(Long id);
    List<Music> findAllMusic();
}
