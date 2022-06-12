package com.goodee.movie.batch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.goodee.movie.mapper.MovieMapper;

@Component
public class MovieJob {

	@Autowired
	private MovieMapper movieMapper;
	
	@Scheduled(cron="0 0/1 * * * ?")
	public void execute() {
		System.out.println("동작");
		System.out.println(movieMapper.selectMovieByQuery(null));
	}
}
