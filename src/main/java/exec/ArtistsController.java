package exec;

import modelForTraining.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/artists")
public class ArtistsController {

    @Autowired
    private ArtistRepository artistRepository;

    @GetMapping("")
    String getArtists(Model model) {
        model.addAttribute("artists", artistRepository.findAll());
        return "artists";
    }

    @GetMapping("/artist")
    String updateGenre(@RequestParam String id, Model model) {
        model.addAttribute("artist", artistRepository.findById(Integer.parseInt(id)).get());
        return "artistUpdateCreate";
    }

    @GetMapping("/newArtist")
    String addArtist(Model model) {
        return "artistUpdateCreate";
    }

    @GetMapping("/artistSongs")
    String songsOfArtist(@RequestParam String id, Model model) {
        model.addAttribute("songs", artistRepository.findById(Integer.parseInt(id)).get().getSongList());
        return "artistSongs";
    }

}
