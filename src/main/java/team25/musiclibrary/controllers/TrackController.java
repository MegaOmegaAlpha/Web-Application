package team25.musiclibrary.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import team25.musiclibrary.entities.Artist;
import team25.musiclibrary.entities.Genre;
import team25.musiclibrary.entities.Track;
import team25.musiclibrary.service.ArtistService;
import team25.musiclibrary.service.GenreService;
import team25.musiclibrary.service.TrackService;

import java.sql.Time;
import java.util.List;

@Controller
public class TrackController {

    @Autowired
    TrackService trackService;

    @Autowired
    ArtistService artistService;

    @Autowired
    GenreService genreService;

    @GetMapping(value = "/tracks", headers = "Accept=application/json")
    public String getTracks(Model model) {
        Iterable<Track> listOfTracks = trackService.getAll();
        model.addAttribute("track", new Track());
        model.addAttribute("listOfTracks", listOfTracks);
        return "jsp/tracks";
    }

    @GetMapping(value = "/getTrack/{id}", headers = "Accept=application/json")
    public Track getTrackById(@PathVariable int id) {
        return trackService.getTrack(id);
    }

    @PostMapping(value = "/addTrack")
    public String addTrack(@RequestParam String name, @RequestParam String album,
                           @RequestParam String duration){
        Track track = new Track(name, album, Time.valueOf("00:".concat(duration)));
        trackService.addTrack(track);
        return "redirect:/tracks";
    }

    @GetMapping(value = "/addTrack")
    public String addTrackPage(Model model) {
        model.addAttribute("track", new Track());
        return "jsp/trackUpdateCreate";
    }

    /*@RequestMapping(value = "/addTrack", method = RequestMethod.GET, headers = "Accept=application/json")
    public String addTrack(@ModelAttribute("track") Track track) {
        trackService.addTrack(track);
        return "redirect:/getAllTracks";
    }*/

    @GetMapping(value = "/updateTrack/{id}", headers = "Accept=application/json")
    public String updateTrack(@PathVariable("id") int id, Model model) {
        model.addAttribute("track", trackService.getTrack(id));
        model.addAttribute("listOfTracks", trackService.getAll());
        return "jsp/trackUpdateCreate";
    }

    @PostMapping(value= "/saveTrack", headers = "Accept=application/json")
    public String saveTrack(@ModelAttribute("track") Track track){
        trackService.updateTrack(track);
        return "redirect:/tracks";
    }

    @GetMapping(value = "/deleteTrack", headers = "Accept=application/json")
    public String deleteTrack(@RequestParam("id") int id) {
        trackService.deleteTrack(id);
        return "redirect:/tracks";
    }

    @GetMapping(value = "/findByArtistAge/{from},{to}", headers = "Accept=application/json")
    public String findByArtistAge(@PathVariable("from") Integer from, @PathVariable("to") Integer to,  Model model){
        model.addAttribute("track", new Track());
        model.addAttribute("listOfTracks", trackService.findAllByArtists_AgeBetween(from, to));
        return "jsp/trackList";
    }
    @GetMapping(value = "/findAllByGenres_RatingLike/{rating}", headers = "Accept=application/json")
    public String findAllByGenres_RatingLike(@PathVariable("rating") Integer rating, Model model){
        model.addAttribute("track", new Track());
        model.addAttribute("listOfTracks", trackService.findAllByGenres_RatingLike(rating));
        return "jsp/trackList";
    }
    @GetMapping(value = "/tracks/trackArtists", headers = "Accept=application/json")
    public String getTrackArtists(@RequestParam int id, Model model){
        List<Artist> artistList = trackService.getTrack(id).getArtists();
        model.addAttribute("artist", new Artist());
        model.addAttribute("artists", artistList);
        return "jsp/trackArtists";
    }
    @GetMapping(value = "/tracks/trackGenres", headers = "Accept=application/json")
    public String getTrackGenres(@RequestParam int id, Model model){
        List<Genre> genreList = trackService.getTrack(id).getGenres();
        model.addAttribute("genre", new Genre());
        model.addAttribute("genres", genreList);
        return "jsp/trackGenres";
    }
}


