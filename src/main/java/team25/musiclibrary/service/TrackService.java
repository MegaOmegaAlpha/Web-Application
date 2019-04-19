package team25.musiclibrary.service;

import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team25.musiclibrary.dao.TrackDAO;
import team25.musiclibrary.entities.Track;

import javax.sql.DataSource;

@Service("trackService")
public class TrackService {

    @Autowired
    DataSource dataSource;
    private String url = "jdbc:mysql://localhost:3306/music_store?serverTimezone=UTC";
    private String userName = "root";
    private String password = "B291098b";
    @Autowired
    TrackDAO trackDAO;

    @Transactional
    public Iterable getAll() {
        return trackDAO.findAll();
    }

    @Transactional
    public Track getTrack(int id) {
        return trackDAO.findById(id).get();
    }

    @Transactional
    public void addTrack(Track track) {
        trackDAO.save(track);
    }

    @Transactional
    public void updateTrack(Track track) {
        trackDAO.save(track);
    }

    @Transactional
    public void deleteTrack(int id) {
        trackDAO.deleteById(id);
    }

    @Transactional
    public List<Track> findAllByArtists_AgeBetween(Integer from, Integer to){
        return trackDAO.findAllByArtists_AgeBetween(from, to);
    }
    @Transactional
    public List<Track> findAllByGenres_RatingLike(Integer rating){
        return trackDAO.findAllByGenres_RatingLike(rating);
    }

    @Transactional
    public List<Track> findByParameters(String name, String album, Time duration) {
        return trackDAO.findAllByNameOrAlbumOrDuration(name, album, duration);
    }
}
