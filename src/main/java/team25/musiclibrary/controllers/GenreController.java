package team25.musiclibrary.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import team25.musiclibrary.entities.Artist;
import team25.musiclibrary.entities.Genre;
import team25.musiclibrary.service.DownloadService;
import team25.musiclibrary.service.GenreService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class GenreController {

    @Autowired
    GenreService genreService;

    @GetMapping("/genres")
    public String getGenres(Model model){
        List<Genre> genreList = genreService.getAll();
        model.addAttribute("genre", new Genre());
        model.addAttribute("listOfGenres", genreList);
        return "jsp/genres";
    }
    @GetMapping(value = "/genres/genre", headers = "Accept=application/json")
    public Genre getGenreById(@PathVariable int id) {
        return genreService.getGenre(id);
    }

    @GetMapping("/addGenre")
    public String addGenrePage(Model model) {
        model.addAttribute("operation", "Create");
        return "jsp/genreUpdateCreate";
    }

    @PostMapping(value = "/addGenre", headers = "Accept=application/json")
    public String addGenre(@RequestParam String name, @RequestParam String rating) {
        Genre genre = new Genre(name, Integer.parseInt(rating));
        genreService.addGenre(genre);
        return "redirect:/genres";
    }

    @GetMapping(value = "/updateGenre/{id}", headers = "Accept=application/json")
    public String updateGenre(@PathVariable("id") int id, Model model) {
        model.addAttribute("genre", genreService.getGenre(id));
        model.addAttribute("listOfGenres", genreService.getAll());
        model.addAttribute("operation", "Update");
        return "jsp/genreUpdateCreate";
    }

    @PostMapping("/updateGenre/{id}")
    public String updateGenreExec(@PathVariable("id") int id, @RequestParam String name, @RequestParam String rating) {
        Genre genre = genreService.getGenre(id);
        genre.setName(name);
        genre.setRating(Integer.parseInt(rating));
        genreService.addGenre(genre);
        return "redirect:/genres";
    }

    @GetMapping(value = "/deleteGenre", headers = "Accept=application/json")
    public String deleteGenre(@RequestParam("id") int id) {
        genreService.deleteGenre(id);
        return "redirect:/genres";
    }

    /*
    tracks of current genre
     */
    @GetMapping("/genreTracks")
    public String getTrackOfGenre(@RequestParam int id, Model model) {
        Genre genre;
        model.addAttribute("tracks", (genre = genreService.getGenre(id)).getTracks());
        model.addAttribute("genre", genre);
        return "jsp/genreTracks";
    }

    @GetMapping("/searchGenre")
    public String searchGenre(@RequestParam String name, @RequestParam String rating, Model model) {
        if (!name.equals("") || !rating.equals("")) {
            model.addAttribute("listOfGenres", genreService.findByParameters(name, (rating.equals("") ?
                    0 : Integer.parseInt(rating))));
        } else {
            model.addAttribute("listOfGenres", genreService.getAll());
        }
        return "jsp/genres";
    }
    @GetMapping("/downloadGenre")
    public void downloadArtist(@RequestParam int id, HttpServletResponse response){
        String fileName;
        Object object;
        StringBuilder stringBuilder = new StringBuilder();
        if(id > 0){
            object = genreService.getGenre(id);
            Genre genre = (Genre) object;
            stringBuilder.append(genre.getName()).append(" ").append(genre.getRating()).append(".xml");
            genre.initToDownload();
        }
        else {
            object = genreService.getAll();
            stringBuilder.append("Genres.xml");
        }
        fileName = stringBuilder.toString();
        DownloadService.download(object, response, fileName);
    }
}
