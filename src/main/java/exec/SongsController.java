package exec;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongsController {

    @GetMapping("")
    String getSongs(Model model) {
        List<String> strings = new ArrayList<>();
        strings.add("song1"); strings.add("song2");
        model.addAttribute("songs", strings);
        return "songs";
    }

    @GetMapping("/song")
    String updateSong(@RequestParam String id, Model model) {
        return "songUpdate";
    }

    @GetMapping("/newSong")
    String addSong(Model model) {
        return "songUpdate";
    }
}
