package com.example.lookify.controllers;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lookify.models.Song;
import com.example.lookify.services.SongService;

@Controller
public class SongController {
	
	@Autowired
	SongService songService;
	
	//RETORNA A PÁGINA PRINCIPAL
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	//PÁGINA PRINCIPAL
	@GetMapping("/dashboard")
	public String dashboard(String artist, Model model) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "dashboard.jsp";
	}
	
	
	//NUEVA CANCIÓN
	@GetMapping("/songs/new")
	public String addSong(@ModelAttribute("song") Song song) {
		return "add.jsp";
	}
	
	@PostMapping("/songs/new")
	public String addSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if(result.hasErrors()) {
			return "add.jsp";
		}else {
			songService.addSong(song);
			return "redirect:/dashboard";
		}
	}
	
	//INFORMACION ESPECÍFICA DE UNA CANCIÓN
	@GetMapping("/songs/{id}")
	public String details(@PathVariable("id") Long id, Model model) {
		Song song = songService.findSong(id);
		model.addAttribute("song", song);
		return "details.jsp";
	}
	
	
	//TOP 10 DE CANCIONES
	@GetMapping("/top-ten")
	public String details(Model model) {
		List<Song> songs = songService.topTen();
		model.addAttribute("songs", songs);
		return "top.jsp";
	}
	
	
	//BORRAR UNA CANCION
	@RequestMapping("/songs/{id}/delete")
	public String deleteSong(@PathVariable("id") Long id) {
		songService.deleteSong(songService.findSong(id));
		return "redirect:/dashboard";
	}
	
	//BUSCAR POR ARTISTA
	@GetMapping("/search")
	public String search(@RequestParam(name = "q", required = false) String artist, Model model) {
		if (artist == null || artist.isEmpty()) {
			return "redirect:/dashboard";
		}
		List<Song> songs = songService.artistas(artist);
		model.addAttribute("songs", songs);
		
		return "search.jsp";
	}
}
