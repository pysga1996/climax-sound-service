package com.alpha.service;

import com.alpha.model.dto.ArtistDTO;
import com.alpha.model.dto.ArtistSearchDTO;
import java.io.IOException;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface ArtistService {

    Optional<ArtistDTO> findById(Long id);

    ArtistDTO findByName(String name);

    Page<ArtistDTO> findByConditions(Pageable pageable, ArtistSearchDTO artistSearchDTO);

    Page<ArtistDTO> findAll(Pageable pageable);

    ArtistDTO create(ArtistDTO artist, MultipartFile multipartFile);

    ArtistDTO update(Long id, ArtistDTO artist, MultipartFile multipartFile) throws IOException;

    void deleteById(Long id);
}
