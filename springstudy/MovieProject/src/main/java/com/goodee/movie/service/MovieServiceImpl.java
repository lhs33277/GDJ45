package com.goodee.movie.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.goodee.movie.domain.MovieDTO;
import com.goodee.movie.mapper.MovieMapper;

public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieMapper movieMapper;
	
	@Override
	public List<MovieDTO> findMovieList() {
		
		return movieMapper.selectMovieList();
	}
	
	@Override
	public List<MovieDTO> findMovieByQuery(Map<String, Object> map) {
		
		return movieMapper.selectMovieByQuery(map);
	}
	
	
	
	
	
	
}
