package modelForTraining;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface SongRepository extends CrudRepository<Song, Integer> {

}
