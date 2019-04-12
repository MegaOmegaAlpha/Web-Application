package team25.musiclibrary.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import team25.musiclibrary.entities.Genre;
import team25.musiclibrary.service.GenreService;

import java.util.List;

@Controller
public class GenreController {

    @Autowired
    GenreService genreService;

    @RequestMapping("/getAllGenres")
    public String getGenres(Model model){
        List<Genre> genreList = genreService.getAll();
        model.addAttribute("genre", new Genre());
        model.addAttribute("listOfGenres", genreList);
        return "jsp/genres";
    }
    @RequestMapping(value = "/getGenre/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Genre getGenreById(@PathVariable int id) {
        return genreService.getGenre(id);
    }

    @GetMapping("/addGenre")
    public String addGenrePage(Model model) {
        return "jsp/genreUpdateCreate";
    }

    @RequestMapping(value = "/addGenre", method = RequestMethod.POST, headers = "Accept=application/json")
    public String addGenre(@RequestParam String name, @RequestParam String rating) {
        Genre genre = new Genre(name, Integer.parseInt(rating));
        genreService.addGenre(genre);
        return "redirect:/getAllGenres";
    }

    @RequestMapping(value = "/updateGenre/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public String updateGenre(@PathVariable("id") int id, Model model) {
        model.addAttribute("genre", genreService.getGenre(id));
        model.addAttribute("listOfGenres", genreService.getAll());
        return "jsp/genreUpdateCreate";
    }

    @PostMapping("/updateGenre/{id}")
    public String updateGenreExec(@PathVariable("id") int id, @RequestParam String name, @RequestParam String rating) {
        Genre genre = genreService.getGenre(id);
        genre.setName(name);
        genre.setRating(Integer.parseInt(rating));
        genreService.addGenre(genre);
        return "redirect:/getAllGenres";
    }

    @RequestMapping(value = "/deleteGenre/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public String deleteGenre(@PathVariable("id") int id) {
        genreService.deleteGenre(id);
        return "redirect:/getAllGenres";
    }

    /*
    tracks of current genre
     */
    @GetMapping("/genreTracks")
    public String getTrackOfGenre(@RequestParam String id, Model model) {
        model.addAttribute("songs", genreService.getGenre(Integer.parseInt(id)).getTracks());
        return "jsp/genreSongs";
    }
}
