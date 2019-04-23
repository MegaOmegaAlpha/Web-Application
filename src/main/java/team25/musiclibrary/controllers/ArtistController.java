package team25.musiclibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import team25.musiclibrary.entities.Artist;
import team25.musiclibrary.entities.Track;
import team25.musiclibrary.service.ArtistService;
import team25.musiclibrary.service.DownloadService;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@Controller
public class ArtistController {

    @Autowired
    ArtistService artistService;

    @GetMapping("/artists")
    public String getArtists(Model model){
        List<Artist> artistList = artistService.getAll();
        model.addAttribute("artist", new Artist());
        model.addAttribute("listOfArtists", artistList);
        return "jsp/artists";
    }
    @GetMapping(value = "/getArtist", headers = "Accept=application/json")
    public Artist getArtistById(@RequestParam int id) {
        return artistService.getArtist(id);
    }

    @PostMapping(value = "/addArtist", headers = "Accept=application/json")
    public String addArtistPage(@RequestParam("name") String name, @RequestParam("age") int age) {
        Artist artist = new Artist(name, age);
        artistService.addArtist(artist);
        return "redirect:/artists";
    }
    @GetMapping(value = "/addArtist", headers = "Accept=application/json")
    public String addArtist(Model model){
        model.addAttribute("operation", "Create");
        return "jsp/artistUpdateCreate";
    }

    @GetMapping(value = "/updateArtist", headers = "Accept=application/json")
    public String updateArtist(@RequestParam int id, Model model) {
        model.addAttribute("artist", artistService.getArtist(id));
        model.addAttribute("operation", "Update");
        return "jsp/artistUpdateCreate";
    }

    @PostMapping("updateArtist")
    public String updateArtistExec(@RequestParam int id, String name, String age) {
        Artist artist = artistService.getArtist(id);
        artist.setName(name);
        artist.setAge(Integer.parseInt(age));
        artistService.addArtist(artist);
        return "redirect:/artists";
    }

    @GetMapping(value = "/deleteArtist", headers = "Accept=application/json")
    public String deleteArtist(@RequestParam int id) {
        artistService.deleteArtist(id);
        return "redirect:/artists";
    }

    @GetMapping(value = "/artistTracks", headers = "Accept=application/json")
    public String getArtistSongs(@RequestParam int id, Model model) {
        Artist artist;
        model.addAttribute("tracks", (artist = artistService.getArtist(id)).getTracks());
        model.addAttribute("artist", artist);
        return "jsp/artistTracks";
    }

    @GetMapping("/searchArtist")
    public String searchArtist(@RequestParam String name, @RequestParam String age, Model model) {
        if (!name.equals("") || !age.equals("")) {
            model.addAttribute("listOfArtists", artistService.findByParameters(name, age.equals("") ?
                    0 : Integer.parseInt(age)));
        } else {
            model.addAttribute("listOfArtists", artistService.getAll());
        }
        return "jsp/artists";
    }

    @GetMapping("/downloadArtist")
    public void downloadArtist(@RequestParam int id, HttpServletResponse response){
        String fileName;
        Object object;
        StringBuilder stringBuilder = new StringBuilder();
        if(id > 0){
            object = artistService.getArtist(id);
            Artist artist = (Artist) object;
            stringBuilder.append(artist.getName()).append(" ").append(artist.getAge()).append(".xml");
            artist.initToDownload();
        }
        else {
            object = artistService.getAll();
            stringBuilder.append("Artists.xml");
        }
        fileName = stringBuilder.toString();
        DownloadService.download(object, response, fileName);
    }
}
