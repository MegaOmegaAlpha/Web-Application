package team25.musiclibrary.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import team25.musiclibrary.entities.Genre;

import java.util.List;

@Repository
public interface GenreDAO extends CrudRepository<Genre, Integer> {

    List<Genre> findAllByNameOrRating(String name, int rating);

}
