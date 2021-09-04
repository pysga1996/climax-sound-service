package com.alpha.model.entity;

import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "theme")
public class Theme {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "theme_id_gen")
    @SequenceGenerator(name = "theme_id_gen", sequenceName = "theme_id_seq", allocationSize = 1)
    @ToString.Include
    private Integer id;

    @NotBlank
    @Column(unique = true, nullable = false)
    @ToString.Include
    private String name;

    @OneToMany(mappedBy = "theme", fetch = FetchType.LAZY)
    @Fetch(value = FetchMode.SUBSELECT)
    private Collection<Song> songs;

//    @OneToMany(mappedBy = "theme", fetch = FetchType.LAZY)
//    @Fetch(value = FetchMode.SUBSELECT)
//    private Collection<Album> albums;

}
