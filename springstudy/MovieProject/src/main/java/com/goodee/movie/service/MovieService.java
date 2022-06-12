package com.goodee.movie.service;

import java.util.List;
import java.util.Map;

import com.goodee.movie.domain.MovieDTO;

public interface MovieService {
	public List<MovieDTO> findMovieList();
	public List<MovieDTO> findMovieByQuery(Map<String, Object> map);
	
}
