package com.ninatompkin.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ninatompkin.lookify.models.Song;
import com.ninatompkin.lookify.services.SongService;


@Controller
public class SongsController {
	private final SongService songService;
	
	public SongsController(SongService songService) {
		this.songService = songService;
	}
	
	@RequestMapping("/")
	public String index() {
		System.out.println("Welcome to Lookify!");
		return "index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String showSongs(Model model) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		System.out.println("Current location: dashboard");
		return "dashboard.jsp";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String searchArtist(@RequestParam(value="searchQuery") String search, Model model) {
		System.out.println("Searching for "+search+"...");
		List<Song> songsWithArtist = songService.findArtist(search);
		model.addAttribute("search",search);
		model.addAttribute("songsFromArtist", songsWithArtist);
		return "search.jsp";
	}

	
	@RequestMapping("/search/topTen")
	public String topTen(Model model) {
		System.out.println("Current location: top ten");
		List<Song> topTen = songService.findTopTen();
		model.addAttribute("topSongs",topTen);
		return "topten.jsp";
	}
	
	@RequestMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song) {
		System.out.println("Current location: new song");
		return "new.jsp";
	}
	
	@RequestMapping(value="/songs", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Uh oh, your form has errors." + result);
			return "new.jsp";
		}
		else {
			songService.addSong(song);
			System.out.println("Awesome! A Song has been added into our database." + song);
			return "redirect:/dashboard";
		}
	}
	
    @RequestMapping("/songs/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
    	Song song = songService.findSong(id);
    	model.addAttribute("song", song);
    	return "show.jsp";
    }
	
	@RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        songService.deleteSong(id);
        return "redirect:/dashboard";
    }
}
