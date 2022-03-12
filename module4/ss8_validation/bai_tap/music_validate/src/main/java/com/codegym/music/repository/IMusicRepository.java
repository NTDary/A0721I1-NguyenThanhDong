package com.codegym.music.repository;

import com.codegym.music.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IMusicRepository extends JpaRepository<Music, Long> {
//    Page<Music> findAll(Pageable pageable);
}
