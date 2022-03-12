package com.codegym.music.service.impl;

import com.codegym.music.model.Music;
import com.codegym.music.repository.IMusicRepository;
import com.codegym.music.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository iMusicRepository;


    @Override
    public Page<Music> findAll(Pageable pageable) {
        return iMusicRepository.findAll(pageable);
    }

    @Override
    public Optional<Music> findById(Long id) {
        return iMusicRepository.findById(id);
    }

    @Override
    public void save(Music music) {
        iMusicRepository.save(music);
    }

    @Override
    public void remove(Long id) {
        iMusicRepository.deleteById(id);
    }


    @Override
    public List<Music> findAllMusic() {
        return iMusicRepository.findAll();
    }
}
