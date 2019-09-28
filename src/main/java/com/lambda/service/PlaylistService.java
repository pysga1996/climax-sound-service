package com.lambda.service;

import com.lambda.model.entity.Playlist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface PlaylistService {
    Optional<Playlist> findById(Long id);
    Page<Playlist> findAll(Pageable pageable);
    Page<Playlist> findAllByNameContaining(String name, Pageable pageable);
    void save(Playlist playlist);
    void deleteById(Long id);
}
