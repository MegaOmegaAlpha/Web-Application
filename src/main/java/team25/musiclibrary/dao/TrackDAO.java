package team25.musiclibrary.dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import team25.musiclibrary.entities.Track;

import java.sql.Connection;
import java.util.List;

@Repository
public interface TrackDAO extends CrudRepository<Track, Integer> {

    List<Track> findAllByArtists_AgeBetween(Integer from, Integer to);
}
