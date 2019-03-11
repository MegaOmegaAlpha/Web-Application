package exec;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/artists")
public class ArtistsController {

    @GetMapping("")
    String getArtists(Model model) {
        return "artists";
    }

    @GetMapping("/artist")
    String updateGenre(@RequestParam String id, Model model) {
        return "artistUpdate";
    }

    @GetMapping("/newArtist")
    String addArtist(Model model) {
        return "artistUpdate";
    }

}
