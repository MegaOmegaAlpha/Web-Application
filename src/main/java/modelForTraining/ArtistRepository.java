package modelForTraining;

import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository<Artist, Integer> {

    Artist findByName(String name);

}
