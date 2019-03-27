package exec;

import modelForTraining.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/genres")
public class GenresController {

    @Autowired
    private GenreRepository genreRepository;

    @GetMapping("")
    String getGenres(Model model) {
        model.addAttribute("genres", genreRepository.findAll());
        return "genres";
    }

    @GetMapping("/genre")
    String updateGenre(@RequestParam String id, Model model) {
        model.addAttribute("genre", genreRepository.findById(Integer.parseInt(id)).get());
        return "genreUpdateCreate";
    }

    @GetMapping("/newGenre")
    String addArtist(Model model) {
        return "genreUpdateCreate";
    }

}
