package exec;

import modelForTraining.ArtistRepository;
import modelForTraining.GenreRepository;
import modelForTraining.Song;
import modelForTraining.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongsController {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private GenreRepository genreRepository;

    @GetMapping("")
    String getSongs(Model model) {
        List<Song> songList = (List<Song>) songRepository.findAll();
        model.addAttribute("songs", songList);
        return "songs";
    }

    @GetMapping("/song")
    String updateSong(@RequestParam String id, Model model) {
        model.addAttribute("song", songRepository.findById(Integer.parseInt(id)).orElse(null));
        return "songUpdate";
    }

    @PostMapping("/song")
    String updateSong(@RequestParam String songName, @RequestParam String songAlbum,
                      @RequestParam String songDuration, @RequestParam String songArtist,
                      @RequestParam String songGenre, @RequestParam String id, HttpServletResponse response) {
        if (songName != null && songAlbum != null && songDuration != null && songArtist != null &&
        songGenre != null && id != null) {
            Song song = songRepository.findById(Integer.parseInt(id)).orElse(null);
            song.setName(songName);
            song.setAlbum(songAlbum);
            song.setDuration(Integer.parseInt(songDuration));
            song.setArtist(artistRepository.findByName(songArtist));
            song.setGenre(genreRepository.findByName(songGenre));
            songRepository.save(song);
            try {
                response.sendRedirect("/songs");
                return null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "songUpdatex";
    }

    @GetMapping("/newSong")
    String addSong(Model model) {
        return "songUpdate";
    }
}
