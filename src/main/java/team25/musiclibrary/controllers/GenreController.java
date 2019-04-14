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
    @GetMapping("/genres/genreTracks")
    public String getTrackOfGenre(@RequestParam int id, Model model) {
        model.addAttribute("tracks", genreService.getGenre(id).getTracks());
        return "jsp/genreTracks";
    }


}
