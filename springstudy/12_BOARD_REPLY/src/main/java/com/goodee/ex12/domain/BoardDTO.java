package com.goodee.ex12.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
<<<<<<< HEAD
@NoArgsConstructor
@AllArgsConstructor
=======
@AllArgsConstructor
@NoArgsConstructor
>>>>>>> a253384adb4cb43f711c76c7b574dc52fe345675
@Builder
public class BoardDTO {
	private Long rn;
	private Long boardNo;
	private String writer;
	private String title;
	private String content;
	private Long hit;
	private String ip;
	private Date created;
	private Date modified;
}
