package com.goodee.movie.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goodee.movie.domain.MovieDTO;
import com.goodee.movie.service.MovieService;

@Controller
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping("/")
	public String index() {
		return "/index";
	}
	
	@ResponseBody
	@GetMapping(value="/movie/searchAllMovies", produces="application/json; charset=UTF-8")
	public Map<String, Object> searchAllMovies(){
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<MovieDTO> movies = movieService.findMovieList();
		
		if(movies.size() == 0) {
			map.put("msg", "목록이 존재하지 않습니다.");
			map.put("movies", null);
			map.put("status", 0);
		} else {
			map.put("msg", "전체 " + movies.size() + "개의 목록을 가져왔습니다.");
			map.put("movies", movies);
			map.put("status", 1);
		}
		
		return map;
	}
	
	@ResponseBody
	@PostMapping(value="/movie/searchMovie", produces="application/json; charset=UTF-8")
	public Map<String, Object> searchMovie(@RequestBody Map<String, Object> map) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		List<MovieDTO> movies = movieService.findMovieByQuery(map);
		
		if(movies.size() == 0) {
			result.put("msg", map.get("searchText").toString() + " 검색 결과가 없습니다.");
			result.put("movies", null);
			result.put("status", 0);
		} else {
			result.put("msg", movies.size() + "개의 검색 결과가 있습니다.");
			result.put("movies", (movies));
			result.put("status", 1);
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
