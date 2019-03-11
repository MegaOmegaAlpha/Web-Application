package exec;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/genres")
public class GenresController {

    @GetMapping("")
    String getGenres(Model model) {
        return "genres";
    }

    @GetMapping("/genre")
    String updateGenre(@RequestParam String id, Model model) {
        return "genreUpdate";
    }

    @GetMapping("/newGenre")
    String addArtist(Model model) {
        return "genreUpdate";
    }

}
