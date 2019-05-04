package team25.musiclibrary.dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import team25.musiclibrary.entities.Track;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface TrackDAO extends CrudRepository<Track, Integer> {

    List<Track> findAllByArtists_AgeBetween(Integer from, Integer to);

    @Query(value = "SELECT t.id, t.name, t.album, t.duration " +
            "FROM track t " +
            "INNER JOIN genre_track gt " +
            "ON t.id = gt.track_id " +
            "INNER JOIN genre g " +
            "ON gt.genre_id = g.id " +
            "WHERE g.rating = ?1", nativeQuery = true   )
    List<Track> findAllByGenres_RatingLike( Integer rating);

    List<Track> findAllByNameOrAlbumOrDuration(String name, String album, LocalTime duration);
}
