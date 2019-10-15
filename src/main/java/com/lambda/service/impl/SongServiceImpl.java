package com.lambda.service.impl;

import com.lambda.model.entity.Artist;
import com.lambda.model.entity.Like;
import com.lambda.model.entity.Song;
import com.lambda.repository.PeopleWhoLikedRepository;
import com.lambda.repository.SongRepository;
import com.lambda.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {
    @Autowired
    SongRepository songRepository;

    @Autowired
    PeopleWhoLikedRepository peopleWhoLikedRepository;

    @Autowired
    UserDetailServiceImpl userDetailService;

    @Autowired
    AudioStorageService audioStorageService;

    @Override
    public Page<Song> findAllByUploader_Id(Long id, Pageable pageable) {
        return songRepository.findAllByUploader_Id(id, pageable);
    }

    @Override
    public Optional<Song> findById(Long id) {
        return songRepository.findById(id);
    }

    @Override
    public Iterable<Song> findAllByTitle(String title) {
        return songRepository.findAllByTitle(title);
    }

    @Override
    public Iterable<Song> findAllByTitleContaining(String name) {
        return songRepository.findAllByTitleContaining(name);
    }

    @Override
    public Page<Song> findAll(Pageable pageable) {
        return songRepository.findAll(pageable);
    }

    @Override
    public Page<Song> findAllByTitleContaining(String name, Pageable pageable) {
        return songRepository.findAllByTitleContaining(name, pageable);
    }

    @Override
    public Page<Song> findAllByArtistsContains(Artist artist, Pageable pageable) {
        return songRepository.findAllByArtistsContains(artist, pageable);
    }

    @Override
    public Page<Song> findAllByTag_Name(String name, Pageable pageable) {
        return songRepository.findAllByTag_Name(name, pageable);
    }

    @Override
    public Iterable<Song> findAllByAlbum_Id(Long id) {
        return songRepository.findAllByAlbum_Id(id);
    }

    @Override
    public Song save(Song song) {
        songRepository.saveAndFlush(song);
        return song;
    }

    @Override
    public Boolean deleteById(Long id) {
        Optional<Song> song = songRepository.findById(id);
        if (song.isPresent()) {
            songRepository.deleteById(id);
            String fileUrl = song.get().getUrl();
            String filename = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
            return audioStorageService.deleteLocalStorageFile(audioStorageService.audioStorageLocation, filename);
        }
        return false;
    }

    @Override
    public void deleteAll(Collection<Song> songs) {
        songRepository.deleteAll(songs);
    }
    @Override
    public void setFields(Song oldSongInfo,Song newSongInfo){
        oldSongInfo.setTitle(newSongInfo.getTitle());
        oldSongInfo.setArtists(newSongInfo.getArtists());
        oldSongInfo.setGenres(newSongInfo.getGenres());
        oldSongInfo.setCountry(newSongInfo.getCountry());
        oldSongInfo.setReleaseDate(newSongInfo.getReleaseDate());
        oldSongInfo.setTags(newSongInfo.getTags());
        oldSongInfo.setTheme(newSongInfo.getTheme());
    }

    @Override
    public Page<Song> sortByDate(Pageable pageable) {
        return null;
    }

    @Override
    public boolean hasUserLiked(Long songId) {
        Long userId = userDetailService.getCurrentUser().getId();
        Like peopleWhoLikeds = peopleWhoLikedRepository.findBySongIdAndUserId(songId, userId);
//        Long size = StreamSupport.stream(peopleWhoLikeds.spliterator(), false).count();
        return (peopleWhoLikeds != null);
    }

    @Override
    public Page<Song> setLike(Page<Song> songList) {
        for (Song song: songList) {
            if (hasUserLiked(song.getId())) {
                song.setLiked(true);
            } else {
                song.setLiked(false);
            }
        }
        return songList;
    }



}
