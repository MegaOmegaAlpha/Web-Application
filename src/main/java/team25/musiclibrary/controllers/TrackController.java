package team25.musiclibrary.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import team25.musiclibrary.entities.Artist;
import team25.musiclibrary.entities.Genre;
import team25.musiclibrary.entities.Track;
import team25.musiclibrary.service.ArtistService;
import team25.musiclibrary.service.DownloadService;
import team25.musiclibrary.service.GenreService;
import team25.musiclibrary.service.TrackService;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalTime;
import java.util.ArrayList;
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
                           @RequestParam String duration, @RequestParam List<String> artistIdList,
                           @RequestParam List<String> genreIdList){
        Track track = new Track(name, album, LocalTime.parse(duration));
        for (String id : artistIdList) {
            track.getArtists().add(artistService.getArtist(Integer.parseInt(id)));
        }
        for (String id : genreIdList) {
            track.getGenres().add(genreService.getGenre(Integer.parseInt(id)));
        }
        trackService.addTrack(track);
        return "redirect:/tracks";
    }

    @GetMapping(value = "/addTrack")
    public String addTrackPage(Model model) {
        model.addAttribute("track", new Track());
        model.addAttribute("artistList", artistService.getAll());
        model.addAttribute("genreList", genreService.getAll());
        model.addAttribute("operation", "Create");
        return "jsp/trackUpdateCreate";
    }


    @GetMapping(value = "/updateTrack/{id}", headers = "Accept=application/json")
    public String updateTrack(@PathVariable("id") int id, Model model) {
        model.addAttribute("track", trackService.getTrack(id));
        model.addAttribute("artistList", artistService.getAll());
        model.addAttribute("genreList", genreService.getAll());
        model.addAttribute("operation", "Update");
        return "jsp/trackUpdateCreate";
    }

    @PostMapping(value= "/updateTrack/{id}", headers = "Accept=application/json")
    public String saveTrack(@PathVariable("id") int id, @RequestParam String name,
                            @RequestParam String album, @RequestParam String duration,
                            @RequestParam List<String> artistIdList, @RequestParam List<String> genreIdList){
        Track track = trackService.getTrack(id);
        track.setName(name);
        track.setAlbum(album);
        track.setDuration(LocalTime.parse(duration));
        List<Artist> artistList = new ArrayList<>();
        for (String artistId : artistIdList) {
            artistList.add(artistService.getArtist(Integer.parseInt(artistId)));
        }
        track.setArtists(artistList);
        List<Genre> genreList = new ArrayList<>();
        for (String genreId : genreIdList) {
            genreList.add(genreService.getGenre(Integer.parseInt(genreId)));
        }
        track.setGenres(genreList);
        trackService.updateTrack(track);
        return "redirect:/tracks";
    }

    @GetMapping(value = "/deleteTrack", headers = "Accept=application/json")
    public String deleteTrack(@RequestParam("id") int id) {
        trackService.deleteTrack(id);
        return "redirect:/tracks";
    }

    @GetMapping(value = "/findByArtistAge", headers = "Accept=application/json")
    public String findByArtistAge(@RequestParam int ageMin, @RequestParam int ageMax,  Model model){
        model.addAttribute("listOfTracks", trackService.findAllByArtists_AgeBetween(ageMin, ageMax));
        return "jsp/hardQueryPage1";
    }
    @GetMapping(value = "/findAllByGenres_RatingLike", headers = "Accept=application/json")
    public String findAllByGenres_RatingLike(@RequestParam Integer rating, Model model){
        model.addAttribute("listOfTracks", trackService.findAllByGenres_RatingLike(rating));
        return "jsp/hardQueryPage2";
    }
    @GetMapping(value = "/tracks/trackArtists", headers = "Accept=application/json")
    public String getTrackArtists(@RequestParam int id, Model model){
        Track track;
        List<Artist> artistList = (track = trackService.getTrack(id)).getArtists();
        model.addAttribute("track", track);
        model.addAttribute("artists", artistList);
        return "jsp/trackArtists";
    }
    @GetMapping(value = "/tracks/trackGenres", headers = "Accept=application/json")
    public String getTrackGenres(@RequestParam int id, Model model){
        Track track;
        List<Genre> genreList = (track = trackService.getTrack(id)).getGenres();
        model.addAttribute("track", track);
        model.addAttribute("genres", genreList);
        return "jsp/trackGenres";
    }

    @GetMapping("/searchTrack")
    public String searchTrack(@RequestParam String name, @RequestParam String album,
                            @RequestParam String duration, Model model) {
        if (!name.equals("") || !album.equals("") || !duration.equals("")) {
            List<Track> tracks = trackService.findByParameters(name, album, LocalTime.parse(duration.equals("") ?
                    "00:00:00" : duration));
            model.addAttribute("listOfTracks", tracks);
        } else {
            model.addAttribute("listOfTracks", trackService.getAll());
        }
        return "jsp/tracks";
    }

    @GetMapping("/downloadTrack")
    public void downloadTrack(@RequestParam int id, HttpServletResponse response) {
        String fileName;
        Object object;
        StringBuilder stringBuilder = new StringBuilder();
        if(id > 0){
            object = trackService.getTrack(id);
            Track track = (Track) object;
            stringBuilder.append(track.getName()).append(" ").append(track.getAlbum()).append(".xml");
            track.initToDownload();
        }
        else {
            object = trackService.getAll();
            stringBuilder.append("Tracks.xml");
        }
        fileName = stringBuilder.toString();
        DownloadService.download(object, response, fileName);
    }
}


