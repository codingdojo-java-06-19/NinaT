package com.ninatompkin.lookify.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
		return "index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String showSongs(Model model) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "dashboard.jsp";
	}
	
	@RequestMapping("/search/topTen")
	public String topTen() {
		return "topten.jsp";
	}
	
	@RequestMapping("/songs/new")
	public String newSong() {
		return "new.jsp";
	}
}
