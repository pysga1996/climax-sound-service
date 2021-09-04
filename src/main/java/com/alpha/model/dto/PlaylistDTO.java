package com.alpha.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Collection;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"user", "songs"}, allowGetters = true)
public class PlaylistDTO {

    private Long id;

    @NotBlank
    private String title;

    private String username;

    private Collection<SongDTO> songs;
}
