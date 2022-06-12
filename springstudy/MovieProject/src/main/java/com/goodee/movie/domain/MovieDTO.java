package com.goodee.movie.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {

	private Long no;
	private String title;
	private String genre;
	private String description;
	private Double star;
}
