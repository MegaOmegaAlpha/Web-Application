package team25.musiclibrary.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import team25.musiclibrary.entities.Artist;

import java.util.List;

@Repository
public interface ArtistDAO extends CrudRepository<Artist, Integer> {

    List<Artist> findAllByNameOrAge(String name, int age);

}
