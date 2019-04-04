package exec;

import modelForTraining.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
import java.time.LocalTime;
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
        model.addAttribute("song", songRepository.findById(Integer.parseInt(id)).get());
        List<Artist> artists = (List<Artist>) artistRepository.findAll();
        List<Genre> genres = (List<Genre>) genreRepository.findAll();
        model.addAttribute("artists", artists);
        model.addAttribute("genres", genres);
        return "songUpdateCreate";
    }

    @PostMapping("/song")
    String updateSong(@RequestParam String songName, @RequestParam String songAlbum,
                      @RequestParam String songDuration, @RequestParam List<String> songArtistIdList,
                      @RequestParam List<String> songGenreIdList, @RequestParam String id, HttpServletResponse response) {
        if (songName != null && songAlbum != null && songDuration != null && songArtistIdList != null &&
                songGenreIdList != null && id != null) {
            Song song = songRepository.findById(Integer.parseInt(id)).get();
            song.setName(songName);
            song.setAlbum(songAlbum);
            song.setDuration(LocalTime.parse(songDuration));
            /*song.setArtist(artistRepository.findById(Integer.parseInt(songArtistId)).get());
            song.setGenre(genreRepository.findById(Integer.parseInt(songGenreId)).get());*/
            for (String artistId : songArtistIdList) {
                song.getArtists().add(artistRepository.findById(Integer.parseInt(artistId)).get());
            }
            for (String genreId : songGenreIdList) {
                song.getGenres().add(genreRepository.findById(Integer.parseInt(genreId)).get());
            }
            songRepository.save(song);
            try {
                response.sendRedirect("/songs");
                return null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "songUpdateCreate";
    }

    @GetMapping("/newSong")
    String addSong(Model model) {
        model.addAttribute("genres", genreRepository.findAll());
        model.addAttribute("artists", artistRepository.findAll());
        return "songUpdateCreate";
    }

    @GetMapping("/search")
    String getSongsWithParameters(@RequestParam String name, String album,
                                  @RequestParam String duration, @RequestParam String artistName,
                                  @RequestParam String genreName, Model model) {
        name = name == null ? "" : name;
        album = album == null ? "" : album;
        artistName = artistName == null ? "" : artistName;
        genreName = genreName == null ? "" : genreName;
        LocalTime durationTime = duration.equals("") ? LocalTime.MIN : LocalTime.parse(duration);
        /*if (!name.equals("") || !album.equals("") || !durationTime.equals(LocalTime.MIN)) {
            model.addAttribute("songs", songRepository.findByParams(name, album, durationTime, artistName, genreName));
        }*/
        return "songs";
    }

    @GetMapping("/songArtists")
    String getArtistsOfSong(@RequestParam String id, Model model) {
        model.addAttribute("artists", songRepository.findById(Integer.parseInt(id)).get().getArtists());
        return "songArtists";
    }

    @GetMapping("/songGenres")
    String getGenresOfSong(@RequestParam String id, Model model) {
        model.addAttribute("genres", songRepository.findById(Integer.parseInt(id)).get().getGenres());
        return "songGenres";
    }
}
