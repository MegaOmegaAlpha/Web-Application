package modelForTraining;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface SongRepository extends CrudRepository<Song, Integer> {

    @Query("from Song as s where s.name =:name or s.album =:album or s.duration =:duration or s.artist.name =:artistName or s.genre.name =:genreName")
    List<Song> findByParams(String name, String album, LocalTime duration, String artistName, String genreName);

}
