package modelForTraining;

import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Integer> {

    Genre findByName(String name);

}
