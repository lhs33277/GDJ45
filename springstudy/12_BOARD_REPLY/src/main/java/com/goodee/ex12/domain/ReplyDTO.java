package com.goodee.ex12.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
=======
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
>>>>>>> a253384adb4cb43f711c76c7b574dc52fe345675
public class ReplyDTO {
	private Long replyNo;
	private String writer;
	private String content;
	private String ip;
	private Long boardNo;
	private Date created;
<<<<<<< HEAD
=======

>>>>>>> a253384adb4cb43f711c76c7b574dc52fe345675
}
