package com.alpha.model.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Collection;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode()
@JsonIgnoreProperties(value = {"albums", "songs", "avatarResource", "avatarUrl"},
    allowGetters = true, ignoreUnknown = true)
public class ArtistDTO {

    private Long rn;

    private Long id;

    @NotBlank
    private String name;

    @JsonIgnore
    private String unaccentName;

    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private Date birthDate;

    private String avatarUrl;

    private ResourceInfoDTO avatarResource;

    private String biography;

    @JsonBackReference(value = "song-artist")
    private Collection<SongDTO> songs;

    @JsonBackReference(value = "album-artist")
    private Collection<AlbumDTO> albums;
}
